(function(listfield){
	//log(listfield);
	var values	=	{};
	for(f in listfield)if(listfield[f].name!="id"){
		var name	=	listfield[f].name;
		var text	=	listfield[f].text;
		//==========================
		var obj = Ext.getCmp(name);
		
		if(obj==null){
			obj = Ext.getCmp(name+SYS.only)
		}
		//log(name)
		
		
		//log(listfield[f]);
		if(listfield[f].type=="obj"){
			
			//log(listfield[f]);
			
			var ls = Get("/entity/"+listfield[f].model+"/"+obj.value).obj;
			if(ls[0]!=null){
				values[text]=ls[0];
			}//else values[name]={};
		}else if(listfield[f].type=="list"){
		/*	values[name]	=	[];
			var ep = Ext.getCmp("panel_"+name).store.data.items;
			for(e in ep){
				ep[e].data.id=null;
				values[name].push(ep[e].data);
			}*/
			//Ext.getCmp("panel_role").store.data.items
		}else{
			//log(obj);
			if(obj!=null)
			values[text]=obj.value;
		}
	}
	//log(values);
	return values;
})