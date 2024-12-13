package kundenverwaltung;

/**
 * Abstrakte Klasse Person.
 *
 * Diese Klasse repräsentiert eine allgemeine Person (im Kundenverwaltungskontext einen Kunden)
 * und dient als Superklasse für natürliche und juristische Personen.
 * Sie enthält gemeinsame Attribute und Methoden, die für beide Typen von Personen gelten.
 */
abstract class Person
{
    private int id;
    private String name;
    private String strasse;
    private String hausnummer;
    private String ort;
    private String plz;
    private int anzahlBestellungen;
    private double bisherigesBestellvolumen;

    /**
     * Konstruktor der Klasse Person.
     *
     * Initialisiert eine Person mit allen relevanten Basisinformationen.
     *
     * @param name                   Der Name der Person.
     * @param strasse                Die Straße der Adresse der Person.
     * @param hausnummer             Die Hausnummer der Adresse.
     * @param ort                    Der Wohn- oder Standort der Person.
     * @param plz                    Die Postleitzahl der Adresse.
     * @param anzahlBestellungen     Die Anzahl der bisherigen Bestellungen.
     * @param bisherigesBestellvolumen Der Gesamtwert der bisherigen Bestellungen.
     */
    public Person(int id, String name, String strasse, String hausnummer, String ort, String plz, int anzahlBestellungen, double bisherigesBestellvolumen)
    {
        this.id = id;
        this.name = name;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.ort = ort;
        this.plz = plz;
        this.anzahlBestellungen = anzahlBestellungen;
        this.bisherigesBestellvolumen = bisherigesBestellvolumen;
    }

    abstract void datenAusgeben();

    /**
     * Abstrakte Methode, die überprüft, ob eine Person ein Premiumkunde ist.
     *
     * Muss von den abgeleiteten Klassen implementiert werden, da die Kriterien
     * für Premiumkunden von natürlichen und juristischen Personen unterschiedlich sind.
     *
     * @return true, wenn die Person ein Premiumkunde ist, ansonsten false.
     */
    abstract boolean istPremiumkunde();

    /**
     * Liefert die vollständige Postanschrift der Person.
     *
     * Die Adresse wird in folgendem Format zurückgegeben:
     * "<Name>
     *  <Straße> <Hausnummer>
     *  <Ort> <PLZ>"
     *
     * @return Die vollständige Postanschrift als String.
     */
    public String lieferePostanschrift()
    {
        System.out.println("Liefere Postanschrift.\n");
        return name +"\n"+ strasse +" "+ hausnummer +"\n"+ ort +" "+ plz;
    }

    /**
     * Ergänzt eine neue Bestellung der Person.
     *
     * Aktualisiert die Anzahl der Bestellungen und erhöht das Bestellvolumen
     * um den angegebenen Wert.
     *
     * @param bestellwert Der Wert der neuen Bestellung.
     */
    public void ergaenzeBestellung(String bestellnummer, double bestellwert)
    {
        System.out.println("Addiere eine Bestellung.");
        anzahlBestellungen++;
        System.out.println("Addiere uebergebenen Bestellwert: " + bestellwert);
        bisherigesBestellvolumen += bestellwert;
        System.out.println("Bestellung Nr. " +bestellnummer+ " erfolgreich hinzugefuegt.");
    }

    /**
     * Abstrakte Methode zur Berechnung der Wichtigkeit der Person.
     *
     * Muss von den  Unterklassen implementiert werden, da die Logik zur
     * Berechnung der Wichtigkeit bei natürlichen und juristischen Personen unterschiedlich ist.
     *
     * @return Ein Wert (double), der die Wichtigkeit der Person beschreibt.
     */
    abstract double ermittleWichtigkeit();

    // Getter
    public int getAnzahlBestellungen()
    {
        return anzahlBestellungen;
    }

    public double getBisherigesBestellvolumen()
    {
        return bisherigesBestellvolumen;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getStrasse()
    {
        return strasse;
    }

    public String getOrt()
    {
        return ort;
    }

    public String getPlz()
    {
        return plz;
    }

    public String getHausnummer()
    {
        return hausnummer;
    }

    //Setter
    public void setAnzahlBestellungen(int anzahlBestellungen)
    {
        this.anzahlBestellungen = anzahlBestellungen;
    }

    public void setBisherigesBestellvolumen(double bisherigesBestellvolumen)
    {
        this.bisherigesBestellvolumen = bisherigesBestellvolumen;
    }
}