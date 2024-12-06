package kundenverwaltung;

public class JuristischePerson extends Person
{
    private String rechtsform;
    private boolean istKapitalgesellschaft;

    public JuristischePerson(String name, String strasse, String hausnummer, String ort, String plz, int anzahlBestellungen, double bisherigesBestellvolumen, String rechtsform, boolean istKapitalgesellschaft)
    {
        super(name, strasse, hausnummer, ort, plz, anzahlBestellungen, bisherigesBestellvolumen);
        this.rechtsform = rechtsform;
        this.istKapitalgesellschaft = istKapitalgesellschaft;
    }

    public boolean istPremiumkunde()
    {
        return istKapitalgesellschaft && getBisherigesBestellvolumen() > 5000;
    }

    public double ermittleWichtigkeit()
    {
        return getBisherigesBestellvolumen() * (istKapitalgesellschaft ? 2 : 1);
    }

    @Override
    public String lieferePostanschrift()
    {
        return getName() +" "+ rechtsform +"\n"+ getStrasse() +" "+ getHausnummer() +"\n"+ getPlz() +" "+ getOrt();
    }
}
