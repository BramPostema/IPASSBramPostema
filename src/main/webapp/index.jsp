<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>JSP - Hello World</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<%--</body>--%>
<%--</html>--%>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="index.css">
    <title>Medicatie Tracker</title>
    <script type="text/javascript" src="./dagAanmaken.js"></script>
    <script type="text/javascript" src="./DokterService.js"></script>
    <script type="text/javascript" src="./DagService.js"></script>
    <script type="text/javascript" src="./PatientService.js"></script>
</head>
<body onload=" javascript:ShowInloggen();">
<p>To invoke the java Dag <a href="restservices/dag">DAGEN</a></p>
<p><a href="restservices/dokter">DOKTERS</a></p>
<p>dokter account aanmaken ==> <a href="accountAanmaken.html">DoktersAccountAanmaken</a></p>
<div id="knoppen">
    <h1>Medicatie Tracker</h1>
    <div>
        <button onclick="ShowPagina('Home')">Home</button>
        <button onclick="ShowPagina('DagAanmaken'); SetDate()" >DagAanmaken</button>
        <button onclick="ShowPagina('InnameNoteren')">InnameNoteren</button>
        <button onclick="ShowPagina('DagenOverzicht')">DagenOverzicht</button>
        <!--Hier komen later meer opties bij-->
    </div>
</div>
<!--Pagina Home-->
<div class="blauwebox" id="Home">
    hallo welkom op de pagina

</div>
<!--Pagina van dagAanmaken-->
<div class="blauwebox" id="DagAanmaken">
    <h2> Dag aanmaken </h2>
    Hier kun je de informatie van een dag invullen.<br><br>


    <form id="DagMakenVeld">
        selecteer de bijwerkingen:

        <select name="bijwerking1" id="bijwerking1">
            <option value="Niks">Niks</option>
            <option value="Verminderde eetlust">Verminderde eetlust</option>
            <option value="Hartkloppingen">Hartkloppingen</option>
            <option value="Depressief">Depressief</option>
            <option value="Hoofdpijn">Hoofdpijn</option>
        </select>
            <select name="bijwerking2" id="bijwerking2">
                <option value="Niks">Niks</option>
                <option value="Verminderde eetlust">Verminderde eetlust</option>
                <option value="Hartkloppingen">Hartkloppingen</option>
                <option value="Depressief">Depressief</option>
                <option value="Hoofdpijn">Hoofdpijn</option>
            </select>
            <select name="bijwerking3" id="bijwerking3">
                <option value="Niks">Niks</option>
                <option value="Verminderde eetlust">Verminderde eetlust</option>
                <option value="Hartkloppingen">Hartkloppingen</option>
                <option value="Depressief">Depressief</option>
                <option value="Hoofdpijn">Hoofdpijn</option>
            </select> <br><br>
        datum:<input id="Datum" type="date" /><br><br>
        notitie:<input id="Notitie" type="text"><br><br>
        submit: <input type="button" onclick="new DagService().addDag()"/>
    </form>

    <!-- <img src="mooimaken.jpg" width="600" height="300"> <br> <br> -->
<%--    <span id="errorname"></span>--%>
    <label id="nietalleveldeningevult"></label>
    <label id="aangemaakt"></label>

</div>
<div class="blauwebox" id="InnameNoteren"><h2>InnameNoteren</h2>
    selecteer de medicatie soort het merk wat er achter staat is alleen als hulpmiddel en hoeft niet kloppend te zijn:

    <br><select name="medicatie" id="medicatie">
        <option value="methylfenidaat kort (Ritalin)">methylfenidaat kort (Ritalin)</option>
        <option value="methylfenidaat lang (Concerta)">methylfenidaat lang (Concerta)</option>
        <option value="dexamfetamine kort (Amfexa)">dexamfetamine kort (Amfexa)</option>
        <option value="dexamfetamine lang (Amfexa)">dexamfetamine lang (Amfexa)</option>
        <option value="atomoxetine (Strattera)">atomoxetine (Strattera)</option>
    </select><br><br>
    datum:<input id="innameDatum" type="date" /><br><br>
    tijd:<input id="innameTijd" type="time"><br><br>
    dosis:<input id="dosis" type="number" min="0" value="0" step="0.5"><br><br>
    submit: <input type="button" onclick="new InnameService().addInname()"/>
    </form>
</div>
<div class="blauwebox" id="DagenOverzicht">
    <h2>DagenOverzicht</h2>
    <table style="width:100%" id="table">
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Age</th>
        </tr>
        <tr>
            <td>Jill</td>
            <td>Smith</td>
            <td>50</td>
        </tr>
        <tr>
            <td>Eve</td>
            <td>Jackson</td>
            <td>94</td>
        </tr>
    </table>

</div>
<div class="blauwebox" id="Inloggen">
    <h2>Inloggen</h2>
    Gebruikersnaam: <input id="Gebruikersnaam" type="text"  placeholder="Gebruikersnaam" onfocus="this.placeholder=''" onblur="this.placeholder='Gebruikersnaam'" ><br><br>
    Wachtwoord: <input id="wachtwoord" type="password"   placeholder="Wachtwoord" onfocus="this.placeholder=''" onblur="this.placeholder='Wachtwoord'"><br><br>
    <button onclick="new PatientService().inlogPatient()">Inloggen</button><br>
    <button onclick="location.href='http://82.197.208.233:8080/accountAanmaken.html';">DokterAccountAanmaken</button><br>
    <button onclick="location.href='http://82.197.208.233:8080/AccountAanmakenPatiënt.html';">PatiëntAccountAanmaken</button><br>


<%--    <button onclick="InloggenKlopt()">Inloggen</button><br>--%>
    <p id="inlogtext"></p>
</div>
<div id="footer">hallooo</div>

</body>




</html>