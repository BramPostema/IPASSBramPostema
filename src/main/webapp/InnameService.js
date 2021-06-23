class InnameService{

    addInname(){
        var medicatie = document.getElementById("medicatie").value
        var datum =document.getElementById("innameDatum").value
        var tijd =document.getElementById("innameTijd").value
        var dosis =document.getElementById("dosis").value
        var key = window.sessionStorage.getItem("gebruikersnaamUser")
        var data = {medicatie:medicatie, datum:datum, tijd:tijd, dosis:dosis}
        fetch("/restservices/inname/"+key,
            {method: "Post",
                headers:{'Content-Type': 'application/json'},
                body: JSON.stringify(data)})
        document.getElementById("medicatie").value= 'methylfenidaat kort (Ritalin)';
        document.getElementById("dosis").value= 0;
        SetDate("innameDatum")
        SetTime("innameTijd")


    }

    getInname(){
        fetch("/restservices/inname")
            .then(response => {return response.json()})
            .then(data => console.log(data))

    }
}