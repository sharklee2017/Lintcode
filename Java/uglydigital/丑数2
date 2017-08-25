描述：设计一个算法，找出只含素因子2，3，5 的第 n 大的数。符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
      如果n = 9， 返回 10
思路：如果暴力破解，在lintcode时间空间都会超；方法2，由丑数的定义可知，任何一个丑数都是2^i * 3^j * 5^m这种形式的，因此不断寻找丑数，将他们按从小到大的
顺序进行排列，直到第n个即为结果。 首先定义一个数组存放丑数，认为1是丑数，则初始化数组num[0] = 1，然后从2,3,5这三个种子中挑选，选择num[0]*2，num[0]*3，
num[0]*5中最小的数为新的丑数，显然应该选择2，即num[1] = 2，然后在从2,3,5中选择，这时应该是从num[1]*2，num[0]*3，num[0]*5中进行选择，显然选择3，即
num[2] = 3，然后再从num[1]*2，num[1]*3，num[0]*5中选择最小的，选择2，即num[3] = 4，依次进行如下操作，得到最终的结果
class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
       int[] u =new int[n];
       int num_2 = 0;
       int num_3 = 0;
       int num_5 = 0;
       u[0]=1;
       for(int i=1;i<n;i++){
           u[i]=Math.min(Math.min(u[num_2]*2,u[num_3]*3),u[num_5]*5);
           //这几段代码的意思是找出到底是2,3,5中哪个种子计算出的ugly[i]，当然，有可能有多个种子，比如ugly[num_2]*2 == ugly[num_3]*3时，
           //需要把num_2++，并且要使num_3++。因此这里不能使用if-else，要全部使用if进行判断。
           if(u[i]%2==0)
           num_2++;
           if(u[i]%3==0)
           num_3++;
           if(u[i]%5==0)
           num_5++;
       }
       return u[n-1];
}
};
