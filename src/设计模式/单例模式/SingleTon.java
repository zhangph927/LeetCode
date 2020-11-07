package 设计模式.单例模式;

import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;

/**
 * @ClassName : SingleTon
 * @Description :
 * @Author : zph
 * @Date: 2020-11-05 23:05
 * @Version : V1.0
 */
public class SingleTon {

    private SingleTon() {

    }

    private static volatile SingleTon instance = null;

    public SingleTon getInstance() {
        if (instance == null) {
            synchronized (SingleTon.class) {
                if (instance == null) {
                    instance = new SingleTon();

                }
            }
        }
        return instance;

    }


}
