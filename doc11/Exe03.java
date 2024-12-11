//Para Hora:

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Exe03 {
    public static void main(String[] args) {
        String horaString = "14:30"; // Exemplo de string no formato "HH:mm"
        
        try {
            LocalTime hora = LocalTime.parse(horaString);
            System.out.println("Hora: " + hora);
        } catch (DateTimeParseException e) {
            System.out.println("Erro ao fazer o parsing da hora: " + e.getMessage());
        }
    }
}