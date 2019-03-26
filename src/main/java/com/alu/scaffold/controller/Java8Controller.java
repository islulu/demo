package com.alu.scaffold.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * @author jairy
 * @date 2019/3/15
 */
@Api(description ="java8新特性")
@RestController
@RequestMapping("/java8")
@Logger
public class Java8Controller {

    @ApiOperation("接口内允许添加默认实现的方法")
    @GetMapping("/demo01")
    public static void demo01(){
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        formula.calculate(100);
        formula.sqrt(16);
    }

    /**
     * 定义一个公式接口
     */
    interface Formula {
        double calculate(int a);
        /**
         * 默认方法 可直接调用
         */
        default double sqrt(int a) {
            return Math.sqrt(a);
        }
    }

    //---------------------------------------

    @ApiOperation("Lambda 表达式：一个含有字符串的集合进行排序")
    @GetMapping("/demo02")
    public static void demo02(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        //1 不再推荐
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        //2
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        //3
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        //4
        names.sort((a, b) -> b.compareTo(a));
    }

    //---------------------------------------

    @ApiOperation("函数式接口 Functional Interface")
    @GetMapping("/demo03")
    public static void demo03(){
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);

    }

    /**
     * 1.即使去掉 @FunctionalInterface 也是好使的，它仅仅是一种约束而已。
     * 2.只要接口中仅仅包含一个抽象方法，我们就可以将其改写为 Lambda 表达式
     */
    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }

    //---------------------------------------

    @ApiOperation("便捷的引用类的构造器及方法")
    @GetMapping("/demo04")
    public static void demo04(){
        /**
         * 通过 :: 关键字来引用类的方法或构造器
         */
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);

    }








    public static void main(String[] args) {

    }

}
