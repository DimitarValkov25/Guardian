import javafx.geometry.Side;

import java.awt.*;

public class number2 {
    public static void main(String[] args) {
        rectangleArea();
        rectanglePerimeter();
        outputMonth();
        suicide();
    }

    // TASK 1---------------
    public static void rectangleArea() {
        int SideA = 2;
        int SideB = 6;
        int Area = SideA * SideB;
        System.out.println("RecArea :   " + Area + " cm");

    }

    public static void rectanglePerimeter() {
        int SideA = 2;
        int SideB = 6;
        int Perimeter = 2 * SideA + 2 * SideB;
        System.out.println("RecPerimeter:   " + Perimeter + " cm");
    }

    // TASK 2----------------
    public static void outputMonth() {

        String outputMonth = "May";


        if (outputMonth.equals("January")) {
            System.out.println("Days: 31");
        } else if (outputMonth.equals("January")) {
                System.out.println("Days: 31");
        }
         else if (outputMonth.equals("February")) {
            System.out.println("Days: 29");
        } else if (outputMonth.equals("March")) {
            System.out.println("Days: 31");
        } else if (outputMonth.equals("April")) {
            System.out.println("Days: 30");
        } else if (outputMonth.equals("May")) {
            System.out.println("Days: 31");
        } else if (outputMonth.equals("Jun")) {
            System.out.println("Days: 30");
        } else if (outputMonth.equals("July")) {
            System.out.println("Days: 31");
        } else if (outputMonth.equals("August")) {
            System.out.println("Days: 31");
        } else if (outputMonth.equals("September")) {
            System.out.println("Days: 31");
        } else if (outputMonth.equals("Octomber")) {
            System.out.println("Days: 31");
        } else if (outputMonth.equals("November")) {
            System.out.println("Days: 30");
        } else if (outputMonth.equals("December")) {
            System.out.println("Days: 31");
        }

    }

    // TASK 3------------------------------
    public static void suicide() {
        int FloorNumber = 8;
        String FloorInhabitantName;
        String OneLaastJump;

        switch (FloorNumber) {
            case 8:
                FloorInhabitantName = "Mimi";
                System.out.println(" FloorInhabitantName:Hello " + FloorInhabitantName);
            case 7:
                FloorInhabitantName = "Pepi";
                System.out.println(" FloorInhabitantName:Hello " + FloorInhabitantName);
            case 6:
                FloorInhabitantName = "Vania";
                System.out.println(" FloorInhabitantName:Hello " + FloorInhabitantName);
            case 5:
                FloorInhabitantName = "Arthas";
                System.out.println(" FloorInhabitantName:Hello " + FloorInhabitantName);
            case 4:
                FloorInhabitantName = "Tirion";
                System.out.println(" FloorInhabitantName:Hello " + FloorInhabitantName);
            case 3:
                FloorInhabitantName = "Jhon";
                System.out.println(" FloorInhabitantName:Hello " + FloorInhabitantName);
            case 2:
                FloorInhabitantName = "Gabriela";
                System.out.println(" FloorInhabitantName:Hello " + FloorInhabitantName);
            case 1:
                FloorInhabitantName = "Sonya";
                System.out.println(" FloorInhabitantName:Hello " + FloorInhabitantName);
            case 0:
                OneLaastJump = "Ouchhhhhh";
                System.out.println(" OneLaastJump: " + OneLaastJump);
                break;

        }


    }

}
