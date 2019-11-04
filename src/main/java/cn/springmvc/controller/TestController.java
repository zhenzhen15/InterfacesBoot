package cn.springmvc.controller;


import org.apache.commons.codec.digest.Md5Crypt;

public class TestController {
    public static void main(String[] args) {
        String upassword="admin";
        String password = "$1$vZcxsXDq$Zmf3aliEnzaUOEEaMh0.w0";
        String[] salts = password.split("\\$");
        System.out.println(salts.length);
        String mysalt = "";
        for (int i = 1; i < 3; i++) {
            mysalt += "$" + salts[i];
        }
        mysalt += "$";
        System.out.println(mysalt);
        String pas= Md5Crypt.md5Crypt(upassword.getBytes(),mysalt);
        System.out.println(pas);



    }
}
