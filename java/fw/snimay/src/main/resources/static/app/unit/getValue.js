(function(listfield,uuid){
	if(uuid==null)uuid="";
	//log(listfield);
	var values	=	{};
	for(f in listfield)if(listfield[f].name!="id"){
		var name	=	listfield[f].name;
		//==========================
		var obj = Ext.getCmp(name+uuid);
		
		//log(listfield[f]);
		if(listfield[f].type=="obj"){
			var ls = Get("/entity/"+listfield[f].model+"/"+obj.value).obj;
			if(ls[0]!=null){
				values[name]=ls[0];
			}//else values[name]={};
		}else if(listfield[f].type=="list"){
			values[name]	=	[];
			var ep = Ext.getCmp("panel_"+name).store.data.items;
			for(e in ep){
				ep[e].data.id=null;
				values[name].push(ep[e].data);
			}
			//Ext.getCmp("panel_role").store.data.items
		}else{
			values[name]=obj.value;
		}
	}
	//log(values);
	return values;
})