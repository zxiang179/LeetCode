package zx.leetcode.dog.mar;

public class Copy_List_with_Randow_Pointer_138 {
	
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
        	return null;
        }
        RandomListNode p = head;
        //复制每个节点，添加到每个节点后面
        while(p!=null){
        	RandomListNode np = new RandomListNode(p.label);
        	np.next = p.next;
        	p.next = np;
        	p = np.next;
        }
        
        p = head;
        //复制随机节点
        while(p!=null){
        	p.next.random = p.random==null?null:p.random.next;
        	p = p.next.next;
        }
        
        //分离链表
        RandomListNode nhead = head.next;
        p = head;
        RandomListNode q = nhead;
        while(p!=null){
        	p.next = q.next;
        	if(q.next!=null){
        		q.next = q.next.next;
        	}
        	p = p.next;
        	q = q.next;
        }
        return nhead;
    }
	
	class RandomListNode{
		int label;
		RandomListNode next,random;
		RandomListNode(int x){
			label = x;
		}
	}

}
