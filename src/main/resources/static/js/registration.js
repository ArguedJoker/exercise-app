function displayUser(){
    const req = new XMLHttpRequest();
    req.onreadystatechange = () => {
        // Example handle logic
        if (req.status === 200 && req.readyState === 4) {
            if (req.getResponseHeader("Content-Type") === "application/json") {
                console.log("oh look its some JSON: " + req.responseText);
                // adding an element to the body example
                let elem = document.createElement('div');
                elem.textContent = "User Profile";
                document.body.appendChild(elem);

                let stuff = JSON.parse(req.response);
                stuff.forEach(user => {
                     console.log(user); // prints whole element
                     console.log(user.name); // allows access to specific value

                    // adding title to the body of the page
                    let elem = document.createElement('div');
                    let header = document.createElement('h1');
                    header.textContent = "User name: " + user.name;
                    elem.appendChild(header);
                    stuff.forEach(user => {
                        console.log(user) // print all notes for each notebook
                        let title = document.createElement('p');
                        let description = document.createElement('p');
                        title.textContent = "Title: " + note.title;
                        description.textContent = "Description: " + note.description;
                        elem.appendChild(title);
                        elem.appendChild(description);
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
    req.open("GET", "http://localhost:8080/User");
    req.send();
}

