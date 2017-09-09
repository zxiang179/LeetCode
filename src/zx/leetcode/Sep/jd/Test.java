package zx.leetcode.Sep.jd;

public class Test {
	
	public static void main(String[] args) {
		Test t = new Test();
		t.method(null);
	}
	
	public void method(Object o){
		System.out.println("Object");
	}
	
	public void method(String s){
		System.out.println("String");
	}

}
