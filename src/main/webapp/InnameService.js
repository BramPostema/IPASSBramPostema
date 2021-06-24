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
        var key=window.sessionStorage.getItem("gebruikersnaamUser")+":"+document.getElementById("innameDatumZoeken").value
        fetch("/restservices/inname/"+key)
            .then(response => {return response.json()})
            .then(data => {
                var table = document.getElementById("innameTable")
                table.innerHTML = ""
                var header = table.insertRow(0)
                var cell1 = header.insertCell(0)
                var cell2 = header.insertCell(1)
                var cell3 = header.insertCell(2)
                cell1.innerHTML = "Tijd"
                cell2.innerHTML = "Medicatie"
                cell3.innerHTML = "Dosis"
                for (var key in data){
                    if (data.hasOwnProperty(key)) {
                        var obj = data[key]
                        console.log(obj["datum"])
                        this.innameAddRow( obj["tijd"], obj["medicatie"], obj["dosis"])
                    }}})

    }
    innameAddRow(tijd, medicatie, dosis){
        var table = document.getElementById("innameTable")
        var row = table.insertRow(-1)
        var cell1 = row.insertCell(0)
        var cell2 = row.insertCell(1)
        var cell3 = row.insertCell(2)
        cell1.innerHTML = tijd
        cell2.innerHTML = medicatie
        cell3.innerHTML = dosis
    }

}