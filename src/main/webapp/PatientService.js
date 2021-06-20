class PatientService {

    addPatient(data){
        console.log(data)
        console.log(JSON.stringify(data))
        // var key = "Isa"
        var key = "Asi"
        fetch("/restservices/patient/"+key,
            {method: "Post",
                headers:{'Content-Type': 'application/json'},
                body: JSON.stringify(data)})
        document.getElementById("bijwerking1").value= 'Niks';
        document.getElementById("bijwerking2").value= 'Niks';
        document.getElementById("bijwerking3").value= 'Niks';
        document.getElementById("Notitie").value= '';
        document.getElementById("Datum").value= '';

    }

    getPatient(){
        fetch("/restservices/dag")
            .then(response => {return response.json()})
            .then(data => console.log(data))

    }
    inlogPatient(){
        var gebnaam = document.getElementById("Gebruikersnaam").value
        var wachtwoord = document.getElementById("wachtwoord").value
        var test = {gebruikersnaam:gebnaam, wachtwoord: wachtwoord}
        console.log(test)
        fetch("/restservices/patientlogin", {method: "Post",
            headers:{'Content-Type': 'application/json'},
            body: JSON.stringify(test)}).then(res => {return String(res)
            }).then(data => console.log(data))
    }
}