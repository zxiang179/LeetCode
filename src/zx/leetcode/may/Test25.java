package zx.leetcode.may;

import java.util.Stack;

/**
 * 445. Add Two Numbers II
 * @author Carl_Hugo
 * @date 2017年5月20日
 */
public class Test25 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	Stack<Integer> stack1 = new Stack<Integer>();
    	Stack<Integer> stack2 = new Stack<Integer>();
    	Stack<Integer> res = new Stack<Integer>();
    	ListNode resList = new ListNode(0);
    	ListNode head = resList;
    	int count = 0;
    	while(l1!=null||l2!=null){
    		if(l1!=null){
    			stack1.push(l1.val);
    			l1=l1.next;
    		}
            if(l2!=null){
    			stack2.push(l2.val);
    			l2=l2.next;
    		}
    	}
    	while(!stack1.isEmpty()||!stack2.isEmpty()){
    		int tmp1,tmp2,tmpRes;
    	    if(!stack1.isEmpty()&&!stack2.isEmpty()){
    	    	tmp1 = stack1.pop();
    	    	tmp2 = stack2.pop();
    	    	tmpRes = tmp1+tmp2+count;
    	    	count = 0;
    	    	if(tmpRes>=10){
    	    		count=1;
    	    		res.push(tmpRes-10);
    	    	}else{
    	    		res.push(tmpRes);
    	    	}
    	    }else if(!stack1.isEmpty()){
    	    	tmp1 = stack1.pop();
    	    	tmpRes = tmp1+count;
    	    	count = 0;
    	    	if(tmpRes>=10){
    	    		count=1;
    	    		res.push(tmpRes-10);
    	    	}else{
    	    		res.push(tmpRes);
    	    	}
    	    }else if(!stack2.isEmpty()){
    	    	tmp2 = stack2.pop();
    	    	tmpRes = tmp2+count;
    	    	count = 0;
    	    	if(tmpRes>=10){
    	    		count=1;
    	    		res.push(tmpRes-10);
    	    	}else{
    	    		res.push(tmpRes);
    	    	}
    	    }
    	}
    	if(count==1){
    		res.push(1);
    	}
    	while(!res.isEmpty()){
    		ListNode node = new ListNode(res.pop());
    		resList.next = node;
    		resList = resList.next;
    	}
    	return head.next;
    }
    
    public static void main(String[] args) {
		int[] list1 = new int[]{7,2,4,3};
		int[] list2 = new int[]{5,6,4};
		ListNode l1 = ConvertToList(list1);
		ListNode l2 = ConvertToList(list2);
		new Test25().addTwoNumbers(l1, l2);
	}

    public static ListNode ConvertToList(int[] nums){
    	ListNode list = new ListNode(0);
    	ListNode head = list;
    	for(int i:nums){
    		list.next=new ListNode(i);
    		list = list.next;
    	}
    	return head.next;
    }

}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;	}
}


