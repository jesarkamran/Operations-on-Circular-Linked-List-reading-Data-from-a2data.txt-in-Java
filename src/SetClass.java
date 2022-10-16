import java.util.ArrayList;

// This is the class where we are performing the multiple operations on the circular linked list
public class SetClass
{
    // Method for finding the union of 2 linked lists.
    public CircularLinkedList union(CircularLinkedList list1, CircularLinkedList list2)
    {
        // Creating the new object of circular linked list
        CircularLinkedList c = new CircularLinkedList();
        // Inserting the node values into the arraylist
        ArrayList<Integer> list = arraylist(list1.getList(), list2.getList());

        // After adding the two linked lists into 1 data structure
        // we are performing the operation of union on the new third linked list to store this
        for (Integer integer : list) {
            Node temp = new Node(integer);
            c.sortAndInsert(temp);
        }
        return c;
    }
    // Method for 2 linked lists into one Arraylist.
    // This method helps us in easiness of performing the operation on linked lists
    // this does not eliminate the duplicates in lists.
    public ArrayList<Integer> arraylist(Node a, Node b)
    {
        ArrayList<Integer> list = new ArrayList<>();
        // Inserting the node values into the arraylist
        Node a1 = a, b1 = b;
        do
        {
            list.add(a1.data); a1 = a1.next;
        }while (a1 != a);
        do
        {
            if (b.next == b1) list.add(b.data);
            list.add(b1.data); b1 = b1.next;
        }while (b1 != b);
        return list;
    }
    // Method for finding the intersection of 2 linked lists.
    public CircularLinkedList getIntersection(Node list1, Node list2) {
        if (list1 ==null || list2 == null) return null;
        else {
            // Creating the new object of node as a type of arraylist
            ArrayList<Node> common = new ArrayList<>();
            Node a = list1;
            do {
                Node b = list2;
                do {

                    if (a.data == b.data) {
                        common.add(a);
                    }
                    b = b.next;
                } while (b != list2);
                a = a.next;
            } while (a != list1);
            // Creating the new object of circular linked list
            CircularLinkedList c = new CircularLinkedList();
            // After adding the two linked lists into 1 data structure
            // we are performing the operation of union on the new third linked list to store this
            for (Node node : common) {
                Node temp = new Node(node.data);
                // data is being added on the basis of sorted order
                c.sortAndInsert(temp);
            }
            return c;
        }
    }
    // Method for the deletion of node from the linked list.
    public CircularLinkedList deleteNode(CircularLinkedList list, int key)
    {
        //Setting the updated list in object
        list.setList(delete(list.getList(),key));
       return list;
    }
    public Node delete(Node head, int key) {
//      Find the required node
        Node curr = head, prev = new Node();
        while (curr.data != key) {
            if (curr.next == head) {
                System.out.println("\nGiven node is not found" + " in the list!!!");
                break;
            }

            // Here we are setting the pointers for the next deletion
            prev = curr;
            curr = curr.next;
        }

        // If more than one node, check if
        // it is first node
        if (curr == head) {
            prev = head;
            while (prev.next != head)
                prev = prev.next;
            head = curr.next;
            prev.next = head;
        }

        // check if node is last node
        else if (curr.next == head) {
            prev.next = head;
        }
        else {
            prev.next = curr.next;
        }
        return head;
    }

    // Method for finding the difference of node from the linked list.
    public CircularLinkedList difference(CircularLinkedList list1, CircularLinkedList list2)
    {
        if (list1.getList() != null && list2.getList() != null) {
            ArrayList<Integer> diff = new ArrayList<>();
            Node a = list1.getList();
            do {
                Node b = list2.getList();
                boolean check = true;
                do {
                    if (a.data == b.data) {
                        check = false;
                    }
                    b = b.next;
                } while (b != list2.getList());
                if (check) diff.add(a.data);
                a = a.next;
            } while (a != list1.getList());
            // Creating the new object of circular linked list
            CircularLinkedList c1 = new CircularLinkedList();
            // After adding the two linked lists into 1 data structure
            // we are performing the operation of difference on the new third linked list to store this
            for (Integer integer : diff) {
                Node temp = new Node(integer);
                c1.sortAndInsert(temp);
            }
            // Returning the new code from the method
            return c1;
        }
        else return  list1;
    }

    // Method for printing the circular linked list
    // Here we have passed the circular linked list object as a parameter.
    public void print(CircularLinkedList list) {
        // Condition for checking the null value of list
        if (list != null) {
            // Creating new list object of Node.
            Node circularList = list.getList();
            if (circularList != null) {
                Node node = list.getList();
                System.out.print("{ ");
                // Using do-while loop because circular linked is preferred in this one better
                do {
                    System.out.print(node.data + ", ");
                    node = node.next;
                } while (node != circularList);
                System.out.println("}");
                // If list was empty then null is printed
            } else System.out.println("{}");
        }
    }
}