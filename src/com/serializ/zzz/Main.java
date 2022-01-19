package serializ.zzz;


import serializ.zzzcommon.Test;

import java.io.*;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 *D:\ideaProject2\test 跨jvm测试类
 **/
public class Main {

    public static void main(String[] args) {

        Test test = new Test();
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("D:/ideaProject2/code/test.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(test);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/test.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
        System.out.println();
        System.out.println("序列化存在的字段"+test.getA());
        System.out.println("静态字段"+Test.staticNum);
        System.out.println("序列化静态final字段"+Test.staticFinalNum);
        System.out.println("transient字段"+test.getTransientNum());
        System.out.println("父类字段"+test.pre);

    }
}
