function displayRoutines(){
    const req = new XMLHttpRequest();
    req.onreadystatechange = () => {

        if (req.status === 200 && req.readyState === 4) {
            if (req.getResponseHeader("Content-Type") === "application/json") {
                console.log("oh look its some JSON: " + req.responseText);

                let header = document.createElement('h1');
                header.textContent = "Routines";
                document.body.appendChild(header);

                let stuff = JSON.parse(req.response);
                stuff.forEach(el => {

                    let elem = document.createElement('div');
                    let header = document.createElement('h1');
                    header.textContent = "Routine name: " + el.routineName;
                    elem.appendChild(header);

                    el.exerciseInfo.forEach(exercise => {

                        let exerciseId = document.createElement('p');
                        let exerciseTitle = document.createElement('p');
                        let exerciseDescription = document.createElement('p');
                        let exerciseDuration = document.createElement('p');
                        let targetMuscle = document.createElement('p');
                        let numberOfSets = document.createElement('p');
                        let numberOfReps = document.createElement('p');

                        exerciseId.textContent = "Exercise ID: " + exercise.exerciseId;
                        exerciseTitle.textContent = "Exercise Title: " + exercise.exerciseTitle;
                        exerciseDescription.textContent = "Description: " + exercise.exerciseDescription;
                        exerciseDuration.textContent = "Duration of Exercise in seconds: " + exercise.exerciseDuration;
                        targetMuscle.textContent = "Target Muscle Group: " + exercise.targetMuscle;
                        numberOfSets.textContent = "Number of Sets: " + exercise.numberOfSets;
                        numberOfReps.textContent = "Number of Reps: " + exercise.numberOfReps;

                        elem.appendChild(exerciseId);
                        elem.appendChild(exerciseTitle);
                        elem.appendChild(exerciseDescription);
                        elem.appendChild(exerciseDuration);
                        elem.appendChild(targetMuscle);
                        elem.appendChild(numberOfSets);
                        elem.appendChild(numberOfReps);
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





