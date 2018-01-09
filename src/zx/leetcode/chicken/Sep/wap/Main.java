package zx.leetcode.chicken.Sep.wap;
import java.util.*;
/**
 * Lucky Subsequence
 * @author Carl_Hugo
 * 2017年10月13日 下午7:18:36
 */
public class Main {

    static class A_B{
        int a;
        int b;
        public A_B(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int result = 0;
        for(int i = 0; i < n; i++){
            int first = arr[i];
            int second = 0;
            for(int j = i; j < n; j++){
                if(arr[j] == first)continue;
                if(arr[j] == second)continue;
                if(arr[j] > first){
                    second = first;
                    first = arr[j];
                }else if(arr[j] > second){
                    second = arr[j];
                }
                if(second > 0){
                    if((first^second) > result){
                        result = first^second;
                    }
                }
            }
        }
        System.out.println(result);
    }

}