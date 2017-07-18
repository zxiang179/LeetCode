package zx.leetcode.july;
/**
 * 147. Insertion Sort List
 * @author Carl_Hugo
 */
public class Test23 {
	
	/**
	 * Sort a linked list using insertion sort
	 * @param head
	 * @return
	 */
    public ListNode insertionSortList(ListNode head) {
    	//默认头结点没有元素
    	//无序队列的首元素
    	ListNode first=null;
    	ListNode follow = null;
    	ListNode second = null;
    	//
    	ListNode selected = null;
        if(head==null)return null;
        
        follow = head;
        if(head.next==null){
        	first = null;
        }else{
        	first = head.next;	
        }
        
        if(first==null||first.next==null){
        	second = null;
        }else{
        	second = head.next.next;	
        }
        if(first!=null){
        	first.next=null;	
        }
        while(second!=null){
        	selected = second;
        	second = second.next;
        	selected.next=null;
        	while(first!=null){
        		if(first.val>selected.val){
        			selected.next = first;
            		follow.next = selected;
            		break;
        		}
        		if(first.next==null){
        			first.next = selected;
        			selected.next = null;
        			break;
        		}
        		follow = first;
    			first = first.next;
        	}
        	follow = head;
            first = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
		int[] arr = {1};
		ListNode head = new ListNode(0);
		ListNode temp = head;
		
		for(int i :arr){
			ListNode node = new ListNode(i);
			temp.next=node;
			temp=temp.next;
		}
		new Test23().insertionSortList(head);
	}
}

class ListNode{
	ListNode next;
	int val;
	ListNode(int x){
		val = x;
	}
}