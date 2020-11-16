(function(data,url,callback,appdat,pid){
	var grid 	= {};
	
	//log(appdat);
	//log(data);
	var columns = _("entity.fun.getColumns")(data.fields,data.query_); 
	var load = "(function(){\n"+
		"var name='"+data.name+"';\n"+
		"var url='"+url+"';\n"+
		"var pid='"+pid+"';\n"+
		"var db 	= dbload(url,null,{'name':name}).obj;\n"+
		"Ext.getCmp(pid).getRootNode().removeAll();\n"+
		"Ext.getCmp(pid).getRootNode().appendChild(_('entity.fun.gridtotree')(db));\n"+
		"Ext.getCmp(pid).collapseAll();\n"+
		"Ext.getCmp(pid).expandAll();\n"+
		"return true;\n"+
	"})\n";
	load = eval(load);
	
	grid = {
		xtype		:	'treepanel',
		rootVisible	: 	false,  //隐藏根节点
        selModel	:	Ext.create('Ext.selection.CheckboxModel'),
        columns 	:	columns,
        loadfun		:	load,
       // store:{ data	:[], proxy: { type: 'memory',  reader: { type: 'json', root: '.' } } },
        listeners   :	{
        	show:function(){
        		this.loadfun();
        	}
        } 
	};
	//grid["tbar"]	=	_("entity.fun.getTbar")(clazz,id,callback);
	//grid["store"]	=	_("entity.fun.getStore")(clazz,1);
	
	
	//=======================
    grid["tbar"]	=	[];
    
	for(a in appdat.apps){
		//log(appdat.apps[a]);
		if(appdat.apps[a].type=="topButton"){
			grid["tbar"].push({
				 text		:	appdat.apps[a].name,
				 appid		:	appdat.apps[a].id,
				 callback	:	load,
				 handler:function(){
					 var pid	=	this.ownerCt.ownerCt.id;
					 App(this.appid,this.callback,pid);
				 }
			});
		}else{
			var icon = "lib/ext/shared/icons/fam/application_view_list.png";
			if(appdat.apps[a].name.indexOf("删除")!=-1){
				icon	=	"lib/ext/shared/icons/fam/delete.gif";
			}
			
			grid["columns"].push({
				xtype: 'actioncolumn',
				text:appdat.apps[a].name,  
				flex:1,
				callback	:	load,
				appid		:	appdat.apps[a].id,
		        items: [{
		        	icon: icon,
		            tooltip: appdat.apps[a].name,  
		            handler: function(grid, rowIndex, colIndex) {
		            	 var pid	=	this.ownerCt.ownerCt.id;
		            	// log(this.appid);
		            	//s log(this.callback);
						 App(this.appid,this.callback,pid,grid.store.getAt(rowIndex).data);
		            }
		        }] 
			});
		}
		
	}
	
	  
	grid["columns"].sort(function(a,b){
    	if(a["text"]==null)return 0;
    	if(b["text"]==null)return 0;
    	
    	var c=a["text"].indexOf("删除")==-1?1:2;
    	var d=b["text"].indexOf("删除")==-1?1:2;
    	return c-d;
    });
    
	return grid;
})