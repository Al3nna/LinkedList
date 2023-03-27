//This file is to run the code

//importing required class
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        //creating main BonBon Object
        BonBon main = new BonBon();
        //creating base Bucket Object
        Bucket base = new Bucket();
        //getting inScanner
        Scanner inScanner = BonBon.getInScanner();

        //setting attributes
        boolean moreBB = true;
        Node prevNode = new Node();
        int num = 1;
        boolean error;

        //looping until user has no more BonBons to enter
        while (moreBB != false) {
            //creating new BonBon
            main.createBB();

            //if BonBon is the first
            if (num == 1) {
                //setting the list head
                base.setHead(main.bb);
            //if BonBon is not the first
            } else {
                //settign new Node
                base.addNode(prevNode, main.bb);
            }

            //setting previous node for next item
            prevNode = base.node;
            //recognizing a BonBon was added to the bucket
            num++;

            System.out.println();
            //setting var
            error = true;
            //looping while error = true
            while (error != false) {
                System.out.println("Would you like to enter another BonBon? (Yes or No)");
                //getting response from user
                String response = inScanner.nextLine();
                //if response is at least 3 chars long
                if (response.length() >= 3) {
                    //trimming response
                    String r = response.substring(0, 3);
                    //setting r to lowercase
                    r = r.toLowerCase();
                    //if r contains "yes"
                    if (r.contains("yes")) {
                        //updating vars
                        error = false;
                        moreBB = true;
                    }
                //if response is at least 2 chars long
                } else if (response.length() >= 2) {
                    //trimming response
                    String r = response.substring(0, 2);
                    //setting r to lowercase
                    r = r.toLowerCase();
                    //if r contains "no"
                    if (r.contains("no")) {
                        //updating vars
                        error = false;
                        moreBB = false;
                    }
                }
                System.out.println();
            }
                //finding tail
            //setting attribute
            Node n = base.head;
            //looping while next node is not known
            while (n.next != null) {
                //switching to next node
                n = n.next;
            }
            //recognizing tail
            base.setTail(n);
        }

        System.out.println();
        System.out.println("HEAD");
        //printing head of list
        System.out.println(base.head);
        System.out.println();
        //printing list in ascending order
        base.printListA(base.head);
        System.out.println();
        System.out.println("******************************************");
        System.out.println();
        System.out.println("TAIL:");
        //printing tail of list
        System.out.println(base.tail);
        System.out.println();
        //printing list in descending order
        base.printListD(base.tail);
        
    }
}
