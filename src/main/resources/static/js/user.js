let index = {
	init : function(){
		let _this = this;
		
		//여기 this는 index를 가르킴
		console.log(this);
		//이벤트를 바인딩
		$("#btn-save").on("click",function(){
			alert('btn-save 클릭됨');
			
			//여기서 save는 this.save()로 생략되어있는데
			//여기 this가 button을 가르키고 있어서 save를 못 찾음
			console.log(this);
			_this.save();
		});
	},
	//이렇게 설계하면 장점 : 
	save : function() {
		alert("btn-save 로직 실행");
	}
}

index.init();

