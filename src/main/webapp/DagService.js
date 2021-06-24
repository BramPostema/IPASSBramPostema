class DagService{

    addDag(){
        var bijwerking1 = document.getElementById("bijwerking1").value
        var bijwerking2 =document.getElementById("bijwerking2").value
        var bijwerking3 =document.getElementById("bijwerking3").value
        var notitie =document.getElementById("Notitie").value
        var datum =document.getElementById("Datum").value
        var key = window.sessionStorage.getItem("gebruikersnaamUser")
        var data = {bijwerking1:bijwerking1, bijwerking2:bijwerking2, bijwerking3:bijwerking3, notitie:notitie, datum:datum}
        fetch("/restservices/dag/"+key,
            {method: "Post",
                headers:{'Content-Type': 'application/json'},
                body: JSON.stringify(data)})
        document.getElementById("bijwerking1").value= 'Niks';
        document.getElementById("bijwerking2").value= 'Niks';
        document.getElementById("bijwerking3").value= 'Niks';
        document.getElementById("Notitie").value= '';
        SetDate("Datum")

    }

    getDagen(){
        var key = window.sessionStorage.getItem("gebruikersnaamUser")
        fetch("/restservices/dag/"+key)
            .then(response => response.json())
            .then(data =>
            {
                var table = document.getElementById("dagTable")
                table.innerHTML = ""
                var header = table.insertRow(0)
                var cell1 = header.insertCell(0)
                var cell2 = header.insertCell(1)
                var cell3 = header.insertCell(2)
                var cell4 = header.insertCell(3)
                var cell5 = header.insertCell(4)
                cell1.innerHTML = "Datum"
                cell2.innerHTML = "Bijwerking1"
                cell3.innerHTML = "Bijwerking2"
                cell4.innerHTML = "Bijwerking3"
                cell5.innerHTML = "Notitie"
                for (var key in data){
                    if (data.hasOwnProperty(key)) {
                        var obj = data[key]
                        this.dagAddRow(obj["datum"], obj["bijwerking1"], obj["bijwerking2"], obj["bijwerking3"], obj["notitie"])
                    }
                }
                this.addRowHandlers()
            })

    }
    // bijwerking1, bijwerking2, bijwerking3, datum, notitie
    dagAddRow(datum, bijwerking1, bijwerking2, bijwerking3, notitie){
        var table = document.getElementById("dagTable")
        var row = table.insertRow(-1)
        var cell1 = row.insertCell(0)
        var cell2 = row.insertCell(1)
        var cell3 = row.insertCell(2)
        var cell4 = row.insertCell(3)
        var cell5 = row.insertCell(4)
        cell1.innerHTML = datum
        cell2.innerHTML = bijwerking1
        cell3.innerHTML = bijwerking2
        cell4.innerHTML = bijwerking3
        cell5.innerHTML = notitie

    }
    addRowHandlers() {
        var table = document.getElementById("dagTable");
        var rows = table.getElementsByTagName("tr");
        for (var i = 1; i < rows.length; i++) {
            var row = table.rows[i];
            row.onclick = function(){
                var cell1 = this.getElementsByTagName("td")[0];
                var cell2 = this.getElementsByTagName("td")[1];
                var cell3 = this.getElementsByTagName("td")[2];
                var cell4 = this.getElementsByTagName("td")[3];
                var cell5 = this.getElementsByTagName("td")[4];
                var datum = cell1.innerHTML;
                var notitie = cell5.innerHTML;

                alert("Datum:" + datum +" Notitie: "+notitie);

            };
        }
    }
    geefMessage(){
        console.log("hallo")
    }
}