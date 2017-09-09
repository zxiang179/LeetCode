package zx.leetcode.Sep.jd;

public class Main {
	
	public static void main(String[] args) {
		Other o = new Other();
		new Main().addOne(o);
		System.out.println(o.i);
	}
	
	public void addOne(final Other o){
		o.i++;
	}
	
}

class Other{
	public int i;
}
