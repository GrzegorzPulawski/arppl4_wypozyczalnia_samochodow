package hibernatewypozyczalnia;

import hibernatewypozyczalnia.dao.SamochodDao;
import hibernatewypozyczalnia.parser.SamochodParser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SamochodDao samochodDao = new SamochodDao();
        SamochodParser parser = new SamochodParser(scanner, samochodDao);
        parser.parse();
    }
}
