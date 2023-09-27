package org.example.LinkedList;

import java.util.List;

class ListNodeAdd {
    int val;
    ListNodeAdd next;

    ListNodeAdd() {
    }

    ListNodeAdd(int val) {
        this.val = val;
    }

    ListNodeAdd(int val, ListNodeAdd next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {
    public ListNodeAdd addTwoNumbers(ListNodeAdd l1, ListNodeAdd l2) {
        int sum= l1.val + l2.val;
        int carry = sum / 10;
        sum = sum % 10;


        ListNodeAdd newHead = new ListNodeAdd(sum);
        ListNodeAdd backup = newHead;

        ListNodeAdd prev = newHead;
        ListNodeAdd next = null;


        while(l1.next!=null || l2.next!=null){
            int val1=0;
            int val2=0;
            if(l1.next!=null){
                l1 = l1.next;
                val1 = l1.val;
            }
            if(l2.next != null){
                l2 = l2.next;
                val2 = l2.val;
            }
            sum = val1+ val2 + carry;
            carry = sum/10;
            sum = sum % 10;
            next = new ListNodeAdd(sum);
            prev.next = next;
            prev = prev.next;
        }
        if(carry!=0){
            next = new ListNodeAdd(carry);
            prev.next = next;
        }
        return backup;
    }

    public static void main(String [] args){
        AddTwoNumbers add = new AddTwoNumbers();
        ListNodeAdd head1 = new ListNodeAdd(2);
        head1.next = new ListNodeAdd(4);
        head1.next.next = new ListNodeAdd(3);
        ListNodeAdd head2 = new ListNodeAdd(5);
        head2.next = new ListNodeAdd(6);
        head2.next.next = new ListNodeAdd(4);
        ListNodeAdd output = add.addTwoNumbers(head1, head2);
        add.printLinkedList(output);
    }

    private void printLinkedList(ListNodeAdd output) {

        while(output!=null){
            System.out.println(output.val);
            output=output.next;
        }
    }
}
