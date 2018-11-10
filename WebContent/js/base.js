$(document).ready(function (){
	$("#ajaxFileUpload").bind("click", function(){
		fileUpload($("#ajaxFileUpload"));
	});
	
	if($("#ajaxFileUploadFile").length==0){
		$("#ajaxFileUpload").after("<input name=\"file\" style=\"display:none\" type=\"file\" size=\"20\" id=\"ajaxFileUploadFile\">");
	}
});

/*-- 附件上传 --*/
function fileUpload(type){
	$("#ajaxFileUploadFile").on("change", function(){
		ajaxFileUpload(type);
	});
	$("#ajaxFileUploadFile").click();
}

function ajaxFileUpload(type) {
	$.ajaxFileUpload({  
        url:"upload.action?type=" + type, //type表示文件类型 
        secureuri:true, 
        fileElementId:"ajaxFileUploadFile",//上传file控件的id，
        dataType:'json', 
        beforeSend: function() {
        },
        success:function(data,status){
        	bootbox.alert("上传成功");
        	var onSuccess = $("#ajaxFileUpload").attr("onSuccess");
        	window[onSuccess](data);
        },  
        error:function(status){ 
        	console.log(status);
            bootbox.alert("上传失败");
            var onFailed = $("#ajaxFileUpload").attr("onFailed");
            window[onFailed]();
        }
    }); 
    return 0;
}

/*-- 图片预览 --*/
function img_view(a){
	window.open($(a).attr("src"));
}

/*-- 刪除图片 --*/
function delPic(a){
	$(a).parent().remove();
}

function showMask(sel, msg){
	if($("#mask").length==0){
		sel.append('<div id="mask" class="mask" style="display:none;text-align:center;"><div class="maskMsg" style="width:80%;text-align:left;"></div></div>');
	}
	
	var offsettop=$(sel).offset().top;
    var offsetleft=$(sel).offset().left;
    var height = $(sel).height();
    var width = $(sel).width();
    console.log(offsetleft + width * 0.1)
    $("#mask").css({"poistion":"absolute","top":offsettop, "left":offsetleft, "width":width, "height":height});
    $(".maskMsg").css("position", "absolute");
    $(".maskMsg").text(msg);
    var msg_width = $(".maskMsg").width();
    $(".maskMsg").css("left", (width-msg_width)/2);
    var font_size = $('body').css("font-size").replace("px","");
    console.log(font_size);
 	$(".maskMsg").css("top", (height)/2-font_size/2);
    $("#mask").show();
}
//隐藏遮罩层
function hideMask(){
    $("#mask").hide();
}