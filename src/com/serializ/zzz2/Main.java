package serializ.zzz2;

import serializ.zzzcommon.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @program: code
 * @description:
 * @author:
 * @create:
 **/
public class Main {

    public static void main(String[] args)  {

        Test test2 = null;
        Object obj;
        try
        {
            FileInputStream fileIn = new FileInputStream("D:/ideaProject2/code/test.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            obj = in.readObject();
            test2 = (Test) obj;
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("序列化存在的字段"+test2.getA());
        System.out.println("静态字段"+Test.staticNum);
        System.out.println("序列化静态final字段"+Test.staticFinalNum);
        System.out.println("transient字段"+test2.getTransientNum());
        System.out.println("父类字段"+test2.pre);

        System.out.println("--------------------测试反射获取序列化有而本地类没有的字段-----------------------");
        System.out.println(obj.getClass());
        Class<?> clazz = obj.getClass();
        try {
            System.out.println(clazz.getDeclaredField("otherNum1"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
