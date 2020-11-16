(function(data,url,callback,appdat,pid,ndat){
	var stname = ndat[data.query_];
	stname = "<div style='color:#F0F'>"+stname+"</div>"
	Ext.MessageBox.confirm("提醒框","是否要生成?"+stname,function(id){
		if(id=="yes"){
			dbload(url,{},{
				"name"	:data.name,
				"id"	:ndat.id
			});
			if(callback!=null){
				eval(callback)(dat);
			}
		}
	});
})