class InnameService{

    addInname(){
        var bijwerking1 = document.getElementById("bijwerking1").value
        var bijwerking2 =document.getElementById("bijwerking2").value
        var bijwerking3 =document.getElementById("bijwerking3").value
        var notitie =document.getElementById("Notitie").value
        var datum =document.getElementById("Datum").value
        var key = window.sessionStorage.getItem("gebruikersnaamUser")
        var data = {bijwerking1:bijwerking1, bijwerking2:bijwerking2, bijwerking3:bijwerking3, notitie:notitie, datum:datum}
        fetch("/restservices/inname/"+key,
            {method: "Post",
                headers:{'Content-Type': 'application/json'},
                body: JSON.stringify(data)})
        document.getElementById("medicatie").value= 'methylfenidaat kort (Ritalin)';
        document.getElementById("innameTijd").value= 'Niks';
        document.getElementById("dosis").value= 0;
        SetDate("innameDatum")


    }

    getInname(){
        fetch("/restservices/inname")
            .then(response => {return response.json()})
            .then(data => console.log(data))

    }
}