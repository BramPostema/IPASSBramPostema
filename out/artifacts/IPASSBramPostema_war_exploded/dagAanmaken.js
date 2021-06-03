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
function DagAanmaken(){
    console.log(document.getElementById('DagMakenVeld').value)
    console.log(document.getElementById('bijwerkingenBox').value)
    console.log(document.getElementById('Datum').value)
    console.log(document.getElementById('Notitie').value)
    var formData = new FormData(document.querySelector('#DagMakenVeld'));
    var encData = new URLSearchParams(formData.entries());

    // fetch("ja", {method: 'POST', body: encData})
    //     .then(response => response.json())
    //     .then(function (myjson){
    //         console.log(myjson);
    //     });

}