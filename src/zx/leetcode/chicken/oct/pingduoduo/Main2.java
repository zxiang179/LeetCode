package zx.leetcode.chicken.oct.pingduoduo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String firstLine = scanner.nextLine();
		String[] split = firstLine.split("\\s");
		//熊的数量
		int n = Integer.valueOf(split[0]);
		//糖的数量
		int m = Integer.valueOf(split[1]);
		//糖填充的饥饿值
		int[] mArr = new int[m];
		for(int i=0;i<m;i++){
			mArr[i] = scanner.nextInt();
		}
		scanner.nextLine();
		ArrayList<Beer> bArr = new ArrayList<Beer>();
		for(int i=0;i<n;i++){
			String line = scanner.nextLine();
			String[] split2 = line.split("\\s");
			int attack = Integer.valueOf(split2[0]);
			int hungry = Integer.valueOf(split2[1]);		
			Beer b = new Beer(attack,hungry);
			bArr.add(b);
		}
		
		//将小熊根据战斗力排序,降序
		Collections.sort(bArr, new BeerComparator());
		//食物，升序
		Arrays.sort(mArr);
		//外层for循环，根据食物循环
		int i = mArr.length-1;
//		boolean innerLoopIsOver = false;
		
		for(int j=0;j<bArr.size();j++){
			Beer b = bArr.get(j);
			int h = b.hungry;
			i = mArr.length-1;
			while(i>=0){
				if(h>=mArr[i]){
					b.hungry = h - mArr[i];
					h = b.hungry;
				}
				i--;
			}
		}
		
		
		for(int k=0;k<bArr.size();k++){
			System.out.println(bArr.get(k).hungry);
		}
		
		
		
	}
	
	static class BeerComparator implements Comparator<Beer> {
	    @Override
	    public int compare(Beer a, Beer b) {
	         return b.attack-a.attack;
	    }
	    
	}
	
	static class Beer{
		int attack;
		int hungry;
		public Beer(int a,int h){
			attack = a;
			hungry = h;
		}
	}

}
