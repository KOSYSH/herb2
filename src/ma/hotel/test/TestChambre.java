/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.hotel.test;

import java.util.Scanner;
import ma.hotel.entities.Chambre;
import ma.hotel.entities.Hotel;
import ma.hotel.entities.TypeChambre;
import ma.hotel.services.ChambreService;
import ma.hotel.services.HotelService;

/**
 *
 * @author kosysh
 */
public class TestChambre {

    public static void main(String[] args) {
        HotelService hs = new HotelService();
        ChambreService cs = new ChambreService();

        Hotel bouarfa = new Hotel("Hotel Bouarfa", "Bouarfa");
        Hotel oujda = new Hotel("Hotel Oujda", "Oujda");
        Hotel andalous = new Hotel("Hotel Andalous", "Marrakech");
        Hotel gods = new Hotel("Hotel Gods", "Rabat");

        hs.create(bouarfa);
        hs.create(oujda);
        hs.create(andalous);
        hs.create(gods);

        cs.create(new Chambre(250, TypeChambre.SIMPLE, true, bouarfa));
        cs.create(new Chambre(400, TypeChambre.DOUBLE, false, bouarfa));
        cs.create(new Chambre(500, TypeChambre.F1, true, bouarfa));
        cs.create(new Chambre(550, TypeChambre.F2, false, bouarfa));
        cs.create(new Chambre(650, TypeChambre.SUITE, true, bouarfa));

        cs.create(new Chambre(300, TypeChambre.SIMPLE, true, oujda));
        cs.create(new Chambre(450, TypeChambre.DOUBLE, true, oujda));
        cs.create(new Chambre(500, TypeChambre.F1, false, oujda));
        cs.create(new Chambre(600, TypeChambre.F2, false, oujda));
        cs.create(new Chambre(700, TypeChambre.SUITE, true, oujda));

        cs.create(new Chambre(280, TypeChambre.SIMPLE, true, andalous));
        cs.create(new Chambre(350, TypeChambre.DOUBLE, true, andalous));
        cs.create(new Chambre(480, TypeChambre.F1, false, andalous));
        cs.create(new Chambre(550, TypeChambre.F2, false, andalous));
        cs.create(new Chambre(800, TypeChambre.SUITE, false, andalous));

        cs.create(new Chambre(220, TypeChambre.SIMPLE, true, gods));
        cs.create(new Chambre(600, TypeChambre.DOUBLE, false, gods));
        cs.create(new Chambre(300, TypeChambre.F1, true, gods));
        cs.create(new Chambre(450, TypeChambre.F2, true, gods));
        cs.create(new Chambre(900, TypeChambre.SUITE, false, gods));

        System.out.println();
        System.out.println("Hotel: Hotel Bouarfa");
        System.out.println("Chambres:");
        for (Chambre chambre : hs.findById(bouarfa.getId()).getChambres()) {
            System.out.println("  " + chambre);
        }

        System.out.println();
        System.out.println("Hotel: Hotel Oujda");
        System.out.println("Chambres:");
        for (Chambre chambre : hs.findById(oujda.getId()).getChambres()) {
            System.out.println("  " + chambre);
        }

        System.out.println();
        System.out.println("Hotel: Hotel Andalous");
        System.out.println("Chambres:");
        for (Chambre chambre : hs.findById(andalous.getId()).getChambres()) {
            System.out.println("  " + chambre);
        }

        System.out.println();
        System.out.println("Hotel: Hotel Gods");
        System.out.println("Chambres:");
        for (Chambre chambre : hs.findById(gods.getId()).getChambres()) {
            System.out.println("  " + chambre);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.print("Entrez l'etat (libre/occupee) : ");
        String etatSaisi = scanner.nextLine();

        boolean etat;
        if (etatSaisi.equalsIgnoreCase("libre")) {
            etat = true;
        } else {
            etat = false;
        }

        System.out.print("Entrez le prix : ");
        double prix = scanner.nextDouble();

        System.out.println("Chambres trouvees");
        for (Chambre chambre : cs.findByEtatAndPrix(etat, prix)) {
            System.out.println("  " + chambre);
        }
    }
}
