class DagService{

    addDag(data){
        console.log(data)
        console.log(JSON.stringify(data))
        fetch("/IPASSBramPostema_war_exploded/dag",
            {method: "Post",
                headers:{'Content-Type': 'application/json'},
                body: JSON.stringify(data)})
    }
    getDag(data){

    }
}