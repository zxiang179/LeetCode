package zx.leetcode.Sep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * 56. Merge Intervals
 * @author Carl_Hugo
 * 2017年9月29日 上午8:52:02
 */
public class Merge_Intervals {
	
	public class MyComparator implements Comparator<Interval>{
		@Override
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}
	}
	
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<Interval>();
        if(intervals.size()==0)return ans;
        Collections.sort(intervals, new MyComparator());
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i=0;i<intervals.size();i++){
        	Interval interval = intervals.get(i);
        	if(interval.start>end){
        		ans.add(new Interval(start,end));
        		start = interval.start;
        		end = interval.end;
        	}else{
        		end = Math.max(interval.end, end);
        	}
        }
        ans.add(new Interval(start,end));
        return ans;
    }
	
	public static void main(String[] args) {
		int[] inputArr = {1,3,2,6,8,10,15,18};
		List<Interval> inputList = new ArrayList<Interval>();
		for(int i=0;i<4;i++){
			inputList.add(new Interval(inputArr[i*2],inputArr[i*2+1]));
		}
		new Merge_Intervals().merge(inputList);
	}

	static class Interval{
		int start;
		int end;
		Interval(){
			start = 0;
			end = 0;
		}
		Interval(int s,int e){
			start = s;
			end = e;
		}
	}
	
}
