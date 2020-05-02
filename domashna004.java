import java.util.Scanner;

public class domashna004 {
    static int board[][] = new int[6][6];

    public static void main(String[] a) {
        createBoard();
        boardInput();

    }

    static boolean turn = false;
    static Scanner input = new Scanner(System.in);
    static String[] realName = { "0", "Dw", "D", "Q", "K", "M", "Dw" };

    static String[] direction = { "0", "Left Diagonal", "Right Diagonal", "Back Left Diagonal",
            "Back Right Diagonal", "Up", "Down", "Left", "Right"

    };

    static int whiteTurns = 0;
    static int blackTurns = 0;

    static int figureNumber = 0;
    static boolean gameOver = false;

    // static boolean player = false;

    public static void createBoard() {
        int count = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (i == 0) {

                    board[i][j] = count;
                    count++;
                } else if (i == board.length - 1) {
                    if (count == 1 && j < 5)
                        count = 6;

                    board[i][j] = count + 10;
                    count--;

                } else {
                    if (count != 1)
                        count = 1;
                    board[i][j] = 0;
                }

            }
        }

    }

    public static void boardInput() {

        String input;
        do {
            turn();
            System.out.println("Enter figure:");
            input = domashna004.input.nextLine();
            figureNumber = figureNumber(input);
            if (leftRightDwarf(figureNumber)) {
                System.out.println("Left or Right:");
                input = domashna004.input.nextLine();

                if (turn)
                    if (input.equals("Left")) {
                        figureNumber = 11;
                    } else {
                        figureNumber = 16;
                    }
                else {
                    if (input.equals("Left")) {
                        figureNumber = 1;
                    } else {
                        figureNumber = 6;
                    }
                }
            }

            System.out.println("Enter direction:");
            input = domashna004.input.nextLine();
            System.out.println(getDirection(input));
            boardMovement(getDirection(input));
            printBoard();
            turn = !turn;

        } while (figureNumber != 0 && !gameOver);

        domashna004.input.close();
    }

    public static boolean leftRightDwarf(int number) {
        if (number == 1 || number == 11) {
            return true;
        }
        return false;
    }

    public static void boardMovement(int direction) {
        if (figureNumber == 11 || figureNumber == 1) {
            dwarfMovement(direction);
        }
        if (figureNumber == 12 || figureNumber == 2) {
            donkey(direction);
        }
        if (figureNumber == 13 || figureNumber == 3) {
            qeenMovement(direction);
        }
        if (figureNumber == 14 || figureNumber == 4) {
            kingMovement(direction);
        }
        if (figureNumber == 15 || figureNumber == 5) {
            negev(direction);
        }

        if (figureNumber == 16 || figureNumber == 6) {
            dwarfMovement(direction);
        }
    }

    public static void dwarfMovement(int direction) {
        if (direction == 5) {
            int offset = 1;

            int i = 0;
            int j = 0;

            if (turn)
                offset = -1;

            int position = figurePosition(figureNumber);
            if (position > 0) {
                i = position / 10;
                j = position % 10;
            }
            movement(i, j, offset, 0);

        } else {
            System.out.println("This Figure cannot move this way");
        }

    }

    public static void qeenMovement(int direction) {
        int position = figurePosition(figureNumber);
        int i = position / 10;
        int j = position % 10;
        if (position < 10) {
            i = 0;
            j = position;
        }
        if (turn) {
            if (direction == 1) {
                movement(i, j, -1, -1);
            } else if (direction == 2) {
                movement(i, j, -1, 1);
            } else if (direction == 3) {
                movement(i, j, +1, -1);
            } else if (direction == 4) {
                movement(i, j, +1, +1);
            } else {
                System.out.println("This Figure cannot move this way");
            }

        } else {
            if (direction == 1) {
                movement(i, j, 1, -1);
            } else if (direction == 2) {
                movement(i, j, +1, +1);
            } else if (direction == 3) {
                movement(i, j, -1, -1);
            } else if (direction == 4) {
                movement(i, j, -1, 1);
            } else {
                System.out.println("This Figure cannot move this way");
            }

        }

    }

    public static void kingMovement(int direction) {
        System.out.println("Here");
        int position = figurePosition(figureNumber);
        int i = position / 10;
        int j = position % 10;
        if (position < 10) {
            i = 0;
            j = position;
        }

        if (turn) {
            if (direction == 1) {
                movement(i, j, -1, -1);
            } else if (direction == 2) {
                movement(i, j, -1, 1);
            } else if (direction == 3) {
                movement(i, j, 1, -1);
            } else if (direction == 4) {
                movement(i, j, 1, +1);
            } else if (direction == 5) {
                movement(i, j, -1, 0);
            } else if (direction == 6) {
                movement(i, j, -1, 0);
            } else if (direction == 7) {
                movement(i, j, 0, -1);
            } else if (direction == 8) {
                movement(i, j, 0, 1);
            } else {
                System.out.println("This Figure cannot move this way");
            }

        } else {
            if (direction == 1) {
                movement(i, j, 1, -1);
            } else if (direction == 2) {
                movement(i, j, +1, +1);
            } else if (direction == 3) {
                movement(i, j, -1, -1);
            } else if (direction == 4) {
                movement(i, j, -1, 1);
            } else if (direction == 5) {
                movement(i, j, 1, 0);
            } else if (direction == 6) {
                movement(i, j, 1, 0);
            } else if (direction == 7) {
                movement(i, j, 0, 1);
            } else if (direction == 8) {
                movement(i, j, 0, -1);
            } else {
                System.out.println("This Figure cannot move this way");
            }

        }

    }

    public static void negev(int direction) {
        int position = figurePosition(figureNumber);
        int i = position / 10;
        int j = position % 10;
        if (position < 10) {
            i = 0;
            j = position;
        }
        if (turn) {

            if (direction == 5) {
                movement(i, j, 1, 0);
            } else if (direction == 6) {
                movement(i, j, -1, 0);
            } else if (direction == 7) {
                movement(i, j, 0, -1);
            } else if (direction == 8) {
                movement(i, j, 0, 1);
            }

        } else {

            if (direction == 5) {
                movement(i, j, -1, 0);
            } else if (direction == 6) {
                movement(i, j, 1, 0);
            } else if (direction == 7) {
                movement(i, j, 0, 1);
            } else if (direction == 8) {
                movement(i, j, 0, -1);
            }

        }
    }

    public static void donkey(int durection) {
        if (turn) {
            if (blackTurns % 3 == 0) {
                kingMovement(durection);
            }

        } else {
            if (whiteTurns % 3 == 0) {
                kingMovement(durection);
            }
        }
    }

    public static void movement(int i, int j, int offsetI, int offsetJ) {

        board[i][j] = 0;
        try {

            if (board[i + offsetI][j + offsetJ] == 4) {
                gameOver(false);

            } else if (board[i + offsetI][j + offsetJ] == 14) {
                gameOver(true);

            }

            board[i + offsetI][j + offsetJ] = figureNumber;
        } catch (ArrayIndexOutOfBoundsException aobe) {
            System.out.println("Oppss it's seems that you fall out of the board :D :D");
            board[i][j] = figureNumber;
        }
    }

    public static int getDirection(String input) {
        for (int i = 0; i < direction.length; i++) {
            if (direction[i].toLowerCase().equals(input.toLowerCase())) {
                return i;
            }
        }
        return 0;
    }

    public static void gameOver(boolean input) {

        System.out.println("Game Over");
        if (input)
            System.out.println("White wins");
        else
            System.out.println("Black wins");

    }

    public static int figurePosition(int number) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == number) {

                    return (i * 10) + j;
                }
            }
        }
        return -1;

    }

    public static void turn() {
        if (!turn) {
            System.out.println("White:");
            whiteTurns++;
        } else {
            System.out.println("Black:");
            blackTurns++;
        }
    }

    public static int figureNumber(String figure) {

        for (int i = 0; i < realName.length; i++) {
            if (realName[i].toLowerCase().equals(figure.toLowerCase())) {
                if (turn)
                    return i + 10;
                else
                    return i;
            }
        }
        return 0;
    }

    public static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                int x = board[i][j];
                char bW = 'w';
                if (board[i][j] - 10 > 0) {
                    x -= 10;
                    bW = 'b';
                }
                if (board[i][j] == 0)
                    bW = 0;

                System.out.print(bW + realName[x] + " ");
                bW = 'w';

            }
            System.out.println();

        }
    }
}
