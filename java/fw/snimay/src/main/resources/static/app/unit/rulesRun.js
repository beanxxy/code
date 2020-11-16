(function(rulesname){
	var str = "(function(obj){"+ GetItem("Rules","规则代号",rulesname)["规则代码"] +"})"
	return eval(str)();
})