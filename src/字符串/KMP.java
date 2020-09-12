package 字符串;

/**
 * @ClassName KMP
 * @Description TODO
 * @Author zph
 * @Date 2020/2/3 14:24
 * @Version V1.0
 */
public class KMP {


    // KMP中的核心算法，获得记录跳转状态的next数组
    public static int[] next(String sub) {
        int[] next = new int[sub.length() + 1];
        char[] T = sub.toCharArray();
        int length = sub.length();

        int i, j;
        i = 1;
        j = 0;
        next[1] = 0;//第一个字符的next值是0, 假设数组next是从1开始的算，next[0]不用
        while (i < length) {
            if (j == 0 || T[i - 1] == T[j - 1])// 此处T[i]表示后缀单个字符，T[j]表前缀
            {
                ++i;
                ++j;
                next[i] = j;//存放当前的next值为此时模式串的游标值
            } else
                j = next[j];// 若字符不同，刚j值回溯
            //System.out.println("i:" + i + "  j:" + j);
        }
        return next;
    }

    public static int[] nextval(String sub) {
        int[] next = new int[sub.length() + 1];
        char[] T = sub.toCharArray();
        int length = sub.length();

        int i, j;
        i = 1;
        j = 0;
        next[1] = 0;
        while (i < length) {
            if (j == 0 || T[i - 1] == T[j - 1])// 此处T[i]表示后缀单个字符，T[j]表前缀
            {
                ++i;
                ++j;

                if (T[i - 1] != T[j - 1]) // 若当前字符与前缀字符不同
                {
                    next[i] = j;
                } else {
                    next[i] = next[j]; // 若相同，刚将前缀字符的next值赋给next在i位置的值
                }

            } else
                j = next[j];// 若字符不同，刚j值回溯
            //System.out.println("i:" + i + "  j:" + j);
        }
        return next;
    }

    public static int Index_KMP(String str, String sub, int pos) {
        char[] S = str.toCharArray();
        char[] T = sub.toCharArray();
        int[] next = next(sub);
        int i;
        if (pos < 1) {
            System.out.println("起位置输入错误，默认设置为1");
            i = 1;
        } else {
            i = pos;
        }
        int j = 1; // i控制S,j控制T;
        while (i <= S.length && j <= T.length) {
            if (j == 0 || S[i - 1] == T[j - 1]) {
                ++i;
                ++j;
            } else {
                j = next[j]; // j退回合适的位置，i值不变
            }
        }
        if (j > T.length)
            return i - T.length;
        else
            return 0;
    }

    public static void main(String[] args) {
        String sub = "abaabcac";
        String str = "zzzaabaabcacfdsafas";
        int[] next = next(sub);
        System.out.print("next数组是：");
        for (int i = 1; i < next.length; i++) {
            System.out.print(next[i]);
        }

        int index = Index_KMP(str, sub, 1);
        System.out.print("\n匹配位置为：" + index);
    }
}
