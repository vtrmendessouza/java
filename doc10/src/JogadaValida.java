//Maria Eduarda
public class JogadaValida {

    static boolean jogadaValida(String posicoesLivres, int linha, int coluna) {

        // Formata a jogada na forma "linha,coluna"
        String jogada = linha + "," + coluna;
    
        // Verifica se a jogada está presente na string de posições livres
        return posicoesLivres.contains(jogada);
    }
}
/*
Descrição: Utilizado para validar se a jogada do usuário é uma jogada válida.
Uma jogada é considerada válida quando ela está presente dentro da lista de
posicoesLivres. Desta forma, o método recebe a string com as posições livres,
além da linha e coluna jogada pelo usuário. O método verifica se a linha e
coluna está presente dentro da string de posições livres, se estiver retorna
true se não retorna false. Para descobrir se a linha e coluna esta presente
dentro da lista de posições livres pense em usar método contanis da string.
Nível de complexidade: 3 de 10
*/