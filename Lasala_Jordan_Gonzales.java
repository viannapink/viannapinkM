package Final;

import java.util.Scanner;

public class Lasala_Jordan_Gonzales {
    static Scanner getInt = new Scanner(System.in);
    static Scanner getSt = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("1 - Singly Linked List\n2 - Doubly Linked List\n3 - Circular Linked List\nWhich program would you like to access? ");
        int program = getInt.nextInt();

        switch (program) {
            case 1:
                Lists list = new LinkedList();
                System.out.println("============================== SINGLY LINKED LIST ==============================");
                action(list);
                break;
            case 2:
                Lists list2 = new DoublyLinkedList();
                System.out.println("============================== DOUBLY LINKED LIST ==============================");
                action(list2);
                break;
            case 3:
                System.out.println("============================= CIRCULAR LINKED LIST =============================");
                actionC();
                break;
            default:
                System.out.println("\nInput not in the choices!");
                break;
        }
    }

    private static String userInput() {
        System.out.print("Enter number: ");
        return getSt.nextLine();
    }

    private static int indexInput() {
        System.out.print("Enter index: ");
        return getInt.nextInt();
    }

    private static void action(Lists list) {

        boolean exit = false;
        String input;
        int index;

        System.out.println("\n1 - Insert at Start\n2 - Insert at Any Position\n3 - Insert at End\n" +
                "4 - Delete at Start\n5 - Delete at Any Position\n6 - Delete at End\n7 - Exit");

        while (!exit) {

            System.out.print("Select a number: ");
            int action = getInt.nextInt();

            switch (action) {
                case 1:

                    input = userInput();

                    list.insertAtStart(input);
                    list.print();
                    break;
                case 2:

                    input = userInput();
                    index = indexInput();

                    list.insertAt(index, input);
                    list.print();
                    break;
                case 3:

                    input = userInput();

                    list.insertAtEnd(input);
                    list.print();
                    break;
                case 4:

                    list.deleteAtStart();
                    list.print();
                    break;
                case 5:

                    index = indexInput();
                    list.deleteAt(index);
                    list.print();
                    break;
                case 6:

                    list.deleteAtEnd();
                    list.print();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Not in the choices!");
                    break;
            }
        }
    }

    private static void actionC() {

        boolean exit = false;
        String input;

        CircularLinkedList cList = new CircularLinkedList();

        System.out.println("\n1 - Insert at Start\n2 - Insert at End\n3 - Delete at Start\n4 - Delete at End\n5 - Exit");

        while (!exit) {

            System.out.print("Select a number: ");
            int action = getInt.nextInt();


            switch (action) {
                case 1:

                    input = userInput();

                    cList.insertAtStart(input);
                    cList.print();
                    break;
                case 2:

                    input = userInput();

                    cList.insertAtEnd(input);
                    cList.print();
                    break;
                case 3:

                    cList.deleteAtStart();
                    cList.print();
                    break;
                case 4:

                    cList.deleteAtEnd();
                    cList.print();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Not in the choices!");
                    break;
            }
        }
    }

    static class Node {

        public Node prev;
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }
    }

    static public class Lists {

        public int length;
        Node head;

        public void insertAtStart(String data) { }

        public void insertAt(int index, String data) { }

        public void insertAtEnd(String data) { }

        public void deleteAtStart() { }

        public void deleteAt(int index) { }

        public void deleteAtEnd() { }

        public void print() {

            Node node = head;

            if (head == null) {
                System.out.print("\nDATA: No Content\n");
            } else {
                System.out.print("\nDATA: ");

                while (node.next != null) {
                    System.out.print(node.data + " ");
                    node = node.next;
                }
                System.out.println(node.data);
            }
        }

        public boolean isEmpty() {
            return length == 0;
        }
    }

    public static class LinkedList extends Lists {

        public void insertAtStart(String data) {

            System.out.println("SINGLY");
            Node node = new Node(data);
            node.next = null;

            node.next = head;
            head = node;
            length++;

        }

        public void insertAt(int index, String data) {

            Node node = new Node(data);
            node.next = null;

            if (index == 1) {

                insertAtStart(data);

            } else if (index > length) {

                System.out.println("The index you entered does not exist");

            } else {

                Node n = head;
                for (int i = 1; i < index - 1; i++) {
                    n = n.next;
                }
                node.next = n.next;
                n.next = node;
                length++;
            }
        }

        public void insertAtEnd(String data) {

            Node node = new Node(data);
            node.next = null;

            if (isEmpty()) {
                insertAtStart(data);
            } else {

                Node n = head;

                while (n.next != null) {

                    n = n.next;
                }
                n.next = node;
                length++;

            }
        }

        public void deleteAtStart() {

            if (isEmpty()) {
                System.out.println("The List is empty");
            } else {
                head = head.next;
                length--;
            }
        }

        public void deleteAt(int index) {

            if (index == 0) {

                head = head.next;
                length--;

            } else if (index > length) {

                System.out.println("The index you entered does not exist");

            } else {

                Node n = head;
                Node n1;
                for (int i = 0; i < index - 1; i++) {
                    n = n.next;
                }
                n1 = n.next;
                n.next = n1.next;
                n1 = null;
                length--;
            }
        }

        public void deleteAtEnd() {

            if (isEmpty()) {
                System.out.println("The List is empty");
            } else {

                Node n = head;

                while (n.next.next != null) {
                    n = n.next;
                }
                n.next = null;
                length--;
            }
        }
    }

    static class DoublyLinkedList extends Lists {

        Node dHead;
        Node dTail;
        int length;

        public DoublyLinkedList() {

            this.dHead = null;
            this.dTail = null;
            this.length = 0;
        }

        public void insertAtStart(String data) {

            System.out.println("DOUBLY");
            Node n = new Node(data);
            if (isEmpty()) {

                dTail = n;

            } else {

                head.prev = n;

            }
            n.next = dHead;
            dHead = n;
            length++;

        }

        public void insertAt(int index, String data) {

            Node n = new Node(data);

            if (isEmpty()) {
                if (index == 1) {

                    insertAtStart(data);

                } else {

                    System.out.print("\nIndex does not exist");

                }
            } else if (index == 1) {

                insertAtStart(data);

            } else {

                Node node = dHead;
                while (node != null && index > 2) {
                    node = node.next;
                    index--;
                }

                if (node == null) {

                    System.out.println("\nIndex does not exist 2");

                } else {

                    n.next = node.next;
                    n.prev = node;

                    if (node.next != null) {

                        insertAtEnd(data);

                    }
                    node.next = n;
                    length++;
                }
            }
        }

        public void insertAtEnd(String data) {

            Node n = new Node(data);
            Node current = dHead;

            while (current.next != null) {
                current = current.next;
            }
            current.next = n;
            length++;

        }

        public void deleteAtStart() {

            if (isEmpty()) {
                System.out.println("List is Empty");
            } else {

                Node n = dHead;
                if (dHead == dTail) {
                    dTail = null;
                } else {
                    dHead.next.prev = null;
                }
                dHead = dHead.next;
                n.next = null;
                length--;
            }
        }

        public void deleteAt(int index) {

            Node n = dHead;

            if (isEmpty()) {
                System.out.println("List is Empty");
            } else {
                if (index == 1) {
                    if (n.next != null) {

                        deleteAtStart();

                    }
                } else {
                    while (n != null && index > 1) {

                        n = n.next;
                        index--;
                    }
                    if (n == null) {

                        System.out.println("\nIndex does not exist 2");

                    } else if (n.next != null) {

                        n.next.prev = n.prev;
                        n.prev.next = n.next;
                        length--;

                    } else {

                        deleteAtEnd();

                    }
                }
            }
        }

        public void deleteAtEnd() {

            Node current = dHead;

            if (isEmpty()) {

                System.out.println("List is Empty");

            } else {

                while (current.next != null) {
                    current = current.next;
                }
                current.prev.next = current.next;
                length--;
            }
        }
    }

    static class CircularLinkedList extends Lists {

        Node last;
        int length;

        public CircularLinkedList() {

            this.last = null;
            this.length = 0;
        }

        public void insertAtStart(String data) {

            System.out.println("CIRCULAR");

            Node n = new Node(data);
            if (last == null) {

                last = n;

            } else {

                n.next = last.next;

            }
            last.next = n;
            length++;
        }

        public void insertAtEnd(String data) {

            Node n = new Node(data);
            if (last == null) {

                last = n;
                last.next = last;

            } else {

                n.next = last.next;
                last.next = n;
                last = n;
            }
            length++;
        }

        public void deleteAtStart() {

            Node n = last.next;

            if (isEmpty()) {

                System.out.println("List is Empty\n");

            } else {
                if (last.next == last) {

                    last = null;

                } else {

                    last.next = n.next;

                }
                n.next = null;
                length--;
            }
        }

        public void deleteAtEnd() {

            Node n = last.next;
            Node prev = n;

            if (isEmpty()) {

                System.out.println("List is Empty\n");

            } else {
                if (last.next == last) {

                    last = null;

                } else {
                    while (n.next != last.next) {
                        prev = n;
                        n = n.next;
                    }
                    prev.next = last.next;
                    last = prev;
                    n = null;
                }
                length--;
            }
        }

        public void print() {

            if (last == null) {
                System.out.print("\nDATA: No Content\n");

            } else {

                System.out.print("\nDATA: ");
                Node first = last.next;

                while (first != last) {
                    System.out.print(first.data + " ");
                    first = first.next;
                }
                System.out.print(first.data + "\n");
            }
        }
    }
}