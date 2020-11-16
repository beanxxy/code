var Msg = function(dat){
	if(dat.status!=200){
		Ext.Msg.alert("提示","系统错误("+dat.status+"):"+dat.msg);
		return;
	}
	dat = JSON.parse(dat.responseText); 
	if(dat.status!="000"){
		if(dat.msg=="没有登录"){
			if(Ext.getCmp("messjs111j1j1j1")!=null){
				alert("用户登出");
				location.reload();
				return;
			}else{
				App(1,function(dat){
	    			if(dat!=null){
						App(2);   
						return true;
	    			}
	    		});
			}
			
		}else
		Ext.Msg.alert("提示","("+dat.status+"):"+dat.msg);
		return;
	}
	return dat.data;
}
var Get = function(url){
	var dat =$.ajax({url:url,async:false,type: "GET"});
	return Msg(dat);
};
var Post = function(url,data){
	var dat	=	$.ajax({
		headers	:{"Content-Type":"application/json;charset=utf-8"}
		,async		:false
		,type		:"POST"
		,url		:url
		,data:JSON.stringify(data)
	});
	return Msg(dat);
};
var Delete = function(url,data){
	if(data==null)return Msg($.ajax({url:url,async:false,type: "delete",data:JSON.stringify(data)}));
	var dat =$.ajax({url:url,async:false,type: "delete",data:JSON.stringify(data)});
	return Msg(dat);
}

var Put	  = function(url,data){
	var dat	=	$.ajax({
		headers	:{"Content-Type":"application/json;charset=utf-8"}
		,async		:false
		,type		:"PUT"
		,url		:url
		,data:JSON.stringify(data)
	});
	return Msg(dat);
}