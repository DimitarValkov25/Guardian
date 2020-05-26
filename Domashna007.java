import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Domashna007 {

    static String[][] gameBoard;
    static int width,height, bombSize;
    static int numberProbes,numberDisposal;
    static Scanner scanner;
    static Random random =new Random();
    static int[][] minePosition ;
    private static boolean gameOver;
    final static String teritoryFile = "half.txt";
    final static String settings = "settings.txt";
    static String youCanGo[] ;

    public static void main(String[] a) {
        getInformationFromConfigurationFile();
        getInformationFromEnemyFile();
        createGameBoard();
        placeStartAndFinish();
        placeMinesOnGameBoard();
        gameMenu();


    }
    private static void getInformationFromConfigurationFile() {
        try {
            scanner = new Scanner(new File(settings));
            int count=0;
            while(count<3) {
                switch(count) {
                    case 1:
                        numberProbes=Integer.parseInt(regex(scanner.nextLine(),"([\\d]{1,})$"));
                        break;
                    case 2:
                        numberDisposal=Integer.parseInt(regex(scanner.nextLine(),"([\\d]{1,})$"));

                        break;
                }
                count++;
            }

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
        }


    }
    private static void getInformationFromEnemyFile() {

        try {
            scanner = new Scanner(new File(teritoryFile));
            int count=0;
            while(count<4) {
                switch(count) {
                    case 1:
                        width=Integer.parseInt(regex(scanner.nextLine(),"([\\d]{1,})$"));
                        break;
                    case 2:
                        height=Integer.parseInt(regex(scanner.nextLine(),"([\\d]{1,})$"));
                        break;
                    case 3:
                        bombSize =Integer.parseInt(regex(scanner.nextLine(),"([\\d]{1,})$"));
                        break;
                }
                count++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }


    }
    private static void createGameBoard() {
        gameBoard=new String[width][height];
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = "X ";
            }
        }



    }
    private static void placeStartAndFinish() {

        int randomPlace ;
        randomPlace=random.nextInt(3)+1;
        int[][] coordinates = {{0,0,gameBoard.length-1,gameBoard[0].length-1 },
                { 0,gameBoard[0].length-1,gameBoard.length-1,0}};
        String start  ="S ";
        String end="F ";
        if(randomPlace>=coordinates.length) {
            randomPlace-=coordinates.length;
            start="F ";
            end="S ";
        }
        gameBoard[coordinates[randomPlace][0]][coordinates[randomPlace][1]]=start;
        gameBoard[coordinates[randomPlace][2]][coordinates[randomPlace][3]]=end;
        printGameBoard();


    }
    private static void placeMinesOnGameBoard() {
        int minePosisitonX, minePosisitonY;
        minePosition =new int[bombSize][2];
        for (int i = 0; i < bombSize; i++) {
            do {
                minePosisitonX = random.nextInt(gameBoard.length - 1);
                minePosisitonY = random.nextInt(gameBoard[0].length - 1);
            } while (!gameBoard[minePosisitonX][minePosisitonY].equals("X "));
            minePosition[i][0]=minePosisitonX;
            minePosition[i][1]=minePosisitonY;
        }


    }
    private static void printGameBoard() {
        System.out.println();
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }
        System.out.print(" ");
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();


    }
    private static String regex(String rawData, String regex) {
        String url = "";

        Pattern p2 = Pattern.compile(regex);
        Matcher m2 = p2.matcher(rawData);
        if (m2.find()) {
            url = (m2.group(1));
        }
        return url;


    }
    private static String whereIsFinnishLine() {
        for(int i=0;i<gameBoard.length;i++) {
            for(int j=0;j<gameBoard[i].length;j++) {
                if(gameBoard[i][j].equals("F ")) {
                    return i+":"+j;
                }
            }
        }
        return null;


    }
    private static void whereYouCanGo() {
        int[] yourPosition =coordinationSplit(whereAreYou());
        int count=0;
        int cooridination [][] = { {-1,1,0,0 },{0,0,-1,1}};
        for(int i=0;i<4;i++) {
            if(isInGameBoardRange(yourPosition[0]+cooridination[0][i],yourPosition[1]+cooridination[1][i]))count++;
        }
        youCanGo=new String[count];
        count=-1;
        for(int i=0;i<4;i++) {

            if(isInGameBoardRange(yourPosition[0]+cooridination[0][i],yourPosition[1]+cooridination[1][i])) {count++;
                youCanGo[count]=(yourPosition[0]+cooridination[0][i]+":"+(yourPosition[1]+cooridination[1][i]));
            };
        }


    }
    private static void doMovement(String coordinates) {
        int[] yourPosition =coordinationSplit(whereAreYou());

        int[] newPosition =coordinationSplit(coordinates);

        int[] whereIsFinish =coordinationSplit(whereIsFinnishLine());

        for(int i=0;i<minePosition.length;i++) {
            if(minePosition[i][0]==newPosition[0]&&minePosition[i][1]==newPosition[1]) {
                setGameOver(true);
            }
        }
        if(isGameOver()) System.out.println("GAME OVER");

        if(newPosition[0]==whereIsFinish[0]&&newPosition[1]==whereIsFinish[1]) {
            setGameOver(true);
            System.out.println("You win");
        }
        gameBoard[yourPosition[0]][yourPosition[1]]="V ";
        gameBoard[newPosition[0]][newPosition[1]]="* ";
        printGameBoard();


    }
    public static void test(int[] yourPosition,int i,int x,int y,boolean isTrue) {

        if(isInGameBoardRange(yourPosition[0]+x,yourPosition[1]+y)) {
            if(yourPosition[0]+x==minePosition[i][0]&&minePosition[i][1]==yourPosition[1]+y) {
                gameBoard[minePosition[i][0]][minePosition[i][1]]="Y ";
            }
            else {
                gameBoard[yourPosition[0]+x][yourPosition[1]+y]="N ";
            }
        }else if(isInGameBoardRange(yourPosition[0]-x,yourPosition[1]-y)) {
            if(yourPosition[0]-x==minePosition[i][0]&&minePosition[i][1]==yourPosition[1]-y) {

                gameBoard[minePosition[i][0]][minePosition[i][1]]="Y ";
            }else {
                gameBoard[yourPosition[0]-x][yourPosition[1]-y]="N ";
            }
        }else if(isInGameBoardRange(yourPosition[0]-x,yourPosition[1]+y)&&isTrue) {
            if(yourPosition[0]-x==minePosition[i][0]&&minePosition[i][1]==yourPosition[1]+y) {
                gameBoard[minePosition[i][0]][minePosition[i][1]]="Y ";
            }else {
                gameBoard[yourPosition[0]-x][yourPosition[1]+y]="N ";
            }
        }else if(isInGameBoardRange(yourPosition[0]+x,yourPosition[1]-y)&&isTrue) {
            if(yourPosition[0]+x==minePosition[i][0]&&minePosition[i][1]==yourPosition[1]-y) {
                gameBoard[minePosition[i][0]][minePosition[i][1]]="Y ";
            }else {
                gameBoard[yourPosition[0]+x][yourPosition[1]-y]="N ";
            }
        }


    }
    private static void mineChecker() {
        if(numberProbes<=0) {
            System.out.println("Нямаш повече анализи!");
            return;
        }
        int[] yourPosition =coordinationSplit(whereAreYou());
        for(int i=0;i<minePosition.length;i++) {
            test(yourPosition,i,0,-1,false);
            test(yourPosition,i,1,0,false);
            test(yourPosition,i,1,1,true);
        }
        numberProbes--;
        printGameBoard();


    }
    private static void defuseKit(String coordinates) {
        if(numberDisposal<=0) {
            System.out.println("Нямаш повече анализи!");
            return;
        }
        int[] mines =coordinationSplit(coordinates);
        for(int i=0;i<minePosition.length;i++) {
            if(minePosition[i][0]==mines[0]&&minePosition[i][1]==mines[1]) {
                minePosition[i][0]=-1;
                return;
            }
        }
        numberDisposal--;


    }
    private static boolean isInGameBoardRange(int x,int y) {
        try {
            gameBoard[x][y]=gameBoard[x][y];
            return true;
        }catch(ArrayIndexOutOfBoundsException e) {
            return false;
        }


    }
    private static String whereAreYou() {
        for(int i=0;i<gameBoard.length;i++) {
            for(int j=0;j<gameBoard[i].length;j++) {
                if(gameBoard[i][j].equals("S ")||gameBoard[i][j].equals("* ")) {
                    return i+":"+j;
                }
            }
        }
        return null;


    }
    private static int[] coordinationSplit(String coordination) {

        int [] xY={ Integer.parseInt(coordination.split(":")[0]),Integer.parseInt(coordination.split(":")[1])};
        return xY;
    }
    static boolean isGameOver() {
        return gameOver;
    }
    static void setGameOver(boolean gameOver) {
        Domashna007.gameOver=gameOver;


    }
    private static void gameMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. Анализ");
            System.out.println("2. обезвреждане");
            System.out.println("3. придвижване, по бойното поле.");

            option = scanner.nextInt();

            if(option==1) {
                mineChecker();
            }else if(option==2) {
                whereYouCanGo();
                for(int i=0;i<youCanGo.length;i++) {
                    System.out.println((i+1)+"."+youCanGo[i]);
                }
                System.out.println("Int number:");
                option = scanner.nextInt();
                defuseKit(youCanGo[option-1]);
                doMovement(youCanGo[option-1]);

            }else if(option==3) {
                int option2;
                whereYouCanGo();
                for(int i=0;i<youCanGo.length;i++) {
                    System.out.println((i+1)+"."+youCanGo[i]);
                }
                System.out.println("Int number:");
                option = scanner.nextInt();

                System.out.println("1. Проба за мина");
                System.out.println ("2. Обезвреждане на мина");
                System.out.println("3.Мини");

                option2 =scanner.nextInt();
                if(option2==1) {
                    mineChecker();
                }
                if(option2==2) {
                    defuseKit(youCanGo[option-1]);
                    doMovement(youCanGo[option-1]);
                }if(option2==3) {
                    doMovement(youCanGo[option-1]);
                }
            }
        }while (!isGameOver());
    }

}
