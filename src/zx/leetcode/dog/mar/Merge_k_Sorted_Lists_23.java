package zx.leetcode.dog.mar;

import java.util.PriorityQueue;

public class Merge_k_Sorted_Lists_23 {
	
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists==null||lists.length==0){
			return null;
		}
		if(lists.length==1){
			return lists[0];
		}
		int len = lists.length;
		//基于二分的思想将链表两两合并
		while(len>1){
			int mid = (len+1)/2;
			for(int i=0;i<len/2;i++){
				lists[i] = mergeTwoLists(lists[i],lists[i+mid]);
			}
			len = mid;
		}
		return lists[0];
		
	}
	
	public ListNode mergeTwoLists(ListNode list1,ListNode list2){
		ListNode newList = new ListNode(0);
		ListNode p = newList;
		ListNode p1 = list1;
		ListNode p2 = list2;
		while(p1!=null&&p2!=null){
			if(p1.val<=p2.val){
				p.next = p1;
				p1 = p1.next;
			}else{
				p.next = p2;
				p2 = p2.next;
			}
			p=p.next;
		}
		while(p1!=null){
			p.next = p1;
			p1 = p1.next;
			p=p.next;
		}
		while(p2!=null){
			p.next = p2;
			p2 = p2.next;
			p=p.next;
		}
		return newList.next;
	}
	

	public ListNode mergeKLists2(ListNode[] lists) {
		if(lists==null||lists.length==0){
			return null;
		}
		if(lists.length==1){
			return lists[0];
		}
		
		ListNode head = new ListNode(0);
		ListNode p = head;
		PriorityQueue priorityQueue = new PriorityQueue<ListNode>();
		for(ListNode list:lists){
			if(list!=null){
				priorityQueue.offer(list);	
			}
		}
		
		while(!priorityQueue.isEmpty()){
			ListNode node = (ListNode)priorityQueue.poll();
			p.next = node;
			p=p.next;
			if(node.next!=null){
				priorityQueue.offer(node.next);
			}
		}
		return head.next;
    }
	
	class ListNode implements Comparable<ListNode>{
		int val;
		ListNode next;
		public ListNode(int x){
			val = x;
		}
		@Override
		public int compareTo(ListNode node) {
			return this.val-node.val;
		}
	}
	
}
