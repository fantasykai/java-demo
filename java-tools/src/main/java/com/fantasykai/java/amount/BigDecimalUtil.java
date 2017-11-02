package com.fantasykai.java.amount;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;


/**
 * The type Big decimal util.
 */
public class BigDecimalUtil {

    /**
     * 根据单位元金额转换为计算分
     *
     * @param amount 金额(元)
     * @return 分 long
     */
    public static long toPoints(double amount) {
        BigDecimal decimal = new BigDecimal(amount);
        decimal = decimal.multiply(new BigDecimal(100));
        return decimal.setScale(0, RoundingMode.HALF_UP).longValue();
    }

    /**
     * 转换为亿
     *
     * @param amount the amount
     * @return double
     */
    public static double toMillion(double amount) {
        BigDecimal decimal = new BigDecimal(amount);
        decimal = decimal.divide(new BigDecimal(100000000));
        return decimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 根据单位分金额转换为计算元
     *
     * @param amount 金额(分)
     * @return 元 double
     */
    public static double toYuan(long amount) {
        BigDecimal decimal = new BigDecimal(amount);
        decimal = decimal.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
        return decimal.doubleValue();
    }

    /**
     * 格式化金额为分的数据
     *
     * @param amount the amount
     * @return string
     */
    public static String formatCent(long amount) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(toYuan(amount));
    }

    /**
     * 格式化金额为万或亿
     * <p>
     * author: bianshi
     *
     * @param amount the amount
     * @return string
     */
    public static String formatToWanOrYi(double amount) {
        String unit = "万";
        unit = (amount / 10000D < 10000 ? "万" : "亿");
        String s = "";
        if ("万".equals(unit)) {
            s = String.format("%1$1.2f", amount / 10000D);
        } else {
            s = String.format("%1$1.2f", amount / (10000D * 10000D));
        }
        return s + unit;
    }

    /**
     * 格式化为string
     * <p>
     * author: bianshi
     *
     * @param s   the s
     * @param obj the obj
     * @return string
     */
    public static String format(String s, Object obj) {
        if (null == obj) {
            return "--";
        }
        return String.format(s, obj);
    }


    /**
     * 将小数转化为百分比
     *
     * @param bankRate the bank rate
     * @return the string
     */
    public static String convertPercent(BigDecimal bankRate) {
        if (bankRate != null) {
            NumberFormat nf = NumberFormat.getPercentInstance();
            nf.setMinimumFractionDigits(2);
            String rateString = nf.format(bankRate);
            return rateString;
        } else {
            return null;
        }
    }

    /**
     * 四舍五入格式化Double类型并保留指定位数的字符串
     *
     * @param amount 数字金额
     * @param scale  保留小数位数
     * @return string
     * @author jingtian
     */
    public static String formatDouble(Double amount, int scale) {
        if (null == amount) {
            return "--";
        }
        BigDecimal decimal = new BigDecimal(Double.toString(amount)).setScale(
                scale, BigDecimal.ROUND_HALF_UP);
        return decimal.toString();
    }

    /**
     * 四舍五入格式化Double类型为两位小数的字符串
     *
     * @param amount 数字金额
     * @return string
     * @author jingtian
     */
    public static String formatDouble(Double amount) {
        return formatDouble(amount, 2);
    }

    /**
     * Div double.
     *
     * @param divisor        除数
     * @param dividend       被除数
     * @param preciseFigures 精确位数
     * @return double
     */
    public static double div(double divisor,int dividend,int preciseFigures) {
        if(divisor>0&&dividend>0){
            BigDecimal ds = new BigDecimal(divisor);
            BigDecimal dd = new BigDecimal(dividend);
            double result = ds.divide(dd, preciseFigures, BigDecimal.ROUND_HALF_UP).doubleValue();
            return result;
        }else{
            return 0;
        }
    }

    /**
     * Format double string.
     *
     * @param amount  the amount
     * @param pattern the pattern
     * @return the string
     */
    public static String formatDouble(Double amount, String pattern) {
        if(null == amount) {
            return "--";
        }
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(amount);
    }

    /**
     * 格式化金额，保留2位小数
     *
     * @param amount the amount
     * @return string
     */
    public static String format2Double(Double amount) {
        return formatDouble(amount, "0.00");
    }
}
