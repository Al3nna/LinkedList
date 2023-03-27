//This program was made by Alenna for the CTE course "Software & Programming Development 2" instructed by Mr. Gross
//Email - alenna.castaneda@oneidaihla.org
//This files is to handle events closest related to the bucket & nodes

public class Bucket {                                                    
    //creating attributes
    Node head;
    Node tail;
    Node node;
    //setting head of list
    public void setHead(BonBon data) {
        //setting data
        node = new Node(data);
        //setting new Node as head
        head = node;
        /*previous is null by default*/
    }

    //adding Node to list
    public void addNode(Node previousNode,BonBon data) {
        //setting data
        node = new Node(data);
        //setting previous Node
        node.previous = previousNode;
        //setting previous Node's next
        previousNode.next = node;
        /*Node.next is set when another Node is added */
    }

    //setting tail of list
    public void setTail(Node endingNode) {
        //setting Node as tail
        tail = endingNode;
    }

    //printing List, starting from Head
    public void printListA(Node head) {
        System.out.println("Ascending List:");
        System.out.println();

        //creating & setting attribute
        Node n = head;

        //looping while n isn't null
        while (n != null) {
            //printing node
            System.out.println(n);
            //switching to next node
            n = n.next;
        }
    }

    //printing List, starting from Tail
    public void printListD(Node tail) {
        System.out.println("Descending List:");
        System.out.println();

        //creating & setting attribute
        Node n = tail;

        //looping while n isn't null
        while (n != null) {
            //printing node
            System.out.println(n);
            //switching to next node
            n = n.previous;
        }
    }
}

class Node {
    //creating attributes
    Node next;
    Node previous;
    BonBon Data;

    //constructor for filled input
    public Node(BonBon data) {
        this.next = null;
        this.previous = null;
        this.Data = data;
    }

    //constructor for empty input
    public Node() {
        this.next = null;
        this.previous = null;
        this.Data = null;
    }

    public String toString() {
        //setting attribute
        String info = Data.ToString();

        //if previous is not null
        if (previous != null) {
            //setting attribute
            String p = "Previous: "+previous.Data.name;
            //updating var
            info = (info+"\n"+p);
        }

        //if next is not null
        if (next != null) {
            //setting attribute
            String n = "Next: "+next.Data.name;
            //updating var
            info = (info+"\n"+n);
        }
 
        //adding border to info string
        info = "------------------------------------------\n"+info+"\n------------------------------------------";
        return info;
    }
}