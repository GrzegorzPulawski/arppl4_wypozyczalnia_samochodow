package hibernatewypozyczalnia.parser;

import hibernatewypozyczalnia.dao.SamochodDao;
import hibernatewypozyczalnia.model.Samochod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SamochodParser {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final Scanner scanner;
    private final SamochodDao dao;

    public SamochodParser(Scanner scanner, SamochodDao dao) {
        this.scanner = scanner;
        this.dao = dao;
    }
    public void parse() {
        String komenda;
        do {
            System.out.println("Komendy");
            komenda = scanner.next();
            if (komenda.equalsIgnoreCase("Dodaj")) {
                komendaDodaj();
            }else if (komenda.equalsIgnoreCase("Wylistuj")){
                komendaWylistuj();
            } else if (komenda.equalsIgnoreCase("Usuń")) {
                komendaUsun();

            }

        } while (!komenda.equals(("quit")));

    }
    private void komendaUsun(){
        System.out.println("Wprowadź id samochodu. który chcesz usunac");
        Long id = scanner.nextLong();
    }
    private void komendaDodaj() {
        System.out.println("Wprowadz nazwę:");
        String name = scanner.next();

        System.out.println("Wprowadz markę");
        String marka = scanner.next();

        LocalDate dataProdukcji = wprowadzDateProdukcji();

        System.out.println("Wprowadz typ nadwozia:");
        String TypNadwozia = scanner.next();

        LocalDateTime dataWypozyczenia = wprowadzDateWypozyczenia();

        System.out.println("Wprowadz ilosc pasażerów");
        Integer iloscpasazerow = scanner.nextInt();

        Samochod samochod = new Samochod(null, nazwa, marka, dataprodukcji, TypNadwozia, iloscpasazerow)

}

    private LocalDateTime wprowadzDateWypozyczenia() {
    }

    private LocalDate wprowadzDateProdukcji() {
    }



