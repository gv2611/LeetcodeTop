package org.example.LinkedList;

class ListNodeReverse {
    int val;
    ListNodeReverse next;
    ListNodeReverse(){}
    ListNodeReverse(int val){
        this.val = val;
    }
    ListNodeReverse(int val, ListNodeReverse next){
        this.val = val;
        this.next = next;
    }
}
public class ReverseLinkedList2 {

    public ListNodeReverse reverseBetween(ListNodeReverse head, int left, int right) {

        ListNodeReverse temp = new ListNodeReverse(-1);
        ListNodeReverse prev = temp;
        temp.next = head;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNodeReverse cur = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNodeReverse ptr = prev.next;
            prev.next = cur.next;
            cur.next = cur.next.next;
            prev.next.next = ptr;
        }
        return temp.next;

    }


    public static void main(String[] args){
        ReverseLinkedList2 reverse = new ReverseLinkedList2();
        ListNodeReverse head = new ListNodeReverse(1);
        head.next = new ListNodeReverse(2);
        head.next.next = new ListNodeReverse(3);
        head.next.next.next = new ListNodeReverse(4);
        head.next.next.next.next = new ListNodeReverse(5);
        ListNodeReverse output = reverse.reverseBetween(head, 2, 4);
        reverse.printLinkedList(output);
    }
    private void printLinkedList(ListNodeReverse output) {
        while(output!=null){
            System.out.println(output.val);
            output=output.next;
        }
    }




}
