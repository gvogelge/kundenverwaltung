package kundenverwaltung;

abstract class Person
{
    private String name;
    private String strasse;
    private String hausnummer;
    private String ort;
    private String plz;
    private int anzahlBestellungen;
    private double bisherigesBestellvolumen;

    public Person(String name, String strasse, String hausnummer, String ort, String plz, int anzahlBestellungen, double bisherigesBestellvolumen)
    {
        this.name = name;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.ort = ort;
        this.plz = plz;
        this.anzahlBestellungen = anzahlBestellungen;
    }

    abstract boolean istPremiumkunde();
    public String lieferePostanschrift()
    {
        return name +"\n"+ strasse +" "+ hausnummer +"\n"+ ort +" "+ plz;
    }
    public void ergaenzeBestellung(double bestellwert)
    {
        anzahlBestellungen++;
        bisherigesBestellvolumen += bestellwert;
    }
    abstract double ermittleWichtigkeit();

    public int getAnzahlBestellungen()
    {
        return anzahlBestellungen;
    }

    public double getBisherigesBestellvolumen()
    {
        return bisherigesBestellvolumen;
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
}