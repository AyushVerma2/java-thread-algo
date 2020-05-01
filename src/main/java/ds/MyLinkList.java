package ds;

public class MyLinkList {
    Node head;

    public static void main(String[] args) {
        MyLinkList myLinkList = new MyLinkList();
        myLinkList.addNode(new Node(23));
        myLinkList.addNode(new Node(44));
        myLinkList.addNode(new Node(55));
        myLinkList.addNode(new Node(212));
        myLinkList.display();
        //myLinkList.head = myLinkList.reverse(myLinkList.head);
        myLinkList.head = myLinkList.reverseList(myLinkList.head);
        System.out.println();
        myLinkList.display();

    }

    void addNode(Node node) {

        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (null != temp.next) {
            temp = temp.next;
        }
        temp.next = node;


    }

    void display() {
        Node temp = head;
        while (null != temp) {
            System.out.print(temp.data);
            System.out.print("  ");
            temp = temp.next;

        }


    }

    /**
     * Iterative
     *
     * @param node
     * @return
     */
    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;


    }

    /**
     * Recursive
     *
     * @param node
     * @return
     */
    Node reverseList(Node node) {
        if (node == null || node.next == null) return node;
        Node p = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return p;
    }


}


class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}