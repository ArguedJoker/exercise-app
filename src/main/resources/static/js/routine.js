function displayRoutines(){
    const req = new XMLHttpRequest();
    req.onreadystatechange = () => {
        // Example handle logic
        if (req.status === 200 && req.readyState === 4) {
            if (req.getResponseHeader("Content-Type") === "application/json") {
                console.log("oh look its some JSON: " + req.responseText);
                // adding an element to the body example
                let elem = document.createElement('div');
                elem.textContent = "Routines";
                document.body.appendChild(elem);

                let stuff = JSON.parse(req.response);
                stuff.forEach(routine => {
                    console.log(routine); // prints whole element
                    console.log(routine.name); // allows access to specific value

                    // adding title to the body of the page
                    let elem = document.createElement('div');
                    let header = document.createElement('h1');
                    header.textContent = "Routine name: " + routine.name;
                    elem.appendChild(header);
                    stuff.forEach(routine => {
                        console.log(routine) // print all notes for each notebook
                        let routineId = document.createElement('p');
                        let routineName = document.createElement('p');
                        routineId.textContent = "Routine ID: " + routine.routineId;
                        routineName.textContent = "Routine Name: " + routine.name;
                        elem.appendChild(routineId);
                        elem.appendChild(routineName);
                    })
                    document.body.appendChild(elem);
                });
            } else {
                console.log(
                    "Looks like its not JSON but lets see what it is... " + req.responseText
                );
            }
        } else {
            console.log("Oh no... handle error");
        }
    };
    req.open("GET", "http://localhost:8080/Routines");
    req.send();
}

function submitRoutine(){
    let elements = document.getElementById("routine").elements;
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    const req = new XMLHttpRequest();
    req.open("POST", "http://localhost:8080/createRoutine");
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({ title: obj.title, description: obj.description, routine:{ id: Number(obj.routineId)} }));
}