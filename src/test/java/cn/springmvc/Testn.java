package cn.springmvc;

import org.apache.commons.lang3.StringUtils;

public class Testn {
    public static void main(String[] args) {
        String a =null;
        System.out.println(a.isEmpty()); //NullPointerException
        System.out.println(StringUtils.isEmpty(a));
    }
}
