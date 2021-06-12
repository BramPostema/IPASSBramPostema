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
    this.bijwerking2 = obj.bijwerking2;
    this.bijwerking3 = obj.bijwerking3;
    this.datum = obj.datum;
    this.notitie = obj.notitie;
}

function DagAanmaken(){
    var bijwerking11 = document.getElementById('bijwerking1').value;
    var bijwerking22 = document.getElementById('bijwerking2').value;
    var bijwerking33 = document.getElementById('bijwerking3').value;
    var datum1 = document.getElementById('Datum').value;
    var notitie1 = document.getElementById('Notitie').value
    // test = {bijwerking1:bijwerking1, bijwerking}
    // var Dag = new dagObject({
    //     bijwerking1: bijwerking1, bijwerking2: bijwerking2, bijwerking3: bijwerking3, datum: datum, notitie: notitie
    // });
    fetch("/IPASSBramPostema_war_exploded/dag", {method: "Post",headers:{'Content-Type': 'application/json'} ,body: JSON.stringify({bijwerking1: bijwerking11, bijwerking2: bijwerking22, bijwerking3: bijwerking33, datum: datum1, notitie: notitie1})
    }
    )

}