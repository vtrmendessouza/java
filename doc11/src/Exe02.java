//ou quando a data não está no formato americano yyyy-mm-dd é necessário utilizar a classe DateTimeFormatter.

import java.time.LocalDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Exe02 {
    public static void main(String[] args) {
        // String no formato dd/MM/yyyy
        String dataString = "11/12/2024"; 
        
        try {
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
           LocalDate localDate = LocalDate.parse(dataString, formatter);
           System.out.println(localDate); // Exemplo: 2024-12-11
        } catch (DateTimeParseException e) {
            System.out.println("Erro ao converter a string para data: " + e.getMessage());
        }
    }
}