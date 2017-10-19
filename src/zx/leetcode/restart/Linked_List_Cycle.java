package zx.leetcode.restart;

import zx.leetcode.restart.Remove_Linked_List_Elements.ListNode;

public class Linked_List_Cycle {
	
	public boolean hasCycle(ListNode head) {
		//special　input
		if(head==null)return false;
		ListNode node1 = head;
		ListNode node2 = head;
		while(node2!=null&&node2.next!=null){
			node1 = node1.next;
			node2 = node2.next.next;
			if(node1==node2){
				return true;
			}
		}
		return false;
	}
	
}
