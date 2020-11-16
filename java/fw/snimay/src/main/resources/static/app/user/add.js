(function(data,url,callback,dat,pid,ndat){
	 
	//=======================
	
	///log(data);
	//log(url);
	//log(callback);
	//log(dat);
	//log(pid);
	listfield		=	data.fields;
	
	setCurrentClass(data.name);
	var items		=	_("unit.panel")(listfield);
	var panelItems	=	[];
	
	panelItems.push(items);
	
	
	
	//角色字段===============================================================================
	var roles	=	[];
	var roless	=	Get("/entity/Role/").obj;
	
	for(r in roless){
		roles.push({
			"starttime"	:new Date(),
			"overtime"	:new Date(new Date().getTime()+31536000*50*1000),
			"data"		:roless[r]
		});
	}
	panelItems.push({
		title		:	"用户角色",
		autoScroll	:	true,
		xtype		:	'gridpanel',
		id			:	"roleuserid",
		columns		:	[{
			header		:	"角色",
			dataIndex	:	"data",
			flex		:	2,
		    renderer:function(value,robj,e,ee,ef){
		    	if(value==null)return null;
                return value["rolename"];
		    }	
		},{
			header		: "开始时间",
			dataIndex	: "starttime",
			xtype: 'datecolumn',   format:'Y-m-d ',
			flex		: 1,
			editor:{
				xtype: 'datefield',format:'Y-m-d',
				allowBlank:true
			}
		},{
			header		: "结束时间",
			xtype: 'datecolumn',   format:'Y-m-d',
			dataIndex	: "overtime",
			flex		: 1	,
			editor:{
				xtype: 'datefield', format:'Y-m-d',
				allowBlank:true
			}
		}],
		plugins:[
           Ext.create('Ext.grid.plugin.CellEditing',{
        	   clicksToEdit:1 //设置单击单元格编辑(设置为2是双击进行修改)
           })
        ],
		stripeRows:true, //斑马线效果
		selModel	:	Ext.create('Ext.selection.CheckboxModel',{
			checkOnly: true     //只能通过checkbox选择
		}),
		store		:	{ data	:roles, proxy: { type: 'memory',  reader: { type: 'json', root: '.' } } }
	});
	//菜单字段===============================================================================
 
	panelItems.push({
		plugins:[
           Ext.create('Ext.grid.plugin.CellEditing',{
        	   clicksToEdit:1 //设置单击单元格编辑(设置为2是双击进行修改)
           })
        ],
		title		:	"用户菜单",
		xtype		:	'treepanel',
		id			:	"menuuserid",
		//collapsed	:	true,	//默认展开
		rootVisible	: 	false,  //隐藏根节点
		stripeRows	:	true, 	//斑马线效果
		selModel	:	Ext.create('Ext.selection.CheckboxModel',{
			checkOnly: true     //只能通过checkbox选择
		}),
		columns		:	[{
			xtype		: 	'treecolumn', 
			header		:	"菜单",
			dataIndex	:	"text",
			flex		:	2 
		},{
			header		: "开始时间",
			dataIndex	: "starttime",
			xtype: 'datecolumn',   format:'Y-m-d ',
			flex		: 1,
			editor:{
				xtype: 'datefield',format:'Y-m-d',
				allowBlank:true
			}
		},{
			header		: "结束时间",
			xtype: 'datecolumn',   format:'Y-m-d',
			dataIndex	: "overtime",
			flex		: 1	,
			editor:{
				xtype: 'datefield', format:'Y-m-d',
				allowBlank:true
			}
		}],
		 listeners   :	{
			 render:function(){
        		
        	}
		 }
	});
	//功能权限=============================================================
	panelItems.push({
		plugins:[
           Ext.create('Ext.grid.plugin.CellEditing',{
        	   clicksToEdit:1 //设置单击单元格编辑(设置为2是双击进行修改)
           })
        ],
		title		:	"用户功能",
		xtype		:	'treepanel',
		//collapsed	:	true,	//默认展开
		rootVisible	: 	false,  //隐藏根节点
		stripeRows	:	true, 	//斑马线效果
		id			:	"gongnengid",
		selModel	:	Ext.create('Ext.selection.CheckboxModel',{
			checkOnly: true     //只能通过checkbox选择
		}),
		columns		:	[{
			xtype		: 	'treecolumn', 
			header		:	"功能",
			dataIndex	:	"name",
			flex		:	2 
		},{
			header		: "开始时间",
			dataIndex	: "starttime",
			xtype: 'datecolumn',   format:'Y-m-d ',
			flex		: 1,
			editor:{
				xtype: 'datefield',format:'Y-m-d',
				allowBlank:true
			}
		},{
			header		: "结束时间",
			xtype: 'datecolumn',   format:'Y-m-d',
			dataIndex	: "overtime",
			flex		: 1	,
			editor:{
				xtype: 'datefield', format:'Y-m-d',
				allowBlank:true
			}
		}],
		 listeners   :	{
			 render:function(){
        		
        		//log(menuss);
        	}
		 }
	});
	//字段权限===============================================================================
	
	panelItems.push({
		plugins:[
           Ext.create('Ext.grid.plugin.CellEditing',{
        	   clicksToEdit:1 //设置单击单元格编辑(设置为2是双击进行修改)
           })
        ],
		title		:	"字段权限",
		id			:	"zidgid",
		xtype		:	'treepanel',
		//collapsed	:	true,	//默认展开
		rootVisible	: 	false,  //隐藏根节点
		stripeRows	:	true, 	//斑马线效果
		selModel	:	Ext.create('Ext.selection.CheckboxModel',{
			checkOnly: true     //只能通过checkbox选择
		}),
		columns		:	[{
			xtype		: 	'treecolumn', 
			header		:	"字段",
			dataIndex	:	"text",
			flex		:	2 
		},{
			header		: "开始时间",
			dataIndex	: "starttime",
			xtype: 'datecolumn',   format:'Y-m-d ',
			flex		: 1,
			editor:{
				xtype: 'datefield',format:'Y-m-d',
				allowBlank:true
			}
		},{
			header		: "结束时间",
			xtype: 'datecolumn',   format:'Y-m-d',
			dataIndex	: "overtime",
			flex		: 1	,
			editor:{
				xtype: 'datefield', format:'Y-m-d',
				allowBlank:true
			}
		}],
		 listeners   :	{
			 render:function(){
				//alert("sdf");
        		
        	} 
		 }
	});
	 
	//=================================================================================
	
	items.title		=	"用户信息";
	var	win	= new Ext.window.Window({
		title		:	"",
		modal 		:	true,  
		maximizable	:	true,
		constrain	:	true, 	// 防止窗口超出浏览器窗口,保证不会越过浏览器边界
		resizable	:	true, 	// 是否可以调整窗口大小，默认TRUE。
		plain		:	true,	// 将窗口变为半透明状态。 
	//	draggable 	:	false,	//不可以移动
		height		:	500,
		width		:	600,
		layout: {
	   	  	type	:	'hbox',
	        align	:	'stretch'
	    },
	    items		:	{
			 xtype	:	'tabpanel', 
			 flex	:	1,
			 items	:	panelItems//panelItems
		}, 
		callback	:	callback,
		listfield	:	listfield,
		ndat		:	ndat,
		edata		:   data,
		//listfield	:	listfield,
		bbar:["->",{
			text	:	"提交",handler:function(){
				var db1		=	Ext.getCmp("roleuserid").getSelectionModel().selected.items;
				var db2		=	Ext.getCmp("menuuserid").getSelectionModel().selected.items
				var db3		=	Ext.getCmp("gongnengid").getSelectionModel().selected.items
				var db4		=	Ext.getCmp("zidgid").getSelectionModel().selected.items
				var userdb	=	_("user.getValue")(listfield);
				
				userdb.role=[];
				for(d in db1){
					userdb.role.push({
						starttime:db1[d].data.starttime,
						overtime:db1[d].data.overtime,
						data:db1[d].data.data
					});
				}
				
				userdb.menu=[];
				for(d in db2){
					//log(db2);
					userdb.menu.push({
						starttime:db2[d].data.starttime,
						overtime:db2[d].data.overtime,
						db			:	db2[d].data.id
						/*data:{
							id:db2[d].data.id,
							text:db2[d].data.text,
							app:db2[d].data.app,
							type:db2[d].data.type,
							parent:db2[d].data.parent,
						}*/
					});
				}
				
				userdb.apps=[];
				for(d in db3){
					userdb.apps.push({
						starttime	:	db3[d].data.starttime,
						overtime	:	db3[d].data.overtime,
						db			:	db3[d].data.id	
						/*data:{
							id			:	db3[d].data.id,
							name		:	db3[d].data.name,
							url			:	db3[d].data.url,
							js			:	db3[d].data.js,
							clazz		:	db3[d].data.clazz,
							type		:	db3[d].data.type,
							parent		:	db3[d].data.parent,
							remark		:	db3[d].data.remark
						}*/
					});
				}
				
				
				
				userdb.field=[];
				for(d in db4){
					var namest	=	"";
					//log(db4[d].parentNode.data.name);
					if(db4[d].parentNode.data.name!=undefined){
						namest = (db4[d].parentNode.data.name+":"+db4[d].data.name);
					}else{
						namest = db4[d].data.name;
					}
					userdb.field.push({
						starttime	:	db4[d].data.starttime,
						overtime	:	db4[d].data.overtime,
						db			:	namest
					});
				}
				
				if(ndat!=null){
					userdb.id=ndat.id;
					if(ndat.password!=userdb.password){
						userdb.password=Get("/user/"+userdb.password+"/").obj;
					}
				}else userdb.password=Get("/user/"+userdb.password+"/").obj;
				
				//log(userdb);
				if(url!=null){
					//log(url);
					var logindb = dbload(url,userdb,{
						"name":data.name
					});
					if(callback!=null&&eval(callback)(logindb)){
						this.ownerCt.ownerCt.close();
					}
				}else{
					if(callback!=null&&eval(callback)(userdb)){
						this.ownerCt.ownerCt.close();
					}
				}
				/*var logindb = dbload(url,dat);
				log(userdb);
				log(url);
				*/
			}
		}],
		listeners:{
			show:function(){
				
				var menuss	=	Get("/entity/Menu/").obj;
        		menuss		=	_("user.gridtotree")(menuss);
        		Ext.getCmp("menuuserid").getRootNode().appendChild(menuss);
        		//log(menuss);
        		//====================================================
        		var menuss	=	Get("/class/").obj;
        		menuss		=	_("user.classtotree")(menuss);
        		//log(menuss);
        		Ext.getCmp("zidgid").getRootNode().appendChild(menuss);
        		//====================================================
        		var menuss	=	Get("/entity/Appdb/").obj;
        		menuss		=	_("user.gridtotree")(menuss);
        		Ext.getCmp("gongnengid").getRootNode().appendChild(menuss);
				//====================================================
				
				 
				
				var listfield = this.listfield;
				var ndat	  =	this.ndat;
				//log(ndat)
				if(ndat!=null){
					for(f in listfield)if(listfield[f].name!="id"){
						var obj = Ext.getCmp(listfield[f].name);
						//log(obj);
						if(listfield[f].type=="obj"){
							if(ndat[listfield[f].name]!=null)
							obj.setValue(ndat[listfield[f].name].id);
			 
						}else if(listfield[f].type=="list"){
							if("UserRole"==listfield[f].model){
								var datas	=	ndat[listfield[f].name];
								var mmpa	=	{};
								for(d in datas){
									mmpa[datas[d].data.id]=datas[d];
								}
								//log(mmpa);
								var rls	=	ndat[listfield[f].name];
								Ext.getCmp("roleuserid").store.each(function(record,e,o){
									if(mmpa[record.data.data.id]!=null){
										record.set("starttime",mmpa[record.data.data.id].starttime);
										record.set("overtime",mmpa[record.data.data.id].overtime);
										Ext.getCmp("roleuserid").getSelectionModel().select(e,true);
									}
								});
							}
							
							/*var db1		=	Ext.getCmp("roleuserid").getSelectionModel().selected.items;
							var db2		=	Ext.getCmp("menuuserid").getSelectionModel().selected.items
							var db3		=	Ext.getCmp("gongnengid").getSelectionModel().selected.items
							var db4		=	Ext.getCmp("zidgid").getSelectionModel().selected.items*/
							
							if("UserField"==listfield[f].model){
								var datas	=	ndat[listfield[f].name];
								var mmpa	=	{};
								for(d in datas){
									mmpa[datas[d].db]=datas[d];
								}
								Ext.getCmp("zidgid").store.root.eachChild(function(record,e,o){
									var cname = record.get("name");
									record.eachChild(function(rr,cc,oo,ee){
										var keys = cname+":"+rr.get("name");
										//log(keys);
										//log(mmpa);
										if(mmpa[keys]!=null){
											//rr.set("starttime",mmpa[rr.data.data.id].starttime);
											//rr.set("overtime",mmpa[rr.data.data.id].overtime);
											
											Ext.getCmp("zidgid").getSelectionModel().select(rr,true);
											Ext.getCmp("zidgid").getSelectionModel().select(record,true);
										}
									//	log(cname+":"+r.get("name"));
									});
								});
								//log(mmpa);
							}
							
							if("UserMenu"==listfield[f].model){
								var datas	=	ndat[listfield[f].name];
								var mmpa	=	{};
								for(d in datas){
									mmpa[datas[d].db]=datas[d];
								}
								Ext.getCmp("menuuserid").store.root.eachChild(function(record,e,o){
									var cname = record.get("id");
									record.eachChild(function(rr,cc,oo,ee){
										var keys = rr.get("id");
										if(mmpa[keys]!=null){
											Ext.getCmp("menuuserid").getSelectionModel().select(rr,true);
										}
									});
									if(mmpa[cname]!=null){
										Ext.getCmp("menuuserid").getSelectionModel().select(record,true);
									}
								});
								//
								//log(mmpa);
							}
							if("UserApp"==listfield[f].model){
								var datas	=	ndat[listfield[f].name];
								var mmpa	=	{};
								for(d in datas){
									mmpa[datas[d].db]=datas[d];
								}
								Ext.getCmp("gongnengid").store.root.eachChild(function(record,e,o){
									var cname = record.get("id");
									record.eachChild(function(rr,cc,oo,ee){
										var keys = rr.get("id");
										if(mmpa[keys]!=null){
											Ext.getCmp("gongnengid").getSelectionModel().select(rr,true);
										}
									});
									if(mmpa[cname]!=null){
										Ext.getCmp("gongnengid").getSelectionModel().select(record,true);
									}
								});
								//log(mmpa);
							}
							 
						}else{
						//	values[name]=obj.value;
							obj.setValue(ndat[listfield[f].name]);
						}
					}
				}
			}
		}
	});
	
	_("unit.winshow")(win);
})