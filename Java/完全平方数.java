Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

学习了两个方法，方法1，利用一个整数一定由一个整数+平方数构成，通过递推公式dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);遍历完成。当数字n
较大时时间复杂度不乐观。
方法2：利用数学定理，一个整数由四个完全平方数构成，可以由该形式表示4^n(8k+7)。所以问题就转化了，n%4==0，不影响平方数构成个数；n%8==7表示一定由四个平
方数构成，这两个条件就会减少巨大复杂度，然后在进行后续判断就行。
public class PefectQuare {
	public static void main(String[] args) {
		int temp = 18;
		System.out.println(perfectSqrt(temp));
		System.out.println( perfectSquare(temp));
	}

	public static int perfectSqrt(int n) {
		int s = (int) Math.sqrt(n);
        //如果n可以直接分解，那返回1
		if (s * s == n) {
			return 1;
		}
        //构建每个0-n之间所有数字平方和个数的数组，并出示一个最大值
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 0; i <= n; i++) {
			for (int j = 1; j * j + i <= n; j++)
				dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);

		}
		return dp[n];
	}

	public static int perfectSquare(int n) {
		while (n % 4 == 0)
			n /= 4;
		if (n % 8 == 7)
			return 4;
        //排除了个数4的情况，剩余1,2,3这三个情况，利用下边判断是不是由1、2个构成，如果都不是则返回3.
        //下面for默认就是1个或者2个，遍历即可。
		for (int a = 0; a * a <= n; a++) {
			int b = (int) Math.sqrt(n - a * a);
			if (a * a + b * b == n) {
				return (a == 0 ? 0 : 1) + (b == 0 ? 0 : 1);
			}
		}
		return 3;
	}
}
