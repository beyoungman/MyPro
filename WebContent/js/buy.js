$().ready(function (){
	var tolM =0;
	var tolW =0;
	 $(".weigh_money").each(function(){
		tolW = tolW + parseInt($(this).attr("value"));
    });
	 $(".money").each(function(){
			tolM = tolM + parseInt($(this).attr("value"));
	    });
	$(".totolM").text(tolM);
	$(".totolW").text(tolW);
	
	var isHid = true;
	$(".hidden_form").hide();
	$(".hidden_tr").hide();
		
	$(".newBuy").on("click",function (){
		if(isHid){
			$(".hidden_form").show();
			$(".hidden_tr").show();
			isHid=false;
		}else{
			$(".hidden_form").hide();
			$(".hidden_tr").hide();
			isHid=true;
		}
	});
	$(".delete").on("click",function (){
		var r=confirm("是否删除？");
		if (r==true)
		  {
			return true;
		  }
		else{
			return false;
		}
	});
	
});
