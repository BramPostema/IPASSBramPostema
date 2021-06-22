class PatientService {

    addPatient(data){
        console.log(data)
        console.log(JSON.stringify(data))
        fetch("/restservices/patient",
            {method: "Post",
                headers:{'Content-Type': 'application/json'},
                body: JSON.stringify(data)})
        // gebruikersnaam, wachtwoord, email
        // {gebruikersnaam: gebruikersnaam, wachtwoord: wachtwoord, email: email}
        document.getElementById("makengebruikersnaam").innerHTML = ''
        document.getElementById("makenwachtwoord").innerHTML =''
        document.getElementById("makenemail").innerHTML = ''
    }

    getPatient(){
        fetch("/restservices/dag")
            .then(response => {return response.json()})
            .then(data => console.log(data))

    }
    async inlogPatient(){
        let gebruikersnaam = String(document.getElementById("Gebruikersnaam").value);
        let wachtwoord = String(document.getElementById("wachtwoord").value);
        let test = {gebruikersnaam:gebruikersnaam, wachtwoord: wachtwoord}

        console.log(test)
        const s = String(await fetch("/restservices/patientlogin",
            {
                method: "POST",
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(test)
            })
            .then(res => res.text()));

        console.log(s)

        if (s === "true"){
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