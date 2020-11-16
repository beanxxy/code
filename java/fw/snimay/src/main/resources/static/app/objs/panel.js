(function(data,url,callback,appdat,pid){
	return {
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
				header		:	"名称",
				dataIndex	:	"text",
				flex		:	2 
			},{
				header		:	"模型",
				dataIndex	:	"model",flex		:	1
			},{
				header		:	"字段",
				dataIndex	:	"name",flex		:	1
			}/*,{
				header		:	"类型",
				dataIndex	:	"clazz",flex		:	1
			}*/],
			 listeners   :	{
				 render:function(){
	        		var menuss	=	Get("/class/").obj;
	        		menuss		=	_("objs.classtotree")(menuss);
	        		this.getRootNode().appendChild(menuss);
	        	} 
			 }
		};
})