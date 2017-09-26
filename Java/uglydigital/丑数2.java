/*描述：设计一个算法，找出只含素因子2，3，5 的第 n 大的数。符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
      如果n = 9， 返回 10
The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
(1) 1×2, 2×2, 3×2, 4×2, 5×2,6×2，8×2 …
(2) 1×3, 2×3, 3×3, 4×3, 5×3,6×3，8×3…
(3) 1×5, 2×5, 3×5, 4×5, 5×5,6×5，8×5…
*/
class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
     public static int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (factor2 == min)
                factor2 = 2 * ugly[++index2];
            if (factor3 == min)
                factor3 = 3 * ugly[++index3];
            if (factor5 == min)
                factor5 = 5 * ugly[++index5];
        }
        return ugly[n - 1];
    }
};
