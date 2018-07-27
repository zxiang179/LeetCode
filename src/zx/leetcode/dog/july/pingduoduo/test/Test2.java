package zx.leetcode.dog.july.pingduoduo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import zx.leetcode.dog.july.pingduoduo.test.Test2.XianDuan;

/**
 * 求线段覆盖长度
 * 
 * @author zx
 *
 */
public class Test2 {

	static class XianDuan {
		int start;
		int end;

		public XianDuan(int s, int e) {
			this.start = s;
			this.end = e;
		}
	}

	public static int getLength(List<XianDuan> xdList) {
		Collections.sort(xdList, new Comparator<XianDuan>() {
			@Override
			public int compare(XianDuan o1, XianDuan o2) {
				if (o1.start < o2.start) {
					return -1;
				} else if (o1.start > o2.start) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		int res = 0;
		XianDuan xianDuan = xdList.get(0);
		res = 0;
		int end = xianDuan.end;
		int start = xianDuan.start;
		for (int i = 1; i < xdList.size(); i++) {
			XianDuan temp = xdList.get(i);
			if (temp.start <= end && temp.end > end) {
				end = temp.end;
			} 
			if(temp.start>end || i==xdList.size()-1) {
				res += (end - start);
				start = temp.start;
				end = temp.end;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		List<XianDuan> xdList = new ArrayList<XianDuan>();
		xdList.add(new XianDuan(2, 6));
		xdList.add(new XianDuan(1, 3));
		xdList.add(new XianDuan(11, 12));
		xdList.add(new XianDuan(10, 14));
		int len = getLength(xdList);
		System.out.println(len);
	}

}
