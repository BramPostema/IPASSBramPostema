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
        var gebruikersnaam = String(document.getElementById("Gebruikersnaam").value);
        var wachtwoord = String(document.getElementById("wachtwoord").value);
        var test = {gebruikersnaam:gebruikersnaam, wachtwoord: wachtwoord}
        console.log(test)
        const s = fetch("/restservices/patientlogin", {method: "POST",
            headers:{'Content-Type': 'application/json'},
            body: JSON.stringify(test)}).then(res => {return res.text()});
        console.log(s)
        if (false){
            document.getElementById("Inloggen").style.display = "none";
            ShowPagina('knoppen');
            ShowPagina('Home');
            teller=1;
            window.sessionStorage.setItem("gebruikersnaamUser", gebruikersnaam)
            document.getElementById("Gebruikersnaam").value= '';
            document.getElementById("wachtwoord").value= '';
        }else{
            document.getElementById("Gebruikersnaam").value= '';
            document.getElementById("wachtwoord").value= '';
            document.getElementById("inlogtext").innerHTML='foute invoer '+teller;
            teller+=1;
        }

    }
}