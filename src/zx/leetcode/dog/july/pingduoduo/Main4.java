package zx.leetcode.dog.july.pingduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String[] splits = line.split("\\s");
        int N = splits.length;
        int[] w = new int[N];
        boolean[] flag = new boolean[N];
        for (int i = 0; i < N; i++) {
            w[i] = Integer.valueOf(splits[i]);
        }
        Arrays.sort(w);

        int count = 0;
        int start = 0;
        int end = N - 1;
        int i;
        while (start <= end) {
            if (flag[start]) {
                start++;
                continue;
            }
            if (w[end] >= 300) {
                count++;
                flag[end] = true;
                end--;
            } else {
                flag[start] = true;
                i = end;
                int tmp = w[start];
                while (tmp < 300 && i > start) {
                    if (flag[i]) {
                        i--;
                        continue;
                    }
                    if (tmp + w[i] <= 300) {
                        tmp += w[i];
                        flag[i] = true;
                    }
                    i--;
                }
                start++;
                count++;
            }
        }
        System.out.println(count);
    }
}