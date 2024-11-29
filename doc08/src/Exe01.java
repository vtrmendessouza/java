//14/11/2024 - 33º ENCONTRO
import java.util.InputMismatchException;
import java.util.Scanner;
public class Exe01 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);     
        //declaramos e já inicializamos as 
        //variaveis com 400 posicoes vazias
        String nomes[] = new String[400];
        int numeroDeps[] = new int[400];
        float salarios[] = new float[400];
        //variavel utilizada para armazenar a ultima posicao preenchida do vetor
        int ultimaPosicaoGravada = 0 ;
        //variavel para guardar a resposta do usuario se ele deseja digitar os dados de um novo habitante
        char resposta; 
        //leitura dos habitantes e gravacao na memoria (vetores)
        for (int posicaoVetor = 0; posicaoVetor < 400; posicaoVetor++) {
            boolean flag = false;
            nomes = lerNome(teclado, nomes, posicaoVetor);
            salarios = lerSalario(teclado, salarios, posicaoVetor);
            numeroDeps = lerDependentes(teclado, numeroDeps, posicaoVetor);
            do{
                System.out.print ("Deseja entrar com dados do próximo habitante? [s/n]: ");
                resposta = teclado.nextLine().toLowerCase().charAt(0);
                if (resposta == 'n'){
                    ultimaPosicaoGravada = posicaoVetor;
                    flag = true;              
                }
                else if(resposta != 's' && resposta != 'n'){
                    System.out.println("Opção inválida.");
                }
            }
            while(resposta != 's' && resposta != 'n');
            if(flag){
                break;
            }
        }
        float mediaSalario = calcularMediaSalario(salarios, ultimaPosicaoGravada);
        float mediaDeps = calcularMediaDeps(numeroDeps, ultimaPosicaoGravada);
        int posicaoMaiorDeps = encontrarMaiorDeps(numeroDeps, ultimaPosicaoGravada);
        int posicaoMenorDeps = encontrarMenorDeps(numeroDeps, ultimaPosicaoGravada);
        int posicaoMaiorSalario = encontrarMaiorSalario(salarios, ultimaPosicaoGravada);
        int posicaoMenorSalario = encontrarMenorSalario(salarios, ultimaPosicaoGravada);
        imprimirDados(nomes, salarios, numeroDeps, ultimaPosicaoGravada);
        imprimirDadosSalarios(mediaSalario, posicaoMaiorSalario, posicaoMenorSalario, nomes, salarios);
        imprimirMaiorSalario(nomes, salarios, ultimaPosicaoGravada, mediaSalario);
        imprimirMenorSalario(nomes, salarios, ultimaPosicaoGravada, mediaSalario);
        imprimirDadosDeps(mediaDeps,posicaoMaiorDeps, posicaoMenorDeps, nomes, numeroDeps);
        imprimirMaiorDeps(nomes, numeroDeps, ultimaPosicaoGravada, mediaDeps);
        imprimirMenorDeps(nomes, numeroDeps, ultimaPosicaoGravada, mediaDeps);
        teclado.close();
    }
    static void imprimirDados(String nomes[], float salarios[], int numeroDeps[], int ultimaPosicaoGravada){
        int qtdeEspacos;
        String nomeGrande = "";
        System.out.println("\nHabitantes cadastrados:");
        System.out.println("Nome                Salário                    Dependentes");
        System.out.println("----------------------------------------------------------");
        for (int posicaoVetor = 0; posicaoVetor <= ultimaPosicaoGravada; posicaoVetor++) {
            if(nomes[posicaoVetor].length() <= 20){
                System.out.print(nomes[posicaoVetor]);
                qtdeEspacos = (20 - nomes[posicaoVetor].length());
                System.out.print(geraEspacos(qtdeEspacos));
            }
            else{
                nomeGrande = nomes[posicaoVetor].substring(0, 16);
                System.out.print(nomeGrande + "... ");
            }
            System.out.printf("R$ %.2f", salarios[posicaoVetor]);
            qtdeEspacos = (20 - Float.toString(salarios[posicaoVetor]).length());
            System.out.print(geraEspacos(qtdeEspacos));
            System.out.println(numeroDeps[posicaoVetor]);
        }
    }
    static String geraEspacos(int qtde){
        String espacos = "";
        for (int i = 0; i < qtde; i++) {
            espacos += " ";
        }
        return espacos;
    }
    static String[] lerNome(Scanner teclado, String nomes[], int posicaoLivre){
        int q = 0;
        do{
            System.out.print("Digite o nome do habitante: ");
            nomes[posicaoLivre] = teclado.nextLine();
            q = 0;
            for(int i = 0; i < nomes.length; i++){
                if(nomes[posicaoLivre].equals(nomes[i])){
                    q++;
                }
            }
            if(q > 1){
                System.out.println("Habitante já cadastrado.");
            }
        } while(q > 1);
        return nomes;
    }
    static float[] lerSalario(Scanner teclado, float salarios[], int posicaoLivre){
        boolean flag = true;
        do{
            try {
                System.out.print("Digite o salario R$: ");
                salarios[posicaoLivre] = teclado.nextFloat(); 
                flag = false;
            } catch (InputMismatchException variavException) {
                System.out.println("Valor incorreto.");
                teclado.nextLine();
            }
        }
        while(flag);
        teclado.nextLine();
        return salarios;
    }
    static int[] lerDependentes(Scanner teclado, int numeroDeps[], int posicaoLivre){
        boolean flag = true;
        do{
            try {
                System.out.print("Digite a quantidade de dependentes: ");
                numeroDeps[posicaoLivre] = teclado.nextInt(); 
                flag = false;
            } catch (InputMismatchException variavException) {
                System.out.println("Valor incorreto.");
                teclado.nextLine();
            }
        }
        while(flag);
        teclado.nextLine();
        return numeroDeps;
    }
    static float calcularMediaSalario (float salarios[], int ultimaPosicaoGravada){
        float media = 0;
        for(int i = 0; i < ultimaPosicaoGravada + 1; i++){
            media += salarios[i];
        }
        media = media / (ultimaPosicaoGravada + 1);
        return media;
    }
    static float calcularMediaDeps (int numeroDeps[], int ultimaPosicaoGravada){
        float media = 0;
        for(int i = 0; i < ultimaPosicaoGravada + 1; i++){
            media += numeroDeps[i];
        }
        media = media / (ultimaPosicaoGravada + 1);
        return media;
    }
    static int encontrarMaiorSalario (float salarios[], int ultimaPosicaoGravada){
        int posicao = 0;
        float valor= 0;
        for(int i = 0; i < ultimaPosicaoGravada + 1; i++){
            if(i == 0){
                valor = salarios[i];
            }
            else if(salarios[i] > valor){
                posicao = i;
                valor = salarios[i];
            }
        }
        return posicao;
    }
    static int encontrarMenorSalario (float salarios[], int ultimaPosicaoGravada){
        int posicao = 0;
        float valor= 0;
        for(int i = 0; i < ultimaPosicaoGravada + 1; i++){
            if(i == 0){
                valor = salarios[i];
            }
            else if(salarios[i] < valor){
                posicao = i;
                valor = salarios[i];
            }
        }
        return posicao;
    }
    static int encontrarMaiorDeps (int numeroDeps[], int ultimaPosicaoGravada){
        int posicao = 0, quantidade = 0;
        for(int i = 0; i < ultimaPosicaoGravada + 1; i++){
            if(i == 0){
                quantidade = numeroDeps[i];
            }
            else if(numeroDeps[i] > quantidade){
                posicao = i;
                quantidade = numeroDeps[i];
            }
        }
        return posicao;
    }
    static int encontrarMenorDeps (int numeroDeps[], int ultimaPosicaoGravada){
        int posicao = 0, quantidade = 0;
        for(int i = 0; i < ultimaPosicaoGravada + 1; i++){
            if(i == 0){
                quantidade = numeroDeps[i];
            }
            else if(numeroDeps[i] < quantidade){
                posicao = i;
                quantidade = numeroDeps[i];
            }
        }
        return posicao;
    }
    static void imprimirDadosSalarios(float mediaSalario, int posicaoMaiorSalario, 
    int posicaoMenorSalario, String nomes[], float salarios[]){
        String nomeMaiorSalario = nomes[posicaoMaiorSalario];
        String nomeMenorSalario = nomes[posicaoMenorSalario];
        float valorMaiorSalario = salarios[posicaoMaiorSalario];
        float valorMenorSalario = salarios[posicaoMenorSalario];
        System.out.printf("\nMédia salarial: R$ %.2f\n", mediaSalario);
        System.out.println("Nome do habitante com maior salário: " + nomeMaiorSalario);
        System.out.print("Valor do salário de " + nomeMaiorSalario + " R$: ");
        System.out.printf("%.2f\n", valorMaiorSalario);   
        System.out.println("Nome do habitante com menor salário: " + nomeMenorSalario);
        System.out.print("Valor do salário de " + nomeMenorSalario + " R$: ");
        System.out.printf("%.2f\n", valorMenorSalario);
    }
    static void imprimirDadosDeps(float mediaDeps,int posicaoMaiorDeps, 
    int posicaoMenorDeps, String nomes[], int numeroDeps[]){
        String nomeMaiorDeps = nomes[posicaoMaiorDeps];
        String nomeMenorDeps = nomes[posicaoMenorDeps];
        int quantidadeMaiorDeps = numeroDeps[posicaoMaiorDeps];
        int quantidadeMenorDeps = numeroDeps[posicaoMenorDeps];
        System.out.printf("\nMédia de dependentes por habitante: %.1f\n", mediaDeps);
        System.out.println("Habitante com a maior quantidade de dependentes: " + nomeMaiorDeps);
        System.out.println("Quantidade de dependentes de " + nomeMaiorDeps + ": " + quantidadeMaiorDeps);
        System.out.println("Habitante com a menor quantidade de dependentes: " + nomeMenorDeps);
        System.out.println("Quantidade de dependentes de " + nomeMenorDeps + ": " + quantidadeMenorDeps);
    }
    static void imprimirMaiorSalario(String nomes[], float salarios[], int ultimaPosicaoGravada, float mediaSalario){
        int qtdeEspacos;
        String nomeGrande = "";
        System.out.println("\nHabitantes com valor de salário acima da média:");
        System.out.println("Nome                Salário");
        System.out.println("-------------------------------");
        for (int posicaoVetor = 0; posicaoVetor <= ultimaPosicaoGravada; posicaoVetor++) {
            if(salarios[posicaoVetor] > mediaSalario){
                if(nomes[posicaoVetor].length() <= 20){
                    System.out.print(nomes[posicaoVetor]);
                    qtdeEspacos = (20 - nomes[posicaoVetor].length());
                    System.out.print(geraEspacos(qtdeEspacos));
                }
                else{
                    nomeGrande = nomes[posicaoVetor].substring(0, 16);
                    System.out.print(nomeGrande + "... ");
                }
                System.out.printf("R$ %.2f\n", salarios[posicaoVetor]);
            }
        }
    }
    static void imprimirMenorSalario(String nomes[], float salarios[], int ultimaPosicaoGravada, float mediaSalario){
        int qtdeEspacos;
        String nomeGrande = "";
        System.out.println("\nHabitantes com valor de salário abaixo da média:");
        System.out.println("Nome                Salário");
        System.out.println("-------------------------------");
        for (int posicaoVetor = 0; posicaoVetor <= ultimaPosicaoGravada; posicaoVetor++) {
            if(salarios[posicaoVetor] < mediaSalario){
                if(nomes[posicaoVetor].length() <= 20){
                    System.out.print(nomes[posicaoVetor]);
                    qtdeEspacos = (20 - nomes[posicaoVetor].length());
                    System.out.print(geraEspacos(qtdeEspacos));
                }
                else{
                    nomeGrande = nomes[posicaoVetor].substring(0, 16);
                    System.out.print(nomeGrande + "... ");
                }
                System.out.printf("R$ %.2f\n", salarios[posicaoVetor]);
            }
        }
    }
    static void imprimirMaiorDeps(String nomes[], int numeroDeps[], int ultimaPosicaoGravada, float mediaDeps){
        int qtdeEspacos;
        String nomeGrande = "";
        System.out.println("\nHabitantes com quantidade de dependentes acima da média:");
        System.out.println("Nome                Dependentes");
        System.out.println("-------------------------------");
        for (int posicaoVetor = 0; posicaoVetor <= ultimaPosicaoGravada; posicaoVetor++) {
            if(numeroDeps[posicaoVetor] > mediaDeps){
                if(nomes[posicaoVetor].length() <= 20){
                    System.out.print(nomes[posicaoVetor]);
                    qtdeEspacos = (20 - nomes[posicaoVetor].length());
                    System.out.print(geraEspacos(qtdeEspacos));
                }
                else{
                    nomeGrande = nomes[posicaoVetor].substring(0, 16);
                    System.out.print(nomeGrande + "... ");
                }
                System.out.println(numeroDeps[posicaoVetor]);
            }
        }
    }
    static void imprimirMenorDeps(String nomes[], int numeroDeps[], int ultimaPosicaoGravada, float mediaDeps){
        int qtdeEspacos;
        String nomeGrande = "";
        System.out.println("\nHabitantes com quantidade de dependentes abaixo da média:");
        System.out.println("Nome                Dependentes");
        System.out.println("-------------------------------");
        for (int posicaoVetor = 0; posicaoVetor <= ultimaPosicaoGravada; posicaoVetor++) {
            if(numeroDeps[posicaoVetor] < mediaDeps){
                if(nomes[posicaoVetor].length() <= 20){
                    System.out.print(nomes[posicaoVetor]);
                    qtdeEspacos = (20 - nomes[posicaoVetor].length());
                    System.out.print(geraEspacos(qtdeEspacos));
                }
                else{
                    nomeGrande = nomes[posicaoVetor].substring(0, 16);
                    System.out.print(nomeGrande + "... ");
                }
                System.out.println(numeroDeps[posicaoVetor]);
            }
        }
    }
}