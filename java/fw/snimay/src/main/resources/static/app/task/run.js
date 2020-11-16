(function(data,url,callback,dat,pid,ndat){
	var panelItems	=	[];
	panelItems.push({
		title:"流程图-"+ndat.id,
        layout: {
            type: 'absolute'
        },
        html:'<img  src="/process/readImage/'+ndat.processInstanceId+'?'+getOnly()+'"  alt="流程图"  />'
	});
	
	
	if(ndat.taskVariables!=null){
		var kvalues = [];
		var i=0;
		for(up in ndat.taskVariables){
			if(up!="用户"&&up!="提交")
			kvalues.push({
				"keyx":up,
				"valuex":ndat.taskVariables[up]
			});
			i++;
		} 
		//log(kvalues);
		if(i!=0){
			panelItems.push({
				title:"基本信息",
		        xtype: "grid",
		        columns:[{
		        	header	 :'事件', 
		        	dataIndex:"keyx"
		        },{
		        	header	 :'详情', 
		        	dataIndex:"valuex", flex: 1 
		        }],
		        store:{
		        	data:kvalues,
			        proxy: {
			            type: 'memory',
			            reader: {
			                type: 'json',
			                root: '.'
			            }
			        }
		        }
		        
			});
		}
		
	}
	
	
	
	
	log(ndat);
	var clazz		=	null;
	var bbaritem 	=	["->"];
	if(ndat.formKey!=null){
		var clazz		=	Get("/class/"+ndat.formKey).obj;
		var items		=	_("unit.panel")(clazz.fields);
		items.title		=	clazz.text;
		panelItems.push(items);
	}
	var tempk = 0;
	if(ndat.come.length<1){
		ndat.come.push("执行");
	}
	for(n in ndat.come){
		tempk =1;
		bbaritem.push({
			text:ndat.come[n],
			handler:function(){
				var values			=	{};
				if(clazz!=null){
					values			= 	_("task.getValue")(clazz.fields);
					values.id		=	ndat.id;
					values["提交"]	=	this.text;
					values["用户"]	=	SYS.user.username+"("+SYS.user.id+")";
					values[ndat.name+"提交"]=	SYS.user.username+"("+SYS.user.id+")";
					var msg 		= 	Post("/process/completeTask/",values);
					if(msg!=null){
						if(callback!=null&&eval(callback)()){
							this.ownerCt.ownerCt.close();
						}else
						this.ownerCt.ownerCt.close();
					} 
				}else{
					values.id		=	ndat.id;
					values["用户"]	=	SYS.user.username+"("+SYS.user.id+")";
					values["提交"]	=	this.text;
					values[ndat.name+"提交"]=	SYS.user.username+"("+SYS.user.id+")";
					var msg 		= 	Post("/process/completeTask/",values);
					if(msg!=null){
						if(callback!=null&&eval(callback)()){
							this.ownerCt.ownerCt.close();
						}else
						this.ownerCt.ownerCt.close();
					}
				}
				
			}
		});
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
		bbar:bbaritem 
	});
	
	_("unit.winshow")(win);
})