RC='nh763ijkz';
inputTip_code='请输入编号.';
inputTip_amount='请输入数量.';
inputTip_total='请输入总值.';
function createOrder(){
    var p1=document.getElementsByName('B')[0];
    var p2=document.getElementsByName('C')[0];
    var p3=document.getElementsByName('D')[0];
    if(!checkField(p1,p1.value.trim().length==0,inputTip_code))return false;
    if(!checkField(p2,p2.value.trim().length==0,inputTip_amount))return false;
    if(!checkField(p3,p3.value.trim().length==0,inputTip_total))return false;
    var u1='/#bean';
    var s1='{\'B\':\''+p1.value.trim()+'\',\'C\':\''+p2.value.trim()+'\',\'D\':\''+p3.value.trim()+'\'}';
    var s2=encodeURIComponent(s1);
    ajax({
            url:encodeURIComponent(u1),
            method:'post',
            data:{'s':s2},
            success:function(responseText,responseXML){
                postHandler(responseText);
                showInMain('/#bean/[0,10]','listPanel');
            },
            failure:function(status,statusText){
                showMsg(statusText);
            }
    });
}
