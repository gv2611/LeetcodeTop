package org.example.LinkedList;

import java.util.HashMap;
import java.util.List;

class ListNodeCycle{
    int val;
    ListNodeCycle next;
    ListNodeCycle(int x){
        val=x;
        next = null;
    }
}

public class HasCycles {

    public boolean hasCycle(ListNodeCycle head) {

        ListNodeCycle slow = head;
        ListNodeCycle fast = head;
        boolean flag = false;

        while(slow!=null && fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                flag = true;
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args){
        HasCycles hascycles = new HasCycles();

        ListNodeCycle head = new ListNodeCycle(3);
        head.next = new ListNodeCycle(2);
        head.next.next = new ListNodeCycle(0);
        head.next.next.next = new ListNodeCycle(-4);
        head.next.next.next.next = head.next;
        System.out.println(hascycles.hasCycle(head));
    }

}
