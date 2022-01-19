package serializ.zzzcommon;

import java.io.Serializable;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Test extends TestPre implements Serializable {

    /**使用完全相同绝对路径类可以不用设置*/
    private static final long serialVersionUID = 1L;

    /**测试序列化静态的final字段*/
    public static final long staticFinalNum = 1L;

    /**测试序列化静态的字段*/
    public static int staticNum = 2;

    //不被序列化，重新读取重新初始化值
    //序列化读取时默认该类型初始值而不是设置的值
    /**测试序列化transient的字段*/
    transient int transientNum = 3;

    /**测试序列化存在的字段*/
    private int a = 4;

    /**测试序列化不存在的字段*/
    public int otherNum1 = 50;

    public int getTransientNum() {
        return transientNum;
    }

    public int getA() {
        return a;
    }
}
