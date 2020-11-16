(function(dat){
	var ar = [];
	for(d in dat){
		var tmp = [];
		tmp.push(d);
		tmp.push(dat[d]);
		ar.push(tmp);
	}
	return ar;
})