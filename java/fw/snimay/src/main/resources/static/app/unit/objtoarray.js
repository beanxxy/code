(function(dat,query){
	var ar = [];
	if(query==null)query="name";
	for(d in dat){
		var tmp = [];
		tmp.push(dat[d][query]);
		tmp.push(dat[d].id);
		ar.push(tmp);
	}
	//log(ar);
	return ar;
})