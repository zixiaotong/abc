var zc = {
	initLayout:function(){
		var w = $(window).width()>800 ? $(window).width() : 800;
		var s = w/2560;
		$(".headerBanner").css({
			transform:"scale("+s+")"
		});
		$(".headerWrapper").height(1267*s);
		$(".main1").css("marginTop",-186*s+"px");
	}
}
$(function(){
	zc.initLayout();
	$(window).resize(zc.initLayout);

});
$(".navi").on("click","li",function(){
	var attr=$(this).data("fixd");
	var index=$(this).index();
	// if(index!=5){
		$("html,body").stop().animate({
			scrollTop:$(attr).offset().top-150
		},600);
		$(this).addClass("active").siblings().removeClass("active");
	// }
});
$(".navi2").on("click","li",function(){
	var attr=$(this).data("fixd");
	var index=$(this).index();
	if(index!=4){
		$("html,body").stop().animate({
			scrollTop:$(attr).offset().top-150
		},600);
		$(this).addClass("active").siblings().removeClass("active");
	}
});

$(window).on('scroll',function(){
	var m=$(window).scrollTop();
	$(".goto").each(function(index){
		if(m>$(this).offset().top-200){
		$(".navi").children().eq(index).addClass("active").siblings().removeClass("active");
	}
	})
	$(".goto2").each(function(index){
		if(m>$(this).offset().top-200){
		$(".navi2").children().eq(index).addClass("active").siblings().removeClass("active");
	}
	})
})

function rheight(){
	var w = $(window).width()>800 ? $(window).width() : 800;
	var s = w/2560;
	var ht=1267*s+1220-186*s-72;
	$(window).scroll(function(){
		var m=$(window).scrollTop();
		if(m>=ht){
			$(".nav_box").addClass("tofixed");
		}
		else{
			$(".nav_box").removeClass("tofixed");
		}
	})
}
rheight();
$(window).resize(rheight);

// 618弹窗介绍
$(".m1btn").click(function(){
	$(".tcfixed,.tcbox").css("display","block");
})
$(".toclse").click(function(){
	$(this).parent().css("display","none");
	$(".tcfixed").css("display","none");
})
$(".m1btn").click(function(){
	$(".tcfixed,.tcbox").css("display","block");
})
$(".cztc").click(function(){
	$(".tcfixed,.zfbox").css("display","block");
})
