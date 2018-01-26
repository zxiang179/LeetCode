package zx.leetcode.dog.jan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class Second_Minimum_Node_In_a_Binary_Tree {
	
	
	public int findSecondMinimumValue(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        if(root.left==null&&root.right==null)return -1;
        queue.offer(root);
        while(!queue.isEmpty()){
        	TreeNode node = queue.poll();
        	treeSet.add(node.val);
        	if(node.left!=null)queue.offer(node.left);
        	if(node.right!=null)queue.offer(node.right);
        }
        //list去重
        Iterator<Integer> iterator = treeSet.iterator();
        while(iterator.hasNext()){
        	list.add(iterator.next());
        }
        Collections.sort(list);
        if(list.size()<2)return -1;
        int min = list.get(0)>list.get(1)?list.get(1):list.get(0);
        int secondMin = list.get(0)>list.get(1)?list.get(0):list.get(1);
        for(int i=2;i<list.size();i++){
        	if(list.get(i)<min){
        		min = list.get(i);
        		secondMin = min;
        	}else if(list.get(i)<secondMin){
        		secondMin = list.get(i);
        	}
        }
        return secondMin;
    }
	
	@Test
	public void test(){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(2);
		findSecondMinimumValue(root);
	}

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x){
			val = x;
		}
	}

}
