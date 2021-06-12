class DagService{

    addDag(data){
        console.log(data)
        console.log(JSON.stringify(data))
        fetch("/restservices/dag",
            {method: "Post",
                headers:{'Content-Type': 'application/json'},
                body: JSON.stringify(data)})
    }
    getDag(){
        fetch("/restservices/dag")
            .then(response => {return response.json()})
            .then(data => console.log(data))

    }
}