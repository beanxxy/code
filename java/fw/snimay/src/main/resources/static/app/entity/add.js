(function(data,url,callback,dat,pid,ndat){

	
	
	//log(data.name);
	
	listfield		=	data.fields;
	var uuid		=	getOnly();
	setCurrentClass(data.name,uuid);
	var panelItems	=	[];
	var items		=	_("unit.panel")(listfield,uuid);
	var listitems   = 	_("unit.itemslist")(listfield);
	
	
	
	//log(items);
	items.title		=	data.text;
	//排序	index
	listfield.sort(function(a,b){
		return a.index_-b.index_;
	});
	panelItems.push(items);
	for(l in listitems){
		panelItems.push(listitems[l]);
	}
	
	
	if(data.height==612&&data.width==502){
		var anchornum=0;
		var w=1,h=0;
		var wtemp=1;
		for(l in listfield)if(listfield[l].name!="id"){
			anchornum+=Number(listfield[l].anchor);
			if(listfield[l].length_>200)h+=2;
			if(anchornum>=1){
				anchornum=0;h++;
				wtemp=1;
			}else{
				wtemp++;
				if(wtemp>w)w=wtemp;
			}
		}
		data.height	=	h*44+170;
		data.width	=	w*400+20;
		
		if(data.width<500)		data.width	=500;
		if(data.width>1200)		data.width	=1200;
		if(data.height>1000)	data.width	=1000;
		if(data.height<350)		data.height	=350;
		if(panelItems.length>1)	data.height	=500;
		
	}

	 var	win	= new Ext.window.Window({
		title		:	"",
		modal 		:	true,   
		maximizable	:	true,
		autoscroll	:	true,
		constrain	:	true, 	// 防止窗口超出浏览器窗口,保证不会越过浏览器边界
		resizable	:	true, 	// 是否可以调整窗口大小，默认TRUE。
		plain		:	true,	// 将窗口变为半透明状态。 
	//	draggable 	:	false,	//不可以移动
		height		:	data.height,
		width		:	data.width,
		layout: {
	   	  	type	:	'hbox',
	        align	:	'stretch'
	    },
	    items		:	{
			 xtype	:	'tabpanel', 
			 flex	:	1,
			 items	:	panelItems
		}, 
		callback	:	callback,
		listfield	:	listfield,
		ndat		:	ndat,
		edata		:   data,
		bbar:["->",{
			text	:	"提交",handler:function(){
				var className	=	this.ownerCt.ownerCt.edata.name;
				var callback	= 	this.ownerCt.ownerCt.callback;
				var listfield	= 	this.ownerCt.ownerCt.listfield;	
				var dat 	= _("unit.getValue")(listfield,uuid);
				if(ndat!=null)dat.id=ndat.id;
				if(url!=null){
					//log(url);
					var logindb = dbload(url,dat,{
						 "name"	:className
					 });
					if(callback!=null&&eval(callback)(logindb)){
						this.ownerCt.ownerCt.close();
					}
				}else{
					if(callback!=null&&eval(callback)(dat)){
						this.ownerCt.ownerCt.close();
					}
				}
				
			}
		}],
		listeners:{
			show:function(){
				var listfield = this.listfield;
				var ndat	  =	this.ndat;
				//log(ndat)
				if(ndat!=null){
					for(f in listfield)if(listfield[f].name!="id"){
						var obj = Ext.getCmp(listfield[f].name+uuid);
						if(listfield[f].type=="obj"){
							if(ndat[listfield[f].name]!=null)
							obj.setValue(ndat[listfield[f].name].id);
						}else if(listfield[f].type=="list"){
							var name = listfield[f].name;
							var penal= Ext.getCmp("panel_"+name);
							penal.store.loadData(ndat[listfield[f].name]);
						}else{
							if(listfield[f].type=="date"){
								obj.setValue(new Date(ndat[listfield[f].name]));
							}else{
								obj.setValue(ndat[listfield[f].name]);
							}
						}
					}
				}
			}
		}
	});
	
	_("unit.winshow")(win);
})