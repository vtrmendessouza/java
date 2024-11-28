/*
21/11/2024 - 35º ENCONTRO
Exercício Desafio
Este código possui um problema na entrada de dados da idade e do peso, 
se o usuário digitar um texto no lugar da idade ou do peso, 
será gerado uma exceção e o aplicativo fechará. 
Faça então a tratativa da leitura dos dados garantindo que 
o usuário insira um valor que seja aceito.
Desenvolva uma nova funcionalidade que conte a quantidade de de pessoas cadastradas.
Dica: Insira um novo item no menu "Exibir a QTDE de Pessoas" 
e depois no switch faça a exibição da quantidade de linhas no vetor.
Desenvolva uma nova funcionalidade que descubra quem tem a menor idade. 
Exiba o nome da Pessoa e a idade. 
Dica: Insira um novo item  no menu "Exibir a Pessoa com a Menor Idade".
Desenvolva uma nova funcionalidade que descubra quem tem o maior peso. 
Exiba o nome da Pessoa e o peso. 
Dica: Insira um novo item  no menu "Exibir a Pessoa com o Maior Peso".
Desenvolva uma nova funcionalidade que descubra a quantidade 
de pessoas quem tem um peso maior ou igual ao informado pelo usuario. 
Exiba somente a quantidade. 
Dica: Insira um novo item  no menu "Contar QTDE de Pessoas acima de Peso". 
Quando o usuário selecionar esta opção pergunte 
qual o peso que o usuário deseja utilizar como critério de busca, 
e descubra quantas pessoas tem um peso maior ou igual ao informado pelo usuário. 
*/
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.*;
public class Exe02 {
    static Scanner teclado = new Scanner(System.in);
    static String CAMINHO_ARQUIVO = "./doc08/src/dataExe01.txt";
    static int TAMANHO_MAXIMO = 50;
    static String[] nomes = new String[TAMANHO_MAXIMO];
    static int[] idades = new int[TAMANHO_MAXIMO];
    static float[] pesos = new float[TAMANHO_MAXIMO];
    static int contador = 0;
    static boolean limparTela = true;
    public static void main(String[] args) {
        int opcao;
        carregarDados();
        do {
            limparTela();
            opcao = lerOpcaoMenu();
            processarOpcaoMenu(opcao);
        } while(opcao != 7);
        teclado.close();
    }
    static int lerOpcaoMenu(){
        int opcao = 0;
        System.out.println("\n############# Menu #############");
        System.out.println("1. Exibir dados");
        System.out.println("2. Exibir relatório");
        System.out.println("3. Exibir relatório personalizado");
        System.out.println("4. Adicionar dados");
        System.out.println("5. Alterar dados");
        System.out.println("6. Apagar dados");
        System.out.println("7. Sair");
        opcao = lerInt("Escolha uma opção: ");
        return opcao;
    }
    static void processarOpcaoMenu(int opcao){
        limparTela();
        switch (opcao) {
            case 1:
                mostrarDados();
                break;
            case 2:
                //exibirRelatorio();
                break;
            case 3:
                //exibirRelatorioPersonalizado();
                break;
            case 4:
                adicionarDados();
                break;
            case 5:
                alterarDados();
                break;
            case 6:
                apagarDados();
                break;
            case 7:
                System.out.println("\nEncerrando...");
                break;
            default:
                System.out.println("\nOpção inválida. Tente novamente.");
        }
        limparTela = false;
    }
    static void carregarDados() {
        contador = 0;
        FileReader arquivo = null;
        BufferedReader bufferLeitura = null;
        try {
            //define o arquivo que sera aberto
            arquivo = new FileReader(CAMINHO_ARQUIVO);
            bufferLeitura = new BufferedReader(arquivo);
            String linha = bufferLeitura.readLine();
            while (linha != null) {
                String[] campos = linha.split(";");
                if (campos.length == 3 && contador < TAMANHO_MAXIMO) {
                    nomes[contador] = campos[0];
                    //como o split devolve o resultado como string
                    //é necessario converter a idade do arquivo para int 
                    idades[contador] = Integer.parseInt(campos[1]);
                    //é necessário converter o peso do arquivo para float
                    pesos[contador] = Float.parseFloat(campos[2]);
                    contador++;
                }
                linha = bufferLeitura.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Um novo será criado ao salvar.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro nos dados do arquivo: formato inválido.");
        } finally {
            //fechamento do arquivo e do bufferLeitura
            try {
                if (bufferLeitura != null) {
                    bufferLeitura.close();
                }
                if (arquivo != null) {
                    arquivo.close();
                }
            } catch (IOException e) {
                System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
            }
        }
    }
    static void adicionarDados() {
        limparTela = true;
        int q = 0;
        limparTela();        
        //verifico se tem espaco nos vetores
        if (contador >= TAMANHO_MAXIMO) {
            System.out.println("Limite de dados atingido! Não é possível adicionar mais.");
            //estou usando um retorne para forcar o fim da execucao do metodo adicionarDados 
            //quando nao tiver mais posicoes livres no vetor. 
            return;
        }
        do{
            System.out.print("Digite o nome: ");
            nomes[contador] = teclado.nextLine();
            q = 0;
            for(int i = 0; i < nomes.length; i++){
                if(nomes[contador].equals(nomes[i])){
                    q++;
                }
            }
            if(q > 1){
                System.out.println("Nome já cadastrado.");
            }
        } while(q > 1);
        idades[contador] = lerInt("Digite a idade: ");
        pesos[contador] = lerFloat("Digite o peso (em kg): ");
        contador++;
        salvarDados();
    }
    static void salvarDados() {
        BufferedWriter gravador = null;
        try {
            //inicializa o BufferedWriter para escrever no arquivo
            gravador = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO));
            //escreve os dados no arquivo
            for (int i = 0; i < contador; i++) {
                if(nomes[i] != null){
                    //escreve os dados no arquivo
                    gravador.write(nomes[i] + ";" + idades[i] + ";" + pesos[i]);
                    //cria uma nova linha no arquivo
                    gravador.newLine();
                }
            }
            System.out.println("\nDados salvos no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        } finally {
            //fechamento do BufferedWriter 
            if (gravador != null) {
                try {
                    gravador.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
                }
            }
        }
        carregarDados();
    }
    static void mostrarDados() {
        int qtdeEspacos = 0;
        String nomeGrande = "";
        if (contador == 0) {
            System.out.println("Nenhum dado disponível.");
            return;
        }
        System.out.println("\nID  Nome                  Idade Peso");
        System.out.println("---------------------------------------");
        for (int i = 0; i < contador; i++) {
            if(nomes[i] != null){
                System.out.print("|");
                System.out.print(i + 1);
                if(i < 9){
                    qtdeEspacos = 2;
                }
                else{
                    qtdeEspacos = 1;
                }
                System.out.print(gerarEspacos(qtdeEspacos));
                if(nomes[i].length() < 21){
                    System.out.print("|");
                    System.out.print(nomes[i]);
                    //calcula quantos espacos sao necessarios para alinhar
                    //o valor da idade na posicao da coluna idade
                    qtdeEspacos = (21 - nomes[i].length());
                    //imprime a quantidade de espacos para alinhar os salarios
                    System.out.print(gerarEspacos(qtdeEspacos));
                }
                else{
                    System.out.print("|");
                    nomeGrande = nomes[i].substring(0, 17);
                    System.out.print(nomeGrande + "... ");
                }
                System.out.print("|");
                System.out.print(idades[i]);
                qtdeEspacos = (4 - String.valueOf(idades[i]).length());
                System.out.print(gerarEspacos(qtdeEspacos));
                System.out.print("|");
                System.out.printf("%.1f", pesos[i]);
                qtdeEspacos = (6 - String.valueOf(pesos[i]).length());
                System.out.print(gerarEspacos(qtdeEspacos));
                System.out.print("|\n");
            }
        }
    }
    static String gerarEspacos(int qtde){
        String espacos = "";

        for (int i = 0; i < qtde; i++) {
            espacos += " ";
        }
        return espacos;
    }
    static void limparTela(){
        if (limparTela){
            try {
                if (System.getProperty("os.name").contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                }
            } catch (Exception e) {
                System.out.println("Erro ao limpar a tela: " + e.getMessage());
            }
        }
    }
    static int lerInt(String mensagem){
        int valorInt = 0;
        boolean flag = true;
        do{
            try {
                System.out.print(mensagem);
                valorInt = teclado.nextInt();
                flag = false;
            } catch (InputMismatchException variavException) {
                System.out.println("Valor incorreto.");
                teclado.nextLine();
            }
        }
        while(flag);
        teclado.nextLine();
        return valorInt;
    }
    static float lerFloat(String mensagem){
        float valorFloat = 0;
        boolean flag = true;
        do{
            try {
                System.out.print(mensagem);
                valorFloat = teclado.nextFloat();
                flag = false;
            } catch (InputMismatchException variavException) {
                System.out.println("Valor incorreto.");
                teclado.nextLine();
            }
        }
        while(flag);
        teclado.nextLine();
        return valorFloat;
    }
    static char lerResposta(String mensagem){
        char resposta;
        do{
            System.out.print(mensagem);
            resposta = teclado.nextLine().toLowerCase().charAt(0);
            if (resposta != 's' && resposta != 'n'){
                System.out.println("Opção inválida.");
            }
        }
        while((resposta != 's' && resposta != 'n'));
        return resposta;
    }
    static void alterarDados() {
        limparTela = true;
        limparTela();
        mostrarDados();
        char resposta;
        int id = (lerInt("\nDigite o ID que deseja alterar: ") - 1);
        resposta = lerResposta("Deseja alterar o nome " + nomes[id] + "? s/n ");
        if(resposta == 's'){
            nomes[id] = teclado.nextLine();
        }
        resposta = lerResposta("Deseja alterar a idade " + idades[id] + "? s/n ");
        if(resposta == 's'){
            idades[id] = lerInt("Digite a nova idade: ");
        }
        resposta = lerResposta("Deseja alterar o peso " + pesos[id] + "? s/n ");
        if(resposta == 's'){
            pesos[id] = lerInt("Digite o novo peso: ");
        }
        resposta = lerResposta("Confirma as alterações? s/n ");
        if(resposta == 's'){
            salvarDados();
        }
    }
    static void apagarDados() {
        char resposta;
        limparTela = true;
        limparTela();
        mostrarDados();
        int id = lerInt("\nDigite o ID que deseja apagar: ") - 1;
        resposta = lerResposta("Deseja apagar " + nomes[id] + "? s/n ");
        if (resposta == 's'){
            nomes[id] = null;
        }
        salvarDados();
    }
    static String maiorIdadeGeral(){
        String nome = "";
        int valor = 0;
        for(int i = 0; i < contador; i++){
            if(i == 0){
                valor = idades[i];
                nome = nomes[i];
            }
            else if(idades[i] > valor){
                nome = nomes[i];
            }
        }
        return nome;
    }
    static String menorIdadeGeral(){
        String nome = "";
        int valor = 0;
        for(int i = 0; i < contador; i++){
            if(i == 0){
                valor = idades[i];
                nome = nomes[i];
            }
            else if(idades[i] < valor){
                nome = nomes[i];
            }
        }
        return nome;
    }
    static String maiorPesoGeral(){
        String nome = "";
        float peso = 0;
        for(int i = 0; i < contador; i++){
            if(i == 0){
                peso = pesos[i];
                nome = nomes[i];
            }
            else if(idades[i] < peso){
                nome = nomes[i];
            }
        }
        return nome;
    }
    static String menorPesoGeral(){
        String nome = "";
        float peso = 0;
        for(int i = 0; i < contador; i++){
            if(i == 0){
                peso = pesos[i];
                nome = nomes[i];
            }
            else if(idades[i] > peso){
                nome = nomes[i];
            }
        }
        return nome;
    }
    static int quantMaiorIdadeMediaGeral(){
        int quantidade = 0, valor = 0, q = 0;
        for(int i = 0; i > contador; i++){
            q += idades[i];
        }
        valor = q / contador;
        for(int i = 0; i < contador; i++){
            if(idades[i] >= valor){
                quantidade ++;
            }
        }
        teclado.nextLine();
        return quantidade;
    }
    static int quantMenorIdadeMedia(){
        int quantidade = 0, valor = 0, q = 0;
        for(int i = 0; i > contador; i++){
            q += idades[i];
        }
        valor = q / contador;
        for(int i = 0; i < contador; i++){
            if(idades[i] >= valor){
                quantidade ++;
            }
        }
        teclado.nextLine();
        return quantidade;
    }
    static int quantMaiorPesoMedia(){
        int quantidade = 0, valor = 0, q = 0;
        for(int i = 0; i > contador; i++){
            q += pesos[i];
        }
        valor = q / contador;
        for(int i = 0; i < contador; i++){
            if(pesos[i] >= valor){
                quantidade ++;
            }
        }
        teclado.nextLine();
        return quantidade;
    }
    static int quantMenorPesoMedia(){
        int quantidade = 0, valor = 0, q = 0;
        for(int i = 0; i > contador; i++){
            q += pesos[i];
        }
        valor = q / contador;
        for(int i = 0; i < contador; i++){
            if(pesos[i] >= valor){
                quantidade ++;
            }
        }
        teclado.nextLine();
        return quantidade;
    }
    static int escolherIdade(){
        int escolha = lerInt("Informe a idade: ");
        teclado.nextLine();
        return escolha;
    }
    static float escolherPeso(){
        float escolha = lerFloat("Informe o peso: ");
        teclado.nextLine();
        return escolha;
    }
    static int quantMaiorIdadeEscolha(){
        int quantidade = 0;
        int valor = escolherIdade();
        for(int i = 0; i < contador; i++){
            if(idades[i] >= valor){
                quantidade ++;
            }
        }
        teclado.nextLine();
        return quantidade;
    }
    static int quantMenorIdadeEscolha(){
        int quantidade = 0;
        int valor = escolherIdade();
        for(int i = 0; i < contador; i++){
            if(idades[i] >= valor){
                quantidade ++;
            }
        }
        teclado.nextLine();
        return quantidade;
    }
    static int quantMaiorPesoEscolha(){
        int quantidade = 0;
        float peso = escolherPeso();
        for(int i = 0; i < contador; i++){
            if(pesos[i] >= peso){
                quantidade ++;
            }
        }
        teclado.nextLine();
        return quantidade;
    }
    static int quantMenorPesoEscolha(){
        int quantidade = 0;
        float peso = escolherPeso();
        for(int i = 0; i < contador; i++){
            if(pesos[i] >= peso){
                quantidade ++;
            }
        }
        teclado.nextLine();
        return quantidade;
    }
}