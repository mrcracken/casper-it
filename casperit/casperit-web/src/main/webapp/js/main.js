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
function retrieveEmployees(){
	//making AJAX request
	var xhr = new XMLHttpRequest();
	//GET method for http://localhost:8080/casperit-web/rest/employees
	xhr.open('GET', 'http://localhost:8080/casperit-web/rest/employees', true);
	//function for checking status 
	xhr.onload = function(){
	    //checking status
	    if(this.status == 200){
	        //if OK here we parsing JSON
	        var employees = JSON.parse(this.responseText);
            if(employees != null){
                console.log(employees);
            }   else console.log("Error!");
	    }
	}
	//GET JSON
	xhr.send();
}


// Return all empoloyees
function retrieveTables(){
	//making AJAX request
	var xhr = new XMLHttpRequest();
	//GET method for http://localhost:8080/casperit-web/rest/tables
	xhr.open('GET', 'http://localhost:8080/casperit-web/rest/tables', true);
	//function for checking status 
	xhr.onload = function(){
	    //checking status
	    if(this.status == 200){
	        //if OK here we parsing JSON
	        var employeeTables = JSON.parse(this.responseText);
            if(employeeTables != null){
                console.log(employeeTables);
            }   else console.log("Error!");
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
	        var meetingRooms = JSON.parse(this.responseText);
            if(meetingRooms != null){
                console.log(meetingRooms);
            }   else console.log("Error!");
	    }
	}
	//GET JSON
	xhr.send();
}
