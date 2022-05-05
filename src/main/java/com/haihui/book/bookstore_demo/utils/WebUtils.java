package com.haihui.book.bookstore_demo.utils;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/5, 星期四
 * @version : 1.0
 **/

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @description  :
 * @version      : [v1.0]
 */
public class WebUtils {
    public static <T> T copyParamToBean(Map params, T bean){
        try {
            BeanUtils.populate(bean,params);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }
}