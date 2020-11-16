(function(data,url,callback,appdat,pid,ndat){
/*	log(data);
	log(url);
	log(callback);
	log(appdat);
	log(pid);
	log(ndat);*/
	Ext.MessageBox.confirm("部署","是否要部署?"+ndat.name,function(ide){
		if(ide=="yes"){
			Post('/models/'+ndat.id+'/deployment');
			if(callback!=null&&eval(callback)()){}
		}
		
	}); 
})