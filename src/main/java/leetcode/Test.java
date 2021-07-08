package leetcode;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Test {

    /*
    for 选择 in 选择列表:
        # 做选择
        将该选择从选择列表移除
        路径.add(选择)
        backtrack(路径, 选择列表)
        # 撤销选择
        路径.remove(选择)
        将该选择再加入选择列表
     */

    @org.junit.Test
    public void test() {
//        Map<String, String> map = new HashMap<>();
//        map.put("aa", "1");
//        map.put("bB", "1");

        int[] arr = new int[]{1,2,2,5,2,3,10,5,7};
        heapsort(arr);
    }

    public static void heapsort(int[] arr) {
        /*
         *  第一步：将数组堆化
         *  beginIndex = 第一个非叶子节点。
         *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
         */
        int len = arr.length - 1;
        int beginIndex = (arr.length >> 1) - 1;
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(i, len, arr);
        }
        /*
         * 第二步：对堆化数据排序
         * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。
         * 直至未排序的堆长度为 0。
         */
        for (int i = len; i > 0; i--) {
            swap(0, i, arr);
            maxHeapify(0, i - 1, arr);
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     *
     * @param index 需要堆化处理的数据的索引
     * @param len   未排序的堆（数组）的长度
     */
    private static void maxHeapify(int index, int len, int[] arr) {
        // 左子节点索引
        int li = (index << 1) + 1;
        // 右子节点索引
        int ri = li + 1;
        // 子节点值最大索引，默认左子节点。
        int cMax = li;
        // 左子节点索引超出计算范围，直接返回。
        if (li > len) return;
        // 先判断左右子节点，哪个较大。
        if (ri <= len && arr[ri] > arr[li]) {
            cMax = ri;
        }
        if (arr[cMax] > arr[index]) {
            // 如果父节点被子节点调换
            swap(cMax, index, arr);
            // 则需要继续判断换下后的父节点是否符合堆的特性。
            maxHeapify(cMax, len, arr);
        }
    }

}
