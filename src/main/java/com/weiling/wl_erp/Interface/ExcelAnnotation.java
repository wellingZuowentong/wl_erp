package com.weiling.wl_erp.Interface;

import java.lang.annotation.*;

/**
 * 功能:Excel模板设置
 * */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelAnnotation {
    //Excel列ID(Excel列排序序号)
    int id ();
    //Excel列名
    String[] name();
    //Excel列宽
    int width()default 5000;
}
