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
        document.getElementById("Datum").value= '';

    }

    getDag(){
        fetch("/restservices/dag")
            .then(response => {return response.json()})
            .then(data => console.log(data))

    }
}