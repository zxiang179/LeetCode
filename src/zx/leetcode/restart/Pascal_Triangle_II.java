package zx.leetcode.restart;

import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle_II {

	public List<Integer> getRow(int rowIndex){
		List<List<Integer>> resList = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		row.add(1);
		resList.add(row);
		if(rowIndex==0){
			return row;
		}else{
			for(int i=0;i<rowIndex;i++){
				List<Integer> lastRow = resList.get(i);
				ArrayList<Integer> nowRow = new ArrayList<Integer>();
				nowRow.add(1);
				for(int j=0;j<lastRow.size()-1;j++){
					nowRow.add(lastRow.get(j)+lastRow.get(j+1));
				}
				nowRow.add(1);
				resList.add(nowRow);
			}
		}
		return resList.get(rowIndex);
		
	}
	
}
