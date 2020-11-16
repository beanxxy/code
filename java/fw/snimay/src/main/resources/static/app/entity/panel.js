(function(data,url,callback,appdat,pid){
	var grid 	= {};
	
 	log(data);
	
	var load	= "(function(){\n"+
		
		"var name='"+data.name+"';\n"+
		"var url='"+url+"';\n"+
		"var pid='"+pid+"';\n"+
		"var db 	= dbload(url,null,{'name':name}).obj;\n"+
		"Ext.getCmp(pid).store.loadData(db);\n"+
		"return true;\n"+	
	"})\n";
	load = eval(load);
	
	var columns = _("entity.fun.getColumns")(data.fields); 
	grid 		= {
		xtype		:	'gridpanel',
    	autoScroll	:	true,
        selModel	:	Ext.create('Ext.selection.CheckboxModel'),
        columns 	:	columns ,
        listeners   : {
        	show:function(){
        		load();
        	}
        },
        viewConfig    : {
            getRowClass : function(record,rowIndex,rowParams,store){
            	//log(record.data);
            	if(record.data.processVariables!=null){
            		if(record.data.processVariables["节点状态"]=="红灯")
                		return "x-grid-red";
                	if(record.data.processVariables["节点状态"]=="绿灯")
                		return "x-grid-record-green";
                	if(record.data.processVariables["节点状态"]=="黄灯")
                		return "x-grid-record-yellow";
            	}
            	return null;
                 /*if(record.data.status == '3' || record.data.status == '7' || record.data.status == '8'){     //正常关闭、责任人原因中止、发起人原因中止 
                          return 'x-grid-record-red';
                 }
                if(record.data.status == '2' || record.data.status == '5' || record.data.status == '6'){
                          return 'x-grid-record-yellow';
                }
                if(record.data.status == '1' || record.data.status == '4'){
                         return 'x-grid-record-green';
                }*/
           }
        },
        store:{ data	:[], proxy: { type: 'memory',  reader: { type: 'json', root: '.' } } }
	};
	
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
		        	icon	:	icon,
		            tooltip	:	appdat.apps[a].name,  
		            handler	:	function(grid, rowIndex, colIndex) {
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