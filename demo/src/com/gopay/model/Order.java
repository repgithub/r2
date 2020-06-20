package com.gopay.model;

import com.chahuashan.web.base.controller.annotation.URIANT;
import com.chahuashan.web.base.persist.UUIDGenerator;
import com.chahuashan.web.base.persist.annotation.ColumnANT;
import com.chahuashan.web.base.persist.annotation.TableANT;
import com.chahuashan.web.base.ui.annotation.ComponentANT;

import java.util.Date;

/**
 * Created by CHS on 1/10/18.
 */
@URIANT(pathname = "bean")
@TableANT(name="TB_BEAN")
public class Order {

    @ComponentANT(name = "A",title = "id",inputType = "input",inputSubtype = "hidden")
    @URIANT(pathname = "A")
    @ColumnANT(name="A",type = "varchar",length=30,isKey = true,nullable = false,unique = true)
    private String id;

    @ComponentANT(name = "B",title = "code",inputType = "input",inputSubtype = "text",rights = 2)
    @URIANT(pathname = "B")
    @ColumnANT(name="B",type = "varchar",length=50,nullable = false,unique = true)
    private String code;

    @ComponentANT(name = "C",title = "amount",inputType = "input",inputSubtype = "text",rights = 2)
    @URIANT(pathname = "C")
    @ColumnANT(name="C",type = "integer")
    private int amount;

    @ComponentANT(name = "D",title = "total",inputType = "input",inputSubtype = "text",rights = 2)
    @URIANT(pathname = "D")
    @ColumnANT(name="D",type = "integer")
    private int total;

    @ComponentANT(name = "E",title = "createTime",dateFormat = "yyyy-MM-dd HH:mm")
    @URIANT(pathname = "E")
    @ColumnANT(name="E",type = "timestamp")
    private Date createTime;

    public Order() {
        this.id=UUIDGenerator.createUUID();
        this.createTime=new Date();
    }

    public Order(String code, int amount, int total) {
        this.id=UUIDGenerator.createUUID();
        this.createTime=new Date();
        this.code = code;
        this.amount = amount;
        this.total = total;
    }

    public String getId() {
        return id;
    }
}
