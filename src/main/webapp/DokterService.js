

class DokterService{

    addDokter(data){
        console.log(data)
        console.log(JSON.stringify(data))
        fetch("/IPASSBramPostema_war_exploded/dokter", 
        {method: "Post",
        headers:{'Content-Type': 'application/json'},
        body: JSON.stringify(data)})
        // gebruikersnaam, wachtwoord, email
        // {gebruikersnaam: gebruikersnaam, wachtwoord: wachtwoord, email: email}
    }
    getDokter(data){

    }
}