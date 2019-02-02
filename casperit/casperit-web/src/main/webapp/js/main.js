/**
* Created by IBA Group on 2019.
*/ 	

// Return all meetingroom reservations
function retrieveMeeteingRoomReservations(){
	//making AJAX request
	var xhr = new XMLHttpRequest();
	//GET method for http://localhost:8080/casperit-web/rest/reservation
	xhr.open('GET', 'http://localhost:8080/casperit-web/rest/reservation/', true);
	//function for checking status 
	xhr.onload = function(){
	    //checking status
	    if(this.status == 200){
	        //if OK here we parsing JSON
	        var reservations = JSON.parse(this.responseText);
            if(reservations != null){
                console.log(reservations);
            }   else console.log("Error!");
	    }
	}
	//GET JSON
	xhr.send();
}

// Return all empoloyees
function retrieveEmployees(e){
	//making AJAX request
	var empId = e.id;
	var xhr = new XMLHttpRequest();
	//GET method for http://localhost:8080/casperit-web/rest/employees
	xhr.open('GET', 'http://localhost:8080/casperit-web/rest/employees/'+empId, true);
	//function for checking status 
	xhr.onload = function(){
	    //checking status
	    if(this.status == 200){
	        //if OK here we parsing JSON
	        var employees = JSON.parse(this.responseText)[0];
            if(employees != null){
				console.log(employees);
				
				var temp = '<input id="find_by_name" type="text" placeholder="Find"> <div id="employee_info">'+
				' <p style="color: #599DE5; font-family: "Rubik", sans-serif;">'+employees.firstName+'</p>	<img src="../img/halloween-ghost.png"/>'+
				'<p style="color: white; margin-top: 15px; font-family: "Rubik", sans-serif;">'+employees.specialization+'</p>'+				
				'<div style="text-align: left;"><label>Телефон:</label> <span>'+employees.phone+'</span></div>'+
				'<div style="text-align: left;" ><label>Рабочее место:</label> <span>In our hearts</span></div></div>';
				var element = document.getElementById('employeeCardPl');
				element.innerHTML = temp;

            }   else console.log("Error!");
	    }
	}
	//GET JSON
	xhr.send();
}


// Return all empoloyees
function retrieveTables(){
	var array_of = [];
	//making AJAX request
	var xhr = new XMLHttpRequest();
	//GET method for http://localhost:8080/casperit-web/rest/tables
	xhr.open('GET', 'http://localhost:8080/casperit-web/rest/tables', true);
	//function for checking status 
	xhr.onload = function(){
		//checking status
		if(this.status == 200){
		  //if OK here we parsing JSON
		  var tables = JSON.parse(this.responseText);
		  // prepare var for output
		  var outputActive = '';
		  var outputEmpty = '';
		  var output = '';
		  console.log(tables);
		  console.log(tables.length)
		  //output notes in a list
		  for(var i in tables){
			  var innerttext = '';
			  if (tables[i].employee != null){
				 	innerttext = '<div class="talbe_container_active" id="' + tables[i].employee.id +'" onclick="retrieveEmployees(this)">' +tables[i].code + '</div>';
				}else{
				 	innerttext= '<div class="talbe_container">' +tables[i].code +'</div>';
				 	}
				array_of.push(innerttext);
			//   if (tables[i].employee != null){
			// 	output += '<div class="talbe_container_active" id="' + tables[i].employee.id +'" >' +
			// 						tables[i].code +
			// 					  '</div>';
			// 					  console.log("Active");
			// 					  document.getElementById('tablesOutput').innerHTML = output;
			//   } 
			//   	if( tables[i].employee == null){
			// 	output += '<div class="talbe_container">' +
			// 	  					tables[i].code +
			// 					  '</div>';
			// 					  console.log("Empty!" + outputEmpty);
			// 					  document.getElementById('tablesOutput').innerHTML = output;
			// 	}

		  }

		  	var map_container = document.getElementById('tablesOutput');
			var j=0
			var temp = '<div class="line_container"> ';
			for(var i = 0; i<3; i++){
			
			temp =temp.concat( '<div class="set_container">').concat(array_of[j]).concat(array_of[j+1]).concat('</div>')
			j=j+2;
		}
			temp=temp.concat('</div>')

			for(var i = 0; i<2; i++){
			temp =temp.concat( '<div class="line_container">');
for(var w=0; w<3;w++){
			temp=temp.concat( '<div class="set_container">').concat(array_of[j]).concat(array_of[j+1]).concat(array_of[j+2]).concat(array_of[j+3]).concat('</div>');
j=j+4;}
			temp=temp.concat('</div>');
			}

			temp =temp.concat( '<div class="line_container"> ');
			for(var i = 0; i<3; i++){
			
				temp =temp.concat( '<div class="set_container">').concat(array_of[j]).concat(array_of[j+1]).concat('</div>')
				j=j+2;
			}
			temp=temp.concat('</div>');
			map_container.innerHTML = temp;
			console.log(temp);
		  //output in index.html where div id=foldersMenu
		  //document.getElementById('meetingrooms').innerHTML = output;
		}
	  }
	//GET JSON
	xhr.send();
}

// Return all meetingrooms
function retrieveMeetengrooms(){
	//making AJAX request
	var xhr = new XMLHttpRequest();
	//GET method for http://localhost:8080/casperit-web/rest/meetingrooms
	xhr.open('GET', 'http://localhost:8080/casperit-web/rest/meetingrooms', true);
	//function for checking status 
	xhr.onload = function(){
		//checking status
		if(this.status == 200){
		  //if OK here we parsing JSON
		  var meetingrooms = JSON.parse(this.responseText);
		  // prepare var for output
		  var output = '';
		  console.log(meetingrooms);
		  //output notes in a list
		  for(var i in meetingrooms){
			  //output note in a list. Here we generate HTML
			  output +=  
						'<tr class="select">' +
						'<td>' + meetingrooms[i].name + '</td>' +
						'<td>' +
							'<div class="circle-table" id="circle-gray"></div>' +
						'</td>' +
						'<td>' + meetingrooms[i].complectation + '</td>' +
						'<td>' + meetingrooms[i].capacity + '</td>' +
						'<td>' +
							'<input type="button" class="search_room" href="#" value="Забронировать" id="' + meetingrooms[i].id +'" onclick="sendIdToForm(this)">' +
						'</td>' +
					'</tr>';
		  }
		  //output in index.html where div id=foldersMenu
		  document.getElementById('meetingrooms').innerHTML = output;
		  console.log(output);
		}
	  }
	  //GET JSON
	  xhr.send();
}

window.onload = function() {
	retrieveMeetengrooms();
	retrieveTables();
}

// function for create new folder on the page
function createNewMeeting(){
	//folder name from form
	var startTime = parseInt(document.getElementById('startTimeId').value);
	console.log(startTime);

	var endTime = parseInt(document.getElementById('endTimeId').value);
	console.log(endTime);
	// checking valid (function validateForm(name,url)) name and url. Name must not be empty
	// and url must not be empty and have the form like google.com 
	// or www.google.com



	var employeeId = 1;

	var meetingRoomId = parseInt(localStorage.getItem('meetId'));
	console.log("MR=" +meetingRoomId);
		//HTTP Request
		var xhr = new XMLHttpRequest();
		//POST method for http://localhost:8080/casperit-web/rest/reservation/
		xhr.open('POST', 'http://localhost:8080/casperit-web/rest/reservation/', true);
		//header
		xhr.setRequestHeader("Content-type", "application/json");
		//checking response status
		var data = JSON.stringify({ "startDate":startTime, "endDate":endTime, "meetingRoom":{id:meetingRoomId}, "employee":{id:employeeId }});
		console.log("OK" + data);
		xhr.onreadystatechange = function () {
			//if OK
			if (xhr.readyState == 4 && xhr.status == 200) {
				//var json = JSON.parse(xhr.responseText);
			}
		//prepare JSON to POST
		var data = JSON.stringify({ "startDate":startTime, "endDate":endTime, "meetingRoom":{id:meetingRoomId}, "employee":{id:employeeId }});

		console.log("OK" + data);
		//POST JSON
		xhr.send(data);
		//alert for OK
		//alert("Meetingroom Reservation " + name + " successfully added!");
	}
	//page reloading
	//window.location.reload();
}

function sendIdToForm(e){
	localStorage.setItem('meetId', e.id);
	var temp = localStorage.getItem('meetId');
	console.log(temp);
}
