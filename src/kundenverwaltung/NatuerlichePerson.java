package kundenverwaltung;

public class NatuerlichePerson extends Person
{
    private String geschlecht;
    private String anrede;

    /**
     * Konstruktor der Klasse NatuerlichePerson.
     *
     * Initialisiert eine natürliche Person mit allen relevanten Attributen.
     * Verwendet den Konstruktor der Superklasse Person zur Initialisierung allgemeiner Eigenschaften.
     *
     * @param name                   Der Name der Person.
     * @param strasse                Die Straße, in der die Person wohnt.
     * @param hausnummer             Die Hausnummer der Adresse.
     * @param ort                    Der Wohnort der Person.
     * @param plz                    Die Postleitzahl des Wohnorts.
     * @param anzahlBestellungen     Die bisherige Anzahl der Bestellungen der Person.
     * @param bisherigesBestellvolumen Der Gesamtwert der bisherigen Bestellungen der Person.
     */
    public NatuerlichePerson(String name, String strasse, String hausnummer, String ort, String plz, int anzahlBestellungen, double bisherigesBestellvolumen)
    {
        super(name, strasse, hausnummer, ort, plz, anzahlBestellungen, bisherigesBestellvolumen);
    }

    /**
     * Überprüft, ob die Person ein Premiumkunde ist.
     *
     * Eine Person wird als Premiumkunde betrachtet, wenn sie eines der folgenden Kriterien erfüllt:
     * - Ihr bisheriges Bestellvolumen überschreitet 1000 Euro.
     * - Sie hat mehr als 10 Bestellungen getätigt.
     *
     * @return true, wenn die Person ein Premiumkunde ist, andernfalls false.
     */
    public boolean istPremiumkunde()
    {
        return getBisherigesBestellvolumen() > 1000 || getAnzahlBestellungen() > 10;
    }

    /**
     * Berechnet die Wichtigkeit der Person für das Unternehmen.
     *
     * Die Wichtigkeit wird durch folgende Formel ermittelt:
     * Wichtigkeit = (Bisheriges Bestellvolumen) + (Anzahl der Bestellungen * 10)
     *
     * Diese Berechnung kombiniert den Umsatz, den die Person generiert hat,
     * und die Anzahl der Bestellungen, um einen Wert zu erhalten, der ihre
     * Bedeutung für das Unternehmen widerspiegelt.
     *
     * @return Ein Wert (double), der die Wichtigkeit der Person darstellt.
     */
    public double ermittleWichtigkeit()
    {
        return getBisherigesBestellvolumen() + getAnzahlBestellungen() * 10;
    }
}
