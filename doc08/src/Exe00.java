/*
Desafio: Sistema de Controle de Habitantes
O código abaixo realiza a leitura de múltiplos nomes, 
salarios e qtde de dependentes de uma determinada cidade.
Faça ajustes no código para ao término da impressão dos dados dos habitantes, 
seja impresso na tela:
- A média dos salarios dos habitantes.
Exemplo: 
Média dos salários: R$ 2780,22
- A média de dependentes.
Exemplo:
Média de dependentes: 2,7 dependentes por habitante.
- O nome do habitante que tem a menor quantidade de dependentes. 
Além do nome imprima também a quantidade de dependentes deste habitante. 
Não se preocupe se existir empate na quantidade mínima de habitantes. 
Exemplo:
Habitante com a menor quantidade de dependentes: Carlos
Quantidade de dependentes do Carlos: 1
- O nome do habitante que tem o maior salário. 
Além do nome imprima também o valor do salário deste habitante.
Exemplo: 
Nome do habitante com maior salário: José
Valor do salário do José: R$ 4200,58
- Imprima o nome e a quantidade de dependentes dos habitantes que possuem 
o número de dependentes menor que a média geral de dependentes por habitante.
Exemplo:
Nome                             Qtde de Dependentes
Mário                              1
Maria                              1
Marcelo                          2
Roberto                          0
- Este código possui um problema, foi estipulado que serão 20 espaços para imprimir a coluna de nome. 
Se um usuário tiver mais de 20 caracteres no nome a formatação ficará incorreta. 
Você deve fazer uma correção na impressão do nome da seguinte forma: 
Se o usuário tiver mais de 19 caracteres você deverá retirar três caracteres no fim do nome 
e terminar com ... no nome.
Exemplo:
Rogério de Freitas Ribeiro deve ficar
Rogério de Freit...
*/
import java.util.Scanner;
public class Exe00 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);     

        //declaramos e já inicializamos as 
        //variaveis com 400 posicoes vazias
        String nomes[] = new String[400];
        int numeroDeps[] = new int[400];
        float salarios[] = new float[400];

        String nomesMenorNumeroDeps[] = new String[400];
        int menorNumeroDeps[] = new int[400];

        //variavel utilizada para armazenar a ultima posicao preenchida do vetor
        int ultimaPosicaoGravada = 0 ;

        //variavel para guardar a resposta do usuario se ele deseja digitar os dados de um novo habitante
        char resposta; 

        //leitura dos habitantes e gravacao na memoria (vetores)
        for (int posicaoVetor = 0; posicaoVetor < 400; posicaoVetor++) {
    
            nomes = lerNome(teclado, nomes, posicaoVetor);
            salarios = lerSalario(teclado, salarios, posicaoVetor);
            numeroDeps = lerDependentes(teclado, numeroDeps, posicaoVetor);

            System.out.print("\nDeseja entrar com dados do próximo habitante [s/n]: ");
            resposta = teclado.nextLine().toLowerCase().charAt(0);
            
            if (resposta == 'n'){
                ultimaPosicaoGravada = posicaoVetor;               
                break;
            }
        }
        imprimirDados(nomes, salarios, numeroDeps, ultimaPosicaoGravada);
        teclado.close();
    }
    static void imprimirDados(String nomes[], float salarios[], int numeroDeps[], int ultimaPosicaoGravada){
        //acessando os dados para imprimir na tela
        int qtdeEspacos;
        System.out.println("\nNome                Salario                QtdeDependentes");
        System.out.println("----------------------------------------------------------");
        
        for (int posicaoVetor = 0; posicaoVetor <= ultimaPosicaoGravada; posicaoVetor++) {
            //imprime o nome do habitante
            System.out.print(nomes[posicaoVetor]);
            
            //calcula quantos espacos sao necessarios para alinhar o valor do salario na posicao da coluna salario
            qtdeEspacos = (20 - nomes[posicaoVetor].length());
            //imprime a quantidade de espacos para alinhar os salarios
            System.out.print(geraEspacos(qtdeEspacos));

            //imprime o salario
            System.out.print("R$ " + salarios[posicaoVetor]);

            //calcula quantos espacos sao necessarios para alinhar a quantidade de dependentes
            qtdeEspacos = (20 - Float.toString(salarios[posicaoVetor]).length());

            //imprime os espacos
            System.out.print(geraEspacos(qtdeEspacos));

            //imprime a quantidade de dependentes
            System.out.println(numeroDeps[posicaoVetor]);
        }
        mediaSalario(salarios, ultimaPosicaoGravada);
        mediaDependente(numeroDeps, ultimaPosicaoGravada);
        menorDependente(numeroDeps, nomes, ultimaPosicaoGravada);
        maiorSalario(salarios, nomes, ultimaPosicaoGravada);
    }
    static String geraEspacos(int qtde){
        String espacos = "";

        for (int i = 0; i < qtde; i++) {
            espacos += " ";
        }
        return espacos;
    }
    static String[] lerNome(Scanner teclado, String nomes[], int posicaoLivre){
        System.out.print("Digite o nome do habitante: ");
        nomes[posicaoLivre] = teclado.nextLine(); 
        return nomes;
    }
    static float[] lerSalario(Scanner teclado, float salarios[], int posicaoLivre){
        System.out.print("Digite o salario R$: ");
        salarios[posicaoLivre] = teclado.nextFloat(); 
        
        //resolve o problema da limpeza do buffer
        teclado.nextLine();
        return salarios;
    }
    static int[] lerDependentes(Scanner teclado, int numeroDeps[], int posicaoLivre){
        System.out.print("Digite a quantidade de dependentes: ");
        numeroDeps[posicaoLivre] = teclado.nextInt(); 

        //resolve o problema da limpeza do buffer
        teclado.nextLine();
        return numeroDeps;
    }
    static void mediaSalario (float salarios[], int ultimaPosicaoGravada){
        float media = 0;

        for(int i = 0; i < ultimaPosicaoGravada + 1; i++){
            media += salarios[i];
        }
        media = media / (ultimaPosicaoGravada + 1);
        System.out.printf("\nMédia salarial: R$ %.2f\n", media);
    }
    static void mediaDependente (int numeroDeps[], int ultimaPosicaoGravada){
        float media = 0;

        for(int i = 0; i < ultimaPosicaoGravada + 1; i++){
            media += numeroDeps[i];
        }
        media = media / (ultimaPosicaoGravada + 1);
        System.out.printf("Média de dependentes: %.1f dependentes por habitante.\n", media);
    }
    static void menorDependente (int numeroDeps[], String nomes[], int ultimaPosicaoGravada){
        String nome = "";
        int quantidade = 0;

        for(int i = 0; i < ultimaPosicaoGravada + 1; i++){
            if(i == 0){
                nome = nomes[i];
                quantidade = numeroDeps[i];
            }
            else if(numeroDeps[i] < quantidade){
                nome = nomes[i];
                quantidade = numeroDeps[i];
            }
        }
        System.out.println("Habitante com a menor quantidade de dependentes: " + nome);
        System.out.println("Quantidade de dependentes de " + nome + ": " + quantidade);
    }
    static void maiorSalario (float salarios[], String nomes[], int ultimaPosicaoGravada){
        String nome = "";
        float valor = 0;

        for(int i = 0; i < ultimaPosicaoGravada + 1; i++){
            if(i == 0){
                nome = nomes[i];
                valor = salarios[i];
            }
            else if(salarios[i] > valor){
                nome = nomes[i];
                valor = salarios[i];
            }
        }
        System.out.println("Nome do habitante com maior salário: " + nome);
        System.out.print("Valor do salário de " + nome + " R$: ");
        System.out.printf("%.2f\n", valor);
    }
    static void vetorMenorNumeroDeps(int numeroDeps[], String nomes[], int ultimaPosicaoGravada, float mediaDependente, int menorNumeroDeps[], String nomesMenorNumeroDeps[]){
        int contador = 0;

        for(int i = 0; i < ultimaPosicaoGravada; i++){
            if(numeroDeps[i] < mediaDependente){
                menorNumeroDeps[contador] = numeroDeps[i];
                nomesMenorNumeroDeps[contador] = nomes[i];
                contador++;
            }
        }
    }
}
