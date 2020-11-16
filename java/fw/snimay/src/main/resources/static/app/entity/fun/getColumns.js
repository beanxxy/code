(function(fields,query){
	var column = [];
	
	
	
	fields.sort(function(a,b){
		return a.index_>b.index_;
	});
	for(f in fields){
		//log(fields[f]);
		if(fields[f].ishide!=null&&fields[f].ishide==true){
			
		}else{
			if(query!=null&&fields[f].name==query){//树形结构
				column.push({
					 xtype: 'treecolumn', //this is so we know which column will show the tree
					 header		: fields[f].text,
					 dataIndex	: fields[f].name,
					 flex		: 1
				});
			}else if(fields[f].type=="obj"){
				var dp = fields[f].clazzquery;
				column.push({
					header		:	fields[f].text,
					dataIndex	:	fields[f].name,
					flex		:	fields[f].flex==null?1:Number(fields[f].flex),
					db			:	fields[f].clazzquery,
				    renderer:function(value,robj,e,ee,ef){
				    	//log(fields[f].clazzquery);
				    	if(value==null)return null;
                        return value[dp];
				    }
				});
			}else if(fields[f].type=="list"){
				
			}else{
				if(fields[f].type=="date"){
					column.push({
						header		: fields[f].text,
						dataIndex	: fields[f].name,
						xtype: 'datecolumn',   format:'Y-m-d h:i:s',
						flex		: fields[f].flex==null?1:Number(fields[f].flex)
					});
				}else column.push({
					header		: fields[f].text,
					dataIndex	: fields[f].name,
					flex		: fields[f].flex==null?1:Number(fields[f].flex),
							
					renderer 	: fields[f].text.indexOf("密码")!=-1?(function(value) {return "**************";}):null
				}); 	
			}
			
			
		}
		
	}
	return column;
})