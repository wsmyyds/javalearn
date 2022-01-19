package com.bloomfiter;

/**
 * @program: javaguide
 * @description:
 * @author:
 * @create:
 **/
public class Main {

    public static void main(String[] args) {

        SimpleBloom simpleBloom = new SimpleBloom();
        //System.out.println("sbc".hashCode());
        //2147483647
        System.out.println(simpleBloom.contains("abc"));
        System.out.println(simpleBloom.contains("abcd"));
        System.out.println(simpleBloom.add("abc"));
        //System.out.println(simpleBloom.add("ok"));
        System.out.println(simpleBloom.contains("abc"));
        System.out.println(simpleBloom.contains("abcd"));


//        //Google guava
//        //创建一个BloomFilter
//        BloomFilter<String> filter = BloomFilter.create(Funnels.integerFunnel(),1000,0.01);
//        // 可能存在
//        System.out.println(filter.mightContain("abc"));
//        System.out.println(filter.mightContain("abcd"));
//        // 增加
//        filter.put("abc");
//        filter.put("abcd");
//        System.out.println(filter.mightContain("abc"));
//        System.out.println(filter.mightContain("abcd"));

    }
}
