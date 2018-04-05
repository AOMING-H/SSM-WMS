$(function() {
	$("#btn-login").click(function() {
		$.ajax({
			url: url_login,
			type: 'POST',
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify({
				account: $("#account").val(),
				password: md5($("#password").val())
			}),
			success: function(response) {
				console.log(response);
				var meta = JSON.parse(response).meta;
				var data = JSON.parse(response).data;
				if(meta.success== true){
					window.location.href = serverIP;
				}
			},
			error: function(response) {
				console.log(response);
			}
		});

	});
	$("#btn-login1").click(function() {
		$.ajax({
			url: url_login,
			type: 'GET',
			data: {
				account: $("#account").val(),
				password: md5($("#password").val()),
			},
			success: function(response) {
				console.log(response);
				var meta = JSON.parse(response).meta;
				var data = JSON.parse(response).data;
				if(meta.success== true){
					console.log('login success');
					window.location.href="/SSM-WMS/";
				}
			}
		});

	});
});