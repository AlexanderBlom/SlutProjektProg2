# SlutProjektProg2
Planering:
Krypteringsprogram som skickar data till en server. Servern krypterar data och skickar tillbaka den till klienten.

Programmet börjar med att fråga klienten efter IP adress och port.
När klienten och servern har en koppling kan klienten med hjälp av ett gui skicka meddelanden till servern som servern krypterar/dekrypterar.

Om jag har tid ska klienten också kunna skicka filer som servern krypterar/dekrypterar.

1. Skapa test program för klient och server för att lära mig hur det fungerar.
2. Låta klienten skicka meddelanden och ge servern metoder för att kryptera meddelanden.
3. Låta klienten skicka filer och ge servern metoder för att kryptera filerna.


## Loggbok:
2019-04-12
* Skapade GUI, Model och Controller till servern och klienten istället för att använda JOptionPane.
* Jag har inte hunnit få de att fungera än.
* Behöver planera i mindre steg hur jag ska lösa problemet.

2019-04-26
* Klienten har nu ett GUI som kan användas för att ansluta till servern. Sedan kan klienten skicka meddelande samt nyckel för att kryptera
* Nästa steg är att kunna skicka filer till servern som den krypterar.

2019-05-03
* Påbörjade metoden för att öppna filer
* Använder FileChooser men måste komma på hur programmet ska hitta filen.
