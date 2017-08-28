描述：输入一串序列，求最大连续字序列和
示例输入：45 -27 128 13 -86 -21
输出：最大子序列和为：159
复杂度O(n)
思路：首先是输入问题，由于不知道输入长度，直接就想到用arraylist去接收，发现一直跳不出while循环，最终使用接受一行字符串，然后解析出数组。
    解题方法：用两个变量，max记录当前的最大值，maxvalue记录整个过程的最大值，每次用num[i]和num[i]+max比较，num[i]大说明原来的max把num[i]拉小了，此时
    将num[i]赋给max，表示从该位置继续往后判别。maxvalue始终记录最大值

import java.util.Scanner;
public class MaxSubArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();//接受一行字符串
		String[] strings = str1.split(" ");
		int[] result = new int[strings.length];
		for (int i = 0; i < strings.length; i++) {
			result[i] = Integer.parseInt(strings[i]);
		}
		System.out.println(max(result));
	}

	public static int max(int[] nums) {
		int max = nums[0];
		int maxvalue = nums[0];
		for (int i = 1; i < nums.length; i++) {
			max = Math.max(nums[i], max + nums[i]);
			maxvalue = Math.max(max, maxvalue);
		}
		return maxvalue;

	}
}
