package zx.leetcode.restart;

public class Remove_Linked_List_Elements {
	
	 public static ListNode removeElements(ListNode head, int val) {
		 if(head==null){
			 return null;
		 }
		 ListNode node = head;
		 
		 while(node.next!=null){
			 if(node.next.val==val){
				 node.next = node.next.next;
			 }else{
				 node=node.next;				 
			 }
		 }
		//考虑表头节点
		 return head.val==val?head.next:head;
	 }
	 
	 public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		removeElements(head,6);
	}
	 
	 static class ListNode{
		 int val;
		 ListNode next;
		 public ListNode(int x){
			 val = x;
		 }
	 }

}
