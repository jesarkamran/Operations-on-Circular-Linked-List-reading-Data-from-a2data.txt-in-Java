import java.io.*;
import java.util.*;

// Runner Class Contain the main method which is helping the logic implemented in other two classes to execeute
public class Runner {
    public static void main(String args[]) throws IOException {

        //Creating the file object to specify the location of the file
        File file = new File("E:\\Programming\\Paid  Tasks\\paid task 9\\Linked List\\src\\a2data.txt");
        // Buffer reader object is created to read the object of file class
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String answer = "";
        while ((st = br.readLine()) != null) {
            answer = answer + "\n" + st;
        }
        String[] inputs = answer.split("\n");

        // Seprating the lines on the basis of space between them for distinguishing the output in a pattern
        ArrayList<String[]> lists = new ArrayList<>();
        for (String input : inputs) {
            lists.add(input.split(" "));
        }

        ArrayList<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            nodeList.add(new Node());
        }
        // Creating the multiples objects of circular linked list class to store the data in the format
        CircularLinkedList c0,c1, c5,c7,c8;
        c0 =new CircularLinkedList();
        c1 =new CircularLinkedList();
        c5 =new CircularLinkedList();
        c7 =new CircularLinkedList();
        c8 =new CircularLinkedList();


        //Here comes the cases of description of the problem
        // 1- In first we are printing the data of circular linked list
        // 2- Here we are inserting the data into the circular linked list
        // 3- Here we are checking the operation which we are going to perform on the circular linked list
        SetClass obj = new SetClass();
        for (String[] list : lists) {
            // sortAndInsert() method is inserting the values in sorted order
            // this method is defined in the node class
            if (list.length == 2) // print data
            {
                int index = Integer.parseInt(list[1]);
                c8.setList(nodeList.get(index));
                System.out.print("P" + index + ": ");
                obj.print(c8);
            } else if (list.length == 3) // insert data
            {
                if (list[0].equals("I") && list[1].equals("0")) {
                    int index = Integer.parseInt(list[1]);
                    c0.sortAndInsert(new Node(Integer.parseInt(list[2])));
                    nodeList.set(index, c0.getList());
                } else if (list[0].equals("I") && list[1].equals("1")) {
                    int index = Integer.parseInt(list[1]);
                    c1.sortAndInsert(new Node(Integer.parseInt(list[2])));
                    nodeList.set(index, c1.getList());
                } else if (list[0].equals("I") && list[1].equals("5")) {
                    int index = Integer.parseInt(list[1]);
                    c5.sortAndInsert(new Node(Integer.parseInt(list[2])));
                    nodeList.set(index, c5.getList());
                } else if (list[0].equals("I") && list[1].equals("7")) {
                    int index = Integer.parseInt(list[1]);
                    c7.sortAndInsert(new Node(Integer.parseInt(list[2])));
                    nodeList.set(index, c7.getList());
                } else if (list[0].equals("D") && list[1].equals("5")) {
                    int index = Integer.parseInt(list[1]);
                    CircularLinkedList c = new CircularLinkedList();
                    c.setList(nodeList.get(index));
                    int key = Integer.parseInt(list[2]);
                    c5 = obj.deleteNode(c, key);
                    nodeList.set(index, c5.getList());
                }
            } else if (list.length == 4) // operations on data
            {
                if (list[0].equals("U")) {
                    // Operation for union

                    CircularLinkedList c = new CircularLinkedList();
                    int index1 = Integer.parseInt(list[1]);
                    int index2 = Integer.parseInt(list[2]);
                    int saveIndex = Integer.parseInt(list[3]);
                    CircularLinkedList l1 = new CircularLinkedList();
                    CircularLinkedList l2 = new CircularLinkedList();
                    l1.setList(nodeList.get(index1));
                    l2.setList(nodeList.get(index2));
                    c = obj.union(l1, l2);
                    nodeList.set(saveIndex, c.getList());

                } else if (list[0].equals("\\")) {
                    // Operation for difference

                    CircularLinkedList c = new CircularLinkedList();
                    int index1 = Integer.parseInt(list[1]);
                    int index2 = Integer.parseInt(list[2]);
                    int saveIndex = Integer.parseInt(list[3]);
                    CircularLinkedList l1 = new CircularLinkedList();
                    CircularLinkedList l2 = new CircularLinkedList();
                    l1.setList(nodeList.get(index1));
                    l2.setList(nodeList.get(index2));
                    c = obj.difference(l1, l2);
                    nodeList.set(saveIndex, c.getList());

                } else if (list[0].equals("*")) {
                    // Operation for intersection

                    CircularLinkedList c = new CircularLinkedList();
                    int index1 = Integer.parseInt(list[1]);
                    int index2 = Integer.parseInt(list[2]);
                    int saveIndex = Integer.parseInt(list[3]);
                    c = obj.getIntersection(nodeList.get(index1), nodeList.get(index2));
                    if (c != null) nodeList.set(saveIndex, c.getList());

                } else if (list[0].equals("D")) {
                    // Operation for deletion

                    CircularLinkedList c = new CircularLinkedList();
                    int index1 = Integer.parseInt(list[1]);
                    int index2 = Integer.parseInt(list[2]);
                    CircularLinkedList node = new CircularLinkedList();
                    node.setList(nodeList.get(index1));
                    c = obj.deleteNode(node, Integer.parseInt(list[index2]));
                    nodeList.set(index1, c.getList());
                }
            }
        }
    }
}
