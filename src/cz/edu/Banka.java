package cz.edu;

import java.io.PrintWriter;

public class Banka {
    private String nazev;
    private Ucet[] ucty;
    private int aktualniPocetUctu;
    private int maximalniPocetUctu;

    public Banka(String nazev, int maximalniPocetUctu) {
        this.nazev = nazev;
        this.aktualniPocetUctu = 0;
        this.ucty = new Ucet[maximalniPocetUctu];
        this.maximalniPocetUctu = maximalniPocetUctu;
    }

    void najdiNejchudsiUcet() {
        if (aktualniPocetUctu != 0) {
            Ucet minUcet = ucty[0];
            for (int i = 0; i < aktualniPocetUctu; i++) {
                if (ucty[i].dejStavUctu() < minUcet.dejStavUctu()) {
                    minUcet = ucty[i];
                }
            }
            System.out.println("Nejchudsi ucet: " + minUcet);
        } else {
            System.out.println("Zadne ucty k dispozici");
        }
    }

    void najdiNejbohatsiUcet() {
        if (aktualniPocetUctu != 0) {
            Ucet maxUcet = ucty[0];
            for (int i = 0; i < aktualniPocetUctu; i++) {
                if (ucty[i].dejStavUctu() > maxUcet.dejStavUctu()) {
                    maxUcet = ucty[i];
                }
            }
            System.out.println("Nejbohatsi ucet: " + maxUcet);
        } else {
            System.out.println("Zadne ucty k dispozici");
        }
    }

    void celkemNaUctech() {
        double suma = 0;
        for (int i = 0; i < aktualniPocetUctu; i++) {

            suma += ucty[i].dejStavUctu();
        }
        System.out.println("Celkem na uctech je: " + suma);
    }

    void prumernyStavUctu() {
        double suma = 0;
        for (int i = 0; i < aktualniPocetUctu; i++) {
            suma += ucty[i].dejStavUctu();
        }
        System.out.println("Prumerny stav uctu je: " + suma / aktualniPocetUctu);
    }

    void zalozUcet(String kod, double prvniVklad, boolean jeKontokorent) {
        if (aktualniPocetUctu != maximalniPocetUctu) {
            if (najdiUcet(kod) == null) {
                Ucet ucet = new Ucet(kod, prvniVklad, jeKontokorent);
                ucty[aktualniPocetUctu++] = ucet;
                System.out.println("Ucet zalozen: " + ucet);
            } else {
                System.out.println("Ucet s kodem '" + kod + "' jiz existuje");
            }
        } else {
            System.out.println("Nelze zalozit, dosazeno maxima poctu uctu.");
        }
    }


    void vlozPenize(double castka, String kod) {
        Ucet ucet = najdiUcet(kod);
        if (existujeUcet(ucet, kod)) {
            ucet.vlozPenize(castka);
        }
    }

    void vyberPenize(double castka, String kod) {
        Ucet ucet = najdiUcet(kod);
        if (existujeUcet(ucet, kod)) {
            ucet.vyberPenize(castka);
        }
    }

    void vypisUcet(String kod) {
        Ucet ucet = najdiUcet(kod);
        if (existujeUcet(ucet, kod)) {
            System.out.println(ucet);
        }
    }

    private Ucet najdiUcet(String kod) {
        for (int i = 0; i < aktualniPocetUctu; i++) {
            if (ucty[i].dejKod().equals(kod)) {
                return ucty[i];
            }
        }
        return null;
    }

    private boolean existujeUcet(Ucet ucet, String kod) {
        if (ucet != null) {
            return true;
        } else {
            System.out.println("Ucet s kodem '" + kod + "' nenalezen.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Banka{" +
                "nazev='" + nazev + '\'' +
                '}';
    }
    public static void save(Banka banka, PrintWriter write, String kod){
        write.printf(banka.najdiUcet(kod).toString());

    }

}
