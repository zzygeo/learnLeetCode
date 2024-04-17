package hashTable;

import java.util.HashMap;

/**
 * @Author zzy
 * @Description 给定一个整数数组num和一个整数目标值target，找到和为目标值的两个整数
 */
public class TwoSum {
    public static void main(String[] args) {
        int i2 = 130;
        int i = 130;
        System.out.println(i2 == i);
    }

    public static int[] towSum(int[] nums, int target) {
        int[] arr = new int[2];
        // 如果给的数组是空的，那么也返回两个为0的数组
        if (nums == null || nums.length == 0) {
            return arr;
        }
        // 在查找元素是否存在时，hashMap是首选
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 取出当前值，判断是否有想要的值在hashmap里
            int otherTarget = target - nums[i];
            if (hashMap.containsKey(otherTarget)) {
                // 有目标值，则返回key和当前的i
                arr[0] = hashMap.get(otherTarget);
                arr[1] = i;
            }
            hashMap.put(nums[i], i);
        }
        return arr;
    }
}
