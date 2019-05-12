package com;

/**
 * @author jue
 * @date 2019/2/26 20:00
 * @describe
 */
public class MethodTest {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        test1(sb);
        System.out.println(sb.toString());
    }

    private static void test1(StringBuffer sb) {
        sb.append("nihao弟弟");
    }
}
