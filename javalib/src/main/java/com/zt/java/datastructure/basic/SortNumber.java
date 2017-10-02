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

}
