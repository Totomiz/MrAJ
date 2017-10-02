package com.zt.java.datastructure.basic;

/**
 * Created by tony.zhang
 * Email: tony.zhang.Mr@foxmail.com
 * <p>基本排序</p>
 */

public class SortNumber {
    public static void main(String[] args) {
        Integer[] originNums = new Integer[]{33, 1111, 44, 43324, 13, 11, 558, 2001, 200, 9, 100, 42, 78};
        SortNumber handle = new SortNumber();
        System.out.println("original Nums:");
        printf(originNums);
        printf(handle.bubbleSortByAsc(originNums));
        printf(handle.bubbleSortByAsc2(originNums));
        printf(handle.bubbleSortByDesc(originNums));
        printf(handle.bubbleSortByDesc2(originNums));
        printf(handle.quickSortByAsc(originNums));
        printf(handle.quickSortByDesc(originNums));
        printf(handle.insertSortByAsc(originNums));
        printf(handle.insertSortByDesc(originNums));
        printf(handle.shellSortAsc(originNums));
        printf(handle.shellSortByDesc(originNums));
        printf(handle.selectSortByAsc(originNums));
        printf(handle.selectSortByDesc(originNums));
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

    /**
     * 基本思想：每步将一个待排序的记录，按其顺序码大小插入到
     * 前面已经排序的字序列的合适位置（从后向前找到合适位置后），
     * 直到全部插入排序完为止。
     * <p>
     * 从第一个元素开始，该元素可以认为已经被排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 将新元素插入到该位置中
     * 重复步骤2
     *
     * @param nums
     */
    public Integer[] insertSortByAsc(Integer[] nums) {
        System.out.println("insert sort by Asc:");
        Integer[] clone = nums.clone();
        for (int i = 0; i < clone.length; i++) {
            int temp = clone[i];//取出下个待插入排序的数
            int j = 0;//插入的位置标记
            for (j = i; j > 0 && temp < clone[j - 1]; j--) {//满足待排序数小于前面的数条件，j--
                clone[j] = clone[j - 1];//整体后移一位
            }
            clone[j] = temp;
        }
        return clone;
    }


    /**
     * 基本思想：每步将一个待排序的记录，按其顺序码大小插入到
     * 前面已经排序的字序列的合适位置（从后向前找到合适位置后），
     * 直到全部插入排序完为止。
     * <p>
     * 从第一个元素开始，该元素可以认为已经被降序排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 如果该元素（已排序）小于新元素，将该元素移到下一位置
     * 重复步骤3，直到找到已排序的元素大于或者等于新元素的位置
     * 将新元素插入到该位置中
     * 重复步骤2
     *
     * @param nums
     */
    public Integer[] insertSortByDesc(Integer[] nums) {
        System.out.println("insert sort by Desc:");
        Integer[] clone = nums.clone();
        for (int i = 0; i < clone.length; i++) {
            int temp = clone[i];//取出下个待插入排序的数
            int j = 0;//插入的位置标记
            for (j = i; j > 0 && temp > clone[j - 1]; j--) {//满足待排序数大于前面的数条件，j--
                clone[j] = clone[j - 1];//整体后移一位
            }
            clone[j] = temp;
        }
        return clone;
    }

    /**
     * 希尔排序升序
     * 基本思想：
     * 将数组拆分成d长度的小数组，最开始d长度为length/2
     * 对小数组插入排序
     * 再将d长度缩小为d/2
     * 重复操作，直到d=1
     *
     * @param nums src numbers
     * @return result numbers
     */
    public Integer[] shellSortAsc(Integer[] nums) {
        System.out.println("shell sort by Asc:");
        Integer[] clone = nums.clone();
        for (int d = clone.length / 2; d >= 1; d /= 2) {//d每次缩小二分之一
            for (int groupStarPosition = 0; groupStarPosition <= clone.length - d; groupStarPosition++) {//分成d长度的段
                //对d长度的每组数进行插入排序,每组起始坐标为groupStarPosition
                for (int j = groupStarPosition; j < groupStarPosition + d; j++) {
                    int temp = clone[j];
                    int k = 0;
                    for (k = j; k > groupStarPosition && temp < clone[k - 1]; k--) {
                        clone[k] = clone[k - 1];
                    }
                    clone[k] = temp;
                }
            }
        }
        return clone;
    }

    /**
     * 希尔排序升序
     * 基本思想：
     * 将数组拆分成d长度的小数组，最开始d长度为length/2
     * 对小数组插入排序
     * 再将d长度缩小为d/2
     * 重复操作，直到d=1
     *
     * @param nums src numbers
     * @return result numbers
     */
    public Integer[] shellSortByDesc(Integer[] nums) {
        System.out.println("shell sort by Desc:");
        Integer[] clone = nums.clone();
        for (int d = clone.length / 2; d >= 1; d /= 2) {//d每次缩小二分之一
            for (int groupStarPosition = 0; groupStarPosition <= clone.length - d; groupStarPosition++) {//分成d长度的段
                //对d长度的每组数进行插入排序,每组起始坐标为groupStarPosition
                for (int j = groupStarPosition; j < groupStarPosition + d; j++) {
                    int temp = clone[j];
                    int k = 0;
                    for (k = j; k > groupStarPosition && temp > clone[k - 1]; k--) {
                        clone[k] = clone[k - 1];
                    }
                    clone[k] = temp;
                }
            }
        }
        return clone;
    }

    /**
     * 选择排序（升序）
     * 每次选择一个最小值排在有序数组的后面一位上
     * 主要关心每次选择的最小值的位置与值，再将此位置与数值交换
     *
     * @param nums src numbers
     * @return result numbers
     */
    public Integer[] selectSortByAsc(Integer[] nums) {
        System.out.println("select sort by Asc:");
        Integer[] clone = nums.clone();
        int position = 0;//记录本次选择数的数组位置
        int value = 0;//记录本次选择的值
        for (int i = 0; i < clone.length; i++) {
            value = clone[i];//初始值为clone[i]
            for (int j = i; j < clone.length; j++) {
                //如果发现有值比当前选择的值小，position记录他在数组中的位置，更新value的值，进行下次比较
                if (clone[j] <= value) {
                    position = j;
                    value = clone[j];
                }
            }
            //将此次选择的最小值与clone[i]位置交换
            int temp = clone[i];
            clone[i] = value;
            clone[position] = temp;
        }
        return clone;
    }

    /**
     * 选择排序(降序)
     * 每次选择一个最大值排在有序数组的后面一位上
     * 主要关心每次选择的最大值的位置与值，再将此位置与起始选择位置交换
     *
     * @param nums src numbers
     * @return result numbers
     */
    public Integer[] selectSortByDesc(Integer[] nums) {
        System.out.println("select sort by Desc:");
        Integer[] clone = nums.clone();
        int position = 0;//记录本次选择数的数组位置
        int value = 0;//记录本次选择的值
        for (int i = 0; i < clone.length; i++) {
            value = clone[i];//初始值为clone[i]
            for (int j = i; j < clone.length; j++) {
                //如果发现有值比当前选择的值大，position记录他在数组中的位置，更新value的值，进行下次比较
                if (clone[j] >= value) {
                    position = j;
                    value = clone[j];
                }
            }
            //将此次选择的最小值与clone[i]位置交换
            int temp = clone[i];
            clone[i] = value;
            clone[position] = temp;
        }
        return clone;
    }
}
