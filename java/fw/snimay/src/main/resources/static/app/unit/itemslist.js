(function(listfield){
	var items	=	[];
	
	//log(listfield);
	for( f in listfield ){
		//log(listfield[f].name);
		var nid		=	"panel_"+listfield[f].name;
		if(listfield[f].clazz=="java.util.Set"){
			var dat	=	Get("/class/"+listfield[f].model).obj;
			//_("unit.panel")(dat.field);
			var columns = _("entity.fun.getColumns")(dat.fields); 
			
			columns.push({
				xtype		:	'actioncolumn',
				text		:	"修改",  
				flex		:	1,
				dbc		:	dat,
		        items: [{
		        	icon: "lib/ext/shared/icons/fam/grid.png",
		           // tooltip: appdat.apps[a].name,  
		            handler: function(grid, rowIndex, colIndex) {
		            	_("entity.add")(this.dbc,null,function(dat){
		            		var dfc= grid.store.getAt(rowIndex);
		            		for(d in dat){
		            			dfc.set(d,dat[d]);
		            		}
							return true;
						},null,null,grid.store.getAt(rowIndex).data);
		            }
		        }] 
			});
			
			columns.push({
				xtype		:	'actioncolumn',
				text		:	"删除",  
				flex		:	1,
				//callback	:	load,
				//appid		:	appdat.apps[a].id,
		        items: [{
		        	icon: "lib/ext/shared/icons/fam/delete.gif",
		           // tooltip: appdat.apps[a].name,  
		            handler: function(grid, rowIndex, colIndex) {
		            	grid.store.remove(grid.store.getAt(rowIndex));
		            }
		        }] 
			});
			//log(dat);
			items.push({
				title		:	dat.text,
				id			:	nid,
				tbar		:	[{
					text	:	"添加",
					dbc		:	dat,
					handler :	function(){
						var	This	=	this.ownerCt.ownerCt;
						_("entity.add")(this.dbc,null,function(dat){
							//log(This);
							//log(dat);
							This.store.insert(This.store.getCount(), dat);  //插入新行作为grid最后一行
							This.getView().refresh(); //刷新
							return true;
						});
					}
				}],
				xtype		:	'gridpanel',
				columns 	:	columns ,
		    	autoScroll	:	true,
		        selModel	:	Ext.create('Ext.selection.CheckboxModel'),
		        store		:	{ data:[], proxy: { type: 'memory',  reader: { type: 'json', root: '.' } } }
			});
			
			
		}
	}
	return items;
})