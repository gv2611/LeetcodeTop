package org.example.LinkedList;

import java.util.HashMap;

class Node{
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {

        if(head==null){
            return null;
        }
        Node backup = head;
        Node prev= new Node(head.val);
        Node newNode = prev;
        HashMap<Node, Node> originalToNew = new HashMap<>();
        originalToNew.put(head, prev);

        while(head!=null ){
            Node next = null;
            if (head.next!=null){
                next = new Node(head.next.val);
                originalToNew.put(head.next, next);
            }
            prev.next = next;
            prev = prev.next;
            head=head.next;
        }

        head = backup;
        prev = newNode;


        while (head!=null){
            prev.random = originalToNew.get(head.random);
            head=head.next;
            prev=prev.next;
        }
        return newNode;
    }

    public static void main(String[] args){
        CopyListWithRandomPointer copy = new CopyListWithRandomPointer();
        Node head = new Node(7);
        head.random = null;
        head.next = new Node(13);
        head.next.random = head;
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.random = head;
        head.next.next.next.random = head.next.next;
        head.next.next.random = head.next.next.next.next;
        Node output = copy.copyRandomList(head);
        copy.printLinkedList(head);


    }

    private void printLinkedList(Node head) {

        while(head!=null){
            System.out.println(head.val+"Random : " + head.random+" -> " );
            head=head.next;
        }
    }

}
