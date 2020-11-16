(function(db){
	var Root = [];
	var menu = {};
//	var roles= db.user.role;
	/*for(r in roles){
		var mens = roles[r].data.menus;
		for(m in mens){
			menu[mens[m].data.id]				=	mens[m].data;
			menu[mens[m].data.id]["children"]   =  [];   
		}
	}*/
	var mens = db.menu;
	//log(db);
	for(m in mens){
		if(mens[m]!=null&&mens[m].data!=null){
			menu[mens[m].data.id]				=	mens[m].data;
			menu[mens[m].data.id]["children"]   =  [];   
		}
		
	}
	
	for(m in menu){
		if(menu[m].parent==null){
			Root.push(menu[m]);
		}else{
			if(menu[menu[m].parent.id]!=null)
			menu[menu[m].parent.id]["children"].push({
				leaf		: true,
				app			: menu[m].app,
				clazz		: menu[m].clazz,
				text		: menu[m].text,
				id			: menu[m].id
 			});
		}
	}
	/*log(menu);
	log(Root);*/
	return Root;
})