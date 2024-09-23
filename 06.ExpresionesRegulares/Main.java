import java.util.regex.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String text = "Sample text with IP 192.168.1.1 and date 12/12/2022. Call (123) 456-7890. Password: Passw0rd!";

        // 1. Extraer todas las direcciones IP de un texto
        extractIPs(text);

        // 2. Validar un número de teléfono
        validatePhoneNumber("978 60 25 63");
        validatePhoneNumber("658 25 25 30");



        // 3. Extraer todas las fechas en formato DD/MM/YYYY
        extractDates(text);

        // 4. Validar una contraseña
        validatePassword("Passw0rd!");

        // 5. Extraer todas las palabras que empiezan con una letra mayúscula
        extractCapitalizedWords(text);
    }

    public static void extractIPs(String text) {
        Pattern pattern = Pattern.compile("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Found IP: " + matcher.group());
        }
    }


        public static void validatePhoneNumber(String phoneNumber) {
            Pattern pattern = Pattern.compile("\\b\\d{2,3} \\d{2,3} \\d{2} \\d{2}\\b");
            Matcher matcher = pattern.matcher(phoneNumber);
            System.out.println("Phone number valid: " + matcher.matches());

    }

    public static void extractDates(String text) {
        Pattern pattern = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Found date: " + matcher.group());
        }
    }

    public static void validatePassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        Matcher matcher = pattern.matcher(password);
        System.out.println("Password valid: " + matcher.matches());
    }

    public static void extractCapitalizedWords(String text) {
        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]*\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Found capitalized word: " + matcher.group());
        }
    }
}

