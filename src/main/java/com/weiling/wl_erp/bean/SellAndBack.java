package com.weiling.wl_erp.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/21
 */
public class SellAndBack extends Sell {
    private List<OkBack> backlist;

    public SellAndBack(){}

    public SellAndBack(List<OkBack> backlist) {
        this.backlist = backlist;
    }

    public List<OkBack> getBacklist() {
        return backlist;
    }

    public void setBacklist(List<OkBack> backlist) {
        this.backlist = backlist;
    }

    @Override
    public String toString() {
        return "SellAndBack{" +
                "backlist=" + backlist +
                '}';
    }
}
