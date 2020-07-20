let index = {
	//변수는 let 쓰고 ,함수의 이름이 없어도 실행될수밖에 없는 영역에 ()=> 씀
	init : function(){
		//이벤트를 바인딩
		$("#btn-save").on("click",()=>{
			this.save();
		});
	},
	
	//이렇게 설계하면 장점 : 버튼 리스너를 새로 만들고 밑에서 처리하면됨
	save : function() {
		let data = {
				username:$("#username").val(),
				password:$("#password").val(),
				email:$("#email").val()
		};
		//fetch쓰면 jquery안써도 됨
		$.ajax({
			type :"POST",
			url: "/auth/joinProc",
			//자바스크립트 오브젝트를 JSON String으로 바꾼것
			data : JSON.stringify(data),
			//스프링이 메세지 컨버터가 작동해서 requestBody를 붙여야함
			//그러기 위해서는 스프링에게 컨텍스트 타입을 알려줘야한다. 그래야만 오브젝트로 변환해줌
			contentType : "application/json; charset=utf-8",
			//응답 받는 타입 설정
			dataType : "json"
		}).done((resp)=>{
			if(resp.statusCode == 1){
				alert("회원가입 성공");
				location.href="/";
			}
			console.log(resp);
		}).fail(function(error){
			console.log(error);
		})
		//자바스크립트오브젝트 => 제이슨 스트링
		//JSON.stringify(자바스크립트오브젝트);
		//제이슨 스트링 => 자바스크립트 오브젝트
		//JSON.parse(제이슨스트링);
	}
}

index.init();

