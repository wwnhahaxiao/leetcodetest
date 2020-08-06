package leetcode;

public class SortAlgorithm {

    //插入排序
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int index = i;
            while (index >= 1 && temp < arr[index - 1]) {
                arr[index] = arr[index - 1];
                index--;
            }
            arr[index] = temp;
        }
    }

    //希尔排序
    private static void shellSort(int[] arr) {
        for (int step = arr.length / 2; step >= 1; step /= 2) {
            for (int i = 0; i < step; i++) {
                for (int j = i + step; j < arr.length; j += step) {
                    int temp = arr[j];
                    int index = j;
                    while (index >= step && temp < arr[index - step]) {
                        arr[index] = arr[index - step];
                        index -= step;
                    }
                    arr[index] = temp;
                }
            }
        }
    }

    //选择排序
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }

    //冒泡排序
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    //归并排序
    private static void mergeSort(int[] arr) {
        int[] result = new int[arr.length];
        mergeSortRecursive(arr, result, 0, arr.length - 1);
    }

    private static void mergeSortRecursive(int[] arr, int[] result, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortRecursive(arr, result, left, mid);
        mergeSortRecursive(arr, result, mid + 1, right);
        int start = left, start1 = left, start2 = mid + 1;
        while (start1 <= mid && start2 <= right) {
            result[start++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= mid) {
            result[start++] = arr[start1++];
        }
        while (start2 <= right) {
            result[start++] = arr[start2++];
        }
        for (int i = left; i <= right; i++) {
            arr[i] = result[i];
        }
    }

    //快速排序
    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left;
        for (int i = mid + 1; i <= right; i++) {
            if (arr[i] < arr[mid]) {
                int temp = arr[i];
                for (int j = i; j > mid; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[mid] = temp;
                mid++;
            }
        }
        quickSort(arr, left, mid - 1);
        quickSort(arr, mid + 1, right);
    }

    //堆排序
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

    public static void main(String[] args) {
        int[] test = {7,7,7,6,5,4,3,2,1};
//        insertionSort(test);
//        shellSort(test);
//        mergeSort(test);
//        quickSort(test);
        heapsort(test);
        System.out.println(test);

//        Random random = new Random();
//        for (int j = 0; j < 100000; j++) {
//            int[] test = new int[random.nextInt(1000)];
//            for (int i = 0; i < test.length; i++) {
//                test[i] = random.nextInt(1000);
//            }
//            Test.quickSort(test);
//            for (int i = 1; i < test.length; i++) {
//                if (test[i] < test[i - 1]) {
//                    System.out.println("error");
//                }
//            }
//        }

    }
}
