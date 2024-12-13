package kundenverwaltung;

import java.util.ArrayList;

public class KundenVerwaltungsSystem
{
    private void erstelleTop10(ArrayList<? extends Person> kundenliste)
    {
        ArrayList<Person> kopierteListe = new ArrayList<>(kundenliste);
        System.out.println("Berechne fuer jeden Kunden einen Wichtigkeitswert.");
        System.out.println("Sortiere Kundenliste nach Wichtigkeit.");
        sortiereKunden(kopierteListe);
        System.out.println("Gebe 10 wichtigsten Kunden aus.");
        System.out.println();
        top10Ausgeben(kopierteListe);
    }

    private void top10Ausgeben(ArrayList<? extends Person> kundenliste)
    {
        int size = Math.min(kundenliste.size(), 10); // int size wird maximal 10 zugeordnet
        System.out.println("Platz | Name                     | Wichtigkeit");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < size; i++)
        {
            System.out.printf("%-5d | %-24s | %.2f%n", i+1, kundenliste.get(i).getName(), kundenliste.get(i).ermittleWichtigkeit());
        }
    }

    private void sortiereKunden(ArrayList<Person> kundenliste)
    {
        for (int i = 0; i < kundenliste.size(); i++)
        {
            for (int j = 0; j < kundenliste.size()-1; j++)
            {
                Person kundeA = kundenliste.get(j);
                Person kundeB = kundenliste.get(j+1);
                if(kundeA.ermittleWichtigkeit() < kundeB.ermittleWichtigkeit())
                {
                    kundenliste.set(j+1, kundeA);
                    kundenliste.set(j, kundeB);
                }
            }
        }
    }

    public void testStarten(String testName)
    {
        System.out.println("\n******************************************");
        System.out.println("TEST START " + testName);
        System.out.println();
    }
    public void testBeenden(String testName)
    {
        System.out.println();
        System.out.println("TEST ENDE " + testName);
        System.out.println("******************************************\n");
    }
    public static void main(String[] args)
    {
        // 0. Kundenverwaltungssystem insatnziieren
        KundenVerwaltungsSystem kundenVerwaltungsSystem = new KundenVerwaltungsSystem();

        // 1. ArrayList privatkundenListe instanziieren
        ArrayList<NatuerlichePerson> privatkundenListe = new ArrayList<>();

        // 2. ArrayList firmenListe instanziieren
        ArrayList<JuristischePerson> firmenListe = new ArrayList<>();

        // 3. Privatkunden-Daten aus JSON lesen und als natuerlichePersonen instanziieren
        NatuerlichePerson privatkunde1 = new NatuerlichePerson(1,"Max Mustermann", "Mauerweg", "12", "Berlin", "10247", 2, 118.22,'M',"Herr");
        NatuerlichePerson privatkunde2 = new NatuerlichePerson(2,"Karl Hans", "Sachsendamm", "7", "Koeln", "50667", 3, 89.97,'M',"Herr");
        NatuerlichePerson privatkunde3 = new NatuerlichePerson(3,"Charlotte Frey", "Bruesseler Strasse", "49", "Hamburg", "20095", 4, 164,'W',"Frau");
        NatuerlichePerson privatkunde4 = new NatuerlichePerson(4,"Lena Meier", "Marktplatz", "21", "Berlin", "12063", 1, 49.90,'W', "Frau");
        NatuerlichePerson privatkunde5 = new NatuerlichePerson(5,"Anna Friedrich", "Uhlsteinstrasse", "11", "Tuebingen", "72076", 6, 356.94,'W',"Frau");
        NatuerlichePerson privatkunde6 = new NatuerlichePerson(6,"Jan Trump", "Allee der Freiheit", "42", "Leipzig", "04103", 2, 118.22,'M',"Herr");
        NatuerlichePerson privatkunde7 = new NatuerlichePerson(7,"Tom Schuster", "Rosenstraße", "5", "München", "80331", 2, 150.75,'M',"Herr");
        NatuerlichePerson privatkunde8 = new NatuerlichePerson(8,"Lisa Hoffmann", "Schlossallee", "10", "Stuttgart", "70173", 4, 320.50,'W',"Frau");
        NatuerlichePerson privatkunde9 = new NatuerlichePerson(9,"Julian Becker", "Hauptstraße", "12", "Frankfurt", "60311", 3, 200.00,'M',"Herr");
        NatuerlichePerson privatkunde10 = new NatuerlichePerson(10,"Sophie Keller", "Am Stadtpark", "8", "Düsseldorf", "40210", 11, 1200,'W',"Frau");

        // 4. Firmen-Daten aus JSON lesen und als juristischePersonen instanziieren
        JuristischePerson firma1 = new JuristischePerson(11,"HelloWorld", "Innovationsweg", "15", "Berlin", "10117", 10, 4500.50, "AG", true);
        JuristischePerson firma2 = new JuristischePerson(12,"Handelshaus Java", "Hafenstraße", "22", "Hamburg", "20457", 5, 2300.00, "GmbH", true);
        JuristischePerson firma3 = new JuristischePerson(13,"Bauwerk Objekte", "Baumallee", "7", "München", "80333", 8, 3150.75, "GmbH", true);
        JuristischePerson firma4 = new JuristischePerson(14,"Logistik Double", "Industriestraße", "5", "Frankfurt", "60311", 4, 1200.99, "SE", true);
        JuristischePerson firma5 = new JuristischePerson(15,"Kreativ Integer", "Kunststraße", "3", "Dresden", "01067", 6, 1980.45, "OHG", false);
        JuristischePerson firma6 = new JuristischePerson(16,"Energy Bool", "Windparkstraße", "19", "Leipzig", "04105", 12, 5400.00, "AG", true);
        JuristischePerson firma7 = new JuristischePerson(17,"MediCare Instance", "Gesundheitsallee", "23", "Stuttgart", "70173", 7, 2980.30, "GmbH", true);
        JuristischePerson firma8 = new JuristischePerson(18,"Green Char", "Nachhaltigkeitsstraße", "12", "Freiburg", "79098", 9, 3500.00, "KG", false);
        JuristischePerson firma9 = new JuristischePerson(19,"Future Array", "Technologiepark", "8", "Dortmund", "44139", 15, 7000.00, "AG", true);
        JuristischePerson firma10 = new JuristischePerson(20,"Logi Loop", "Transportweg", "27", "Hannover", "30159", 3, 1100.00, "OHG", false);

        // 5. Privatkunden Instanzen der privatkundenListe hinzufügen
        privatkundenListe.add(privatkunde1);
        privatkundenListe.add(privatkunde2);
        privatkundenListe.add(privatkunde3);
        privatkundenListe.add(privatkunde4);
        privatkundenListe.add(privatkunde5);
        privatkundenListe.add(privatkunde6);
        privatkundenListe.add(privatkunde7);
        privatkundenListe.add(privatkunde8);
        privatkundenListe.add(privatkunde9);
        privatkundenListe.add(privatkunde10);

        // 6. Firmen Instanzen der firmenListe hinzufügen
        firmenListe.add(firma1);
        firmenListe.add(firma2);
        firmenListe.add(firma3);
        firmenListe.add(firma4);
        firmenListe.add(firma5);
        firmenListe.add(firma6);
        firmenListe.add(firma7);
        firmenListe.add(firma8);
        firmenListe.add(firma9);
        firmenListe.add(firma10);
        System.out.println("TESTPROGRAMM START.");
        System.out.println("******************************************");

        // 8. Funktion istPremiumkunde der Klasse natuerlichePerson testen
        kundenVerwaltungsSystem.testStarten("NatuerlichePerson.istPremiumkunde()");
        privatkundenListe.get(0).datenAusgeben();
        privatkundenListe.get(0).istPremiumkunde();
        System.out.println();
        privatkundenListe.get(9).datenAusgeben();
        privatkundenListe.get(9).istPremiumkunde();
        kundenVerwaltungsSystem.testBeenden("NatuerlichePerson.istPremiumkunde()");

        // 9. Funktion bestellungZureckgeben der Klasse natuerlichePerson testen
        kundenVerwaltungsSystem.testStarten("NatuerlichePerson.bestellungZurueckgeben()");
        privatkundenListe.get(2).datenAusgeben();
        System.out.println();
        privatkundenListe.get(2).bestellungZurueckgeben("011122401", 41);
        System.out.println();
        privatkundenListe.get(2).datenAusgeben();
        kundenVerwaltungsSystem.testBeenden("NatuerlichePerson.bestellungZurueckgeben()");

        // 10. Funktion istPremiumkunde der Klasse juristische person testen
        kundenVerwaltungsSystem.testStarten("JuristischePerson.istPremiumkunde()");
        firmenListe.get(8).datenAusgeben();
        firmenListe.get(8).istPremiumkunde();
        System.out.println();
        firmenListe.get(9).datenAusgeben();
        firmenListe.get(9).istPremiumkunde();
        kundenVerwaltungsSystem.testBeenden("JuristischePerson.istPremiumkunde()");

        // 11. lieferePostanschrift() der Klasse juristischePerson testen
        kundenVerwaltungsSystem.testStarten("JuristischePerson.lieferePostanschrift()");
        firmenListe.get(3).datenAusgeben();
        System.out.println();
        System.out.println(firmenListe.get(3).lieferePostanschrift());
        kundenVerwaltungsSystem.testBeenden("JuristischePerson.lieferePostanschrift()");

        // 12. Funktion ergaenzeBestellung testen
        kundenVerwaltungsSystem.testStarten("Person.ergaenzeBestellung()");
        firmenListe.get(7).datenAusgeben();
        System.out.println();
        firmenListe.get(7).ergaenzeBestellung("008112421", 239.90);
        System.out.println();
        firmenListe.get(7).datenAusgeben();
        kundenVerwaltungsSystem.testBeenden("Person.ergaenzeBestellung()");

        // 13. Privatkunden TOP10 erstelln
        kundenVerwaltungsSystem.testStarten("Privatkunden Top10 erstellen");
        kundenVerwaltungsSystem.top10Ausgeben(privatkundenListe);
        System.out.println();
        kundenVerwaltungsSystem.erstelleTop10(privatkundenListe);
        kundenVerwaltungsSystem.testBeenden("Privatkunden Top10 erstellen");

        // 14. Firmen TOP 10 erstellen
        kundenVerwaltungsSystem.testStarten("Firmen Top10 erstellen");
        kundenVerwaltungsSystem.top10Ausgeben(firmenListe);
        System.out.println();
        kundenVerwaltungsSystem.erstelleTop10(firmenListe);
        kundenVerwaltungsSystem.testBeenden("Firmen Top10 erstellen");
    }
}
