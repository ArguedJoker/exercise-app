function displayUser(){
    const req = new XMLHttpRequest();
    req.onreadystatechange = () => {
        // Example handle logic
        if (req.status === 200 && req.readyState === 4) {
            if (req.getResponseHeader("Content-Type") === "application/json") {
                console.log("oh look its some JSON: " + req.responseText);
                // adding an element to the body example
                let header = document.createElement('h1');
                header.textContent = "User Profile";
                document.body.appendChild(header);

                let stuff = JSON.parse(req.response);
                stuff.forEach(el => {

                    let elem = document.createElement('div');
                    let header = document.createElement('h1');
                    let userID = document.createElement('p');
                    let weight = document.createElement('p');
                    let height = document.createElement('p');
                    let email = document.createElement('p');
                    header.textContent = "User name: " + el.firstName + " " + el.lastName;
                    userID.textContent = "User ID: " + el.userId;
                    weight.textContent = el.weight;
                    height.textContent = el.height;
                    email.textContent = el.email;
                    elem.appendChild(header);
                    elem.appendChild(userID);
                    elem.appendChild(email);
                    elem.appendChild(weight);
                    elem.appendChild(height);

                    el.routine.forEach(routine => {

                        let routineId = document.createElement('p');
                        let routineName = document.createElement('p');

                        routineId.textContent = "Routine ID: " + routine.routineId;
                        routineName.textContent = "Routine Name: " + routine.routineName;

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
    req.open("GET", "http://localhost:8080/Users");
    req.send();
}

