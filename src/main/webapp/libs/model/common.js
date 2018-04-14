$(function() {
//	window.serverIP=window.location.protocol+'//'+window.location.hostname+(window.location.port ? ':'+window.location.port: '')+'/SSM-WMS/';
	window.serverIP='http://localhost:8080/SSM-WMS/';
	window.url_login = serverIP + 'login';
	window.url_base_materials = serverIP + 'base/materials';
})

function getFormJson(frm) {
	var o = {};
	var a = $(frm).serializeArray();
	$.each(a, function() {
		if(o[this.name] !== undefined) {
			if(!o[this.name].push) {
				o[this.name] = [o[this.name]];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return JSON.stringify(o);
}
