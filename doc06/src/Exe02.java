/*
Exercício Desafio 02: 25/10/2024 
Em sistemas americanos é muito comum exibir o nome dos usuários no seguinte formato:
MR. RIBEIRO, Rogério para homens se o nome for Rogério de Freitas Ribeiro e
MS. SILVA, Paula para mulheres se o nome for Paula Oliveira da Silva.
onde MR. é a abreviação de Mister ou Senhor em português
onde MS. é a abreviação de Miss ou Senhora/Senhorita em português
O algoritmo abaixo, lê o nome completo do usuário e o sexo e você precisa exibir o nome no formato americano conforme o exemplo anterior.
Dica: Faça o debug de linha a linha do código para entender o seu funcionamento antes de tentar realizar modificações.
*/
import java.util.Scanner;
public class Exe02 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
            String nome, primeiroNome, sobrenome, saudacao;
            char sexo;
            
            System.out.print("Digite o nome: ");
            nome = teclado.nextLine();

            System.out.print("Digite o sexo [f/m]: ");
            sexo = Character.toLowerCase(teclado.nextLine().charAt(0));

            primeiroNome = descobrePrimeiroNome(nome);
            sobrenome = descobreUltimoSobrenome(nome);

            saudacao = (sexo == 'm')? "MR " : "MS ";

            System.out.println(saudacao +
                                sobrenome.toUpperCase() +
                                ", " +
                                primeiroNome.substring(0, 1).toUpperCase() +
                                primeiroNome.substring(1));
            
            teclado.close();
        }
    static String descobreUltimoSobrenome(String nome){
        
        int posEspaco = nome.lastIndexOf(" ");
        String sobrenome = nome.substring(posEspaco + 1);
        return sobrenome;
    }
    static String descobrePrimeiroNome(String nome){

        int posEspaco = nome.indexOf(" ");
        return nome.substring(0, posEspaco);
    }
}