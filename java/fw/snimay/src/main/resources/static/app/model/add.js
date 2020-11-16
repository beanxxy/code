(function(data,url,callback,dat,pid,ndat){
//	var classdat = Get("/clazz/name/"+clazz).obj;
	var id	=	""	;
	if(ndat==null){
		id	=	Post("models/newModel2").obj;
	}else{
		id	=	ndat.id;
	}
	 var	win	= new Ext.window.Window({
		title		:	"编辑",
		modal 		:	true,   
		constrain	:	true, 	// 防止窗口超出浏览器窗口,保证不会越过浏览器边界
		resizable	:	false, 	// 是否可以调整窗口大小，默认TRUE。
		plain		:	true,	// 将窗口变为半透明状态。 
		draggable 	:	false,	//不可以移动
		height		:	"80%",
		width		:	"80%",
		//maximized:true,
		id			:	"createlx121",
		maximizable:true,
		layout		: 	{
			type	:	'fit',
			align	:	'stretch'
	    },
	    pid			:   pid,
	    html		:	"<iframe style='width:100%;height:100%' src='modeler.html?modelId="+id+"'></iframe> ",
	    /*items		:	{
			 xtype	:	'tabpanel', 
			 flex: 1,
			 items	:	items
		}, */
		/*bbar:["->",{	
			text:"提交",handler:function(){
				var value = _("entity.add.fun.getValue")(this.ownerCt.ownerCt.dat);
				var msg   ;
			
				if(updata!=null){
					value.id = updata.id;
					msg	  = Put("/"+classdat.sever+"/",value);
				}else{
					msg	  = Post("/"+classdat.sever+"/",value);
				} 
				if(msg!=null){
					if(callback!=null){
						//回调
						eval(callback)(
								this.ownerCt.ownerCt.dat.name,
								this.ownerCt.ownerCt.pid);
						this.ownerCt.ownerCt.close();
					}
				}
			}
		}],*/
		listeners:{
			close:function(){
				if(callback!=null&&eval(callback)()){
				}
			}
		}
	});
	 _("unit.winshow")(win);
})