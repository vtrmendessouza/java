public class ConverterJogadaStringParaVetorInt {

    //Converte uma jogada no formato "xy" para um vetor de inteiros [x, y].
    //@param jogada String no formato "xy", onde x representa a linha e y representa a coluna.
    //@return Vetor de inteiros contendo [linha, coluna].

    static int[] converterJogadaStringParaVetorInt(String jogada) {

        // Extrai o caractere referente à linha (x) e converte para inteiro
        int linha = Character.getNumericValue(jogada.charAt(0));

        // Extrai o caractere referente à coluna (y) e converte para inteiro
        int coluna = Character.getNumericValue(jogada.charAt(1));

        // Retorna o vetor de inteiros [linha, coluna]
        return new int[] { linha, coluna };
    }
}