package myreflection;

import com.myreflection.TestClass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: javaguide
 * @description:
 * @author:
 * @create:
 **/
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        //知道类名
        Class<?> getClass1 = TestClass.class;
        System.out.println(getClass1);
        //知道类实例
        TestClass testClass = new TestClass();
        Class<?> getClass2 = testClass.getClass();
        System.out.println(getClass2);
        //知道类路径
        Class<?> getClass3 = Class.forName("myreflection.TestClass");
        System.out.println(getClass3.getDeclaredField("testVal"));
        //这个方式不会进行初始化?
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> getClass4 = classLoader.loadClass("myreflection.TestClass");
        System.out.println(getClass4);
        System.out.println((getClass1==getClass2)==(getClass3==getClass4));
        System.out.println("------------------------------------");
        //通过反射获得的class生成实例对象
        TestClass testClassReflect = (TestClass) getClass1.newInstance();
        testClassReflect.testMethod();

        Method method = getClass1.getDeclaredMethod("testMethod");
        method.invoke(testClassReflect);
        System.out.println(getClass1.getDeclaredMethods());


    }


}
