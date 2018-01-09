package zx.leetcode.chicken.may;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. Number of Boomerangs
 * @author Carl_Hugo
 * @date 2017年5月4日
 */
public class Test10 {

	/**
	 * 两次遍历 将所有坐标之间的距离存在map中
	 * 求二维数组每一行横向的情况数相加
	 * @param points
	 * @return
	 */
	public int numberOfBoomerangs(int[][] points) {
	   int n =  points.length;
	   int dis;
	   int count = 0;
	   for(int i=0;i<n;i++){
		   Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		   for(int j=0;j<n;j++){
	           dis = (points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
	           if(!map.containsKey(dis)){
	        	   map.put(dis, 0);
	           }
	           //两个位置j和k可以颠倒
	           count+=map.get(dis)*2;
	           map.put(dis, map.get(dis)+1);
		   }
	   }
	   return count;
	}
	
	public static void main(String[] args) {
		new Test10().numberOfBoomerangs(new int[][]{{0,0},{1,0},{2,0}});
	}
}
