package zx.leetcode.restart;

import zx.leetcode.restart.Remove_Linked_List_Elements.ListNode;

public class Remove_Nth_Node_From_End_of_List {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null)return null;
		//创建preHead,避免第一个节点为就为删除的节点。
		ListNode preHead = new ListNode(0);
		preHead.next = head;
		ListNode p = head;
		//保证follow在p的后一个节点同步移动
		ListNode follow = preHead;
		for(int i=0;i<n;i++){
			p=p.next;	
		}
		while(p!=null){
			p=p.next;
			follow = follow.next;
		}
		follow.next = follow.next.next;	
		return preHead.next;
	}

}
