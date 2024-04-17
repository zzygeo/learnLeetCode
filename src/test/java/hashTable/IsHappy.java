package hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author zzy
 * @Description 判断快乐数
 */
public class IsHappy {
    public static void main(String[] args) {
        boolean happy = isHappy(19);
        System.out.println(happy);
    }

    public static boolean isHappy(int n) {
        // 快乐数可能是无线循环的，因此判断sum是否重复出现，直到sum==1的时候终止
        Set<Integer> tSet = new HashSet<>();
        int total = 0;
        while(total != 1) {
            total = sum(n);
            // 判断在不在set里
            boolean isInSet = tSet.add(total);
            if (isInSet == false) {
                // 已经重复了
                return false;
            } else {
                n = total;
            }
        }
        return true;
    }

    public static int sum(int n) {
        // 返回每数字每个位数上的合
        int sum = 0;
        while(n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
