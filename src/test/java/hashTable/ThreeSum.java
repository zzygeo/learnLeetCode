package hashTable;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Author zzy
 * @Description 给一个整数数组nums，判断是否存在三元组[nums[i], nums[j], nums[k]]满足i!=j、i!=k 且 j!=k
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        test3(arr);
    }
    // 考虑去重，太占用时间
    public static List<List<Integer>> test(int[] nums) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            integerIntegerHashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                int sum = nums[i] + nums[j];
                if (integerIntegerHashMap.containsKey(-sum)) {
                    if (integerIntegerHashMap.get(-sum) != i && integerIntegerHashMap.get(-sum) != j) {
                        // 在这里对数组进行排序，然后去判断是否已经存在
                        ArrayList<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(-sum);
                        integers.sort((a, b) -> a - b);
                        Stream<List<Integer>> listStream = arrayLists.stream().filter((item) -> {
                            if (item.get(0).equals(integers.get(0)) && item.get(1).equals(integers.get(1)) && item.get(2).equals(integers.get(2))) {
                                return true;
                            }
                            return false;
                        });

                        if (listStream.count() == 0) {
                            arrayLists.add(integers);
                        }
                    }
                }
            }
        }
        return arrayLists;
    }
    // 优化的hashSet解法
    public static List<List<Integer>> test2(int[] nums) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        int[] ints = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < ints.length; i++) {
            // 如果排序后第一个元素已经大于0，则直接返回结果
            if (ints[i] > 0) {
                break;
            }
            if (i > 0 && ints[i] == ints[i - 1]) {// a去重，如果上一个元素和当前元素相等，则跳过本次循环。因为已经处理过
                continue;
            }
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < ints.length; j++) {
                if (j > i + 2 && ints[j] == ints[j - 1] && ints[j - 1] == ints[j - 2]) { // b去重
                    continue;
                }
                int c = 0 - (ints[i] + ints[j]);
                if (set.contains(c)) {
                    arrayLists.add(Arrays.asList(ints[i], ints[j], c));
                    set.remove(c); // c去重
                } else {
                    set.add(ints[j]);
                }
            }
        }
        return arrayLists;
    }

    // 使用双指针解法
    public static List<List<Integer>> test3(int[] nums) {
        // 先排序
        int[] ints = Arrays.stream(nums).sorted().toArray();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            // 如果第一个就大于0，则直接返回结果
            if (ints[i] > 0) {
                break;
            }

            // a 去重
            if (i > 0 && ints[i] == ints[i - 1]) {
                continue;
            }

            int temp = ints[i];
            int left = i + 1;
            int right = ints.length - 1;

            while (left < right) {
                if (temp + ints[left] + ints[right] > 0) {
                    right--;
                } else if (temp + ints[left] + ints[right] < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(temp, ints[left], ints[right]));
                    // 去重，排除重复的位，保证left和right的旁边一位一定不一致
                    while (left < right && ints[left] == ints[left + 1]) left++;
                    while (left < right && ints[right] == ints[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
