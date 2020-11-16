var SYS		=	{};
var getValue		=	function(key){
	var clazz=GetCurrentClass();
	var classdat = Get("/class/"+clazz).obj;
	var fields   = classdat.fields;
	var value 	 = {};
	var info     = [];//SYS.only
	for(f in fields){
		if(fields[f].text==key){
			return Ext.getCmp(fields[f].name+SYS.only).getValue();
		}
	}
	if(key!=null){
		return value[key]; 
	}
	return value;
};
var setValue		=	function(key,value){
	var clazz=GetCurrentClass();
	var classdat = Get("/class/"+clazz).obj;
	var fields   = classdat.fields;
	for(f in fields){
		if(fields[f].text==key){
			Ext.getCmp(fields[f].name+SYS.only).setValue(value);return;
		}
	}
}; 
/**
 * 获取一个实体
 */
var GetItem			=	function(clazz,key,value){
		clazz		=	GetCurrentClass(clazz);
	var classdat 	= 	Get("/class/"+clazz).obj;
	var db   		= 	Get("/entity/"+clazz+"/").obj;
	
	var keyname		=	{};
	var is			=	1;
	var enkey		=	"";
	for(fe in classdat.fields){
		if(key==classdat.fields[fe].text)enkey	=	classdat.fields[fe].name;
		keyname[classdat.fields[fe].name]=classdat.fields[fe].text;
	}
	var lis			=	[];
	for(dfd in db){
		var data  		= 	{};
		if(db[dfd][enkey]==value){
			for(bec in db[dfd]){
				data[keyname[bec]]=db[dfd][bec];
			} 
			lis.push(data);
			//return data;
		}
	}
	return lis;
}; 
/**
 * 查询实体的总数
 */
var GetItemsCount	=	function(clazz){
	clazz			=	GetCurrentClass(clazz);
	var db   		= 	Get("/entity/"+clazz+"/").obj;
	return db.length;
};
/**
 * 获取当前实体类
 */
var GetCurrentClass	=	function(clazz){
	if(clazz!=null&&clazz.length>0){
		return clazz; 
	}
	return SYS.CurrentClass;
} 
/**
 * 设置当前实体类
 */
var setCurrentClass	=	function(clazz,only){
	if(only==null)only	=	"";
	SYS.only			=	only;
	SYS.CurrentClass	=	clazz;
}

/**
 * 导入规则
 */
var importRule	=	function(strrule){
	clazz		=	GetCurrentClass(clazz);
	_("entity.fun.actionRule")(strrule,clazz);
}; 