package zx.leetcode.dog.july.pingduoduo;

import java.util.Scanner;

public class Main5 {
	static int diffs[] = new int[10];
    static int c[];

    public static void main(String[] args) {
        int n, k;
        //统计每个数出现的频次
        int nc[] = new int[10];
        String s;
        Scanner sc = new Scanner(System.in);
        //号码的长度	
        n = sc.nextInt();
        //靓号需要的长度
        k = sc.nextInt();
        //靓号
        s = sc.next();
        for (int i = 0; i < n; i++) {
            nc[s.charAt(i) - '0']++;
        }
        int min = Integer.MAX_VALUE, minIndex = -1;
        int r;
        for (int i = 0; i < 10; i++) {
            r = Min(nc.clone(), i, k);
            if (min > r) {
                minIndex = i;
                min = r;
                diffs = c;
            }
        }
        String mins = Mins(diffs, s, String.valueOf(minIndex));
        System.out.println(min);
        System.out.println(mins);
    }

    /**
     * 
     * @param nc 频次数组
     * @param index 某一个值0-9
     * @param k 靓号需要的长度
     * @return
     */
    private static int Min(int nc[], int index, int k) {
        int res = 0;
        //与index相距的距离
        int j = 1;
        k -= nc[index];
        c = new int[10];
        while (k > 0 && j < 10) {
        	//从左边找 与index的间隔为j
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

    private static String Mins(int change[], String origin, String rep) {
        StringBuilder sb = new StringBuilder(origin);
        int[] change1 = change.clone();
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (change[sb.charAt(i) - '0'] > 0) {
                change[sb.charAt(i) - '0']--;
                sb.replace(i, i + 1, rep);
            }
        }

        StringBuilder sb2 = new StringBuilder(origin);
        for (int i = 0; i < sb2.length(); i++) {
            if (change1[sb2.charAt(i) - '0'] > 0) {
                change1[sb2.charAt(i) - '0']--;
                sb2.replace(i, i + 1, rep);
            }
        }

        int j = 0;
        while (j < sb.length() && sb.charAt(j) == sb2.charAt(j))
            j++;
        if (j >= sb.length()) return sb.toString();
        if (sb.charAt(j) > sb2.charAt(j)) return sb2.toString();
        return sb.toString();
    }
}
