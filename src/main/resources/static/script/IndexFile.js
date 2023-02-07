console.log("This is index file ")

function AllRecord(){
	let url = `/All?val=1`;
	
	fetch(url).then((response) => {
				return response.json();
			})
				.then((data) => {

					console.log("data is ", data);
					let response = data.response;
					console.log("response ", response);

					response.forEach(e=>{
					console.log("e ",e);
})
});
}