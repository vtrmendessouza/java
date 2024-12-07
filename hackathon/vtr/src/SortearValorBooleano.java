import java.util.Random;

public class SortearValorBooleano {

    static boolean sortearValorBooleano() {

        // Criar um objeto Random
        Random random = new Random();
    
        // Retornar o valor sorteado (true ou false)
        return random.nextBoolean();
    }
}