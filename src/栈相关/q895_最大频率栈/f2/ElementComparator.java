package 栈相关.q895_最大频率栈.f2;

import java.util.Comparator;

/**
 * @ClassName : ElementComparator
 * @Description :
 * @Author : zph
 * @Date: 2020-07-07 22:06
 * @Version : V1.0
 */
public class ElementComparator implements Comparator<Element> {
    @Override
    public int compare(Element o1, Element o2) {
        if(o1.freq!=o2.freq){
            return o2.freq-o1.freq;
        }
        return o2.seq-o1.seq;
    }
}
