package com.huawei;

/**
 * N皇后问题，在棋牌上，每行每列每对角线只允许出现一个皇后
 */

import java.util.Arrays;
import java.util.Date;

public class NQueen {
    static short N = 8;
    static int count = 0;

    public static void main(String[] args) {

        Date start = new Date();
        short[] chess = new short[N];
        Arrays.fill(chess, (short) 0);
        putQueen(chess, (short) 0);
        Date end = new Date();
        System.out.println("解决 " + N + " 皇后问题，用时：" + String.valueOf(end.getTime() - start.getTime()) + "毫秒，计算结果：" + count);

    }

    public static void putQueen(short[] chess, short row) {
        short[] chessTemp = chess.clone();
        if (row == N) {
            for (short i : chessTemp) {
                System.out.print(i + "\t");
            }
            System.out.println();
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            chessTemp[row] = (short) i;
            if (isSafety(chessTemp, row, (short) i)) {

                putQueen(chessTemp, (short) (row + 1));
            }
        }

    }

    public static boolean isSafety(short[] chess, short row, short col) {

        int step = 1;
        for (short i = (short) (row - 1); i >= 0; i--) {

            if (chess[i] == col) {
                return false;
            }
            if (chess[i] == col - step) {
                return false;
            }
            if (chess[i] == col + step) {
                return false;
            }
            step++;
        }
        return true;

    }
}
