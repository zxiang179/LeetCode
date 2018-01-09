package zx.leetcode.chicken.restart;

import zx.leetcode.chicken.restart.Remove_Linked_List_Elements.ListNode;

public class Swap_Nodes_in_Pairs {
	
	public ListNode swapPairs(ListNode head) {
		if(head==null||head.next==null){
			return head;
		}
		ListNode temp = head.next;
		head.next = swapPairs(head.next.next);
		temp.next = head;
        return temp;
    }
	
	public ListNode swapPairs2(ListNode head) {
		if(head==null||head.next==null){
			return head;
		}
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode current = dummyNode;
		while(current.next!=null&&current.next.next!=null){
			ListNode first = current.next;
			ListNode second = current.next.next;
			first.next = second.next;
			second.next = first;
			current.next = second;
			current = current.next.next;
		}
		return dummyNode.next;

    }

}
