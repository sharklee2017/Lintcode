给定两个二进制字符串，返回他们的和（用二进制表示）。
a = 11
b = 1
返回 100
思路：从最右边开始判断，求和进位，循环的长度为连个串的长度的较大值。另一个长度不够补0；
public class Solution {
    /*
     * @param a: a number
     * @param b: a number
     * @return: the result
     */
    public String addBinary(String a, String b) {
        // write your code here
      int maxLen = Math.max(a.length(), b.length());
		  StringBuilder sb = new StringBuilder();
		  int carry = 0;
		  for (int i = 0; i < maxLen; i++) { 
      // 从右边开始逐位取出字符串 a、b 的字符值 tempA 和
			// tempB，如果长度不足，则用0替代
			int tempA = a.length() > i ? a.charAt(a.length() - i - 1) - '0' : 0;
			int tempB = b.length() > i ? b.charAt(b.length() - i - 1) - '0' : 0;
			sb.insert(0, (tempA + tempB + carry) % 2); // 在最左侧插入相加结果
			carry = tempA + tempB + carry > 1 ? 1 : 0; // 得到进位
		}
		if (carry == 1)
			sb.insert(0, 1); // 如果最高位有进位，则最高位还要加一位 1
		return sb.toString();
    }
}
