package zx.leetcode.dog.july.pingduoduo;

import java.util.Scanner;

public class Main3 {
    static int diff[] = new int[10];
    static int c[];

    public static void main(String[] args) {
        int n, k;
        int nc[] = new int[10];
        String str;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        str = sc.next();
        for (int i = 0; i < n; i++) {
            nc[str.charAt(i) - '0']++;
        }
        int min = Integer.MAX_VALUE, minIndex = -1;
        int r;
        for (int i = 0; i < 10; i++) {
            r = getMin(nc.clone(), i, k);
            if (min > r) {
                minIndex = i;
                min = r;
                diff = c;
            }
        }
        String mins = getMins(diff, str, String.valueOf(minIndex));
        System.out.println(min);
        System.out.println(mins);
    }

    private static int getMin(int nc[], int index, int k) {
        int res = 0;
        int j = 1;
        k -= nc[index];
        c = new int[10];
        while (k > 0 && j < 10) {
            if (index - j >= 0) {
                while (k > 0 && nc[index - j] > 0) {
                    k--;
                    res += j;
                    nc[index - j]--;
                    c[index - j]++;
                }
            }
            if (k > 0 && index + j < 10) {
                while (k > 0 && nc[index + j] > 0) {
                    k--;
                    res += j;
                    nc[index + j]--;
                    c[index + j]++;
                }
            }
            j++;
        }
        return res;
    }

    private static String getMins(int diff[], String origin, String rep) {
        StringBuilder sb = new StringBuilder(origin);
        for (int i = 0; i < sb.length(); i++) {
            if (diff[sb.charAt(i) - '0'] > 0) {
                diff[sb.charAt(i) - '0']--;
                sb.replace(i, i + 1, rep);
            }
        }
        return sb.toString();
    }
}