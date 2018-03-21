package zx.leetcode.dog.mar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_Duplicate_Subtrees_652 {
	
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(root==null){
        	return result;
        }
        Map<String,List<TreeNode>> map = new HashMap<String,List<TreeNode>>();
        serializeSubTree(root,map);
        for(List<TreeNode> rootGroup:map.values()){
        	if(rootGroup.size()>1){
        		result.add(rootGroup.get(0));
        	}
        }
        return result;
    }
	
	private String serializeSubTree(TreeNode node,Map<String,List<TreeNode>> map){
		if(node==null)return "";
		String s = "<"+serializeSubTree(node.left,map)+node.val+serializeSubTree(node.right,map)+">";
		if(!map.containsKey(s)){
			map.put(s, new ArrayList<>());
		}
		map.get(s).add(node);
		return s;
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
