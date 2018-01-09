package zx.leetcode.chicken.restart;

import zx.leetcode.chicken.restart.Remove_Linked_List_Elements.ListNode;

public class Merge_Two_Sorted_Lists {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode newListHead = new ListNode(0);
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode p3 = newListHead;
		while(p1!=null&&p2!=null){
			if(p1.val<=p2.val){
				p3.next = p1;
				p1 = p1.next;
			}else{
				p3.next = p2;
				p2 = p2.next;
			}
			p3 = p3.next;
		}
		if(p1!=null){
			p3.next = p1;
		}
		if(p2!=null){
			p3.next = p2;
		}
		return newListHead.next;
	}

}
