package com.bloomfiter;

import java.util.BitSet;

/**
 * @program: javaguide
 * @description:
 * @author:
 * @create:
 **/
public class SimpleBloom {

    /***范围*/
    private static final int BLOOM_FILTER_SIZE = 10000;
    /***生成hash方法的k*/
    private static final int[] SEEDS = new int[]{3, 13};
    /***bitSet*/
    private BitSet bitArray = new BitSet(BLOOM_FILTER_SIZE);
    /***根据k生成hash方法array*/
    private SimpleHash[] simpleHashFun = new SimpleHash[SEEDS.length];

    public SimpleBloom() {
        //init，k生成hash方法
        for (int i = 0; i < SEEDS.length; i++) {
            simpleHashFun[i] = new SimpleHash(SEEDS[i]);
        }

    }

    /***增加一个val*/
    public boolean add(Object val){

        for (SimpleHash simpleHash:simpleHashFun
             ) {
            bitArray.set(simpleHash.hash(val),true);
        }
        return true;
    }

    /***检测是否包含val*/
    public boolean contains(Object val){

        boolean res = true;
        for (SimpleHash simpleHash:simpleHashFun
             ) {
            res=res&&(bitArray.get(simpleHash.hash(val)));
        }
        return res;
    }

    private static class SimpleHash {

        private int seed;

        public SimpleHash(int seed) {

            this.seed = seed;
        }

        /***根据seed假装hash一下*/
        public int hash(Object val) {

            return val == null ? 0 : (seed * (val.hashCode() >> 16)) >> 6;
        }
    }


}
