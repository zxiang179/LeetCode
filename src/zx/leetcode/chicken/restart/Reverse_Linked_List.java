package zx.leetcode.chicken.restart;

public class Reverse_Linked_List {
	
	public ListNode reverseList(ListNode head) {
		if(head==null)return null;
		//考虑到head在LeetCode中为实际存在的一个链表节点
		ListNode newHead = new ListNode(0);
		newHead.next = null;
		ListNode p1 = head;
		ListNode temp = null;
		while(p1!=null){
			temp = p1;
			p1 = p1.next;
			temp.next = newHead.next;
			newHead.next = temp;
		}
		return newHead.next;
	}
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x){
			val = x;
		}
	}

}
