package 数组.两数之和.q170_两数之和III数据结构设计;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : Solution
 * @Description :设计并实现一个 TwoSum 的类，使该类需要支持 add 和 find 的操作。
 * <p>
 * add 操作 -  对内部数据结构增加一个数。
 * find 操作 - 寻找内部数据结构中是否存在一对整数，使得两数之和与给定的数相等。
 * <p>
 * 示例 1:
 * <p>
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * 示例 2:
 * <p>
 * add(3); add(1); add(2);
 * find(3) -> true
 * find(6) -> false
 * <p>
 * 在列表有序的情况下，可以使用双指针，时间为O(N)，插入一个数字的时间为O(N)。
 * <p>
 * 可以使用哈希表，查找的时间为O(N)，插入时间为O(1)。
 * <p>
 * 两种方法空间都是O(N)。
 * <p>
 * 综上所述，没有排序的列表没有必要为了解题去排序。
 * <p>
 * 设计此数据结构时，也是使用哈希表最好。
 * @Author : zph
 * @Date: 2020-09-13 15:13
 * @Version : V1.0
 */
public class TwoSum {
    private Map<Integer, Integer> countsMap;

    /**
     * Initialize your data structure here.
     */
    public TwoSum() {
        countsMap = new HashMap<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        if (countsMap.containsKey(number))
            countsMap.replace(number, countsMap.get(number) + 1);
        else
            countsMap.put(number, 1);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : countsMap.entrySet()) {
            int key = value - entry.getKey();
            if ((key == entry.getKey() && entry.getValue() > 1)
                    || (key != entry.getKey() && countsMap.containsKey(key))) {
                return true;
            }
        }
        return false;
    }
}
