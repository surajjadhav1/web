import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class CircularLinkedListDemo {
    Node root, last;

    void createLinkedList() {
        root = last = null;
    }

    void insertRight(int data) {
        Node n = new Node(data);
        if (root == null) {
            root = last = n;
            last.next = root;
        } else {
            last.next = n;// 1
            last = n;// 2
            last.next = root;// 3
        }
    }

    void printList() {
        if (root == null) {
            System.out.println("List Empty");
        } else {
            Node t;
            t = root;
            do {
                System.out.println(t.data);
                t = t.next;
            } while (t != root);// 2
        }
    }

    public static void main(String args[]) {
        int ch, e;
        var obj = new CircularLinkedListDemo();
        Scanner in = new Scanner(System.in);
        obj.createLinkedList();
        do {
            System.out.println(
                    "1.insertRight\n2.PrintList \n0.ToEnd");
            ch = in.nextInt();
            switch (ch) {
              

                case 1:
                    System.out.println("Enter Data:");
                    e = in.nextInt();
                    obj.insertRight(e);
                    System.out.println("Added");
                    break;

               
                case 2:
                    obj.printList();
                    break;

                case 0:
                    System.out.println("Exiting ");
                    break;

                default:
                    System.out.println("Wrong option selected");
                    break;
            }
        } while (ch != 0);
        in.close();
    }
}
