(function(data,url,callback,appdat,pid,ndat){
/*	log(data);
	log(url);
	log(callback);
	log(appdat);
	log(pid);
	log(ndat);*/
	if(ndat!=undefined){
		var stname = ndat[data.query_];
		stname = "<div style='color:#F0F'>"+stname+"</div>"
		Ext.MessageBox.confirm("删除框","是否要删除?"+stname,function(id){
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
		
	}else{
		var dat	=	Ext.getCmp(pid).getSelectionModel().getSelection();
		if(dat.length==0){
			Ext.Msg.alert("提示","请选择。");
	 	}else{
	 		var stname="";
	 		for(d in dat){
	 			//log(dat[d].data[data.query_])
				if(stname.length!=0){
					stname+=",";
				}
				stname+=(dat[d].data[data.query_]==null?"":dat[d].data[data.query_]);
			}
			stname = "<div style='color:#F0F'>"+stname+"</div>" 
			Ext.MessageBox.confirm("删除框","是否要删除?"+stname,function(id){
				if(id=="yes"){
					for(d in dat){
						 dbload(url,{},{
							 "name"	:data.name,
							 "id"	:dat[d].id
						 });
					}
					if(callback!=null){
						eval(callback)(dat);
					}
				}
			});
	 	}
	}
	
	
	
})