package zx.leetcode.chicken.Aug.toutiao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		List<Integer> resList = new ArrayList<Integer>();
		TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
		
		int[] X = new int[count];
		int[] Y = new int[count];
		for(int i=0;i<count;i++){
			X[i]=scanner.nextInt();
			Y[i]=scanner.nextInt();
		}
		//对于一个点来说，只要没有第二个点的X坐标和Y坐标同时高于改点，该点即为最大
		for(int i=0;i<count;i++){
			boolean flag = true;
			int x = X[i];
			int y = Y[i];
			for(int j=i+1;j<count;j++){
				if(X[j]>x&&Y[j]>y){
					flag=false;
					break;
				}
			}
			if(flag==true){
				treeMap.put(y, x);
			}
		}
		
		Set<Entry<Integer,Integer>> entrySet = treeMap.entrySet();
		Iterator<Entry<Integer, Integer>> iterator = entrySet.iterator();
		while(iterator.hasNext()){
			Entry<Integer, Integer> next = iterator.next();
			int x = next.getValue();
			int y = next.getKey();
			resList.add(x);
			resList.add(y);
//			System.out.println(x+" "+y);
		}
		
		for(int i=resList.size()-2;i>=0;i=i-2){
			if(i%2==0&&i!=resList.size()-2)System.out.println();
			System.out.print(resList.get(i)+" "+resList.get(i+1));
		}
		
	}

}
