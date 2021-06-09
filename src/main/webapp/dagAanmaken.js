function HideAllPaginas(){
    document.getElementById("Home").style.display = "none";
    document.getElementById("DagAanmaken").style.display = "none";
    document.getElementById("InnameNoteren").style.display = "none";
    document.getElementById("DagenOverzicht").style.display = "none";
}
function ShowInloggen() {
    document.getElementById("knoppen").style.display = "none";
    document.getElementById("Home").style.display = "none";
    document.getElementById("DagAanmaken").style.display = "none";
    document.getElementById("InnameNoteren").style.display = "none";
    document.getElementById("DagenOverzicht").style.display = "none";
    document.getElementById("Inloggen").style.display = "none";
    document.getElementById("Inloggen").style.display = "block";
}
var teller =1;
function InloggenKlopt(){
    gebruikersnaam = String(document.getElementById("Gebruikersnaam").value);
    wachtwoord = String(document.getElementById("wachtwoord").value);
    if (gebruikersnaam == '' && wachtwoord==''){
    document.getElementById("Inloggen").style.display = "none";
    ShowPagina('knoppen');
    ShowPagina('Home');
    teller=1;
    }else{
        document.getElementById("Gebruikersnaam").value= '';
        document.getElementById("wachtwoord").value= '';
        document.getElementById("inlogtext").innerHTML='foute invoer '+teller;
        teller+=1;
    }

}
function ShowPagina(pagina) {
    HideAllPaginas();
    document.getElementById(pagina).style.display = "block";
}

// function DagAanmaken(){
//     // var myClass = Java.type("nl.hu.ipass.IpassTest.Main");
//     // myClass.dagAanmaken(document.getElementById("Notitie").value);
//     // document.getElementById('errorname');
//     if (document.getElementById('Datum').value==''||String(document.getElementById('Notitie').value)==''){
//         document.getElementById('nietalleveldeningevult').innerHTML = 'foutje';
//     }
//     // document.getElementById('Datum');
//     // document.getElementById('Notitie');
//     // document.getElementById('bijwerkingenBox');
// }
function dagObject(obj) {
    this.bijwerking1 = obj.bijwerking1;
    this.Datum = obj.Datum;
    this.Notitie = obj.Notitie;
}

function DagAanmaken(){
    // console.log(document.getElementById('DagMakenVeld').value)
    var bijw1 = String(document.getElementById('bijwerking1').value)
    console.log(document.getElementById('bijwerking1').value)
    console.log(document.getElementById('bijwerking3').value)
    // var Datum = document.getElementById('Datum').value
    console.log(document.getElementById('Notitie').value)
    // console.log(document.getElementById("DagMakenVeld").value)
    // var form = document.querySelector("#DagMakenVeld");
    // console.log(form)
    // fetch("")
    var bijwerking1 = document.getElementById('bijwerking1').value;
    var Datum = document.getElementById('Datum').value;
    var Notitie = document.getElementById('Notitie').value
    var Dag = new dagObject({
        bijwerking1: bijwerking1,
        Datum: Datum,
        Notitie: Notitie
    });
    fetch("/IPASSBramPostema_war_exploded/Dag", {method: "Post",headers:{'Content-Type': 'application/json'} ,body: JSON.stringify(Dag)})

}