
function update(id){
	console.log("The Value of id is",id);
	var JSONObj = new Object();
	JSONObj = {"id":id}
	
	let url = `/update`
	fetch(url,{
		method:'POST',
		body:JSON.stringify(
			JSONObj			
		),
		headers:{
			"Content-Type":"application/json;charset=UTF-8"
		}
	}).then(function(response){
		return response.json()
	}).then(function(data){
		let response = data.response;
		console.log("The Value of record is",response);
		console.log(typeof response);
		console.log("Updated Record is",data);
		
		
		
	})
}
