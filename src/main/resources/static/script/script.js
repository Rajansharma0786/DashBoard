	console.log("This is script file")


//This method is for search the content
const search = () => {
	//	console.log("Searching....");


	var selectedValue = document.getElementById("select1").value;
	console.log(selectedValue);

	
		let value = $("#search-input").val();


		if (value == "") {
			$(".search-result").hide();
		}
		else if (selectedValue === "client") {


			// Sending  request to data
			let url = `/search?val=${value}`;
			fetch(url).then((response) => {
				return response.json();
			})
				.then((data) => {

					console.log("data is ", data);
					let response = data.response;
					console.log("response ", response);

					let text = `<div class='list-group'>`;
					response.forEach(e=>{
					console.log("e ",e);

					text +=`<a href='/show?val=${e.client}' class='list-group-item list-group-item-action'>${e.client}</a>`;

					})

					$(".search-result").html(text);
					$(".search-result").show();


				});
		} else if(selectedValue ==="service"){
			let url =`/searchbyService?val=${value}`;
			
			fetch(url).then((response) => {
				console.log(response)
				return response.json();
			})
				.then((data) => {

					console.log("data is ", data);
					console.log(typeof 'data');
					let response = data.response;
					console.log("response ", response);

					let text = `<div class='list-group'>`;
					response.forEach(e=>{
					console.log("e ",e);

					text +=`<a href='/showservices?val=${e.service}' class='list-group-item list-group-item-action'>${e.service}</a>`;
					
					
					})



					$(".search-result").html(text);
					$(".search-result").show();
					});

		}	else if(selectedValue ==="frontEndUrl"){
			let url =`/searchbyFrontUrl?val=${value}`;
			
			fetch(url).then((response) => {
				return response.json();
			})
				.then((data) => {

					console.log("data is ", data);
					let response = data.response;
					console.log("response ", response);

					let text = `<div class='list-group'>`;
					response.forEach(e=>{
					console.log("e ",e);

					text +=`<a href='/showbyfrontEndUrl?val=${e.frontEndUrl}' class='list-group-item list-group-item-action'>${e.frontEndUrl}</a>`;

					})




					$(".search-result").html(text);
					$(".search-result").show();
					});
			
		} else if(selectedValue ==="schedulersBackendUrl"){
			console.log(value);
			
			console.log("Controller inside backendurl");
			
			let url =`/searchbySchedulers?val=${value}`;
			
			fetch(url).then((response) => {
				console.log("response is",response);
				return response.json();	
			})
				.then((data) => {

					console.log("data is ", data);
					let response = data.response;
					console.log("response ", response);

					let text = `<div class='list-group'>`;
					
					response.forEach((e)=>{
					console.log("e ",e);

					text +=`<a href='/showbyschedulersBackendUrl?val=${e.schedulersBackendUrl}' class='list-group-item list-group-item-action'>${e.schedulersBackendUrl}</a>`;

					
					})

					$(".search-result").html(text);
					$(".search-result").show();
					});
			
		}

};













