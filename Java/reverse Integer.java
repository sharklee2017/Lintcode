将一个整数中的数字进行颠倒，当颠倒后的整数溢出时，返回 0 (标记为 32 位整数)。

public class Solution {
    /*
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int x) {
        // write your code here
        long result = 0;
		int temp = Math.abs(x);
		while (temp > 0) {
			result *= 10;
			result += temp % 10;
			if (result > Integer.MAX_VALUE) {
				return 0;
			}
			temp /= 10;
		}
		return (int) (x >= 0 ? result : -result);
    }
}
