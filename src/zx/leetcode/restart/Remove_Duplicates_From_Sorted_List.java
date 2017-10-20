package zx.leetcode.restart;

import zx.leetcode.restart.Remove_Linked_List_Elements.ListNode;

public class Remove_Duplicates_From_Sorted_List {

	 public ListNode deleteDuplicates(ListNode head) {
		 if(head==null||head.next==null)return head;
		 ListNode p = head.next;
		 ListNode follow = head;
		 while(p!=null){
			 if(p.val==follow.val){
				 follow.next = p.next;
				 p=p.next;
			 }else{
				 p = p.next;
				 follow = follow.next;	 
			 }
		 }
		 return head;
	 }
	
}
