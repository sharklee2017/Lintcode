输入一个整数，返回其在杨辉三角中所在的行数。
使用一维数组保存每一行的数，然后依次计算下一行，方法简单明了，学习模板
方法：
 public static long printYFTriangle(long x) {
        long[] a = new long[(int) (x + 1)];//此处传递进来的x，可以获知x所在的行数不会大于x+1
        long previous = 1;
        boolean flag = false;
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j <= i; j++) {
                long current = a[j];
                a[j] = previous + current;
                previous = current;
                if (a[j] == x) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
