package org.example.LinkedList;

class ListNodeRemove {
     int val;
      ListNodeRemove next;
      ListNodeRemove() {}
      ListNodeRemove(int val) { this.val = val; }
      ListNodeRemove(int val, ListNodeRemove next) { this.val = val; this.next = next; }
  }
public class RemoveNthNodeFromEnd {

    public static void main(String[] args){
        RemoveNthNodeFromEnd remove = new RemoveNthNodeFromEnd();
        ListNodeRemove head = new ListNodeRemove(1);

        head.next = new ListNodeRemove(2);
        head.next.next = new ListNodeRemove(3);
        head.next.next.next = new ListNodeRemove(4);
        head.next.next.next.next = new ListNodeRemove(5);
        ListNodeRemove output = remove.removeNthFromEnd(head, 3);
        remove.printLinkedList(output);
    }
    private void printLinkedList(ListNodeRemove output) {
        while(output!=null){
            System.out.println(output.val);
            output=output.next;
        }
    }
    public ListNodeRemove removeNthFromEnd(ListNodeRemove head, int n) {

        ListNodeRemove backup = head;

        ListNodeRemove slow = head;
        ListNodeRemove fast = head;
        int count = 0;

        while(count!=n){
            fast = fast.next;
            count++;
        }

        while(fast!=null){
            slow = slow.next;
            fast=fast.next;
        }

        slow.next=slow.next.next;
        return backup;

    }
}
