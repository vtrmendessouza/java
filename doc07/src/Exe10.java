/*
10: A prefeitura de uma cidade precisa fazer uma pesquisa entre seus habitantes, 
coletando dados sobre o salário e número de filhos.
O algoritmo deve ler os dados de vários habitantes. 
Após a leitura dos dados de um habitante o usuário responde 
se ele deseja inserir os dados s ou n de um novo habitante. 
A prefeitura deseja saber:
a) média do salário da população;
b) média do número de filhos;
c) maior salário;
d) percentual de pessoas com salário até R$ 1000,00.
*/
import java.util.Scanner;
public class Exe10 {
        public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        int salario = 0, somaSalario = 0, quantidadeSalario = 0, mediaSalario = 0, maiorSalario = 0,
        filho = 0, somaFilho = 0, quantidadeFilho = 0, mediaFilho = 0;
        float quantidadeSalarioAte1000 = 0, percentualSalarioAte1000;
        char resposta = 's';
        
        while(resposta == 's'){
            System.out.printf("informe o valor do salário: ");
            salario = teclado.nextInt();
            System.out.printf("informe a quantidade de filhos: ");
            filho = teclado.nextInt();

            somaSalario = somaSalario + salario;
            quantidadeSalario ++;
            somaFilho = somaFilho + filho;
            quantidadeFilho ++;

            if(salario > maiorSalario){
                maiorSalario = salario;
            }
            if (salario <= 1000){
                quantidadeSalarioAte1000 ++;
            }
            System.out.printf("Deseja continuar? s/n: ");
            resposta = teclado.next().charAt(0);
        }
        mediaSalario = somaSalario / quantidadeSalario;
        mediaFilho = somaFilho / quantidadeFilho;
        percentualSalarioAte1000 = quantidadeSalarioAte1000 / quantidadeSalario * 100;
        System.out.printf("Média salarial: %d\n", mediaSalario);
        System.out.printf("Média de filhos: %d\n", mediaFilho);
        System.out.printf("Maior salário: %d\n", maiorSalario);
        System.out.printf("Percentual de pessoas com salário até R$ 1000,00: %.2f%%\n", percentualSalarioAte1000);
        teclado.close();
    }    
}