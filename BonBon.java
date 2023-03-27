//this file is to handle events closest related to the BonBons

//importing required classes
import java.util.InputMismatchException;
import java.util.Scanner;

public class BonBon {
    //setting attributes
    String name;
    int age;
    String owner;
    String gender;
    String fullData;
    //creating new BonBon object
    BonBon bb;

    //creating scanner that reads from System.in
    static Scanner inScanner = new Scanner(System.in);
    //creating method to get inScanner
    public static Scanner getInScanner() {return (inScanner);}

    //constructor
    public BonBon() {
        name = "empty";
        age = 0;
        owner = "empty";
        gender = "empty";
    }

    //putting BonBon data into string
    public String ToString() {
        //setting value
        fullData = (name+", Age "+age+" "+gender+" owned by "+owner);
        return (fullData);
    }

    //printinng BonBon Data
    public void printBB(BonBon bb) {
        System.out.println("BonBon creation was succesful");
        System.out.println("------------------------------");
        System.out.println("Name: "+bb.name);
        System.out.println("Gender: "+bb.gender);
        System.out.println("Age: "+bb.age);
        System.out.println("Owner: "+bb.owner);
        System.out.println("-------------------------------");
    }

    //creating BonBon
    public void createBB() {
        //setting bb
        bb = new BonBon();
        System.out.println("Please enter the BonBon's name.");
        //getting name from user
        bb.name =  inScanner.nextLine();
        System.out.println();
        //setting attribute
        char data = 'e';
        //while data is not f or m
        while (data != 'f' && data != 'm') {
            System.out.println("Enter "+bb.name+"'s gender (F or M)");

            //getting data from user
            data = inScanner.nextLine().charAt(0);
            
            //creating temp string
            String temp = (data+"");
            //setting temp to lowercase
            temp = temp.toLowerCase();
            //setting data val
            data = temp.charAt(0);

            if (data != 'f' && data != 'm') {
                System.out.println();
                System.out.println("-==-Error-==-");
                System.out.println("Invalid input. Please enter "+'"'+"Male"+'"'+" or "+'"'+"Female"+'"'+".");
                System.out.println();
            }
        }

        //if data = f
        if (data == 'f') {
            bb.gender = "Female";
        //data = m
        } else {
            bb.gender = "Male";
        }
        System.out.println();
        
        //setting attribute
        boolean error = true;
        //while input is invalid
        while (error != false) {
            //resetting var
            error = false;
            try {
                System.out.println("Enter "+bb.name+"'s age.");
                //getting age from user
                bb.age = inScanner.nextInt();
                //reading & discarding user input
                inScanner.nextLine();
                System.out.println();

                //if age < 0
                if (bb.age < 0) {
                    //updating var
                    error = true;
                    System.out.println();
                    System.out.println("-==-Error-==-");
                    System.out.println(bb.name+"'s age cannot be negative.");
                    System.out.println();
                }
            } catch (InputMismatchException i) {
                //updating var
                error = true;
                System.out.println("-==-Error-==-");
                System.out.println("Please enter a whole number of at least 0.");
                System.out.println();
            }
        }
        
        System.out.println("Enter "+bb.name+"'s owner.");
        //getting owner from user
        bb.owner = inScanner.nextLine();
        System.out.println();

        //printing object
        printBB(bb);
    }
}
