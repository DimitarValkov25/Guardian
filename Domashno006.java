package Domashno006;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;


public class Domashno006 {


    static int[] intnumber;
    static String[] intword;
    static int length;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        int number = 0;
        do {
            System.out.println("1. NumberWorker");
            System.out.println("2. WordWorker ");
            System.out.println("3. Exit");

            number = scanner.nextInt();

            if (number == 1) {
                numberOptionMenu();
            } else if (number == 2) {
                wordOptionMenu();
            } else if (number == 3) break;

        } while (number >= 1 || number <= 2);


    }

    public static void numberOptionMenu() {
        int number = 0;
        do {
            System.out.println("How many numbers you want to enter?");
            length = scanner.nextInt();
            System.out.println("Enter the number/s!");
            fill();

            System.out.println("1. Извеждане само на простите числа от масива");
            System.out.println("2. Извеждане на най-често срещан елемент в масива");
            System.out.println("3. Извеждане на максимална редица от нарастващи елементи в масива");
            System.out.println("4. Извеждане на максимална редица от намаляващи елементи в масива");
            System.out.println("5. Извеждане на максимална редица от еднакви елементи в масива");
            System.out.println("6. Извеждане на последователност от числа от масива, които имат сума равна на число, генерирано на случаен принцип");
            System.out.println("7. Връщане назад към основното меню");

            number = scanner.nextInt();
            if (number == 1) {
                searchForPrimeNumbers();
            } else if (number == 2) {
                repeatedElements(intnumber);
            } else if (number == 3) {
                ascendingRow(intnumber);
            } else if (number == 4) {
                descendingRow(intnumber);
            } else if (number == 5) {
                dublicateNumberSearch(intnumber);
            } else if (number == 6) {
                findNumbers(intnumber);
            } else if (number == 7) break;

        } while (number >= 1 || number <= 6);

    }
    public static void wordOptionMenu() {
        int number = 0;
        System.out.println("How many words you want to enter?");
        length = scanner.nextInt();
        System.out.println("Enter the word/s!");
        display();

        do {
            System.out.println("1. Обърнете буквите на думите от масива наобратно и ги визуализирайте в конзолата");
            System.out.println("2. Изведете броя на повтарящите се символи за всяка една от думите в масива");
            System.out.println("3. Изведете броя на символите за всяка една от думите в масива");
            System.out.println("4. Изведете броя на повтарящите се думи от масива");
            System.out.println("5. Връщане назад към основното меню");


            number = scanner.nextInt();
            if (number == 1) {
                wordReverse();
            } else if (number == 2) {
                String intword2="";
                for(int i=0;i<intword.length;i++)
                {
                    intword2+=intword[i]+" ";
                }
                System.out.println(intword2);
                dublicatedLetters(intword2);
            } else if (number == 3) {
                letterNumber();
            } else if (number == 4) {
                dublicatedWords();
            } else if (number == 5) break;
        } while (number >= 1 || number <= 4);

    }
    public static void ascendingRow(int arr[]) {
        Queue<Integer> tempNumbers = new LinkedList<>();
        Queue<Integer> numbers = new LinkedList<>();
        tempNumbers.add(arr[0]);
        int max = 1, len = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                len++;
                tempNumbers.add(arr[i]);
            } else {
                if (max < len) {
                    max = len;
                    numbers.clear();
                    for (Integer e : tempNumbers) {
                        numbers.add(e);
                    }
                }
                len = 1;
                tempNumbers.clear();
                tempNumbers.add(arr[i]);
            }
        }
        if (max < len) {
            numbers.clear();
            for (Integer e : tempNumbers) {
                numbers.add(e);
            }
        }
        if (numbers.isEmpty()) {
            for (Integer e : tempNumbers) {
                numbers.add(e);
            }
        }
        for (Integer number : numbers) {
            System.out.println(number);
        }

    }
    public static void descendingRow(int arr[]) {
        Queue<Integer> tempNumbers = new LinkedList<>();
        Queue<Integer> numbers = new LinkedList<>();
        tempNumbers.add(arr[0]);
        int max = 1, len = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                len++;
                tempNumbers.add(arr[i]);
            } else {
                if (max < len) {
                    max = len;
                    numbers.clear();
                    for (Integer e : tempNumbers) {
                        numbers.add(e);
                    }
                }
                len = 1;
                tempNumbers.clear();
                tempNumbers.add(arr[i]);
            }

        }
        if (max < len) {
            numbers.clear();
            for (Integer e : tempNumbers) {
                numbers.add(e);
            }
        }
        if (numbers.isEmpty()) {
            for (Integer e : tempNumbers) {
                numbers.add(e);
            }
        }
        for (Integer number : numbers) {
            System.out.println(number);
        }

    }
    public static void searchForPrimeNumbers() {
        for (int i = 0; i < intnumber.length; i++) {
            boolean isPrime = true;
            if (intnumber[i] > 1) {
                int elsqrt = (int) Math.sqrt(intnumber[i]);
                for (int j = 2; j < elsqrt; i++) {
                    if (intnumber[i] % i == 0) {
                        isPrime = false;
                    }
                }
            }
            if (isPrime)
                System.out.println("Prime:" + intnumber[i]);
        }

    }
    public static void repeatedElements(int[] arr) {
        int max = 1, len = 1;
        int maxNumber=arr[0];

        for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        len++;
                    } else {
                        if (max < len) {

                            max = len;
                            maxNumber=arr[i];
                        }
                        len = 1;
                    }
                }
            if (max < len) {

                max = len;
                maxNumber = arr[i];
                len = 1;
            }
            }
            System.out.println(maxNumber);

   }
    public static void findNumbers(int arr[]) {
        Queue<Integer> numbers = new LinkedList<>();
        Random r = new Random();
        int randomNumber = r.nextInt(100);
        int sum=0;
        int j=1;
        System.out.println(randomNumber);
        for (int i=0; i<arr.length; i++)
        {
            if(sum==randomNumber)
            {
                for (Integer number: numbers) {
                    System.out.print(number+" ");
                }
                System.out.println();
                break;
            }
            if (sum+arr[i]<=randomNumber) {
                sum+=arr[i];
                numbers.add(arr[i]);
            }
            else
            {
                numbers.clear();
                sum=0;
                i=j;
                j++;
            }
        }
        if(numbers.isEmpty())
        {
            System.out.println("There isn't such sum.");
        }


    }
    public static void dublicateNumberSearch(int arr[]) {
        Queue<Integer> tempNumbers = new LinkedList<>();
        Queue<Integer> numbers = new LinkedList<>();
        tempNumbers.add(arr[0]);
        int max = 1, len = 1;
        for (int i=1; i<arr.length; i++)
        {
            if (arr[i] == arr[i-1]) {
                len++;
                tempNumbers.add(arr[i]);
            }
            else
            {
                if (max < len) {
                    max = len;
                    numbers.clear();
                    for(Integer e : tempNumbers) {
                        numbers.add(e);
                    }
                }
                len = 1;
                tempNumbers.clear();
                tempNumbers.add(arr[i]);
            }

        }
        if (max < len) {
            numbers.clear();
            for(Integer e : tempNumbers) {
                numbers.add(e);
            }
        }
        if(numbers.isEmpty())
        {
            for(Integer e : tempNumbers) {
                numbers.add(e);
            }
        }
        for (Integer number: numbers) {
            System.out.println(number);
        }


    }
    public static void letterNumber() {
        int i=0;
        do{
            System.out.println(intword[i] + "Number of characters:" + intword[i].length());
            i++;
        }while(i<intword.length);

        
    }
    public static void wordReverse() {

        for (int i = 0; i < intword.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(intword[i]);
            sb.reverse();
            System.out.println(sb.toString());
        }
    
    }
    public static void dublicatedWords() {
        int br = 1;
        for (int i = 0; i < intword.length; i++) {
            if (intword[i] != null) {
                for (int j = i + 1; j < intword.length; j++) {

                    if (intword[j] != null) {
                        if (intword[i].toLowerCase().equals(intword[j].toLowerCase())) {
                            br++;
                            intword[j] = null;
                        }
                    }
                }
                System.out.println(intword[i] + "Number of repetitions-" + br);
                br = 1;
            }

        }

    }
    static final int MAX_CHAR = 256;
    static void dublicatedLetters(String str)
    {
        int count[] = new int[MAX_CHAR];
        int len = str.length();
        for (int i = 0; i < len; i++)
            count[str.charAt(i)]++;

        char ch[] = new char[str.length()];
        for (int i = 0; i < len; i++) {
            ch[i] = str.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == ch[j])
                    find++;
            }if (find == 1)
                System.out.println("Repetition of" + str.charAt(i) + " is:" + count[str.charAt(i)]);
        }

    }
    public static void fill() {
        intnumber = new int[length];
        for (int i = 0; i < length; i++) {
            intnumber[i] = scanner.nextInt();
            if (intnumber[i] < 0 || intnumber[i] > 10000) {
                scanner.next();
                System.out.println("invalid number");
                i = -1;
                continue;
            }
        }

    }
    public static void display() {
        intword = new String[length];
        for (int i = 0; i < length; i++) {
            intword[i] = scanner.next();
        }
    }

}

