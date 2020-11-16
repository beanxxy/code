	
/*	var listfield	=	[
		{index:1,type:"string",text:"登录账号",name:"username",anchor:"1",length:100},
		{index:2,type:"string",text:"账号密码",name:"password",anchor:"1",length:100,inputType:"password"}
	];
	*/
(function(data,url,callback){

	listfield		=	data.fields;
	var items	=	_("unit.panel")(listfield);
	
	//log();
	//items.items[1]["inputType"]="password";
	//log(items);
	items.title		=	data.text;
	//排序	index
	listfield.sort(function(a,b){
		return a.index_-b.index_;
	});
	
	if(data.height==612&&data.width==502){
		var anchornum=0;
		var w=1,h=0;
		var wtemp=1;
		for(l in listfield){
			anchornum+=Number(listfield[l].anchor);
			if(anchornum>=1){
				anchornum=0;h++;
				wtemp=1;
			}else{
				wtemp++;
				if(wtemp>w)w=wtemp;
			}
		}
		data.height	=	h*44+150;
		data.width	=	w*250+20;
		
		if(data.width>1200)data.width=1200;
		if(data.height>1000)data.width=1000;
		
	}
	var	win	= new Ext.window.Window({
		title		:	"",
	//	modal 		:	true,   
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
			 items	:	items
		}, 
		callback	:	callback,
		bbar:["->",{
			text	:	"提交",handler:function(){
				var callback= this.ownerCt.ownerCt.callback;
				var dat 	= _("unit.getValue")(listfield);
				var logindb = dbload(url,dat);
				if(callback!=null&&eval(callback)(logindb)){
					this.ownerCt.ownerCt.close();
				}
			}
		}]
	});
	
	_("unit.winshow")(win);
})