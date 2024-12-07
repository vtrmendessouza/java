public class ObterJogadaUsuario {

    //Verifica se a jogada do usuário é válida, ou seja, se está presente na lista de posições livres.
    //@param posicoesLivres = String contendo as posições livres no formato "xy;xy;..."
    //@param linha = Linha escolhida pelo jogador.
    //@param coluna = Coluna escolhida pelo jogador.
    //@return true se a jogada for válida, false caso contrário.
 
    static boolean jogadaValida(String posicoesLivres, int linha, int coluna) {
        // Constrói a representação da posição no formato "xy"
        String posicaoJogada = linha + "" + coluna;

        // Verifica se a posição está contida na string de posições livres
        return posicoesLivres.contains(posicaoJogada);
    }
}