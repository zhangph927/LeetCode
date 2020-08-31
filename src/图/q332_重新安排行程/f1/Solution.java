package 图.q332_重新安排行程.f1;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :332. 重新安排行程
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 *
 * 说明:
 *
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 示例 1:
 *
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2:
 *
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 * @Author : zph
 * @Date: 2020-08-27 20:59
 * @Version : V1.0
 */
public class Solution {


    Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    List<String> itinerary = new LinkedList<String>();

    /**
     * @Title findItinerary
     * @Description Hierholzer 算法
     * @Author zph
     * @Date 2020/8/28 17:35
     * @Param [tickets]
     * @return java.util.List<java.lang.String>
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    public void dfs(String curr) {
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }
        itinerary.add(curr);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> tickets=new ArrayList<>();
        List<String> tickets_1=new ArrayList<>();
        List<String> tickets_2=new ArrayList<>();
        List<String> tickets_3=new ArrayList<>();
        List<String> tickets_4=new ArrayList<>();
        tickets_1.add("MUC");
        tickets_1.add("LHR");

        tickets_2.add("JFK");
        tickets_2.add("MUC");

        tickets_3.add("SFO");
        tickets_3.add("SJC");

        tickets_4.add("LHR");
        tickets_4.add("SFO");

        tickets.add(tickets_1);
        tickets.add(tickets_2);
        tickets.add(tickets_3);
        tickets.add(tickets_4);

        List<String> itinerary = solution.findItinerary(tickets);

        System.out.println(itinerary.toString());


    }





}
