import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class Domashna005 {

    public Domashna005() {

    }
    static int[] mainNumbers;
    static int length;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] a) {
        mainMenu();

    }
    public static void mainMenu() {
        numbersForInspection();

        System.out.println("1. Сортиране на въведените числа във възходящ ред");
        System.out.println ("2. Сортиране на въведените числа в низходящ ред ");
        System.out.println("3. Търсене на позиция на конкретно число") ;
        System.out.println ("4. Разбъркване на числата");
        System.out.println ("5. Изчисляване на сбора на всички числа");
        System.out.println("6. Намиране на най-голямото число");
        System.out.println( "7. Намиране на най-малкото число");
        System.out.println ("8. Намиране средно-аритметично на числата");
        System.out.println ("9. Проверка за симетричност на масива от числа");
        System.out.println ("10. Обръщане на масива от числа");
        System.out.println ("11. Визуализирай въведените числа");
        System.out.println  ("12. Изход ");

        int choise =scanner.nextInt();
        while (choise !=12){
            if (choise < 1 || choise > 12)
            {
                System.out.println("Enter Option");
                choise = scanner.nextInt();


            }
            else if (choise == 1) {
                ascendingOrder();
            } else if (choise == 2) {
                descentingOrder();
            } else if (choise == 3) {
                System.out.println("Enter number:");
                int input = scanner.nextInt();
                chooseNumberForSearch(input);
            } else if (choise == 4) {
                randomArray();
            } else if (choise == 5) {
                sumTheArray();
            } else if (choise == 6) {
                Maximum();
            } else if (choise == 7) {
                Minimum();
            } else if (choise == 8) {
                averageArray();
            } else if (choise == 9) {
                arrInspect(mainNumbers,mainNumbers.length,0);
                display(mainNumbers);
            } else if (choise == 10) {
                invertingAnArray();
            } else if (choise == 11) {
                display(mainNumbers);
            } else if (choise == 12) {
                choise = 12;
            }

            if(choise<12) {
                System.out.println("\nИскате ли да продължите:[Y-N]");
                String option =scanner.next();

                if(option.equals("N")) break;
                else choise=12;
            }else {
                break;
            }

        }


    }
    //numbers ++ enter
    public static void numbersForInspection() {

        try {
            System.out.println("How many numbers do you want to enter:");
            length = scanner.nextInt();

            System.out.println("ENTER NUMBER");
            mainNumbers = new int[length];

            fillTheArray();
        }catch(Exception e) {
            System.out.println("Opss something went wrong :(");
        }



    }


    public static double averageArray() {
        int sum = 0;
        for (int i = 0; i < mainNumbers.length; i++) {
            sum = sum + mainNumbers[i];
        }
        double average = sum / (double) mainNumbers.length;
        System.out.println("Average result is =\t" + average);
        return average;
    }
    public static int sumTheArray(){
        int sum = 0;
        int i;
        for(i=0;i< mainNumbers.length;i++)
            sum+=mainNumbers[i];
        System.out.println("SUM=:"+(sum));
        return sum;
    }


// 12345 54321
    public static void invertingAnArray() {
        int invertingAnArray[] = mainNumbers;

        for (int i = 0; i < invertingAnArray.length / 2; i++) {
            int temp = invertingAnArray[i];
            invertingAnArray[i] = invertingAnArray[invertingAnArray.length - 1 - i];
            invertingAnArray[invertingAnArray.length - 1 - i] = temp;
        }
        for (int i = 0; i < invertingAnArray.length; i++) {
            System.out.print(invertingAnArray[i] + " ");

        }


    }

    public static void chooseNumberForSearch(int number) {
        System.out.println("I Found " + number + ":");
        for (int i = 0; i < mainNumbers.length; i++) {
            if (mainNumbers[i] == number) {
                System.out.print(i + " ");
            }

        }
    }

// +
    public static void ascendingOrder() {
        int turnArray[] = mainNumbers;
        int n = turnArray.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (turnArray[j] > turnArray[j + 1]) {

                    int temp = turnArray[j];
                    turnArray[j] = turnArray[j + 1];
                    turnArray[j + 1] = temp;
                }
        for (int i = 0; i < turnArray.length; i++) {
            System.out.print(turnArray[i] + " ");
        }

    }

// -
    public static void descentingOrder() {
        int turnArray[] = mainNumbers;

        int n = turnArray.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (turnArray[j] < turnArray[j + 1]) {

                    int temp = turnArray[j];
                    turnArray[j] = turnArray[j + 1];
                    turnArray[j + 1] = temp;
                }
        for (int i = 0; i < turnArray.length; i++) {
            System.out.print(turnArray[i] + " ");
        }

    }

//test 3 random
    public static void randomArray() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = mainNumbers.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);

            int a = mainNumbers[index];
            mainNumbers[index] = mainNumbers[i];
            mainNumbers[i] = a;
        }
        display(mainNumbers);

    }

    public static void arrInspect(int[] A, int n, int i) {

        if (i > n/2)
        {
            System.out.println("false");
        }
        else if (A[i] != A[n-1-i]) {
            System.out.println("true");
        }
        else arrInspect(A, n, i+1);
    }
    // posleden
    public static void Minimum() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < mainNumbers.length; i++) {
            min =Math.min(mainNumbers[i], min);
        }
        System.out.println("Minimum: " + min);


    }
    // parvi
    public static void Maximum() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mainNumbers.length; i++) {
            max =Math.max(mainNumbers[i], max);

        }
        System.out.println("Maximum: " + max);


    }



    public static void fillTheArray() {
        for (int i = 0; i < length; i++) {
            mainNumbers[i] = scanner.nextInt();
        }

    }


    public static void display(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);

        }
    }
}
