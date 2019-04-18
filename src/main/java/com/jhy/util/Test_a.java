package com.jhy.util;

import com.jhy.util.test.MyThread;

import java.math.BigDecimal;

/**
 * @Auther: admin
 * @Date: 2018/8/13 10:36
 * @Description:
 */
public class Test_a {
    public static void main(String[] args) {
        BigDecimal  a = new BigDecimal(((39765/12528300)*1000)+"");

        BigDecimal  b = new BigDecimal((float)(39765/12528300*1000));

        System.out.println(a);

        System.out.println(b);

        ;

        System.out.println(new BigDecimal(String.valueOf(39765/(12528.3))));
        System.out.println((float) (39765/(12528300/1000)));

        System.out.println();
    }
}
