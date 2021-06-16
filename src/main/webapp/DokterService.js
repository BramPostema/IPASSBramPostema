

class DokterService{

    addDokter(data){
        console.log(data)
        console.log(JSON.stringify(data))
        fetch("/restservices/dokter",
        {method: "Post",
        headers:{'Content-Type': 'application/json'},
        body: JSON.stringify(data)})
        // gebruikersnaam, wachtwoord, email
        // {gebruikersnaam: gebruikersnaam, wachtwoord: wachtwoord, email: email}
        document.getElementById("makengebruikersnaam").innerHTML = ''
        document.getElementById("makenwachtwoord").innerHTML =''
        document.getElementById("makenemail").innerHTML = ''
    }
    getDokter(){
        fetch("/restservices/dokter")
            .then(response => response.json())
            .then(data => console.log(data))



    }
}