package jpknox.singlylinkedlist;

/**
 * Created by Joao Paulo Knox on 22/02/17.
 * Just going over the basics :)
 */
public class SinglyLinkedListDemo {

    public static void main(String[] args) {
        System.out.println("Hello from the SinglyLinkedList demo!");

        SinglyLinkedList list = new SinglyLinkedList();

        list.displayList();

        list.addNode(4, "Red");
        list.addNode(9, "Blue");
        list.displayList();

        System.out.println(list.findNode(4));
        System.out.println(list.findNode(9));
        System.out.println(list.findNode(1));

        System.out.println(list.removeNode(4));
        list.displayList();

        System.out.println(list.removeNode(9));
        list.displayList();

        list.addNode(4, "Red");
        list.addNode(9, "Blue");
        list.displayList();

        System.out.println(list.removeNode(9));
        list.displayList();

        list.addNode(11, "Yellow");
        list.addNode(13, "Purple");
        list.addNode(15, "Green");
        list.addNode(18, "Orange");
        list.displayList();
        System.out.println(list.removeNode(15));
        list.displayList();

        System.out.println(list.removeNode(99));


        System.out.println("Thanks for popping by! :)");
    }

}

class SinglyLinkedList {

    private Node first;
    private int total;

    public SinglyLinkedList() {
        first = null;
        total = 0;
    }

    public void addNode(int id, String data) {
        Node fresh = new Node(id, data);

        if (first == null) {
            first = fresh;
            return;
        }

        Node temp = first;
        fresh.setNext(temp);
        first = fresh;

    }

    public String removeNode(int id) {
        Node current = first;
        Node prev = first;          //current == prev only at beginning

        if (current == null)
            return null;

        while (current != null) {
            if (current.getId() == id) {
                if (current == first && current.getNext() != null) {
                    first = current.getNext();
                }
                else if (current == first && current.getNext() == null){
                    first = null;
                }

                if (current.getNext() != null) {
                    prev.setNext(current.getNext());
                }
                else if (current.getNext() == null) {
                    prev.setNext(null);
                }

                return "Removing node : " + current.toString();

            }
            prev = current;
            current = current.getNext();
        }

        return "Nothing found with id : " + id;                //nothing found
    }

    public String findNode(int id) {
        Node current = first;

        if (current == null)
            return null;

        while (current != null) {
            if (current.getId() == id)
                return "Found Node : " + current.toString();

            current = current.getNext();
        }

        return "Nothing found with id : " + id;                //nothing found
    }

    public void displayList() {
        System.out.print("Displaying List : ");

        if (first == null) {
            System.out.println("empty");
            return;
        }

        Node current = first;
        while (current != null) {
            System.out.print(current.toString() + " ");
            current = current.getNext();
        }
        System.out.println();

    }



    private class Node {

        private int id;
        private String data;
        private Node next;

        public Node(int id, String data) {
            this.id = id;
            this.data = data;
        }

        public int getId() {
            return id;
        }

        public String getData() {
            return data;
        }

        public void setNext(Node newNext) {
            this.next = newNext;
        }

        public Node getNext() {
            return next;
        }

        @Override
        public String toString() {
            return "{{ id : " + getId() + " }{ data : " + getData() + " }}";
        }

    }

}
