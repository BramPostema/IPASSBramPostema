class DagService{

    addDag(data){
        console.log(data)
        console.log(JSON.stringify(data))
        // var key = "Isa"
        var key = "Asi"
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