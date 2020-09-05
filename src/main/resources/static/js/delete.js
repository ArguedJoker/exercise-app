function deleteUser(){
    let elements = document.getElementById("user").elements;
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    let myID = Number(obj.routineId);

    const req = new XMLHttpRequest();
    req.open("DELETE", "http://localhost:8080/deleteUser/" + myID);
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send();
}

function deleteRoutine(){
    let elements = document.getElementById("routine").elements;
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    let myID = Number(obj.routineId);

const req = new XMLHttpRequest();
req.open("DELETE", "http://localhost:8080/deleteRoutine/" + myID);
req.onload = () => {
    if (req.status === 200 && req.readyState === 4) {
        console.log("Server Responded with: " + req.responseText);
    } else {
        console.log("Oops...");
    }
};
req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
req.send();
}

function deleteExercise(){
    let elements = document.getElementById("exercise").elements;
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    let myID = Number(obj.exerciseId);

    const req = new XMLHttpRequest();
    req.open("DELETE", "http://localhost:8080/deleteExercise/" + myID);
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send()
}