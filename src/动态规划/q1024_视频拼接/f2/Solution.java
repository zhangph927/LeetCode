package 动态规划.q1024_视频拼接.f2;

/**
 * @ClassName : Solution
 * @Description :1024. 视频拼接
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 * <p>
 * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 * <p>
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
 * 输出：3
 * 解释：
 * 我们选中 [0,2], [8,10], [1,9] 这三个片段。
 * 然后，按下面的方案重制比赛片段：
 * 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
 * 现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
 * 示例 2：
 * <p>
 * 输入：clips = [[0,1],[1,2]], T = 5
 * 输出：-1
 * 解释：
 * 我们无法只用 [0,1] 和 [1,2] 覆盖 [0,5] 的整个过程。
 * 示例 3：
 * <p>
 * 输入：clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
 * 输出：3
 * 解释：
 * 我们选取片段 [0,4], [4,7] 和 [6,9] 。
 * 示例 4：
 * <p>
 * 输入：clips = [[0,4],[2,8]], T = 5
 * 输出：2
 * 解释：
 * 注意，你可能录制超过比赛结束时间的视频。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= clips.length <= 100
 * 0 <= clips[i][0] <= clips[i][1] <= 100
 * 0 <= T <= 100
 * @Author : zph
 * @Date: 2020-10-24 08:39
 * @Version : V1.0
 */
public class Solution {

    /**
     * @return int
     * @Title videoStitching
     * @Description 贪心算法
     * @Author zph
     * @Date 2020/10/24 10:01
     * @Param [clips, T]
     */
    public int videoStitching(int[][] clips, int T) {
        int[] max=new int[T];
        for(int[] clip:clips){
            if(clip[0]<T){
                max[clip[0]]=Math.max( max[clip[0]],clip[1]);
            }
        }
        int last=0,res=0,pre=0;
        for(int i=0;i<T;i++){
            last=Math.max(last,max[i]);
            if(i==last){
                return -1;
            }
            if(i==pre){
                res++;
                pre=last;
            }
        }
        return res;
    }


    public static void main(String[] args) {


        Solution solution = new Solution();
        int[][] clips = {{0, 1}, {1, 2}};
        int T = 5;
        int i = solution.videoStitching(clips, T);
        System.out.println(i);


    }


}
