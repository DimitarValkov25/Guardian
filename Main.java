import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String line;
        List<Person> myList = new ArrayList<Person>();
        ArrayList<String> kidsList = new ArrayList<String>();

        try {
            FileReader file = new FileReader("C:\\Users\\maria\\Desktop\\Task420\\src\\file1.txt");
            BufferedReader br = new BufferedReader(file);


            Scanner input = new Scanner((Readable) file);

            while ((line = br.readLine()) != null) {
                String rowInfo = "";
                Pattern p = Pattern.compile("(?<=\\[).+?(?=\\])");
                Matcher m = p.matcher(line);
                    while (m.find()) {
                        String m2 = m.group();
                        rowInfo += m2 + " ";
                    }
                String[] words = rowInfo.split("\\W+");
                Person person = new Person(words[0],words[1],words[2], Integer.parseInt(words[3]),words[4],words[5],Integer.parseInt(words[6]));
                myList.add(person);

                if(words[0].equals("M"))
                {
                    String parentKid = String.valueOf(myList.size()-1)+" ";
                    for(int i=8;i<words.length;i++)
                    {
                        parentKid+=words[i]+" ";
                    }
                    kidsList.add(parentKid);
                }

            }

            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        Scanner input = new Scanner(System.in);
        String query = input.nextLine();

        switch(query)
        {  case "SELECT":

            for (Person person : myList) {
                System.out.println(person.getName()+" "+person.getLastName()+" "+person.getAge()+" "+person.getGender()+" "+
                        person.getAddress()+" "+person.getPhoneNumber());
            }
            break;
            case "SELECT{TYPE}=[R]":
                List<Person> result = myList.stream()
                        .filter(item -> item.getType().equals("R"))
                        .collect(Collectors.toList());
                for (Person person : result) {
                    System.out.println(person.getName()+" "+person.getLastName()+" "+person.getAge()+" "+person.getGender()+" "+
                            person.getAddress()+" "+person.getPhoneNumber());
                }
                break;
            case "SELECT{TYPE}=[R]@{SEX}=[F]":
                result = myList.stream()
                        .filter(item -> item.getType().equals("R")&&item.getGender().equals("F"))
                        .collect(Collectors.toList());
                for (Person person : result) {
                    System.out.println(person.getName()+" "+person.getLastName()+" "+person.getAge()+" "+person.getGender()+" "+
                            person.getAddress()+" "+person.getPhoneNumber());
                }
                break;
            case "SELECT{FNAME}=[Pesho]":
                result = myList.stream()
                        .filter(item -> item.getName().equals("Pesho"))
                        .collect(Collectors.toList());
                for (Person person : result) {
                    System.out.println(person.getName()+" "+person.getLastName()+" "+person.getAge()+" "+person.getGender()+" "+
                            person.getAddress()+" "+person.getPhoneNumber());
                }
                break;
            case "SELECT{AGE}=[18]":
                result = myList.stream()
                        .filter(item -> item.getAge()==18)
                        .collect(Collectors.toList());
                for (Person person : result) {
                    System.out.println(person.getName()+" "+person.getLastName()+" "+person.getAge()+" "+person.getGender()+" "+
                            person.getAddress()+" "+person.getPhoneNumber());
                }
                break;

            default:
                System.out.println("no match");
        }
    }
}