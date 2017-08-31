描述：	/**
   *今日头条笔试题
	 * P为给定的一个二维平面，定义P中的 x 点，如果 x 点满足P中任意点都不在 x 的右上方区域内（横坐标都大于 x ），则称 x
	 * “最大”，求出所有 最大的点集合。 输入：N（点集的个数），输出（“最大”的集合） 测试用例： 5 1 2 5 3 4 6 7 5 9 0 输出：
	 * 4 6 7 5 9 0
	 * 
	 * @param args
	 */
方法1：将坐标按照x排序，排序后观察y的值，寻找y的最大值，因为x已经排序了，y是最大值前面的点x，y都小于该点的，所以不可能是最大，因此将y最大值的点保存，
然后从y最大值向后查找，后面的点继续查找y最大值，直到最后一个点结束。
import java.util.Scanner;

public class ZuoBiao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			sc.nextLine();
			int[] x = new int[n];
			int[] y = new int[n];
			for (int i = 0; i < n; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}
			for (int i = 0; i < x.length - 1; i++) { // 最多做n-1趟排序
				for (int j = 0; j < x.length - i - 1; j++) { // 对当前无序区间score[0......length-i-1]进行排序(j的范围很关键，这个范围是在逐步缩小的)
					if (x[j] > x[j + 1]) { // 把小的值交换到后面
						int temp = x[j];
						int temp1 = y[j];
						x[j] = x[j + 1];
						y[j] = y[j + 1];
						x[j + 1] = temp;
						y[j + 1] = temp1;
					}
				}
			}
			int index = 0;
			while (index < n) {
				index = MaxY(y, index);
				System.out.print(x[index - 1] + " ");
				System.out.print(y[index - 1] + " ");
				System.out.println();
			}
		}
	}

	public static int MaxY(int[] y, int index) {
		int tem = y[index];
		for (int i = index; i < y.length; i++) {
			if (y[i] > tem) {
				tem = y[i];
				index = i;
			}
		}
		return index + 1;
	}
}
  方法2：用了arrayssort的方法，实现比较器接口，重写比较器方法，
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 按x轴从小到大排序，对排序后数组，从后往前迭代，查找当前点Pi.y是否小于 max{Pk.y}, i+1<= k < n
 */
public class ZuoBiao2 {

	public static void solution(Point[] points, int n) {
		Arrays.sort(points, new MyComparator());
		boolean[] valid = new boolean[n];

		int RMaxY = points[n - 1].y;
		valid[n - 1] = true;
		int validCnt = 1;

		for (int i = n - 2; i >= 0; i--) {
			if (points[i].y <= RMaxY)
				continue;
			else {
				RMaxY = points[i].y;
				valid[i] = true;
				validCnt++;
			}
		}

		for (int i = 0; i < n; i++) {
			if (valid[i]) {
				System.out.println(points[i].x + " " + points[i].y);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			points[i] = new Point(x, y);
		}

		solution(points, n);
	}
}

class MyComparator implements Comparator<Point> {
	@Override
	public int compare(Point o1, Point o2) {
		return o1.x - o2.x;
	}
}

class Point {
	public int x;
	public int y;

	public Point(int curx, int cury) {
		x = curx;
		y = cury;
	}
}
