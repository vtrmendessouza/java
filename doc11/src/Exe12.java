/*
Para as operações de subtração de Datas e Horas utlizamos 
a classe Period para diferenças entre objetos LocalDate 
e a classe Duration para diferenças entre objetos LocalTime e LocalDateTime.
Diferença entre duas horas
*/

import java.time.Duration;
import java.time.LocalTime;

public class Exe12 {
    public static void main(String[] args) {
        // Definir duas horas usando LocalTime
        LocalTime hora1 = LocalTime.of(10, 30); // 10:30
        LocalTime hora2 = LocalTime.of(15, 45); // 15:45

        // Calcular a diferença entre as duas horas
        Duration duration = Duration.between(hora1, hora2);

        // Obter a diferença em horas
        long horas = duration.toHours();
        
        // Obter a diferença em minutos
        long minutos = duration.toMinutes() % 60;

        // Exibir a diferença
        System.out.println("Diferença em horas: " + horas);
        System.out.println("Diferença em minutos: " + minutos);
    }
}