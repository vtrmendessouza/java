/*
Exercício Desafio 03: 25/10/2024
Atualmente muitos sistemas forçam o usuário a escolher uma senha que seja complexa o suficiente, 
para que outras pessoas não consiguam descobrir a senha por tentativa e erro.
Você iniciará a construção de um sistema de validação de requisitos obrigatórios de senha.
Inicialmente o seu trabalho é identificar a quantidade de caracteres maiúsculos, 
caracteres especiais e dígitos, além de descobrir se a senha do usuário possui partes do nome.
Altere o código para para que o programa consiga identificar a qtde de caracteres especiais, 
a quantidade de dígitos e se a senha possui partes do nome.
Ex:  Se a senha do usuário for rogerio123 o sistema deve retornar:
A senha possui: 0 caracteres maiúsculos.
A senha possui: 3 caracteres dígitos.
A senha possui partes do nome.
Ex. Se a senha do usuário for freitAbc$1 o sistema deve retornar:
A senha possui: 1 caracteres maiúsculos.
A senha possui: 1 dígitos.
A senha não possui partes do nome.
Dica: Faça o debug de linha a linha do código para entender o seu funcionamento antes de tentar realizar modificações.
*/
import java.util.Scanner;
public class Exe03 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        int qtdeMaiusculas, qtdeDigitos, qtdeEspeciais;
        boolean temPartesDoNome;
        String senha, nome;

        System.out.print("Digite seu nome: ");
        nome = teclado.nextLine();

        System.out.print("Digite sua senha: ");
        senha = teclado.nextLine();

        qtdeMaiusculas = identificaQtdeMaiusculas(senha);
        System.out.println("A senha possui: " + qtdeMaiusculas + " caractere(s) maiúsculos.");

        qtdeDigitos = identificaQtdeDigitos(senha);
        System.out.println("A senha possui: " + qtdeDigitos + " dígito(s).");
        
        qtdeEspeciais = identificaQtdeEspeciais(senha);
        System.out.println("A senha possui: " + qtdeEspeciais + " caractere(s) especiais.");

        temPartesDoNome = identificaSeSenhaTemPartesNome(senha, nome);

        if (temPartesDoNome){
            System.out.println("A senha possui partes do nome do usuário");
        } else {
            System.out.println("A senha não possui partes do nome do usuário.");
        }
        teclado.close();
    }
    static int identificaQtdeMaiusculas(String senha){
        int qtde = 0, posicao = 0;
        char caractere;

        do{
            caractere = senha.charAt(posicao);
            if (caractere >= 65 && caractere <= 90){
                qtde++;
            }
            posicao++;
        }
        while(posicao < senha.length());
        return qtde;
    }
    static int identificaQtdeDigitos(String senha){
        int qtde = 0, posicao = 0;
        char caractere;

        do{
            caractere = senha.charAt(posicao);
            if (caractere >= 48 && caractere <= 57){
                qtde++;
            }
            posicao++;
        }
        while(posicao < senha.length());
        return qtde;
    }
    static int identificaQtdeEspeciais(String senha){
        int qtde = 0, posicao = 0;
        char caractere;

        do{
            caractere = senha.charAt(posicao);
            if (caractere >= 33 && caractere <= 47){
                qtde++;
            }
            posicao++;
        }
        while(posicao < senha.length());
        return qtde;
    }
    static boolean identificaSeSenhaTemPartesNome(String senha, String nome){
        boolean temPartesNome = false;
        char caractereNome, caractereSenha;

        for(int i = 0; i < nome.length(); i++){
            caractereNome = nome.charAt(i);
            for(int j = 0; j < senha.length(); j++){
                caractereSenha = senha.charAt(j);
                if (caractereNome == caractereSenha){
                    temPartesNome = true;
                }
            }
        }
        return temPartesNome;
    }
}