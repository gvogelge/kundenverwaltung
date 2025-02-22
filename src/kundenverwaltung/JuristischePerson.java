package kundenverwaltung;

public class JuristischePerson extends Person
{
    private String rechtsform;
    private boolean istKapitalgesellschaft;

    /**
     * Konstruktor der Klasse JuristischePerson.
     *
     * Initialisiert die Attribute einer juristischen Person einschließlich der allgemeinen Attribute aus der Basisklasse Person.
     *
     * @param id                       Die ID einer juristischen Person.
     * @param name                     Der Name der juristischen Person (z. B. "Firma XY").
     * @param strasse                  Die Straße, in der sich die Firma befindet.
     * @param hausnummer               Die Hausnummer der Adresse.
     * @param ort                      Der Ort, an dem sich die Firma befindet.
     * @param plz                      Die Postleitzahl des Standorts der Firma.
     * @param anzahlBestellungen       Die Anzahl der bisherigen Bestellungen der Firma.
     * @param bisherigesBestellvolumen Der Gesamtwert der bisherigen Bestellungen der Firma.
     * @param rechtsform               Die Rechtsform der Firma (z. B. "GmbH", "AG").
     * @param istKapitalgesellschaft   Gibt an, ob die Firma eine Kapitalgesellschaft ist (true/false).
     */
    public JuristischePerson(int id, String name, String strasse, String hausnummer, String ort, String plz, int anzahlBestellungen, double bisherigesBestellvolumen, String rechtsform, boolean istKapitalgesellschaft)
    {
        super(id, name, strasse, hausnummer, ort, plz, anzahlBestellungen, bisherigesBestellvolumen);
        this.rechtsform = rechtsform;
        this.istKapitalgesellschaft = istKapitalgesellschaft;
    }
    /**
     * Gibt die Daten der juristischen Person in tabellarischer Form aus.
     *
     * Die Methode formatiert die Daten der juristischen Person ähnlich wie in einer SQL-Tabelle
     * und gibt diese auf der Konsole aus. Jede Spalte repräsentiert ein Attribut der Firma.
     */
    public void datenAusgeben() {
        System.out.println("+------+----------------------+------------+---------------------------+---------+-------------------+-------------+-------------+----------------+----------------+");
        System.out.println("| ID   | Name                 | Rechtsform | Straße                    | Hausnr. | Ort               | PLZ         | Bestellungen| Bestellvolumen | Kapitalgesell. |");
        System.out.println("+------+----------------------+------------+---------------------------+---------+-------------------+-------------+-------------+----------------+----------------+");
        System.out.printf("| %-4d | %-20s | %-10s | %-25s | %-7s | %-17s | %-11s | %-11d | %-14.2f | %-14s |%n",
                getId(),
                getName(),
                getRechtsform(),
                getStrasse(),
                getHausnummer(),
                getOrt(),
                getPlz(),
                getAnzahlBestellungen(),
                getBisherigesBestellvolumen(),
                getIstKapitalgesellschaft() ? "Ja" : "Nein");
        System.out.println("+------+----------------------+------------+---------------------------+---------+-------------------+-------------+-------------+----------------+----------------+");
    }

    /**
     * Überprüft, ob die juristische Person ein Premiumkunde ist.
     *
     * Eine juristische Person wird als Premiumkunde betrachtet, wenn sie:
     * - Eine Kapitalgesellschaft ist (z. B. GmbH, AG).
     * - Ein Bestellvolumen von mehr als 5000 Euro erreicht hat.
     *
     * @return true, wenn die Firma ein Premiumkunde ist, andernfalls false.
     */
    public boolean istPremiumkunde()
    {
        System.out.println("Pruefe ob Kunde Kapitalgesellschaft ist und das Bestellvolumen min. 5000 betraegt.");
        boolean istPremiumkunde = istKapitalgesellschaft && getBisherigesBestellvolumen() >= 5000;
        if(istPremiumkunde)
        {
            System.out.println(getName() +"\s"+ getRechtsform() + " ist Premiumkunde.");
        }
        else
        {
            System.out.println(getName() +"\s"+ getRechtsform() + " ist kein Premiumkunde.");
        }
        return istPremiumkunde;
    }

    /**
     * Berechnet die Wichtigkeit der Firma für das Unternehmen.
     *
     * Die Berechnung basiert auf dem bisherigen Bestellvolumen und unterscheidet sich je nach Typ der juristischen Person:
     * - Für Kapitalgesellschaften wird das Bestellvolumen mit 2 multipliziert.
     * - Für andere Rechtsformen wird das Bestellvolumen unverändert verwendet.
     *
     * @return Ein Wert (double), der die Wichtigkeit der Firma darstellt.
     */
    public double ermittleWichtigkeit()
    {
        return getBisherigesBestellvolumen() * (istKapitalgesellschaft ? 2 : 1);
    }

    /**
     * Liefert die vollständige Postanschrift der Firma.
     *
     * Die Postanschrift wird in folgendem Format zurückgegeben:
     * "<Name der Firma> <Rechtsform>
     *  <Straße> <Hausnummer>
     *  <PLZ> <Ort>"
     *
     * @return Die vollständige Postanschrift der Firma als String.
     */
    @Override
    public String lieferePostanschrift()
    {
        System.out.println("Liefere Postanschrift.\n");
        return getName() +" "+ rechtsform +"\n"+ getStrasse() +" "+ getHausnummer() +"\n"+ getPlz() +" "+ getOrt();
    }

    //Getter
    public String getRechtsform()
    {
        return rechtsform;
    }

    public boolean getIstKapitalgesellschaft()
    {
        return istKapitalgesellschaft;
    }
}
