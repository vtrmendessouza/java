/*
Exercício Desafio 01: 25/10/2024
O código abaixo recebe um nome completo de uma pessoa e interage com cada palavra deste nome.
Você deve fazer com que o nome e os sobrenomes sejam convertidos para a primeira letra em maiúsculo.
Ou seja, se o nome fornecido for: rogerio de freitas ribeiro, o resultado deverá ser 
Rogério de Freitas Ribeiro
Note que os conectores do, da e outros não devem ser convertidos para maíusculos.
do - utilizado para indicar posse ou origem, como em "João do Brasil".
da - similar ao "do", mas usado com nomes femininos, como em "Maria da Silva".
de - usado para indicar origem ou pertencimento, como em "Carlos de Souza".
e - usado para ligar dois nomes, como em "Ana e Pedro".
dos - forma plural de "do", como em "André dos Santos".
das - forma plural de "da", como em "Lúcia das Dores".
Dica: Faça o debug de linha a linha do código para entender o seu funcionamento 
antes de tentar realizar modificações.
*/
import java.util.Scanner;
public class Exe01 {
    public static void main(String[] args) throws Exception {
        String nome;
        Scanner teclado = new Scanner(System.in);
        int posicaoAtual = 0;
        int posicaoAnterior = 0;
        int tamanhoNome;

        String novoNome = "";
        String palavra = "";
            
        System.out.print("Digite o nome: ");
        nome = teclado.nextLine();

        //quantidade de caracteres
        tamanhoNome = nome.length();

        do {
            //encontra o primeiro espaço a partir de uma determinada posição
            posicaoAtual = nome.indexOf(" ", posicaoAnterior);

            //para evitar erro quando estiver extraindo
            //o ultimo sobrenome
            if (posicaoAtual == -1){
                posicaoAtual = tamanhoNome;  
            }
            palavra = nome.substring(posicaoAnterior, posicaoAtual);
            switch (palavra) {
                case "do":
                case "da":
                case "de":
                case "e":
                case "dos":
                case "das":
                    novoNome += palavra + " ";
                    break;
    
                default:
                    //converte a primeira em maiúsculo e concaatena com o resto da palavra
                    novoNome += palavra.substring(0, 1).toUpperCase() + palavra.substring(1) + " ";
                    break;
                }
        posicaoAnterior = posicaoAtual + 1;
        }
        while (posicaoAtual <  tamanhoNome);

        System.out.println(novoNome);
        teclado.close();
    }
}