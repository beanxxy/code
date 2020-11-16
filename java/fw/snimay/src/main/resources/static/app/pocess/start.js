(function(data,url,callback,dat,pid,ndat){
	var panelItems	=	[];
	panelItems.push({
		title:"流程图-"+ndat.id,
        layout: {
            type: 'absolute'
        },
        html:'<img  src="/process/img/'+ndat.deploymentId+'"  alt="流程图" />'
	});
	var	win	= new Ext.window.Window({
		title		:	"",
		modal 		:	true,   
		maximizable	:	true,
		autoscroll	:	true,
		constrain	:	true, 	// 防止窗口超出浏览器窗口,保证不会越过浏览器边界
		resizable	:	true, 	// 是否可以调整窗口大小，默认TRUE。
		plain		:	true,	// 将窗口变为半透明状态。 
	//	draggable 	:	false,	//不可以移动
		height		:	"60%",
		width		:	"60%",
		layout: {
	   	  	type	:	'hbox',
	        align	:	'stretch'
	    },
	    items		:	{
			 xtype	:	'tabpanel', 
			 flex	:	1,
			 items	:	panelItems
		}, 
		bbar:["->",{
			text	:	"启动",handler:function(){
				var msg = Get("/process/start/xxy/"+ndat.id);
				if(msg!=null){
					//Ext.Msg.alert("提示","启动成功");
					this.ownerCt.ownerCt.close();
				}
			}
		}] 
	});
	
	_("unit.winshow")(win);
})