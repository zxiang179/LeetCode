package zx.leetcode.chicken.july;
/**
 * 160. Intersection of Two Linked Lists
 * @author Carl_Hugo
 * @date 2017年7月1日
 */
public class Test1 {
	
    /**
     * @param headA
     * @param headB
     * @return
     */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA);
        int lenB = length(headB);
        while(lenA<lenB){
        	headB=headB.next;
        	lenB--;
        }
        while(lenB<lenA){
        	headA=headA.next;
        	lenA--;
        }
        while(headA!=headB){
        	headA=headA.next;
        	headB=headB.next;
        }
        return headA;
    }
	
	class ListNode{
		ListNode next;
		int val;
		ListNode(int x){
			val=x;
			next=null;
		}
	}
	
	public int length(ListNode head){
		int length=0;
		while(head!=null){
			length++;
			head=head.next;
		}
		return length;
	}

}
