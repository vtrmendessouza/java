//Maria Eduarda
public class ConverterJogadaStringParaVetor {
    
    static int[] converterJogadaStringParaVetorInt(String jogada) {

        String[] partes = jogada.split(",");
        int[] jogadaVetor = new int[2];

        jogadaVetor[0] = Integer.parseInt(partes[0]); // Linha
        jogadaVetor[1] = Integer.parseInt(partes[1]); // Coluna
        return jogadaVetor;
    }
}