package kundenverwaltung;

public class NatuerlichePerson extends Person
{
    private String geschlecht;
    private String anrede;

    public NatuerlichePerson(String name, String strasse, String hausnummer, String ort, String plz, int anzahlBestellungen, double bisherigesBestellvolumen)
    {
        super(name, strasse, hausnummer, ort, plz, anzahlBestellungen, bisherigesBestellvolumen);
    }

    public boolean istPremiumkunde()
    {
        return getBisherigesBestellvolumen() > 1000 || getAnzahlBestellungen() > 10;
    }

    public double ermittleWichtigkeit()
    {
        return getBisherigesBestellvolumen() + getAnzahlBestellungen() * 10;
    }
}
