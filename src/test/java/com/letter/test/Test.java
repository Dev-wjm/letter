package com.letter.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        Calendar now = Calendar.getInstance();
//        now.add(Calendar.DAY_OF_YEAR,-7);
//        System.out.println(getNow("yyyyMM",now.getTime()));
//        new Test().getMethods();
//        System.out.println((double)691/5);
        None none = new None();
        Class clazz = none.getClass();
        Method m1 = clazz.getDeclaredMethod("setText", String.class);
        m1.invoke(none,"设置信息");
        System.out.println(none.toString());
    }

    public static String getNow(String format,Date date) {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(date);
    }

    public void getMethods() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Test.class;
        Method method = clazz.getMethod("getNow", String.class, Date.class);
        Object obj = clazz.newInstance();
        method.invoke(method,"yyyyMM",new Date());
        System.out.println("调用方法："+method);

    }
}

class None {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "None{" +
                "text='" + text + '\'' +
                '}';
    }
}
