package zx.leetcode.dog.netease;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


class Line {
	public int left, right;
}

class Rect {
	public int x1,y1,x2,y2;
}

public class Main {
	
	public void test(){
		
		
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		Rect[] a = new Rect[n];

		int count = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			a[i] = new Rect();
			a[i].x1 = cin.nextInt();
		}
		for (int i = 0; i < n; i++) {
			a[i].y1 = cin.nextInt();
		}
		for (int i = 0; i < n; i++) {
			a[i].x2 = cin.nextInt();
		}
		for (int i = 0; i < n; i++) {
			a[i].y1 = cin.nextInt();
		}
		
		Arrays.sort(a, new Comparator<Rect>() {
			public int compare(Rect r1, Rect r2) {
				if(r1.x1>=r2.x1&&r1.y1>=r2.y2){
					return 1;
				}else{
					return -1;
				}
			}
		});
		int endX = a[0].x2;
		int endY = a[0].y2;

		for (int i = 1; i < n; i++) {
			if (a[i].x1 > endX&&a[i].y1>=endY){
				endX = a[i].x1;
				endY = a[i].y1;
				count = 0;				
			}else {
				count++;
				max = max>=count?max:count;
				if (a[i].x2 <= endX&&a[i].y2<=endY){
					
				}else {
					endX = a[i].x2;
					endY = a[i].y2;
				}
			}
		}
		System.out.println(max+1);
	}

	public static int max(int a, int b) {
		return a >= b ? a : b;
	}
	
	/*Scanner cin = new Scanner(System.in);
	int n = cin.nextInt();
	Line[] a = new Line[n];

	int count = 0;
	int max = 0;
	
	for (int i = 0; i < n; i++) {
		a[i] = new Line();
		a[i].left = cin.nextInt();
		a[i].right = cin.nextInt();
	}
	Arrays.sort(a, new Comparator<Line>() {
		public int compare(Line l1, Line l2) {
			if (l1.left >= l2.left)
				return 1;
			else
				return -1;
		}
	});
	int end = a[0].right, ans = 0;

	for (int i = 1; i < n; i++) {
		if (a[i].left > end){
			end = a[i].right;
			count = 0;				
		}else {
			count++;
			max = max>=count?max:count;
			if (a[i].right <= end){
				ans = max(ans, a[i].right - a[i].left);
			}else {
				ans = max(ans, end - a[i].left);
				end = a[i].right;
			}
		}
	}
	System.out.println(ans);
	System.out.println("max="+(max+1));*/

}
