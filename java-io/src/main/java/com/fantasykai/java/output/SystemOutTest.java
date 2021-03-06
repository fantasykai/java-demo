package com.fantasykai.java.output;

public class SystemOutTest {

    public static void main(String[] args) {

        String name = "Jeck";

        int age = 18;

        // printf  java 5 new
        System.out.printf("Hello, %s . Next year, you'll be %d", name, age);

        System.out.println("-------------呵呵--------");

        /**
         *  转  换  符	说    明 	示    例
         %s	字符串类型	"mingrisoft"
         %c	字符类型	'm'
         %b	布尔类型	TRUE
         %d	整数类型（十进制）	99
         %x	整数类型（十六进制）	FF
         %o	整数类型（八进制）	77
         %f	浮点类型	99.99
         %a	十六进制浮点类型	FF.35AE
         %e	指数类型	938000
         %g	通用浮点类型（f和e类型中较短的）
         %h	散列码
         %%	百分比类型	％
         %n	换行符
         %tx	日期与时间类型（x代表不同的日期与时间转换符	 　　　　
         *
         */

        String str= "卡卡西";
        str=String.format("Hi,%s", "鸣人");
        System.out.println(str);
        str=String.format("Hi,%s:%s.%s", "佐助","小樱","鸣人");
        System.out.println(str);
        System.out.printf("字母a的大写是：%c %n", 'A');
        System.out.printf("3>7的结果是：%b %n", 3>7);
        System.out.printf("100的一半是：%d %n", 100/2);
        System.out.printf("100的16进制数是：%x %n", 100);
        System.out.printf("100的8进制数是：%o %n", 100);
        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50*0.85);
        System.out.printf("上面价格的16进制数是：%a %n", 50*0.85);
        System.out.printf("上面价格的指数表示：%e %n", 50*0.85);
        System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50*0.85);
        System.out.printf("上面的折扣是%d%% %n", 85);
        System.out.printf("字母A的散列码是：%h %n", 'A');


    }

}
