package org.example.LinkedList;

import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode backup = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy.next;
        ListNode next = dummy.next;

        while(head.next!= null){
            while(next!=null && next.val == prev.val  ){
                next = next.next;
            }
            prev.next = next;
            prev = next;
            head = head.next;
        }
        return backup;
    }

    public ListNode deleteDuplicates2(ListNode head) {

        ListNode backup = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy.next;
        ListNode next = dummy.next;
        boolean flag = false;
        HashMap<Integer, Integer> mapping = new HashMap<>();

        while(head!= null) {
            if(!mapping.containsKey(head.val)){
                mapping.put(head.val, 1);
            }
            else{
                int val = mapping.get(head.val);
                val = val+1;
                mapping.remove(head.val);
                mapping.put(head.val, val);
            }
            head = head.next;
        }

        head = backup;

        while(head.next != null){
            if(mapping.get(head.val) == 1){
                prev = head;
                next = prev.next;
                break;

            }
            head = head.next;
        }
        head = backup;

        while(head!=null && next!=null) {

            while (mapping.get(next.val) > 1) {
                next = next.next;
            }
            prev.next = next;
            prev = prev.next;
            next = next.next;
            head = head.next;
        }

        return backup;
    }
    private void printLinkedList(ListNode output) {
        while(output!=null){
            System.out.println(output.val);
            output=output.next;
        }
    }

    public static void main(String[] args){
        RemoveDuplicates remove = new RemoveDuplicates();
        ListNode head = new ListNode(1);

        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next.next = new ListNode(5);


        ListNode output = remove.deleteDuplicates2(head);
        remove.printLinkedList(output);
    }
}
