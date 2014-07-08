$(document).ajaxSend(function (event, jqXHR, ajaxOptions) {
    $.each([ '/ent/top', '/ent/left', '/ent/bottom' ], function (n, _this) {
        var url = ajaxOptions.url;
        if (url.indexOf(_this) != -1) {
            url = url.replace(/(.+)\?_=.*/ig, function (r, f) {
                return f;
            });
            ajaxOptions.url = url;
            ajaxOptions.cache = true;
        }
    });
});

/*文本框自动清除两边空格*/
$("[action-type=text_trim]").bind("keyup", function(){
	if(/(^ )|( $)/gi.test($(this).val())){
		$(this).val($.trim($(this).val()));
	}else{
		return false;	
	}
});

/*
*   form 表单验证 扩展
*   电话验证  固定电话或者是手机号
*/

$.extend($.fn.validatebox.defaults.rules,{   
	 phone: {   
		 validator: function(value, param){   
	return /^\d{3,4}-?\d{7,8}$/.test(value) || /^1[3|4|5|8][0-9]\d{8}$/.test(value);
		 },   
		 message: '请输入正确的电话号码'  
	  },
	 telPhone:{
		validator: function(value, param){
			return /^[1234567890-]{5,20}$/.test(value) &&  /\d/.test(value);
		},
		 message: '请输入正确的电话号码'
	 },
    mobile :{
        validator: function(value, param){
            return /^1[3|4|5|8][0-9]\d{8}$/.test(value);
        },
        message: '请输入正确的手机号码'
    },
    laterThen :{
        validator: function(value, param){
            return KP.date.parse(value) >= KP.date.parse($(param[0]).combo('getText'));
        },
        message: '结束时间不能小于开始时间'
    },
    bigThen :{
        validator: function(value, param){
            return parseInt(value) >= parseInt($(param[0]).numberbox('getValue'));
        },
        message: '最高值不能小于最低值'
    }
});

// 验证文本编辑器
function checkDesc(options){
	options = $.extend({
		objID:null,
		title : "", 
		numError : "",
		error:"",
		type : "error",
		allowNum : 20000	
	}, options);
	var desc = $.trim($(options.objID).val());
	if(!desc.length){
		$.messager.alert(options.title, options.error, options.type);
		return false;
	}else if(desc.length > options.allowNum){
		$.messager.alert(options.title, options.numError, options.type);
		return false;
	}else{
		return true;
	}
}

/* 自定义提示内容 start */
if ($.fn.pagination){
	$.fn.pagination.defaults.showPageList = false;
	$.fn.pagination.defaults.showRefresh = false;
	$.fn.pagination.defaults.beforePageText = '第&nbsp;';
	$.fn.pagination.defaults.afterPageText = '页&nbsp;共&nbsp;{pages}&nbsp;页';
	$.fn.pagination.defaults.displayMsg = '当前：第 {from} 条到第 {to} 条&nbsp;共<span class=\'red\'>{total}</span>条';
}
if ($.fn.datagrid){
	$.fn.datagrid.defaults.loadMsg = '正在加载...';
}
if ($.fn.treegrid && $.fn.datagrid){
	$.fn.treegrid.defaults.loadMsg = $.fn.datagrid.defaults.loadMsg;
}
if ($.messager){
	$.messager.defaults.ok = '确定';
	$.messager.defaults.cancel = '取消';
}
if ($.fn.validatebox){
	//$.fn.validatebox.defaults.missingMessage = '该输入项为必输项';
	$.fn.validatebox.defaults.rules.email.message = '请输入有效的电子邮件地址';
	$.fn.validatebox.defaults.rules.url.message = '请输入有效的URL地址';
	$.fn.validatebox.defaults.rules.length.message = '输入内容长度必须介于{0}和{1}之间';
	//$.fn.validatebox.defaults.rules.remote.message = '请修正该字段';
}
/*if ($.fn.numberbox){
	$.fn.numberbox.defaults.missingMessage = '该输入项为必输项';
}
if ($.fn.combobox){
	$.fn.combobox.defaults.missingMessage = '该输入项为必输项';
}
if ($.fn.combotree){
	$.fn.combotree.defaults.missingMessage = '该输入项为必输项';
}
if ($.fn.combogrid){
	$.fn.combogrid.defaults.missingMessage = '该输入项为必输项';
}*/
if ($.fn.calendar){
	$.fn.calendar.defaults.weeks = ['日','一','二','三','四','五','六'];
	$.fn.calendar.defaults.months = ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'];
}
if ($.fn.datebox){
	$.fn.datebox.defaults.currentText = '今天';
    $.fn.datebox.defaults.cleanText = '清空';
	$.fn.datebox.defaults.closeText = '关闭';
	$.fn.datebox.defaults.okText = '确定';
    $.fn.datebox.defaults.cleanText = '清空';
	$.fn.datebox.defaults.missingMessage = '该输入项为必输项';
	$.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	};
	$.fn.datebox.defaults.parser = function(s){
		if (!s) return new Date();
		var ss = s.split('-');
		var y = parseInt(ss[0],10);
		var m = parseInt(ss[1],10);
		var d = parseInt(ss[2],10);
		if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
			return new Date(y,m-1,d);
		} else {
			return new Date();
		}
	};
}
if ($.fn.datetimebox && $.fn.datebox){
	$.extend($.fn.datetimebox.defaults,{
		currentText: $.fn.datebox.defaults.currentText,
		closeText: $.fn.datebox.defaults.closeText,
		okText: $.fn.datebox.defaults.okText,
		missingMessage: $.fn.datebox.defaults.missingMessage
	});
}

/* 自定义提示内容 end */


// 异步加载js  
function loadJS(url,callback,charset){
	var script = document.createElement('script');
	script.onload = script.onreadystatechange = function ()
	{
		if (script && script.readyState && /^(?!(?:loaded|complete)$)/.test(script.readyState)) return;
		script.onload = script.onreadystatechange = null;
		script.src = '';
		script.parentNode.removeChild(script);
		script = null;
		if(callback)callback();
	};
	script.charset=charset || document.charset || document.characterSet;
	script.src = url;
	try {document.getElementsByTagName("head")[0].appendChild(script);} catch (e) {}
}


/*
	cookie 操作
*/
$.cookie = {
	get : function(name){
		var cookieArray=document.cookie.split("; "); //得到分割的cookie名值对
		var cookie=new Object();
		for (var i=0;i<cookieArray.length;i++){
			var arr=cookieArray[i].split("=");       //将名和值分开
			if(arr[0]==name){
                try {
                    return decodeURIComponent(arr[1]);
                } catch(e) {
                    return arr[1];
                }
			}; //如果是指定的cookie，则返回它的值
		}
		return "";
	},
	add : function(objName,objValue,objHours){
		var str = objName + "=" + encodeURIComponent(objValue);
		if(objHours > 0){                               //为时不设定过期时间，浏览器关闭时cookie自动消失
			var date = new Date();
			var ms = objHours*3600*1000;
			date.setTime(date.getTime() + ms);
			str += "; expires=" + date.toGMTString();
		}
		document.cookie = str;
	},
	del :function(objName){
		var domain  = window.location.host;
		var date = new Date();
		var str = objName + "=" + "";
		date.setTime(date.getTime() - 10000);
		str += "; expires=" + date.toGMTString()+";path=/; domain=." + domain + ";";
		document.cookie = str;
	}
}

var mall_id = $.cookie.get("mall_id");
var cookie_wid = $.cookie.get("syewn");
try {
    cookie_wid = decodeURIComponent(cookie_wid).replace('+',' ','g');
} catch (e) {
}
var cookie_aid = $.cookie.get("syeaan");
try {
	cookie_aid = decodeURIComponent(cookie_aid);
} catch (e) {
}

// 获取url 参数
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null) return unescape(r[2]); return null;
}

//为隐藏域赋值
function setHiddenData(obj, value){// obj  "#id" or ".class" or "[attr=**]"
	$(obj).each(function(){
			$(this).val(value);
	});
}

//格式化时间
function formatDateTime(time, format){
    var t = new Date(time);
    var tf = function(i){return (i < 10 ? '0' : '') + i};
    return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a){
        switch(a){
            case 'yyyy':
                return tf(t.getFullYear());
                break;
            case 'MM':
                return tf(t.getMonth() + 1);
                break;
            case 'mm':
                return tf(t.getMinutes());
                break;
            case 'dd':
                return tf(t.getDate());
                break;
            case 'HH':
                return tf(t.getHours());
                break;
            case 'ss':
                return tf(t.getSeconds());
                break;
        }
    })
}
//更换图片链接地址
function showImg(url, repStr, imgDomid){
	 if(url && url.length){
       urls = url.split(".");
       url = url.replace("."+urls[urls.length-1], repStr+ "." + urls[urls.length-1]);
       document.getElementById(imgDomid).src = url;
   }
}

$(function(){
	setHiddenData("[name=mall_id]", mall_id);
});	

