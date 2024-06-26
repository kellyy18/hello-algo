/**
 * File: array.java
 * Created Time: 2022-11-25
 * Author: krahets (krahets@163.com)
 */

package chapter_array_and_linkedlist;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class array {
    /* 随机访问元素 */
    static int randomAccess(int[] nums) {
        // 在区间 [0, nums.length) 中随机抽取一个数字
        int randomIndex = ThreadLocalRandom.current().nextInt(0, nums.length);
        // 获取并返回随机元素
        int randomNum = nums[randomIndex];
        return randomNum;
    }

    /* 扩展数组长度 */
    static int[] extend(int[] nums, int enlarge) {
        // 初始化一个扩展长度后的数组
        int[] res = new int[nums.length + enlarge];
        // 将原数组中的所有元素复制到新数组
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        // 返回扩展后的新数组
        return res;
    }

    /* 在数组的索引 index 处插入元素 num */
    static void insert(int[] nums, int num, int index) {
        // 把索引 index 以及之后的所有元素向后移动一位
        for (int i = nums.length - 1; i > index; i--) {
            nums[i] = nums[i - 1];
        }
        // 将 num 赋给 index 处的元素
        nums[index] = num;
    }

    /* 删除索引 index 处的元素 */
    static void remove(int[] nums, int index) {
        // 把索引 index 之后的所有元素向前移动一位
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }

    /* 遍历数组 */
    static void traverse(int[] nums) {
        int count = 0;
        // 通过索引遍历数组
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
        }
        // 直接遍历数组元素
        for (int num : nums) {
            count += num;
        }
    }

    /* 在数组中查找指定元素 */
    static int find(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }

    /* Driver Code */
    public static void main(String[] args) {
        /* 初始化数组 */
        int[] arr = new int[5];
        System.out.println("To print something");
        System.out.println("Array arr = " + Arrays.toString(arr));
        int[] nums = { 1, 3, 2, 5, 4 };
        System.out.println("Array nums = " + Arrays.toString(nums));

        /* 随机访问 */
        int randomNum = randomAccess(nums);
        System.out.println("Pick random number from nums  " + randomNum);

        /* 长度扩展 */
        nums = extend(nums, 3);
        System.out.println("Extend array to 8 get nums = " + Arrays.toString(nums));

        /* 插入元素 */
        insert(nums, 6, 3);
        System.out.println("Insert at Index position of 3 with number 6 get nums = " + Arrays.toString(nums));

        /* 删除元素 */
        remove(nums, 2);
        System.out.println("Delete index of 2 data element，get nums = " + Arrays.toString(nums));

        /* 遍历数组 */
        traverse(nums);

        /* 查找元素 */
        int index = find(nums, 3);
        System.out.println("Search nums with 3，get index = " + index);
        System.out.println("Kaiyu changed chinese output to english outpu");

    }
}
