/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.hotel.test;

import ma.hotel.entities.Chambre;
import ma.hotel.entities.Hotel;
import ma.hotel.services.HotelService;

/**
 *
 * @author kosysh
 */
public class TestHotel {

    public static void main(String[] args) {
        HotelService hs = new HotelService();

        System.out.println("Hotels avec leurs chambres");
        for (Hotel hotel : hs.findAll()) {
            System.out.println();
            System.out.println("Hotel: " + hotel.getNom()
                    + " - " + hotel.getAdresse());
            System.out.println("Chambres:");

            for (Chambre chambre : hotel.getChambres()) {
                System.out.println("  " + chambre);
            }
        }
    }
}
