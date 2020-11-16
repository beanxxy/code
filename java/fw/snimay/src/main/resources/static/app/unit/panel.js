/**
 * 
 */
(function(listfield,uuid){
	if(uuid==null)uuid="";
	var dateType	=	{
		"string":"textfield",
		"String":"textfield",
		"text"	:"textarea",
		"int"	:"numberfield",
		"date"	:"datefield",
		"float"	:"numberfield",
		"combo"	:"combobox",
		"obj"	:"combobox",
		"list"	:""
	}
	
	listfield.sort(function(a,b){
		return a.index_-b.index_;
	});
	var items	=	[];
	//log(listfield);
	var rulesMap	  = {};
	
	for( f in listfield )if(listfield[f].name!="id"){
		 
		var xtype		=	dateType[ listfield[f].type ] == null ? listfield[f].type : dateType[ listfield[f].type ];
		
		
		
		var name		=	listfield[f].name;
		var text		=	listfield[f].text;
		var length		=	listfield[f].length_;
		var	anchor		=	listfield[f].anchor == null ? 0.5 : listfield[f].anchor;
		var inputType	=	listfield[f].inputType;
		var inurl		=	listfield[f].inurl;
		var vfield		=	listfield[f].clazzquery;
		
		
		
		var dateFormat	=	'Y-m-d h:i:s';
		var labelWidth	=	chineseSize(text)*8+text.length*8;
		var	anchor_inurl=	0;
		//===========================================
		if(xtype=="textfield"&&length>200)xtype="textarea";
		if(labelWidth<70)labelWidth=70;
		if(vfield==null||vfield.length==0)vfield="name";
		if(inurl!=null&&inurl.length>0){
			anchor_inurl=	anchor*0.4; 
			anchor		=	anchor*0.6;
		}
		
		//===========================================
		//name
	
		
		
		var fieldRuleskey = GetCurrentClass()+":"+name;
		
		var	rds			  =	null;
		var maprds		  =	{};
		if(SYS.user!=null){
			rds	=	GetItem("FieldRoles","字段",fieldRuleskey);
			//log(rds);
			for(r in rds){
				if(maprds[rds[r]["事件"]]==null){
					maprds[rds[r]["事件"]] = [];
				}
				maprds[rds[r]["事件"]].push(rds[r]["规则"]);
			}
		}
	/*	log(xtype)
		log(listfield[f])*/
		//var	rds			  = GetItem("FieldRoles","字段",fieldRuleskey);
		//log(rulesMap);
		//log(maprds);
		
		var item	=	{
			margin			: 	'5', 
			maxLength 		:	length,
			labelWidth		:	labelWidth,  
			xtype     		:	xtype,
			fieldLabel		:	text,
			format			:	dateFormat,
			grow			:	true,
			autoscroll		:	true,
			id	      		:	name +uuid,
			inputType		:	inputType,
			columnWidth		:	anchor,
			emptyText		:	'请在这里填写'+text,  
            maxLengthText	:   text+'最大长度为'+length+'个字符',  
            blankText		:	"不能为空，请填写！",
            valueField		:	'value',
            displayField	:	'text',
           // maprds			:	maprds,
            changeRolue		:	maprds["change"],
            renderRolue		:	maprds["render"],
            focusRolue		:	maprds["focus"], 
            blurRolue		:	maprds["blur"],
            listfield		:	listfield,
            listeners 		:	{
            	change	: function(){//改变
            		//log(this.changeRolue);
            		if(this.changeRolue!=null){
            			var obj = _("task.getValue")(this.listfield);
            			for(ch in this.changeRolue){
            				var vc ="(function(obj){"+ this.changeRolue[ch]["codes"] +"})";
            				eval(vc)(obj); 
            			}
            		}
				},
				render	: function(){//加载完
					if(this.renderRolue!=null){
						var obj = _("task.getValue")(this.listfield);
            			for(ch in this.renderRolue){
            				var vc ="(function(obj){"+ this.renderRolue[ch]["codes"] +"})";
            				eval(vc)(obj); 
            			}
            		}
				},
				focus	: function(){//焦点
					if(this.focusRolue!=null){
						var obj = _("task.getValue")(this.listfield);
            			for(ch in this.focusRolue){
            				var vc ="(function(obj){"+ this.focusRolue[ch]["codes"] +"})";
            				eval(vc)(obj); 
            			}
            		}
				},
				blur	: function(){//失去焦点
					if(this.blurRolue!=null){
						var obj = _("task.getValue")(this.listfield);
            			for(ch in this.blurRolue){
            				var vc ="(function(obj){"+ this.blurRolue[ch]["codes"] +"})";
            				eval(vc)(obj);
            			}
            		}
				}
            }
		};
	
		if(text.indexOf("密码")!=-1){
			item["inputType"]="password";
		}
		//log(listfield[f]);
		//log(xtype);
		//if(listfield[f]!=null&&listfield[f].type!=null)
//		if(listfield[f]!=null)
		
		if(xtype=="combobox"){
			//log(listfield[f]);
			var objdb	=	Get("/entity/"+listfield[f].model+"/").obj;
			//log(objdb)
			item["store"]=	new Ext.data.ArrayStore({
				fields	:	[ 'text','value'],
				data	:	_("unit.objtoarray")(objdb,vfield)
			});
		}
		
		if(xtype!="")
			items.push(item);
		//==============================================
		if(inurl!=null&&inurl.length>0){
			var indb =	dbload(inurl).obj;
			indb	 =	_("unit.maptoarray")(indb);
			items.push({
				margin		: 	'5', 
				xtype		:	"combobox",
				store		: 	new Ext.data.ArrayStore({
					fields	:	[ 'text','value'],
					data	:	indb
				}),
				valueField	:	'value',
                displayField:	'text',
				columnWidth	:	anchor_inurl,
				vid			:	name,
				uuid		:	uuid,
				listeners 	:	{
					select	:	function(f,n,e){
						Ext.getCmp(this.vid+this.uuid).setValue(n.data.value);
					}
				}
			});
		}
		
		 
	}
	
	return {
		items		:	items,
		autoscroll	:	true,
		bodyStyle	:	'overflow-x:hidden;overflow-y:auto;',
		layout		:	'column',
		margin		: 	'10'
	}
	
})