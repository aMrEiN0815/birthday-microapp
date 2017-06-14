<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Kommende Geburtstage</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
    
</head>
<body>

<#--
    Diese Seite zeigt aktuell eine Liste aller Angestellten.
    Die Seite soll wie folgt modifiziert werden:
        - Sie soll eine Auflistung aller Angestellten zeigen, die in den nächsten
          14 Tagen ihren Geburtstag feiern (bitte nur im Backend filtern -> BirthdayController)
        - Die Daten sollen in Tabellenform dargestellt werden.
        - Die Daten sollen sortiert sein: nächste Geburtstage zuerst.
        - Die Übersicht soll ansprechend und ordentlich gestaltet werden.

    [Optional]
        - Alle Angestellten die in den nächsten drei Tagen Geburtstag feiern
          in der Tabelle highlighten.
        - Den nächsten Geburtstag in einem Satz über der Tabelle promoten. Bsp.:
          "[Vorname], [Nachname] feiert seinen Geburtstag in [X] Tagen.
-->

<div style="background-color:white; color:grey;">
	<h1> SUBSEQ.NET Mitarbeiter </h1>
	<p> ${filter_employees} von ${max_employees} Mitarbeitern, die innerhalb von ${days} Tagen Geburtstag feiern.</ü>
	<#assign aDateTime = .now>
	<#assign aDate = aDateTime?date>
	<p> STATS & PARAMS 
	<br> Liste generiert: ${aDate}
	<br> Highlighting: ${days_highlight} Tage</p>
	<p> </p>
</div>



<table class="table table-striped">

  <thead>
    <tr>
      <th>Nachname</th>
      <th>Vorname</th>
      <th>Geburtstag</th>
      <th>Alter</th>
    </tr>
  </thead>
 

  <tbody >
	  <#list employees as employee>
	    <tr <#if employee.daysbetween <= days_highlight>
	    	 class="table-danger">
	    	 <#else>
	    	 >
	    	 </#if>
			<td> ${employee.lastname} </td>
			<td> ${employee.firstname} </td>
			<td> ${employee.birthday[8..9]}.${employee.birthday[5..6]}.${employee.birthday[0..3]}</td>
			<td> wird ${employee.age + 1} (in ${employee.daysbetween} Tagen)</td>					
	    </tr>
	  </#list>  
  </tbody>  
 </table>
 
<#--
<ul>
    <#list employees as employee>
        <li>${employee.lastname}, ${employee.firstname}, ${employee.birthday}</li>
    </#list>
</ul>
-->

</body>
</html>