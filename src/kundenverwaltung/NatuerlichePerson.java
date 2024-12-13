package kundenverwaltung;

public class NatuerlichePerson extends Person
{
    private char geschlecht;
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
     * @param geschlecht            Der Anfangsbuchstabe des Geschlechts einer Person.
     * @param anrede                  Die Anrede einer Person.
     */
    public NatuerlichePerson(int id, String name, String strasse, String hausnummer, String ort, String plz, int anzahlBestellungen, double bisherigesBestellvolumen, char geschlecht, String anrede)
    {
        super(id, name, strasse, hausnummer, ort, plz, anzahlBestellungen, bisherigesBestellvolumen);
        this.geschlecht = geschlecht;
        this.anrede = anrede;
    }

    public void datenAusgeben() {
        System.out.println("+------+--------+----------------------+--------+---------------------------+--------+-------------------+-------------+--------------+----------------+");
        System.out.println("| ID   | Anrede | Name                 | Gesch. | Straße                    | Hausnr.| Ort               | PLZ         | Bestellungen | Bestellvolumen |");
        System.out.println("+------+--------+----------------------+--------+---------------------------+--------+-------------------+-------------+--------------+----------------+");
        System.out.printf("| %-4d | %-6s | %-20s | %-6c | %-25s | %-6s | %-17s | %-11s | %-12d | %-14.2f |%n",
                getId(),
                getAnrede(),
                getName(),
                getGeschlecht(),
                getStrasse(),
                getHausnummer(),
                getOrt(),
                getPlz(),
                getAnzahlBestellungen(),
                getBisherigesBestellvolumen());
        System.out.println("+------+--------+----------------------+--------+---------------------------+--------+-------------------+-------------+--------------+----------------+");
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
        System.out.println("Pruefe ob Bestellvolumen min. 1000 betraegt oder Bestellungen min. 11.");
        boolean istPremiumkunde = getBisherigesBestellvolumen() >= 1000 || getAnzahlBestellungen() > 10;
        if(istPremiumkunde)
        {
            System.out.println(getAnrede() +"\s"+ getName() +  " ist Premiumkund" + ((getGeschlecht() == 'M') ? "e." : "in."));
        }
        else
        {
            System.out.println(getAnrede() +"\s"+ getName() +  " ist kein"+ (getGeschlecht() == 'M' ? "" : "e")  +" Premiumkund" + ((getGeschlecht() == 'M') ? "e." : "in."));
        }
        return istPremiumkunde;
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

    public void bestellungZurueckgeben(String bestellNummer, double bestellWert)
    {
        System.out.println("Subtrahiere eine Bestellung.");
        setAnzahlBestellungen(getAnzahlBestellungen()-1);
        System.out.println("Subtrahiere uebergebenen Bestellwert = " + bestellWert);
        setBisherigesBestellvolumen(getBisherigesBestellvolumen()-bestellWert);
        System.out.println("Bestellung Nr." + bestellNummer + " wurde erfolgreich zurueckgegeben.");
    }

    // Getter
    public char getGeschlecht()
    {
        return geschlecht;
    }

    public String getAnrede()
    {
        return anrede;
    }
}
