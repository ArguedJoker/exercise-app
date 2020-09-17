function updateUser(){
    let elements = document.getElementById("updateUser").elements;
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    let myID = Number(obj.userId);

    const req = new XMLHttpRequest();
    req.open("PUT", "http://localhost:8080/updateUser" + myID);
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({firstName: obj.firstName, lastName: obj.lastName }));
}

function updateRoutine(){
    let elements = document.getElementById("updateRoutine").elements;
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    let myID = Number(obj.routineId);

    const req = new XMLHttpRequest();
    req.open("PUT", "http://localhost:8080/updateRoutine" + myID);
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({routineName: obj.routineName}));
}

function updateExercise(){
    let elements = document.getElementById("updateExercise").elements;
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    let myID = Number(obj.exerciseId);

    const req = new XMLHttpRequest();
    req.open("PUT", "http://localhost:8080/updateExercise" + myID);
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({exerciseTitle: obj.exerciseTitle, exerciseDescription: obj.exerciseDescription, exerciseDuration: obj.exerciseDuration, targetMuscle : obj.targetMuscle,  numberOfSets: obj.numberOfSets, numberOfReps: obj.numberOfReps }));
}