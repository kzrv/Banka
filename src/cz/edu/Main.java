package cz.edu;

import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Banka banka = new Banka("Mein Bank", 10);

        banka.zalozUcet("1", 10, false);
        banka.zalozUcet("2", 15, false);
        banka.zalozUcet("3", 5, true);

        try(PrintWriter write = new PrintWriter("ucty.txt")){
                banka.save(banka, write, "1");
                banka.save(banka, write, "2");
                banka.save(banka, write, "3");
        }
            catch(IOException e){
                System.out.println("pizdec");

        }
        banka.najdiNejbohatsiUcet();
        banka.najdiNejchudsiUcet();

        banka.prumernyStavUctu();
        banka.celkemNaUctech();

        banka.vlozPenize(45, "2");
        banka.vyberPenize(45, "1");
        banka.vyberPenize(45, "3");
        banka.najdiNejchudsiUcet();
        banka.najdiNejbohatsiUcet();

        banka.prumernyStavUctu();
        banka.celkemNaUctech();

    }

}
