package hashTable;

import java.util.HashMap;

/**
 * @Author zzy
 * @Description 给四个整数数组num1, num2, num3, num4 计算多少个元组满足
 */
public class FourSumCount {
    public static void main(String[] args) {

    }

    public int test(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 遍历前两个数组，计算和，存入hashMap，然后继续遍历后面两个数组，判断两数之和是不是出现过
        // 如果出现过，则表示出现了一种可能的情况。
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                sum = nums1[i] + nums2[j];
                integerIntegerHashMap.put(sum, integerIntegerHashMap.getOrDefault(sum, 0) + 1);
                // 然后寻转有值的等于这个-sum的下标
            }
        }
        int count = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                sum = nums3[i] + nums4[j];
                if (integerIntegerHashMap.containsKey(-sum)) {
                    // 说明有这个值，那么就加上
                    count += integerIntegerHashMap.get(-sum);
                }
            }
        }
        return count;
    }
 }
