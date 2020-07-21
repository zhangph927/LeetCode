package 多线程和并发.并发.ForkJoin问题;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * @ClassName : ForkJoinTaskDemo
 * @Description :
 * @Author : zph
 * @Date: 2020-07-19 14:31
 * @Version : V1.0
 */
public class ForkJoinTaskDemo {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        CountTask task = new CountTask(1,4);
        Future<Integer> result = pool.submit(task);
        try {
            System.out.println("计算结果=" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
