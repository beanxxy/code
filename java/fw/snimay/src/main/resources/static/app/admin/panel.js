(function(data,url,callback){
	
	$("body").append('<div id="top_div" style="background-color:#fff;height: 58px;font-size: 20px;">'+
	'<div style="float:right;margin-top: 18px;margin-right: 50px;"  ><a id="usernameDIV" href="#"></a> &nbsp &nbsp &nbsp<a id="dc" onclick="_(\'login.out\')()" href="#">登出</a></div><img style="float:right;margin-top: 19px; margin-right: 5px;" alt="" src="lib/ext/shared/icons/fam/user.gif"><div style="float:right;margin-top: 18px;margin-right: 10px;"  >mes</div><div style="background:url(lib/img/logo1.png) no-repeat;background-position:8px 8px;height: 50px;"></div></div>');
	$("#usernameDIV").html(data.username);
	SYS.user = data;
	var menus =  _("admin.getTree")(data);
	var menuItems	=	[];
	
	if(menus.length==0){
		Ext.Msg.alert("错误警报","当前用户没有权限.");
	}else{
		for(m in menus){
			menuItems.push({
				title:menus[m].text,
				xtype:'treepanel',
				rootVisible: false, useArrows: true,
				store: Ext.create('Ext.data.TreeStore', {
		            root: {
		                expanded: true,
		                children: menus[m].children 
		            }
		        }),
		        listeners: {
		            itemclick: function (view, rec, item, index, e) {
		            	if(rec.get("app")!=null){
		            		var id = rec.get('app')+"_"+rec.get('id');
		            		if(Ext.getCmp(id)==null){
		            			var panel 		=App(rec.get("app"),null,id);
		            			//log(panel);
		            			panel.title 	=rec.get("text");
		            			panel.closable	=true;
		            			panel.id		=id;
		            			Ext.getCmp("centermain").add(panel).show();
		            		}else{
		            			Ext.getCmp(id).show();
		            		}
		            	}
		            }
		        }
			});
		}
	}
	
	
	
	
	Ext.create('Ext.container.Viewport', {
		id:	"messjs111j1j1j1",
        layout: 'border',
        items: [{
            region: 'north',
            contentEl:'top_div',//这是从页面中取出ID为top_div的标签作为内容
            border: false,
            margins: '0 0 5 0' 
        }, {
            region: 'west',
            title: "系统功能",
            layout: "accordion", 
            width: 200,
            minWidth: 150,
            maxWidth:250,
            region: "west",
            split: true,
            collapsible: true,
        	items: menuItems  
        }, {
            region: 'center',
            xtype: 'tabpanel', 
            id:"centermain",
            items: [{
            	title:"首页",
            	html:'<iframe width="100%" height="100%"  name="myFrame" src="swagger-ui.html"></iframe>'
            }] 
        }]
    }); 
})