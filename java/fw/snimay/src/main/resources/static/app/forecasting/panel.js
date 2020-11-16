(function(data,url,callback,appdat,pid){
	var grid 	= {};
	var columns	= [];
	
	columns		= [{
		header		: "产品",
		 flex: 1,
		dataIndex	: "cd1",
		columns		:[{
			header		: "产品名称",
			dataIndex	: "cde",
			flex: 1
		}]
	},{
		header		: "实际出货",
		 flex: 1,
		columns		:[{
			header		: "上年度",
			dataIndex	: "cde" 
		},{
			header		: "年度(前6个月)",
			dataIndex	: "cde1"
		},{
			header		: "季度(前3个月)",
			dataIndex	: "cde1"
		},{
			header		: "上个月",
			dataIndex	: "cde1"
		}]
	},{
		header		: "平均值",
		 flex: 1,
		columns		:[{
			header		: "上年度",
			dataIndex	: "cde" 
		},{
			header		: "年度（前6月）",
			dataIndex	: "cde1"
		},{
			header		: "季度（前3月）",
			dataIndex	: "cde1"
		},{
			header		: "上个月",
			dataIndex	: "cde1"
		}]
	},{
		header		: "系数",
		 flex: 1,
		columns		:[{
			header		: "上年度",
			dataIndex	: "cde" 
		},{
			header		: "本年度",
			dataIndex	: "cde1"
		},{
			header		: "季度",
			dataIndex	: "cde1"
		},{
			header		: "月度",
			dataIndex	: "cde1"
		},{
			header		: "增长趋势系数",
			dataIndex	: "cde1"
		}]
	},{
		header		: "真值",
		 flex: 1,
		columns		:[{
			header		: "上年度",
			dataIndex	: "cde" 
		},{
			header		: "年度",
			dataIndex	: "cde1"
		},{
			header		: "季度",
			dataIndex	: "cde1"
		},{
			header		: "上个月",
			dataIndex	: "cde1"
		}]
	},{
		header		: "预测理论值",
		 flex: 1,
		columns		:[{
			header		: "一月份",
			dataIndex	: "cde" 
		},{
			header		: "二月份",
			dataIndex	: "cde1"
		}]
	},{
		header		: "当月时间值",
		flex: 1,
		columns		:[{
			header		: "金额",
			dataIndex	: "cde1",
			flex: 1
		}]
	}];
	grid 		= {
		xtype		:	'gridpanel',
    	autoScroll	:	true,
        selModel	:	Ext.create('Ext.selection.CheckboxModel'),
        columns 	:	columns ,
        listeners   : {
        	show:function(){
        	//	load();
        	}
        }
	};
	
	return grid;
})