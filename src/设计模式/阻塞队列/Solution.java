package 设计模式.阻塞队列;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName : Solution
 * @Description :
 * @Author : zph
 * @Date: 2020-11-05 16:20
 * @Version : V1.0
 */
public class Solution {

    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new LinkedBlockingQueue();

        Object poll = queue.poll();



        try {
            queue.put(11);



        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
