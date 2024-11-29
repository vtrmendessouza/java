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
    public static void main (String[] args) throws Exception {
        int opcao;
        limparTela();
        carregarDados();
        do {
            opcao = exibirMenu();
            processarMenu(opcao);
        } while(opcao != 7);
        teclado.close();
    }
    static int exibirMenu(){
        int opcao = 0;
        System.out.println("\n############### Menu ###############");
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
    static void processarMenu(int opcao){
        switch (opcao) {
            case 1:
                limparTela();
                exibirDados();
                break;
            case 2:
                limparTela();
                exibirRelatorio();
                break;
            case 3:
                limparTela();
                exibirRelatorioPersonalizado();
                break;
            case 4:
                limparTela();
                adicionarDados();
                break;
            case 5:
                limparTela();
                alterarDados();
                break;
            case 6:
                limparTela();
                apagarDados();
                break;
            case 7:
                limparTela();
                System.out.print("Programa encerrado.\n");
                break;
            default:
                System.out.println("Opção inválida.\n");
        }
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
        int q = 0;
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
            for(int i = 0; i < contador; i++){
                if(nomes[contador].equals(nomes[i])){
                    q++;
                }
            }
            if(q > 0){
                System.out.println("Nome já cadastrado.");
            }
        } while(q > 0);
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
            System.out.println("Dados salvos no arquivo.");
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
    static void exibirDados() {
        int qtdeEspacos = 0;
        String nomeGrande = "";
        if (contador == 0) {
            System.out.println("Nenhum dado disponível.");
            return;
        }
        System.out.println("ID  Nome                  Idade Peso");
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
        exibirDados();
        char resposta;
        int id = (lerInt("\nDigite o ID que deseja alterar: ") - 1);
        resposta = lerResposta("Deseja alterar o nome " + nomes[id] + "? s/n ");
        if(resposta == 's'){
            System.out.print("Digite o novo nome: ");
            nomes[id] = teclado.nextLine();
        }
        resposta = lerResposta("Deseja alterar a idade " + idades[id] + "? s/n ");
        if(resposta == 's'){
            idades[id] = lerInt("Digite a nova idade: ");
        }
        resposta = lerResposta("Deseja alterar o peso " + pesos[id] + "? s/n ");
        if(resposta == 's'){
            pesos[id] = lerFloat("Digite o novo peso: ");
        }
        resposta = lerResposta("Confirma as alterações? s/n ");
        if(resposta == 's'){
            salvarDados();
        }
        else{
            System.out.print("Alterações descartadas.\n");
        }
    }
    static void apagarDados() {
        char resposta;
        exibirDados();
        int id = lerInt("\nDigite o ID que deseja apagar: ") - 1;
        resposta = lerResposta("Deseja apagar " + nomes[id] + "? s/n ");
        if (resposta == 's'){
            nomes[id] = null;
        }
        salvarDados();
    }
    static int valorMaiorIdade(){
        int idade = 0;
        for(int i = 0; i < contador; i++){
            if(i == 0){
                idade = idades[i];
            }
            else if(idades[i] > idade){
                idade = idades[i];
            }
        }
        return idade;
    }
    static int valorMenorIdade(){
        int idade = 0;
        for(int i = 0; i < contador; i++){
            if(i == 0){
                idade = idades[i];
            }
            else if(idades[i] < idade){
                idade = idades[i];
            }
        }
        return idade;
    }
    static String nomeMaiorIdade(){
        String nome = "";
        int idade = 0;
        for(int i = 0; i < contador; i++){
            if(i == 0){
                nome = nomes[i];
                idade = idades[i];
            }
            else if(idades[i] > idade){
                nome = nomes[i];
                idade = idades[i];
            }
        }
        return nome;
    }
    static String nomeMenorIdade(){
        String nome = "";
        int idade = 0;
        for(int i = 0; i < contador; i++){
            if(i == 0){
                nome = nomes[i];
                idade = idades[i];
            }
            else if(idades[i] < idade){
                nome = nomes[i];
                idade = idades[i];
            }
        }
        return nome;
    }
    static float valorMaiorPeso(){
        float peso = 0;
        for(int i = 0; i < contador; i++){
            if(i == 0){
                peso = pesos[i];
            }
            else if(pesos[i] > peso){
                peso = pesos[i];
            }
        }
        return peso;
    }
    static float valorMenorPeso(){
        float peso = 0;
        for(int i = 0; i < contador; i++){
            if(i == 0){
                peso = pesos[i];
            }
            else if(pesos[i] < peso){
                peso = pesos[i];
            }
        }
        return peso;
    }
    static String nomeMaiorPeso(){
        String nome = "";
        float peso = 0;
        for(int i = 0; i < contador; i++){
            if(i == 0){
                nome = nomes[i];
                peso = pesos[i];
            }
            else if(pesos[i] > peso){
                nome = nomes[i];
                peso = pesos[i];
            }
        }
        return nome;
    }
    static String nomeMenorPeso(){
        String nome = "";
        float peso = 0;
        for(int i = 0; i < contador; i++){
            if(i == 0){
                nome = nomes[i];
                peso = pesos[i];
            }
            else if(pesos[i] < peso){
                nome = nomes[i];
                peso = pesos[i];
            }
        }
        return nome;
    }
    static float mediaIdade(){
        float media = 0;
        int q = 0;
        for(int i = 0; i < contador; i++){
            q += idades[i];
        }
        media = q / contador;
        return media;
    }
    static float mediaPeso(){
        float media = 0;
        int q = 0;
        for(int i = 0; i < contador; i++){
            q += pesos[i];
        }
        media = q / contador;
        return media;
    }
    static int quantMaiorIdadeMedia(){
        int quantidade = 0;
        float media = mediaIdade();
        for(int i = 0; i < contador; i++){
            if(idades[i] > media){
                quantidade ++;
            }
        }
        return quantidade;
    }
    static int quantMenorIdadeMedia(){
        int quantidade = 0;
        float media = mediaIdade();
        for(int i = 0; i < contador; i++){
            if(idades[i] < media){
                quantidade ++;
            }
        }
        return quantidade;
    }
    static int quantMaiorPesoMedia(){
        int quantidade = 0;
        float media = mediaPeso();
        for(int i = 0; i < contador; i++){
            if(pesos[i] > media){
                quantidade ++;
            }
        }
        return quantidade;
    }
    static int quantMenorPesoMedia(){
        int quantidade = 0;
        float media = mediaPeso();
        for(int i = 0; i < contador; i++){
            if(pesos[i] < media){
                quantidade ++;
            }
        }
        return quantidade;
    }
    static float percentMaiorIdadeMedia(){
        float conversor = contador;
        float percentual = (quantMaiorIdadeMedia() / conversor) * 100;
        return percentual;
    }
    static float percentMenorIdadeMedia(){
        float conversor = contador;
        float percentual = (quantMenorIdadeMedia() / conversor) * 100;
        return percentual;
    }
    static float percentMaiorPesoMedia(){
        float conversor = contador;
        float percentual = (quantMaiorPesoMedia() / conversor) * 100;
        return percentual;
    }
    static float percentMenorPesoMedia(){
        float conversor = contador;
        float percentual = (quantMenorPesoMedia() / conversor) * 100;
        return percentual;
    }
    static int escolherIdade(){
        int escolhaIdade = lerInt("Informe a idade: ");
        return escolhaIdade;
    }
    static float escolherPeso(){
        float escolhaPeso = lerFloat("Informe o peso: ");
        return escolhaPeso;
    }
    static int quantMaiorIdadeEscolha(int escolhaIdade){
        int quantidade = 0;
        for(int i = 0; i < contador; i++){
            if(idades[i] >= escolhaIdade){
                quantidade ++;
            }
        }
        return quantidade;
    }
    static int quantMenorIdadeEscolha(int escolhaIdade){
        int quantidade = 0;
        for(int i = 0; i < contador; i++){
            if(idades[i] >= escolhaIdade){
                quantidade ++;
            }
        }
        return quantidade;
    }
    static int quantMaiorPesoEscolha(float escolhaPeso){
        int quantidade = 0;
        for(int i = 0; i < contador; i++){
            if(pesos[i] >= escolhaPeso){
                quantidade ++;
            }
        }
        return quantidade;
    }
    static int quantMenorPesoEscolha(float escolhaPeso){
        int quantidade = 0;
        for(int i = 0; i < contador; i++){
            if(pesos[i] >= escolhaPeso){
                quantidade ++;
            }
        }
        return quantidade;
    }
    static float percentMaiorIdadeEscolha(){
        float conversor = contador;
        float percentual = (quantMaiorIdadeEscolha() / conversor) * 100;
        return percentual;
    }
    static float percentMenorIdadeEscolha(){
        float conversor = contador;
        float percentual = (quantMenorIdadeEscolha() / conversor) * 100;
        return percentual;
    }
    static float percentMaiorPesoEscolha(){
        float conversor = contador;
        float percentual = (quantMaiorPesoEscolha() / conversor) * 100;
        return percentual;
    }
    static float percentMenorPesoEscolha(){
        float conversor = contador;
        float percentual = (quantMenorPesoEscolha() / conversor) * 100;
        return percentual;
    }
    static void exibirRelatorio(){
        System.out.printf("Total de cadastros: %d\n", contador);
 
        System.out.printf("\nMédia de idade: %.1f\n", mediaIdade());
        System.out.printf("Idade acima da média: %d (%.2f%%)\n", quantMaiorIdadeMedia(), percentMaiorIdadeMedia());
        System.out.printf("Idade abaixo da média: %d (%.2f%%)\n",quantMenorIdadeMedia(), percentMenorIdadeMedia());
 
        System.out.printf("\nMédia de peso: %.1f\n", mediaPeso());
        System.out.printf("Peso acima da média: %d (%.2f%%)\n", quantMaiorPesoMedia(), percentMaiorPesoMedia());
        System.out.printf("Peso abaixo da média: %d (%.2f%%)\n",quantMenorPesoMedia(), percentMenorPesoMedia());
 
        System.out.print("\nMaior idade: " + nomeMaiorIdade());
        System.out.printf(", %d anos.", valorMaiorIdade());
        System.out.printf(" (%.1f vezes maior)\n", (valorMaiorIdade() / mediaIdade()));
        System.out.print("Menor idade: " + nomeMenorIdade());
        System.out.printf(", %d anos.", valorMenorIdade());
        System.out.printf(" (%.1f vezes menor)\n", (mediaIdade() / valorMenorIdade()));
 
        System.out.print("\nMaior peso: " + nomeMaiorPeso());
        System.out.printf(", %.1f quilos.", valorMaiorPeso());
        System.out.printf(" (%.1f vezes maior)\n", (valorMaiorPeso() / mediaPeso()));
        System.out.print("Menor peso: " + nomeMenorPeso());
        System.out.printf(", %.1f quilos.", valorMenorPeso());
        System.out.printf(" (%.1f vezes menor)\n", (mediaPeso() / valorMenorPeso()));
    }
    static void exibirRelatorioPersonalizado(){
        escolherIdade();
        escolherPeso();
        System.out.printf("Total de cadastros: %d\n", contador);
        System.out.printf("\nIdade acima do solicitado: %d (%.2f%%)\n", quantMaiorIdadeEscolha(), percentMaiorIdadeEscolha());
        System.out.printf("Idade abaixo do solicitado: %d (%.2f%%)\n",quantMenorIdadeEscolha(), percentMenorIdadeEscolha());
        System.out.printf("Peso acima do solicitado: %d (%.2f%%)\n", quantMaiorPesoEscolha(), percentMaiorPesoEscolha());
        System.out.printf("Peso abaixo do solicitado: %d (%.2f%%)\n",quantMenorPesoEscolha(), percentMenorPesoEscolha());
    }
}