package 栈.单调栈.q901_股票价格跨度.f1;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName : StockSpanner
 * @Description :901. 股票价格跨度
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 *
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 *
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 *
 *
 *
 * 示例：
 *
 * 输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 * 输出：[null,1,1,1,2,1,4,6]
 * 解释：
 * 首先，初始化 S = StockSpanner()，然后：
 * S.next(100) 被调用并返回 1，
 * S.next(80) 被调用并返回 1，
 * S.next(60) 被调用并返回 1，
 * S.next(70) 被调用并返回 2，
 * S.next(60) 被调用并返回 1，
 * S.next(75) 被调用并返回 4，
 * S.next(85) 被调用并返回 6。
 *
 * 注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
 * (包括今天的价格 75) 小于或等于今天的价格。
 *
 *
 * 提示：
 *
 * 调用 StockSpanner.next(int price) 时，将有 1 <= price <= 10^5。
 * 每个测试用例最多可以调用  10000 次 StockSpanner.next。
 * 在所有测试用例中，最多调用 150000 次 StockSpanner.next。
 * 此问题的总时间限制减少了 50%。
 * @Author : zph
 * @Date: 2020-09-12 23:58
 * @Version : V1.0
 */
public class StockSpanner {

    Deque<Integer> prices;
    Deque<Integer> weights;
    public StockSpanner() {
        prices=new ArrayDeque<>();
        weights=new ArrayDeque<>();

    }

    /**
     * @Title next
     * @Description 单调栈
     * @Author zph
     * @Date 2020/9/13 15:49
     * @Param [price]
     * @return int
     */
    public int next(int price) {
        int res=1;
        while (!prices.isEmpty()&&!weights.isEmpty()&&prices.peekLast()<=price){
            prices.pollLast();
            res+= weights.pollLast();
        }
        prices.offerLast(price);
        weights.offerLast(res);
        return res;
    }

    public static void main(String[] args) {
        StockSpanner solution = new StockSpanner();
        int next = solution.next(11);
        int next1 = solution.next(13);


        int next2 = solution.next(15);
        System.out.println();

    }
}
