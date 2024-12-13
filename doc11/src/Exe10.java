/*
Para as operações de subtração de Datas e Horas utlizamos 
a classe Period para diferenças entre objetos LocalDate 
e a classe Duration para diferenças entre objetos LocalTime e LocalDateTime.
Diferença entre duas datas
*/

import java.time.LocalDate;
import java.time.Period;

public class Exe10 {
    public static void main(String[] args) {
        // Definir duas datas usando LocalDate
        LocalDate data1 = LocalDate.of(2024, 1, 1); // 1º de janeiro de 2024
        LocalDate data2 = LocalDate.of(2024, 12, 11); // 11 de dezembro de 2024

        // Calcular a diferença entre as duas datas
        Period periodo = Period.between(data1, data2);

        // Exibir a diferença em anos, meses e dias
        System.out.println("Diferença: " + periodo.getYears() + " anos, " + 
                           periodo.getMonths() + " meses e " + 
                           periodo.getDays() + " dias.");
    }
}