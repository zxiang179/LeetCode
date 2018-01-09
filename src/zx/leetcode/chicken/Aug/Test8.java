package zx.leetcode.chicken.Aug;
/**
 * 234. Palindrome Linked List
 * @author Carl_Hugo
 * @date 2017年8月18日
 */
public class Test8 {
	
	/**
	 * Given a singly linked list, determine if it is a palindrome.
     * Could you do it in O(n) time and O(1) space?
     * [] is palindrome
	 * @param head
	 * @return
	 */
    public boolean isPalindrome(ListNode head) {
    	if(head==null)return true;
        int len = 0;
        int steps = 0;
        ListNode temp = head;
        while(temp!=null){
        	len++;
        	temp=temp.next;
        }
        ListNode first = head;
        ListNode second = null;
        int compareTimes = 0;
        if(len%2==0){
        	steps = len/2;	
        	compareTimes = steps;
        }else{
        	steps = len/2+1;
        	compareTimes = steps-1;
        }
        temp = head;
        while(steps>0){
        	temp = temp.next;
        	steps--;
        }
        //链表就地逆序
        second = temp;
        ListNode tempHead = new ListNode(0);
        tempHead.next = null;
        while(second!=null){
        	//抽出r
        	ListNode r = second;
        	second = second.next;
        	//放在首节点后面
        	r.next = tempHead.next;
        	tempHead.next=r;
        }
        
        ListNode followNode = tempHead.next;
        while(compareTimes>0){
        	if(first.val!=followNode.val)return false;
        	first = first.next;
        	followNode = followNode.next;
        	compareTimes--;
        }
        return true;
    }
	
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val=x;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,3,2,1};
		ListNode head = new ListNode(arr[0]);
		ListNode temp = head;
		for(int i=1;i<arr.length;i++){
			ListNode node = new ListNode(arr[i]);
			temp.next=node;
			temp=temp.next;
		}
		System.out.println(new Test8().isPalindrome(head));
	}

}
