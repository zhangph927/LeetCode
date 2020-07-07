package 栈相关.q895_最大频率栈.f2;

/**
 * @ClassName : Element
 * @Description :
 * @Author : zph
 * @Date: 2020-07-07 22:04
 * @Version : V1.0
 */
public class Element {
    //数字
    int number;
    //频率
    int freq;
    //序号，递增
    int seq;

    public Element(int number, int freq, int seq) {
        this.number = number;
        this.freq = freq;
        this.seq = seq;
    }
}
