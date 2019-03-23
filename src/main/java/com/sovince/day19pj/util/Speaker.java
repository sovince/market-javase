package com.sovince.day19pj.util;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/22
 * Time: 21:02
 * Description:
 */
public class Speaker {
    public static void say(String words){
        System.out.printf("************ %s ************",words);//"欢迎来到售货机"
        System.out.println();
    }

    public static void alert(String words){
        System.out.println(words);
    }
}
