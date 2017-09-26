描述：写一个程序来检测一个整数是不是丑数。可以认为 1 是一个特殊的丑数。
    丑数的定义是，只包含质因子 2, 3, 5 的正整数。比如 6, 8 就是丑数，但是 14 不是丑数以为他包含了质因子 7。
    给出 num = 8，返回 true。
    给出 num = 14，返回 false
思路：暴力破解即可
    public class Solution {
    /**
     * @param num an integer
     * @return true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
       public static boolean isUglyDigital(int num) {
        for (int i=2; i<6 && num>0; i++)
            while (num % i == 0)
                num /= i;
        return num == 1;
    }
}
