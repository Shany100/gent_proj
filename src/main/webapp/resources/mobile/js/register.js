;(function(){
	
	var form = $("#registerForm");
	
	form.on("submit", function(){
		console.log( $( this ).serialize() );
	});
	
	var getFormData = function(arr){
		var obj = {};
		
		$.each(arr, function(index, data){
			if(!data.value){
				$("#registerForm [name='"+ data.name +"']").focus();
				obj = false;
				return false;
			}
			obj[data.name] = data.value;
		});
		return obj;
	}
	
	$("#submitBtn").click(function(){
		var formDatas = $("#registerForm").serializeArray(),
			strDatas = $("#registerForm").serialize(),
			data;
		
		data = getFormData(formDatas);
		if(data == false){
			return ;
		}
		$.post("/user_register",strDatas, function(data){
			if(data.success){
				$("#tipView").html(data.msg).css("color","green");
				window.location.href="index.jsp"; // "/" 绝对路径
			}else{
				$("#tipView").html(data.msg);
				if(!data.passwordLegal){
					$("input[name='password']").focus();
				}
			}
			
			
		}, 'json')
			.fail(function(){
				alert("post failure.");
			});
	});
})();