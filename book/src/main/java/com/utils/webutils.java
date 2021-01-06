package com.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;



import org.apache.commons.beanutils.BeanUtils;


public class webutils {
    public static <T> T copyParatoBean(Map<?,?> map, T bean) {
        try {
            BeanUtils.populate(bean, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt,int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }

}
