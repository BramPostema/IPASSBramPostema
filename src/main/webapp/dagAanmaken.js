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
    if (gebruikersnaam == 'klaas' && wachtwoord==''){
    document.getElementById("Inloggen").style.display = "none";
    ShowPagina('knoppen');
    ShowPagina('Home');
    teller=1;
    window.sessionStorage.setItem("gebruikersnaamUser", gebruikersnaam)
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

function SetDate(){
    var now = new Date();
    var month = (now.getMonth() + 1);
    var day = now.getDate();
    if (month < 10)
        month = "0" + month;
    if (day < 10)
        day = "0" + day;
    document.getElementById("Datum").value = now.getFullYear() + '-' + month + '-' + day;

}

