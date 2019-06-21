package com.weiling.wl_erp.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/21
 */
public class SellAndBack extends Sell {
    private List<Back> backlist;

    public SellAndBack(){}
    public SellAndBack(List<Back> backlist) {
        this.backlist = backlist;
    }

    public SellAndBack(Integer id, String ordercode, String pname, String cname, Integer oksell, BigDecimal sellprice, BigDecimal allprice, BigDecimal overprice, String guige, String selluser, Integer zhuangtai, Date selltime, String beizhu, List<Back> backlist) {
        super(id, ordercode, pname, cname, oksell, sellprice, allprice, overprice, guige, selluser, zhuangtai, selltime, beizhu);
        this.backlist = backlist;
    }

    public List<Back> getBacklist() {
        return backlist;
    }

    public void setBacklist(List<Back> backlist) {
        this.backlist = backlist;
    }

    @Override
    public String toString() {
        return "SellAndBack{" +
                "backlist=" + backlist +
                '}';
    }
}
