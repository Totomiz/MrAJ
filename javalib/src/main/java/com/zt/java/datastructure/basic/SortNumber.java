package com.zt.java.datastructure.basic;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 * <p>基本排序</p>
 */

public class SortNumber {
    public static void main(String[] args) {
        Integer[] originNums = new Integer[]{33, 1111, 44, 13, 11, 558, 2001, 200, 9, 100, 42, 78};
        SortNumber handle = new SortNumber();
        System.out.println("original Nums:");
        printf(originNums);
        printf(handle.bubbleSortByAsc(originNums));
        printf(handle.bubbleSortByAsc2(originNums));
        printf(handle.bubbleSortByDesc(originNums));
        printf(handle.bubbleSortByDesc2(originNums));
        printf(handle.quickSortByAsc(originNums));
        printf(handle.quickSortByDesc(originNums));
    }

    /**
     * 打印对象数组
     *
     * @param ts
     * @param <T>
     */
    private static <T> void printf(T[] ts) {
        StringBuilder buffer = new StringBuilder();
        for (T t : ts) {
            buffer.append(" ").append(t);
        }
        System.out.println(buffer.toString());
    }

    /**
     * <p>交换两个数</p>
     *
     * @param a num1
     * @param b num2
     */
    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    /**
     * <p>交换两个数的方式二</p>
     *
     * @param a num1
     * @param b num2
     */
    public void swap2(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
    }

    /**
     * <p>非严格冒泡升序排列方式</p>
     *
     * @param nums 数据源
     * @return 排序完成数组
     */
    public Integer[] bubbleSortByAsc2(Integer[] nums) {
        System.out.println("Bubble sort by Asc2:");
        Integer[] clone = nums.clone();
        for (int i = 0; i < clone.length; i++) {
            for (int j = i + 1; j < clone.length; j++) {
                if (clone[i] > clone[j]) {
                    int temp = clone[i];
                    clone[i] = clone[j];
                    clone[j] = temp;
                }
            }
        }
        return clone;
    }

    /**
     * <p>非严格冒泡降序排列方式</p>
     *
     * @param nums 数据源
     * @return 排序完成数组
     */
    public Integer[] bubbleSortByDesc2(Integer[] nums) {
        System.out.println("Bubble sort by Desc2:");
        Integer[] clone = nums.clone();
        for (int i = 0; i < clone.length; i++) {
            for (int j = i + 1; j < clone.length; j++) {
                if (clone[i] < clone[j]) {
                    int temp = clone[i];
                    clone[i] = clone[j];
                    clone[j] = temp;
                }
            }
        }
        return clone;
    }

    /**
     * 冒泡升序
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     * @param nums src
     * @return result
     */
    public Integer[] bubbleSortByAsc(Integer[] nums) {
        System.out.println("Bubble sort by asc");
        Integer[] clone = nums.clone();
        for (int i = 0; i < clone.length - 1; i++) {
            for (int j = 0; j < clone.length - 1 - i; j++) {
                if (clone[j] > clone[j + 1]) {
                    int temp = clone[j];
                    clone[j] = clone[j + 1];
                    clone[j + 1] = temp;
                }
            }
        }
        return clone;
    }

    /**
     * 冒泡降序排列
     *
     * @param nums 数据源
     * @return result
     */
    public Integer[] bubbleSortByDesc(Integer[] nums) {
        System.out.println("Bubble sort by Desc:");
        Integer[] clone = nums.clone();
        for (int i = 0; i < clone.length - 1; i++) {
            for (int j = 0; j < clone.length - 1 - i; j++) {
                if (clone[j] < clone[j + 1]) {
                    int temp = clone[j];
                    clone[j] = clone[j + 1];
                    clone[j + 1] = temp;
                }
            }
        }
        return clone;
    }

    /**
     * 快速排序升序
     *
     * @param nums src
     * @return result
     */
    public Integer[] quickSortByAsc(Integer[] nums) {
        Integer[] clone = nums.clone();
        System.out.println("quick sort by Asc");
        quickSortByAsc(clone, 0, clone.length - 1);
        return clone;
    }

    public void quickSortByAsc(Integer[] nums, int low, int high) {
        if (low < high) {
            int middle = getMiddleAsc(nums, low, high);
            quickSortByAsc(nums, low, middle - 1);
            quickSortByAsc(nums, middle + 1, high);
        }
    }

    /**
     * 获取中轴位置(Asc升序)
     *
     * @param nums src
     * @param low  low
     * @param high high
     * @return position
     */
    private int getMiddleAsc(Integer[] nums, int low, int high) {
        int middleNum = nums[low];//取第一次传入的low位位中轴数
        while (low < high) {
            while (low < high && nums[high] >= middleNum) {//右边high游标不断前移，如果当前位置的数大于中轴上的数
                high--;
            }
            nums[low] = nums[high];//小的移到左边
            while (low < high && nums[low] <= middleNum) {//左边low游标不断后移，如果当前low位置的数小于中轴上的数
                low++;
            }
            nums[high] = nums[low];//大的移到右边
        }
        nums[low] = middleNum;//将中轴数放到正确的位置上
        return low;
    }

    /**
     * 快速排序升序
     *
     * @param nums src
     * @return result
     */
    public Integer[] quickSortByDesc(Integer[] nums) {
        Integer[] clone = nums.clone();
        System.out.println("quick sort by desc:");
        quickSortByDesc(clone, 0, clone.length - 1);
        return clone;
    }

    private void quickSortByDesc(Integer[] nums, int low, int high) {
        if (low < high) {
            int middle = getMiddleDesc(nums, low, high);
            quickSortByDesc(nums, low, middle - 1);//对中轴左边继续排序
            quickSortByDesc(nums, middle + 1, high);//对中轴右边继续排序
        }
    }

    /**
     * 获取中轴位置(Desc降序)
     *
     * @param nums src
     * @param low  low
     * @param high high
     * @return position
     */
    private int getMiddleDesc(Integer[] nums, int low, int high) {
        int middleNum = nums[low];//取第一次传入的low位位中轴数
        while (low < high) {
            while (low < high && nums[high] <= middleNum) {//右边high游标不断前移，如果当前位置的数小于中轴上的数
                high--;
            }
            nums[low] = nums[high];//大的数移到左边
            while (low < high && nums[low] >= middleNum) {//左边low游标不断后移，如果当前low位置的数大于中轴上的数
                low++;
            }
            nums[high] = nums[low];//小的数移到右边
        }
        nums[low] = middleNum;//将中轴数放到正确的位置上
        return low;

    }


}
