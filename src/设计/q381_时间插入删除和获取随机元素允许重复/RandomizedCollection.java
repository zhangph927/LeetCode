package 设计.q381_时间插入删除和获取随机元素允许重复;

import com.sun.xml.internal.ws.developer.SchemaValidation;

import java.util.*;

/**
 * @ClassName : RandomizedCollection
 * @Description :381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 *
 * 注意: 允许出现重复元素。
 *
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 * 示例:
 *
 * // 初始化一个空的集合。
 * RandomizedCollection collection = new RandomizedCollection();
 *
 * // 向集合中插入 1 。返回 true 表示集合不包含 1 。
 * collection.insert(1);
 *
 * // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
 * collection.insert(1);
 *
 * // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
 * collection.insert(2);
 *
 * // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
 * collection.getRandom();
 *
 * // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
 * collection.remove(1);
 *
 * // getRandom 应有相同概率返回 1 和 2 。
 * collection.getRandom();
 * @Author : zph
 * @Date: 2020-11-01 15:33
 * @Version : V1.0
 */
public class RandomizedCollection {

    /**
     * @Title
     * @Description 哈希表
     * @Author zph
     * @Date 2020/11/1 15:54
     * @Param
     * @return
     */

    //容量大小
   int n;
   Map<Integer,Set<Integer>> map;
   List<Integer> list;
   Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.n=0;
        this.map=new HashMap<>();
        this.list=new ArrayList<>();
        this.random=new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Set<Integer> set = map.get(val);
        if(set==null){
            set=new HashSet<>();
        }
        set.add(n);
        list.add(val);
        map.put(val,set);
        n++;
        return set.size()==1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){

        int lastIndex=n-1;
        Set<Integer> lastSet = map.get(list.get(lastIndex));
        Set<Integer> curSet = map.get(val);
        Integer curIndex = curSet.iterator().next();
        swap(list,lastIndex,curIndex);
        list.remove(lastIndex);
        curSet.remove(curIndex);
        if(curSet.size()==0){
            map.remove(val);
        }
        lastSet.remove(lastIndex);
        lastSet.add(curIndex);
        n--;

        }else {
            return false;
        }
        return true;


    }

    private void swap(List<Integer> list,int i,int j){
        int temp=list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }

    /** Get a random element from the collection. */
    public int getRandom() {
      return   list.get(random.nextInt(n));
    }




}
