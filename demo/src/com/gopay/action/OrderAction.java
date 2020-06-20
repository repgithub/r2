package com.gopay.action;

import com.chahuashan.web.base.controller.action.AbstractAction;
import com.chahuashan.web.base.controller.annotation.ActionANT;
import com.chahuashan.web.base.controller.annotation.HttpANT;
import com.gopay.model.Order;
import com.chahuashan.web.base.ui.annotation.ComponentANT;
import com.chahuashan.web.base.ui.component.Component;
import com.chahuashan.web.base.ui.component.Input;
import com.chahuashan.web.base.ui.responser.entity.FormResponser;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHS on 1/10/18.
 */
@ActionANT(bean=Order.class)
public class OrderAction extends AbstractAction {

    public OrderAction() {
        super(Order.class,"N100");
        init();
    }

    private void init(){
        defaultJsonFieldSelector.selectIndex("1,2,3,4,5");
        defaultMetaComponentSelector.selectNames("A,B,C,D,E");
    }


    @HttpANT(hid="11",name="bean.11",METHOD = "get" ,URI = "/#bean")
    public void createOrderInit(){
        List<ComponentANT> var1=viewMeta.getWritableCmpMeta();
        int var2=var1.size();
        List<Component> var3=new ArrayList<>();
        for(int i=0;i<var2;i++){
            ComponentANT var4=var1.get(i);
            Component var5=Component.create(var4);
            if(var5 instanceof Input){
                Input var6=(Input)var5;
                var6.setSize(70);
                var6.setMaxlength(400);
            }
            var3.add(var5);
        }
        FormResponser formResponser=new FormResponser("f11",var3,"createOrder");
        actionContextAware.setResponseBody(formResponser);
    }

    @HttpANT(hid="12",name="bean.12",METHOD = "post" ,URI = "/#bean")
    public void createOrder(){
        create();
    }

    @HttpANT(hid="13",name="bean.13",METHOD = "get" ,URI = "/#bean/id/[\\d\\.]+")
    public void getOrder(){
        get();
    }

    @HttpANT(hid="14",name = "bean.14",METHOD = "get" ,URI = "/#bean@page")
    public void searchOrder(){
        String acceptContentType=actionContextAware.getRequestAcceptContentType();
        boolean _bJSON=acceptContentType.equalsIgnoreCase("json");
        if(_bJSON){
            actionContextAware.setJsonFieldSelector(defaultJsonFieldSelectorID,defaultJsonFieldSelector);
        }else{
            viewContextAware.setContextPathGet("/#bean");
            viewContextAware.setContextPathList("/#bean");
        }
        search();
    }


}
