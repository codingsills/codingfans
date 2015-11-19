//主窗口高度
function getHeight(){
	var total_height = $(window).height();
	var header_height = $('#header').outerHeight(true);
	var footer_height = $('#footer').outerHeight(true);
	return total_height - header_height - footer_height - 50;
}
function formatStr(str){
	for(var i = 0; i < arguments.length - 1; i++) {  
        str = str.replace("{" + i + "}", arguments[i + 1]);  
    }  
    return str;
}
