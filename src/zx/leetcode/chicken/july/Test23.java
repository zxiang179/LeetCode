package zx.leetcode.chicken.july;
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
	public ListNode insertionSortList2(ListNode head){
		ListNode helper = new ListNode(0);//pre head
		ListNode cur = head;
		ListNode pre = helper;
		ListNode next = null;
		if(head==null)return null;
		
		while(cur!=null){
			next = cur.next;
			while(pre.next!=null&&pre.next.val<cur.val){
				pre = pre.next;
			}
			//insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			pre = helper;
			cur = next;
		}
		return helper.next;
		
	}
	
	
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
        return head.next;
    }

    public static void main(String[] args) {
		int[] arr = {2};
		ListNode head = new ListNode(0);
		ListNode temp = head;
		
		for(int i :arr){
			ListNode node = new ListNode(i);
			temp.next=node;
			temp=temp.next;
		}
		ListNode node = new Test23().insertionSortList(head);
		while(node!=null){
			System.out.println(node.val);
			node = node.next;
		}
	}
}

class ListNode{
	ListNode next;
	int val;
	ListNode(int x){
		val = x;
	}
}