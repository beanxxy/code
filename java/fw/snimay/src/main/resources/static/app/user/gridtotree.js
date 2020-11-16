grdtotree	=	function(db){
	var out = [];
	var map={};
	for(k in db){
		map[db[k].id]=db[k];
		map[db[k].id]["children"]=[];
		map[db[k].id]["leaf"]=true;
		map[db[k].id]["starttime"]=new Date();
		map[db[k].id]["overtime"] =new Date(new Date().getTime()+31536000*50*1000);
		map[db[k].id]["expanded"]=true; 
	}
	for(k in db){
		if(db[k].parent!=null&&map[db[k].id]!=null){
			//log(map[db[k].parent.id]);
			map[db[k].parent.id]["children"].push(map[db[k].id]);
			map[db[k].parent.id]["leaf"]=false;
		}
	}
	for(k in map){
		if(map[k]!=null&&map[k].parent==null){
			out.push(map[k]);
		}
	}
	return out;
}