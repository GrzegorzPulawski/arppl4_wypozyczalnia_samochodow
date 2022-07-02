package hibernatewypozyczalnia.parser;

import hibernatewypozyczalnia.dao.SamochodDao;
import hibernatewypozyczalnia.model.Samochod;
import hibernatewypozyczalnia.model.TypNadwozia;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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

    private void komendaWylistuj() {
        List<Samochod> samochodList = dao.zwrocListeSamochodow();
        for (Samochod samochod : samochodList) {
            System.out.println(samochod);
        }
    }

    private void komendaUsun(){
        System.out.println("Wprowadź id samochodu. który chcesz usunac");
        Long id = scanner.nextLong();
    }
    private void komendaDodaj() {
        System.out.println("Wprowadz nazwę:");
        String nazwa = scanner.next();

        System.out.println("Wprowadz markę");
        String marka = scanner.next();

        LocalDate dataProdukcji = wprowadzDateProdukcji();

        TypNadwozia typNadwozia = wybierzTypNadwozia();

        System.out.println("Wprowadz ilosc pasażerów");
        Integer iloscpasazerow = scanner.nextInt();

        Samochod samochod = new Samochod(null, nazwa, marka, dataProdukcji,typNadwozia, iloscpasazerow);
        dao.dodajSamochod(samochod);
}

    private TypNadwozia wybierzTypNadwozia() {
        TypNadwozia typNadwozia = null;
        do {
            try {
                System.out.println("Wybierz typ nadwozia(SEDAN,CABRIO,SUV):");
                String unitString = scanner.next();

                typNadwozia = TypNadwozia.valueOf(unitString.toUpperCase());
            } catch (IllegalArgumentException iae) {

                System.out.println("Niepoprawny typ, wprowadż ponownie:...");
            }
        } while (typNadwozia == null);
        return typNadwozia;
    }
    


    private LocalDate wprowadzDateProdukcji() {
        LocalDate dataProdukcji = null;
        do {
            try {
                System.out.println("Wprowadz datę produkcji:");
                String expiryDateString = scanner.next();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                dataProdukcji = LocalDate.parse(expiryDateString, FORMATTER);

            } catch (IllegalArgumentException iae) {
                System.err.println("Zła data, wprowadz w formacie: yyyy-MM-dd");
            }
        } while (dataProdukcji == null);
        return dataProdukcji;
    }
    }
    



