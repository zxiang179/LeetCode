package zx.leetcode.restart;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

public class Pascal_Triangle {
	
	public static List<List<Integer>> generate(int numRows){
		List<List<Integer>> resList = new ArrayList<List<Integer>>();
		if(numRows>0){
			ArrayList<Integer> row = new ArrayList<Integer>();
			row.add(1);
			resList.add(row);
		}
 		if(numRows>1){
			List<Integer> lastRow = new ArrayList<Integer>();
			for(int i=0;i<numRows-1;i++){
				lastRow = resList.get(i);
				List<Integer> nowRow = new ArrayList<Integer>();
				nowRow.add(1);
				for(int j=0;j<lastRow.size()-1;j++){
					nowRow.add(lastRow.get(j)+lastRow.get(j+1));
				}
				nowRow.add(1);
				resList.add(nowRow);
			}
		}
		return resList;
	}
	
	public static void main(String[] args) {
		generate(3);
	}

}
