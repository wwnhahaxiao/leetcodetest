package com.roshan.leetcode;

public class Test {
    public static void main(String[] args) {
        int min = Integer.MAX_VALUE;
        int floor = 0;
        for (int i = 1; i < 100; i++) {
            if ((100 / i + i) <= min) {
                min = 100 / i + i;
                floor = i;
            }
        }
        System.out.println(min);
        System.out.println(floor);
    }
    public void t1() {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < 100; i++) {
            min = Math.min(min, 100 / i + i);
        }
        System.out.println(min);
    }
    /**
     * def superEggDrop(self, K: int, N: int) -> int:
     *
     *         memo = dict()
     *         def dp(K, N):
     *             if K == 1: return N
     *             if N == 0: return 0
     *             if (K, N) in memo:
     *                 return memo[(K, N)]
     *
     *             # for 1 <= i <= N:
     *             #     res = min(res,
     *             #             max(
     *         #                     dp(K - 1, i - 1),
     *         #                     dp(K, N - i)
     *             #                 ) + 1
     *             #             )
     *
     *             res = float('INF')
     *             # 用二分搜索代替线性搜索
     *             lo, hi = 1, N
     *             while lo <= hi:
     *                 mid = (lo + hi) // 2
     *                 broken = dp(K - 1, mid - 1) # 碎
     *                 not_broken = dp(K, N - mid) # 没碎
     *                 # res = min(max(碎，没碎) + 1)
     *                 if broken > not_broken:
     *                     hi = mid - 1
     *                     res = min(res, broken + 1)
     *                 else:
     *                     lo = mid + 1
     *                     res = min(res, not_broken + 1)
     *
     *             memo[(K, N)] = res
     *             return res
     *
     *         return dp(K, N)
     */
}
