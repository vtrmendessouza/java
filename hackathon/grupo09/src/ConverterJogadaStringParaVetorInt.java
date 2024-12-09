//Maria Eduarda
public class ConverterJogadaStringParaVetorInt {
    
    static int[] converterJogadaStringParaVetorInt(String jogada) {

        String[] partes = jogada.split(";");
        int[] jogadaVetor = new int[2];

        jogadaVetor[0] = Integer.parseInt(partes[0]); // Linha
        jogadaVetor[1] = Integer.parseInt(partes[1]); // Coluna
        return jogadaVetor;
    }
}
/*
Descrição: Utilizado para converter uma jogada no formato xy (linha/coluna)
de string para um vetor de int. Para isto, este método recebe a jogada no
formato string e deve colocar o valor de x dentro do índice 0 do vetor de
inteiro e deve colocar o valor de y dentro do índice 1 do vetor de inteiro.
Após a construção do vetor de inteiro retorne este vetor com o comando
return.
Nível de complexidade: 4 de 10
*/