import java.util.Scanner;
import java.util.Random;

public class domashna03 {

   private static  byte charge = 4;
   private static Random random = new Random();
   private static Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) {

        map();
        fighterFX();
        displayNumber();

    }
    public  static  void map() {
        String something;
        System.out.print("Obstacle ");
        something = scanner.nextLine();
        switch (something) {
            case "wWall":
                System.out.println("Go sideway");
                break;
            case "cChair":
                System.out.println("Jump Over");
                break;
            case "nNothing":
                System.out.println("Move Forward");
                break;
        }
    }
    public  static void fighterFX() {

        int pixels;
        do {
            System.out.println("PIXELS YOU WANT TO BE CALCULATED");
            pixels = scanner.nextInt();
            if (pixels % 2 != 0) {
                System.out.println("Cannot proceed");
                break;
            } else {
                if(!charge())break;
                furnitureDestroyer ();

            }
        } while (true);
        scanner.close();

    }
    public static void furnitureDestroyer (){
        int furnitureExecutioner = random.nextInt(9) + 1;
        if (furnitureExecutioner == 5)
            System.out.println("{}EVERYTHING HAS BEEN DESTROYED{}");
        else
            System.out.println("{}MOUSE ONLY{}");

    } public static boolean charge (){
        System.out.println("MOUSE IS GOING TO BE DAMAGED");
        charge--;
        if (charge == 0)
            if (!chargeOrNO())
                return false;
            else
                charge = 4;
        return true;
    }
    public static boolean chargeOrNO() {
        int randomNumberOne = random.nextInt(999)+1;
        int randomNumberTwo = random.nextInt(999)+1;
        if (randomNumberOne > randomNumberTwo) {
            System.out.println("Electricity ON");
            return true;
        } else if (randomNumberTwo > randomNumberOne) {
            System.out.println("NO Electricity");
            return false;
        } else return chargeOrNO();
    }
    public static void displayNumber() {
        System.out.println("----------EVEN----------");
        int i=10;
        while(i>0)
        {
            if(i%2==0)System.out.println(i+" I am a Robottttt");
            else
            {
                System.out.println(i);
            }
            i--;
        }
    }
}
