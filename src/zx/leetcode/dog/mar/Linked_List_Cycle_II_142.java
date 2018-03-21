package zx.leetcode.dog.mar;

public class Linked_List_Cycle_II_142 {
	
	public ListNode detectCycle(ListNode head) {
		if(head==null||head.next==null){
			return null;
		}
        ListNode fp = head;
        ListNode sp = head;
        while(fp!=null&&fp.next!=null){
        	sp = sp.next;
        	fp = fp.next.next;
        	if(fp==sp){
        		//快慢指针相遇
        		break;
        	}
        }
        if(fp==null||fp.next==null){
        	return null;
        }
        
        fp = head;
        while(fp!=sp){
        	fp = fp.next;
        	sp = sp.next;
        }
        return fp;
    }
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x){
			val = x;
		}
	}

}
