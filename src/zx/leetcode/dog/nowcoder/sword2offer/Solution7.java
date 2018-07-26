package zx.leetcode.dog.nowcoder.sword2offer;

public class Solution7 {
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 int len1 = 0;
		 int len2 = 0;
		 ListNode p1 = pHead1;
		 ListNode p2 = pHead2;
		 while(p1!=null) {
			 len1++;
			 p1=p1.next;
		 }
		 while(p2!=null) {
			 len2++;
			 p2=p2.next;
		 }
		 int diffLen = Math.abs(len1-len2);
		 p1 = pHead1;
		 p2 = pHead2;
		 if(len1>len2) {
			 while(diffLen-->0) {
				 p1 = p1.next;
			 }
		 }else {
			 while(diffLen-->0) {
				 p2 = p2.next;
			 }
		 }
		 while(p1!=null&&p2!=null) {
			 if(p1.val==p2.val) {
				 return p1;
			 }
			 p1 = p1.next;
			 p2 = p2.next;
		 }
		 return null;
    }

}
