package cz.edu;

public class Ucet {
    private final String kod;
    private double stavUctu;
    private final boolean jeKontokorent;

    public Ucet(String kod, double stavUctu, boolean jeKontokorent) {
        this.kod = kod;
        this.stavUctu = stavUctu;
        this.jeKontokorent = jeKontokorent;
    }

    String dejKod() {
        return kod;
    }

    double dejStavUctu() {
        return stavUctu;
    }

    boolean jeKontokorent() {
        return jeKontokorent;
    }

    void vlozPenize(double castka) {
        stavUctu += castka;
        System.out.println(kod + ": Vlozeno " + castka + ". Aktualni stav: " + stavUctu);
    }

    void vyberPenize(double castka) {
        if (castka <= stavUctu || jeKontokorent) {
            stavUctu -= castka;
            System.out.println(kod + ": Vybrano " + castka + ". Aktualni stav: " + stavUctu);
        } else {
            System.out.println("Nelze vybrat " + castka + ". Nedostatecny stav na uctu: " + stavUctu);
        }
    }


    @Override
    public String toString()
    {
        return  kod +";" + stavUctu +";"+jeKontokorent + ";\n" ;
    }
}
