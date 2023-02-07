function add(){
	console.log("This is Add New Record Form");
	var form =document.getElementById('myform');
form.addEventListener('submit',function(event){
	event.preventDefault()
	
	
	var Aggregrator =document.getElementById('aggregrator').value;
	console.log(Aggregrator)
	var client = document.getElementById('client').value;
	console.log(client)
	
	var service = document.getElementById('service').value;
	console.log(service);
	
	var amount = document.getElementById('amount').value;
	console.log(amount);
	
	var frontendurl = document.getElementById('frontendurl').value;
	console.log(frontendurl);
	
	var schedulersbackendurl = document.getElementById('schedulersbackendurl').value;
	console.log(schedulersbackendurl);
	
	var ccportalurl = document.getElementById('ccportalurl').value;
	console.log(ccportalurl);
	
	var serverdetails = document.getElementById('serverdetails').value;
	console.log(serverdetails);
	
	var database = document.getElementById('database').value;
	console.log(database);
	
	var servicemanager = document.getElementById('servicemanager').value;
	console.log(servicemanager);
	
	var sdpurl = document.getElementById('sdpurl').value;
	console.log(sdpurl);
	
	var callbackurl = document.getElementById('callbackurl').value;
	console.log(callbackurl);
	
	var locallocation = document.getElementById('locallocation').value;
	console.log(locallocation);
	
	var developer = document.getElementById('developer').value;
	console.log(developer);
	
	var servicelaunchdate = document.getElementById('servicelaunchdate').value;
	console.log(servicelaunchdate);
	
	var field1 = document.getElementById('field1').value;
	console.log(field1);
	
	var field2 = document.getElementById('field2').value;
	console.log(field2);
	
	var field3 = document.getElementById('field3').value;
	console.log(field3);
	
	var field4 = document.getElementById('field4').value;
	console.log(field4);
	
	var field5 = document.getElementById('field5').value;
	console.log(field5);
	
	var field6 = document.getElementById('field6').value;
	console.log(field6);
	
	var field7 = document.getElementById('field7').value;
	console.log(field7);
	
	var field8 = document.getElementById('field8').value;
	console.log(field8);
	
	var field9 = document.getElementById('field9').value;
	console.log(field9);
	
	var field10 = document.getElementById('field10').value;
	console.log(field10);
	
	/* var JSONObj = {}; */
	var JSONObj = new Object();

	JSONObj = {"aggregrator":Aggregrator,"client":client,"service":service,"amount":amount,"frontEndUrl":frontendurl,"schedulersBackendUrl":schedulersbackendurl,
			"CCPortalUrl":ccportalurl,"ServerDetails":serverdetails,"Database":database,"serviceManager":servicemanager,"callBackUrl":callbackurl,
			"SDPUrl":sdpurl,"localLocation":locallocation,"developer":developer,"serviceLaunchDate":servicelaunchdate,"field1":field1,"field2":field2,"field3":field3,
			"field4":field4,"field5":field5,"field6":field6,"field7":field7,"field8":field8,"field9":field9,"field10":field10}

	console.log("The JSONObj value is",JSONObj);
	let url = `/saveRecord`;
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
		 let response= data.response;
		 console.log("response is",response);
		 console.log(typeof response);
		 console.log("The Value of record is",data);
	 }) 
})


	
	
	
}