package com.chen.lambda;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

/**
 * 陈宇超
 * 23:41
 */
public class Test01 {
    public static void main(String[] args) {

        /**
         * lambda 表达式
         */
        //new Thread(() -> System.out.println("jiansheng")).start();
        //
        //new Thread(() -> System.out.println("jiansheng123")).start();
        //
        //
        //int i = calculateNum((left, right) -> left + right);
        //
        //int i1 = calculateNum((int left, int right) -> {
        //    return left + right;
        //});
        //System.out.println(i1);

        //printNum((int value) -> {return value % 2 == 0;});

        //Integer integer = typeConver(new Function<String, Integer>() {
        //    @Override
        //    public Integer apply(String s) {
        //        return Integer.valueOf(s);
        //    }
        //});
        //
        //Integer integer1 = typeConver(new Function<String, Integer>() {
        //    @Override
        //    public Integer apply(String s) {
        //        return Integer.valueOf(s);
        //
        //    }
        //});
        //System.out.println(integer);

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        foreachArr2(value -> System.out.println(value),arr);

        //System.out.println("用lambda表达式后");
        //
        //
        //foreachArr((int value) -> {
        //    System.out.println(value);
        //});
        //
        //foreachArr(value -> System.out.println(value));


    }

    public static int calculateNum(IntBinaryOperator operator) {
        int a = 20;
        int b = 10;
        return operator.applyAsInt(a, b);

    }


    public static void printNum(IntPredicate predicate) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : arr) {
            if (predicate.test(i)) {
                System.out.println(i);
            }
        }
    }

    public static <R> R typeConver(Function<String,R> function){
        String str = "1235";
        R result = function.apply(str);
        return result;
    }

    public static void foreachArr(IntConsumer consumer){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for(int i:arr){
            consumer.accept(i);
        }

    }

    public static void foreachArr2(IntConsumer consumer,int[] arr){
        for(int i:arr){
            consumer.accept(i);
        }

    }


}
