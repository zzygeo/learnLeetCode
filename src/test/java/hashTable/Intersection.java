package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author zzy
 * @Description 两个数组的交集
 */
public class Intersection {
    public static void main(String[] args) {
        int[] arr = {4, 9, 5};
        int[] arr2 = {9, 4, 9, 8, 4};
        int[] test = test(arr, arr2);
        for (int item : test) {
            System.out.print(item + " ");
        }
    }

    public static int[] test(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            integerIntegerHashMap.put(nums1[i], integerIntegerHashMap.getOrDefault(nums1[i], 0) + 1);
        }
        HashSet<Integer> integers1 = new HashSet<>();
        for (int j = 0; j < nums2.length; j++) {
           if (integerIntegerHashMap.getOrDefault(nums2[j], 0) != 0) {
               integers1.add(nums2[j]);
           }
       }
        return integers1
                .stream().mapToInt(Integer::intValue).toArray();
    }
}
