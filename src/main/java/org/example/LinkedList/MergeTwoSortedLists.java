package org.example.LinkedList;
class ListNodeMerge{
    int val;
    ListNodeMerge next;
    ListNodeMerge(){
    }
    ListNodeMerge(int val){
        this.val = val;
    }
    ListNodeMerge(int val, ListNodeMerge next){
        this.val = val;
        this.next = next;
    }

}
public class MergeTwoSortedLists {
    public ListNodeMerge mergeTwoLists(ListNodeMerge list1, ListNodeMerge list2) {
        ListNodeMerge prev;
        ListNodeMerge next;
        if(list1==null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list2==null && list1==null){
            return null;
        }
        ListNodeMerge newHead;
        if(list1.val <= list2.val){
            newHead = new ListNodeMerge(list1.val);
            list1 = list1.next;
        }
        else {
            newHead = new ListNodeMerge(list2.val);
            list2=list2.next;
        }
        ListNodeMerge backup = newHead;
        prev = newHead;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                prev.next = list2;
                list2 = list2.next;
                prev=prev.next;
            } else if (list2 == null) {
                prev.next = list1;
                list1 = list1.next;
                prev=prev.next;

            } else {
                if (list1.val <= list2.val) {
                    next = new ListNodeMerge(list1.val);
                    list1 = list1.next;
                } else {
                    next = new ListNodeMerge(list2.val);
                    list2 = list2.next;
                }
                prev.next = next;
                prev = prev.next;
            }
        }
        return backup;
    }

    public static void main(String [] args){
        MergeTwoSortedLists merge = new MergeTwoSortedLists();
        ListNodeMerge head1 = new ListNodeMerge(-9);
        head1.next = new ListNodeMerge(3);
        // head1.next.next = new ListNodeMerge(4);

        ListNodeMerge head2 = new ListNodeMerge(5);
        head2.next= new ListNodeMerge(7);
        //head2.next.next = new ListNodeMerge(4);

        ListNodeMerge output = merge.mergeTwoLists(head1, head2);
        merge.printLinkedList(output);
    }

    private void printLinkedList(ListNodeMerge output) {
        while(output!=null){
            System.out.println(output.val);
            output=output.next;
        }
    }

}
