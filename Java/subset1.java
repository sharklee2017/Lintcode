package com.huawei.ziji;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输出一个数组的所有子集
 */
public class ziji {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 2 };
		System.out.println(subsets(nums));
	}

	public static List<List<Integer>> subsets(int[] nums) {

		int length = nums.length;
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		dfs(result, list, nums, 0);
		return result;
	}

	public static void dfs(List<List<Integer>> result, List<Integer> list, int[] nums,
			int pos) {
		result.add(new ArrayList<Integer>(list));

		for (int i = pos; i < nums.length; i++) {
			/*
			 * list.add(nums[i]); dfs(result, list, nums, i + 1);
			 * list.remove(list.size() - 1);
			 */

			if (i != pos && nums[i] == nums[i - 1]) {
				continue;
			}
			list.add(nums[i]);
			dfs(result, list, nums, i + 1);
			list.remove(list.size() - 1); // 这种方法效率更高

		}
	}
}
