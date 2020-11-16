grdtotree	=	function(db){
	var out = [];
	var map={};
	for(k in db){
		//log(db[k]);
		//map[db[k].id]=db[k];
		db[k]["children"]=db[k]["fields"];
		db[k]["leaf"]=false;
		db[k]["starttime"]=new Date();
		db[k]["overtime"] =new Date(new Date().getTime()+31536000*50*1000);
		db[k]["expanded"]=true; /**/
		for(ik in db[k]["children"]){
			db[k]["children"][ik]["leaf"]		=	true;
			db[k]["children"][ik]["starttime"]	=	new Date();
			db[k]["children"][ik]["overtime"]	=	new Date(new Date().getTime()+31536000*50*1000);
		}
	}
	/*for(k in db){
		if(db[k].parent!=null&&map[db[k].id]!=null){
			//log(map[db[k].parent.id]);
			map[db[k].parent.id]["children"].push(map[db[k].id]);
			map[db[k].parent.id]["leaf"]=false;
		}
	}*/
	for(k in db){
		if(db[k]!=null&&db[k].parent==null){
			out.push(db[k]);
		}
	}
	return out;
}