/*
Para as operações de subtração de Datas e Horas utlizamos 
a classe Period para diferenças entre objetos LocalDate 
e a classe Duration para diferenças entre objetos LocalTime e LocalDateTime.
Diferença entre duas datas com horas
*/

import java.time.Duration;
import java.time.LocalDateTime;

public class Exe11 {
    public static void main(String[] args) {
        // Definir duas datas/hora usando LocalDateTime
        LocalDateTime data1 = LocalDateTime.of(2024, 12, 10, 10, 30); // 10 de Dezembro de 2024, 10:30
        LocalDateTime data2 = LocalDateTime.of(2024, 12, 11, 15, 45); // 11 de Dezembro de 2024, 15:45

        // Calcular a diferença entre as duas datas
        Duration duration = Duration.between(data1, data2);

        // Obter a diferença em horas
        long horas = duration.toHours();

        // Exibir a diferença
        System.out.println("Diferença em horas: " + horas);
    }
}