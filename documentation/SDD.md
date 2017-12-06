# Introduction
## 1.1. Overall Description
Voor de Hogeschool van Arnhem en Nijmegen (HAN) afdeling Informatica Communicatie Academie (ICA) wordt er een systeem ontwikkelt die het mogelijk maakt om lokalen via een webapplicatie te reserveren. Dit systeem gaat gebruikt worden door zowel studenten als docenten. De studenten en docenten kunnen via de webapplicatie een lokaal reserveren voor een bepaalde tijd. Om te garanderen dat het gereserveerde lokaal ook daadwerkelijk bezet wordt moet de reservering geactiveerd worden door een QR-code te scannen of een code in te voeren op een tablet die in het lokaal hangt. Na het activeren wordt de camera van de tablet gebruikt als een bewegingssensor om bij te kunnen houden of er daadwerkelijk mensen in het lokaal zijn. Wanneer de sensor voor een x-aantal minuten geen beweging waarneemt wordt er een timer gestart en een melding gegeven om binnen een bepaalde tijd opnieuw de QR-code te scannen of de code in te voeren op de tablet. Wanneer dit niet gedaan wordt en de timer geëindigd is wordt de reservering verwijdert en kan een andere student of docent het lokaal reserveren.


Omdat docenten altijd voorrang hebben op het reserveren van een lokaal wordt het voor een docent mogelijk om een reservering van een student te overschrijven. 

Wanneer de docent een lokaal wilt reserveren die al bezet is door een student krijgt hij/zij hier een melding van. Vervolgens kan de docent kiezen om deze reservering te overschrijven. 
Ook wordt er rekening gehouden met de toekomst van dit systeem, zo moet het bijvoorbeeld in de toekomst mogelijk worden om het systeem uit te breiden met een functie voor het toekennen van punten aan de studenten en docenten. Deze punten moeten toegekend worden op basis van gedrag bij het reserveren, gebruikers die vaak niet komen opdagen bij hun reservering of ander wangedrag vertonen zullen hierdoor een lagere prioriteit kunnen krijgen. Dit hoort echter niet bij dit project en wordt daarom niet volledig uitgewerkt.
Verdere informatie over onder andere het domeinmodel, SSD’s en use cases is te verkrijgen in het SRS document (bijlage 1).
## 1.2. Purpose of this document
 In dit document wordt er gekeken naar het ontwerp van het systeem. Er wordt informatie verstrekt over de architectuur en de design keuzes, ook wordt er gekeken naar het ontwerp van de database.
 
 ## 1.3. Definitions, acronyms, and abbreviations
 
 |Term| Description|
 |----|------------|
 |HAN|	Hogeschool van Arnhem en Nijmegen|
 |ICA|	Informatica Communicatie Academie|
 |SRS|	Software Requirements Specification|
 |SDD|	Software Design Description|
 |SSD|	System Sequence Diagram|
 |SD|	System Diagram|
