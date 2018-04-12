package zx.leetcode.dog.apri;

import java.util.HashSet;
import java.util.Iterator;

public class Longest_Consecutive_Sequence_128 {

	public int longestConsecutive(int[] nums) {
		HashSet<Integer> set = new HashSet();
		int max = 0;
		for (int i : nums) {
			set.add(i);
		}

		while (!set.isEmpty()) {
			Iterator<Integer> iterator = set.iterator();
			int item = iterator.next();
			set.remove(item);
			int len = 1;

			int preItem = item - 1;
			while (set.contains(preItem)) {
				set.remove(preItem--);
				len++;
			}

			int nextItem = item + 1;
			while (set.contains(nextItem)) {
				set.remove(nextItem++);
				len++;
			}
			if (len > max) {
				max = len;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out
				.println(new Longest_Consecutive_Sequence_128().longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
	}
}
