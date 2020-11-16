(function(win){
	 Ext.EventManager.onWindowResize(function(){  
		 if(currentWindow){  
			 currentWindow.center();  
		 }  
	 });
	 win.addListener('beforeshow',function(o){   
	    currentWindow=o;  
	 });   
	
	 win.addListener('destroy',function(o){    
        currentWindow=null;  
	 });
	 win.show();
})