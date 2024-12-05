package kundenverwaltung;

abstract class Person
{
    private String name;
    private String strasse;
    private String ort;
    private String plz;
    private int anzahlBestellungen;
    private double bisherigesBestellvolumen;

    public Person(String name, String strasse, String ort, String plz, int anzahlBestellungen, double bisherigesBestellvolumen)
    {
        this.name = name;
        this.strasse = strasse;
        this.ort = ort;
        this.plz = plz;
        this.anzahlBestellungen = anzahlBestellungen;
    }

    abstract boolean istPremiumkunde();
    public String lieferePostanschrift()
    {
        return name + ", " + strasse + ", " + ort + ", " + plz;
    };
    public void ergaenzeBestellung(double bestellwert)
    {
        anzahlBestellungen++;
        bisherigesBestellvolumen += bestellwert;
    }
    abstract void ermittleWichtigkeit();
}