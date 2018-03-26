package zx.leetcode.dog.yuanjiing;

/**
 * Definition for singly-linked list with a random pointer.
 * 
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head==null)
            return null;
        RandomListNode curPoint = head;
        //复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
        while(curPoint!=null){
            RandomListNode node = new RandomListNode(curPoint.label);
            node.next = curPoint.next;
            curPoint.next = node;
            curPoint = node.next;
         }
        curPoint = head;
        //复制random curPoint是原来链表的结点 curPoint.next是复制curPoint的结点
        while(curPoint!=null){
            if(curPoint.random!=null)
                curPoint.next.random = curPoint.random.next;
            curPoint = curPoint.next.next;
         }
        RandomListNode h2 = head.next;
        RandomListNode cur = h2;
        curPoint = head;
        //拆分链表
        while(curPoint!=null){
            curPoint.next = curPoint.next.next;
            if(cur.next!=null)
                cur.next = cur.next.next;
            cur = cur.next;
            curPoint = curPoint.next;
         }
        return h2;      
     }
    
    class RandomListNode {
         int label;
         RandomListNode next, random;
         RandomListNode(int x) { this.label = x; }
    };
}