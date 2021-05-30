<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
</head>
<body onload="javascript:ShowInloggen();">
<div id="knoppen">
    <h1>Medicatie Tracker</h1>
    <div>
        <button onclick="ShowPagina('Home')">Home</button>
        <button onclick="ShowPagina('DagAanmaken')">DagAanmaken</button>
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


    <form>
        <label for="bijwerkingenBox">selecteer de bijwerkingen:</label>

        <select id="bijwerkingenBox" data-dropup-auto="false" multiple>
            <option value="Hoofdpijn">Hoofdpijn</option>
            <option value="Verminderde eetlust">Verminderde eetlust</option>
            <option value="Hartkloppingen">Hartkloppingen</option>
            <option value="Depressief">Depressief</option>
            <option value="Niks">Niks</option>
        </select> <br><br>
        datum:<input id="Datum" type="date" /><br><br>
        notitie:<input id="Notitie" type="text"><br><br>
    </form>
    <button onclick="DagAanmaken()">Aanmaken</button>
    <!-- <img src="mooimaken.jpg" width="600" height="300"> <br> <br> -->
    <label id="aangemaakt"></label>

</div>
<div class="blauwebox" id="InnameNoteren"><h2>InnameNoteren</h2></div>
<div class="blauwebox" id="DagenOverzicht"><h2>DagenOverzicht</h2></div>
<div class="blauwebox" id="Inloggen">
    <h2>Inloggen</h2>
    Gebruikersnaam: <input id="Gebruikersnaam" type="text"  placeholder="Gebruikersnaam" onfocus="this.placeholder=''" onblur="this.placeholder='Gebruikersnaam'" ><br><br>
    Wachtwoord: <input id="wachtwoord" type="password"   placeholder="Wachtwoord" onfocus="this.placeholder=''" onblur="this.placeholder='Wachtwoord'"><br><br>
    <button onclick="InloggenKlopt()">Inloggen</button><br>
    <p id="inlogtext"></p>
</div>
<div id="footer">hallooo</div>

</body>




</html>