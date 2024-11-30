//21/11/2024 - 35º ENCONTRO
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.*;
public class Exe02 {
    static Scanner scanner = new Scanner(System.in);
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
        scanner.close();
    }
    static int exibirMenu(){
        int opcao = 0;
        System.out.println("\n#. Menu Principal:");
        System.out.println("1. Adicionar Dados");
        System.out.println("2. Alterar Dados");
        System.out.println("3. Apagar Dados");
        System.out.println("4. Exibir Dados");
        System.out.println("5. Exibir Relatório");
        System.out.println("6. Exibir Relatório Personalizado");
        System.out.println("7. Sair");
        opcao = lerInt("Escolha uma opção: ");
        return opcao;
    }
    static void processarMenu(int opcao){
        switch (opcao) {
            case 1:
                limparTela();
                adicionarDados();
                break;
            case 2:
                limparTela();
                alterarDados();
                break;
            case 3:
                limparTela();
                apagarDados();
                break;
            case 4:
                limparTela();
                exibirDados();
                break;
            case 5:
                limparTela();
                exibirRelatorio();
                break;
            case 6:
                limparTela();
                exibirRelatorioPersonalizado();
                break;
            case 7:
                limparTela();
                System.out.print("Programa Encerrado.\n");
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
    static void exibirDados() {
        int qtdeCaracteres = 0;
        int espacoNomeTabela = 0;
        int espacoNomeTitulo = 0;
        int linha = 0;
        int diferenca = 0;
        String mensagem = "";
        carregarDados();
        if (contador == 0) {
            System.out.println("Nenhum dado disponível.");
            return;
        }
        for(int i = 0; i < contador; i++){
            if(i == 0){
                espacoNomeTabela = String.valueOf(nomes[i]).length();
            }
            else if (nomes[i].length() > espacoNomeTabela) {
                espacoNomeTabela = String.valueOf(nomes[i]).length();
            }
        }
        mensagem = "Lista de Cadastro:";
        espacoNomeTitulo = espacoNomeTabela -4;
        linha = espacoNomeTitulo + 23;
        qtdeCaracteres = (linha - mensagem.length()) / 2;
        diferenca = linha - mensagem.length() - qtdeCaracteres * 2;
        System.out.print("\n" + gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(mensagem);
        System.out.print(gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(gerarCaractere(diferenca, "-") + "\n");
        System.out.print("|ID ");
        System.out.print("|Nome");
        System.out.print(gerarCaractere(espacoNomeTitulo, " "));
        System.out.print("|Idade ");
        System.out.print("|Peso |\n");
        System.out.print(gerarCaractere(linha, "-"));
        System.out.print("\n");
        for (int i = 0; i < contador; i++) {
            if(nomes[i] != null){
                System.out.print("|");
                System.out.print(i + 1);
                if(i < 9){
                    qtdeCaracteres = 2;
                }
                else{
                    qtdeCaracteres = 1;
                }
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(nomes[i]);
                qtdeCaracteres = (espacoNomeTabela - nomes[i].length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(idades[i]);
                qtdeCaracteres = (6 - String.valueOf(idades[i]).length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.printf("%.1f", pesos[i]);
                qtdeCaracteres = (5 - String.valueOf(pesos[i]).length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|\n");
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
            nomes[contador] = scanner.nextLine();
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
    
        char resposta = lerResposta("Confirma as alterações? s/n ");
        if(resposta == 's'){
            contador++;
            salvarDados();
            System.out.println("Alterações salvas.");
        }
        else{
            System.out.print("Alterações descartadas.\n");
        }
    }
    static void alterarDados() {
        exibirDados();
        char resposta;
        int id = (lerInt("\nDigite o ID que deseja alterar: ") - 1);
        resposta = lerResposta("Deseja alterar o nome " + nomes[id] + "? s/n ");
        if(resposta == 's'){
            System.out.print("Digite o novo nome: ");
            nomes[id] = scanner.nextLine();
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
            System.out.println("Alterações salvas.");
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
        carregarDados();
        salvarDados();
        System.out.println("Alterações salvas.");
    }
    static void salvarDados() {
        BufferedWriter gravador = null;
        try {
            //inicia o BufferedWriter
            gravador = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO));
            for (int i = 0; i < contador; i++) {
                if(nomes[i] != null){
                    //escreve os dados no arquivo
                    gravador.write(nomes[i] + ";" + idades[i] + ";" + pesos[i]);
                    //cria uma nova linha no arquivo
                    gravador.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        } finally {
            //fecha o BufferedWriter 
            if (gravador != null) {
                try {
                    gravador.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
                }
            }
        }
    }
    static String gerarCaractere(int qtde, String modelo){
        String espacos = "";

        for (int i = 0; i < qtde; i++) {
            espacos += modelo;
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
                valorInt = scanner.nextInt();
                flag = false;
            } catch (InputMismatchException variavException) {
                System.out.println("Valor incorreto.");
                scanner.nextLine();
            }
        }
        while(flag);
        scanner.nextLine();
        return valorInt;
    }
    static float lerFloat(String mensagem){
        float valorFloat = 0;
        boolean flag = true;
        do{
            try {
                System.out.print(mensagem);
                valorFloat = scanner.nextFloat();
                flag = false;
            } catch (InputMismatchException variavException) {
                System.out.println("Valor incorreto.");
                scanner.nextLine();
            }
        }
        while(flag);
        scanner.nextLine();
        return valorFloat;
    }
    static char lerResposta(String mensagem){
        char resposta;
        do{
            System.out.print(mensagem);
            resposta = scanner.nextLine().toLowerCase().charAt(0);
            if (resposta != 's' && resposta != 'n'){
                System.out.println("Opção inválida.");
            }
        }
        while((resposta != 's' && resposta != 'n'));
        return resposta;
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
    static void exibirRelatorio(){
        System.out.printf("Total de cadastros: %d\n", contador);
        System.out.printf("Média de idade: %.1f\n", mediaIdade());
        System.out.printf("Média de peso: %.1f\n", mediaPeso());
        System.out.printf("\nIdade acima da média: %d (%.2f%%)\n", quantMaiorIdadeMedia(), percentMaiorIdadeMedia());
        System.out.printf("Idade abaixo da média: %d (%.2f%%)\n",quantMenorIdadeMedia(), percentMenorIdadeMedia());
        System.out.printf("Peso acima da média: %d (%.2f%%)\n", quantMaiorPesoMedia(), percentMaiorPesoMedia());
        System.out.printf("Peso abaixo da média: %d (%.2f%%)\n",quantMenorPesoMedia(), percentMenorPesoMedia());
        System.out.print("\nMaior idade: " + nomeMaiorIdade());
        System.out.printf(", %d anos.", valorMaiorIdade());
        System.out.printf(" (%.1f vezes acima da média)\n", (valorMaiorIdade() / mediaIdade()));
        System.out.print("Menor idade: " + nomeMenorIdade());
        System.out.printf(", %d anos.", valorMenorIdade());
        System.out.printf(" (%.1f vezes abaixo da média)\n", (mediaIdade() / valorMenorIdade()));
        System.out.print("Maior peso: " + nomeMaiorPeso());
        System.out.printf(", %.1f quilos.", valorMaiorPeso());
        System.out.printf(" (%.1f vezes acima da média)\n", (valorMaiorPeso() / mediaPeso()));
        System.out.print("Menor peso: " + nomeMenorPeso());
        System.out.printf(", %.1f quilos.", valorMenorPeso());
        System.out.printf(" (%.1f vezes abaixo da média)\n", (mediaPeso() / valorMenorPeso()));
        tabelaMaiorIdadeMedia();
        tabelaMenorIdadeMedia();
        tabelaMaiorPesoMedia();
        tabelaMenorPesoMedia();
    }
    static void exibirRelatorioPersonalizado(){
        int quantMaiorIdade = 0;
        int quantMenorIdade = 0;
        int quantMediaIdade = 0;
        int quantMaiorPeso = 0;
        int quantMenorPeso = 0;
        int quantMediaPeso = 0;
        float percentMaiorIdade = 0;
        float percentMenorIdade = 0;
        float percentMediaIdade = 0;
        float percentMaiorPeso = 0;
        float percentMenorPeso = 0;
        float percentMediaPeso = 0;
        float conversor = contador;
        int escolhaIdade = lerInt("Informe a idade: ");
        float escolhaPeso = lerFloat("Informe o peso: ");
        for(int i = 0; i < contador; i++){
            if(idades[i] > escolhaIdade){
                quantMaiorIdade ++;
            }
        }
        for(int i = 0; i < contador; i++){
            if(idades[i] < escolhaIdade){
                quantMenorIdade ++;
            }
        }
        for(int i = 0; i < contador; i++){
            if(idades[i] == escolhaIdade){
                quantMediaIdade ++;
            }
        }
        for(int i = 0; i < contador; i++){
            if(pesos[i] > escolhaPeso){
                quantMaiorPeso ++;
            }
        }
        for(int i = 0; i < contador; i++){
            if(pesos[i] < escolhaPeso){
                quantMenorPeso ++;
            }
        }
        for(int i = 0; i < contador; i++){
            if(pesos[i] == escolhaPeso){
                quantMediaPeso ++;
            }
        }
        percentMaiorIdade = (quantMaiorIdade / conversor) * 100;
        percentMenorIdade = (quantMenorIdade / conversor) * 100;
        percentMediaIdade = (quantMediaIdade / conversor) * 100;
        percentMaiorPeso = (quantMaiorPeso / conversor) * 100;
        percentMenorPeso = (quantMenorPeso / conversor) * 100;
        percentMediaPeso = (quantMediaPeso / conversor) * 100;
        System.out.printf("\nTotal de cadastros: %d\n", contador);
        System.out.print("Idade acima de " + escolhaIdade + ": ");
        System.out.printf("%d (%.2f%%)\n", quantMaiorIdade, percentMaiorIdade);
        System.out.print("Idade abaixo de " + escolhaIdade + ": ");
        System.out.printf("%d (%.2f%%)\n", quantMenorIdade, percentMenorIdade);
        System.out.print("Idade igual a " + escolhaIdade + ": ");
        System.out.printf("%d (%.2f%%)\n", quantMediaIdade, percentMediaIdade);
        System.out.print("Peso acima de " + escolhaPeso + ": ");
        System.out.printf("%d (%.2f%%)\n", quantMaiorPeso, percentMaiorPeso);
        System.out.print("Peso abaixo de " + escolhaPeso + ": ");
        System.out.printf("%d (%.2f%%)\n", quantMenorPeso, percentMenorPeso);
        System.out.print("Peso igual a " + escolhaPeso + ": ");
        System.out.printf("%d (%.2f%%)\n", quantMediaPeso, percentMediaPeso);
        int qtdeCaracteres = 0;
        int espacoNomeTabela = 0;
        int espacoNomeTitulo = 0;
        int linha = 0;
        int diferenca = 0;
        String mensagem = "";
        int mensagemEscolha = 0;
        for(int i = 0; i < contador; i++){
            if(idades[i] > escolhaIdade){
                if(i == 0){
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
                else if (nomes[i].length() > espacoNomeTabela) {
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
            }
        }
        mensagem = "Idade Acima de: ";
        mensagemEscolha = String.valueOf(escolhaIdade).length();
        espacoNomeTitulo = espacoNomeTabela - 4;
        linha = espacoNomeTitulo + 17;
        qtdeCaracteres = (linha - mensagem.length() - mensagemEscolha) / 2;
        diferenca = linha - mensagem.length() - mensagemEscolha - qtdeCaracteres * 2;
        System.out.print("\n" + gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(mensagem + escolhaIdade);
        System.out.print(gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(gerarCaractere(diferenca, "-") + "\n");
        System.out.print("|ID ");
        System.out.print("|Nome");
        System.out.print(gerarCaractere(espacoNomeTitulo, " "));
        System.out.print("|Idade |\n");
        System.out.print(gerarCaractere(linha, "-"));
        System.out.print("\n");
        for(int i = 0; i < contador; i++){
            if(idades[i] > escolhaIdade){
                System.out.print("|");
                System.out.print(i + 1);
                if(i < 9){
                    qtdeCaracteres = 2;
                }
                else{
                    qtdeCaracteres = 1;
                }
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(nomes[i]);
                qtdeCaracteres = (espacoNomeTabela - nomes[i].length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(idades[i]);
                qtdeCaracteres = (6 - String.valueOf(idades[i]).length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|\n");
            }
        }
        for(int i = 0; i < contador; i++){
            if(idades[i] == escolhaIdade){
                if(i == 0){
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
                else if (nomes[i].length() > espacoNomeTabela) {
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
            }
        }
        mensagem = "Idade Igual a: ";
        mensagemEscolha = String.valueOf(escolhaIdade).length();
        espacoNomeTitulo = espacoNomeTabela - 4;
        linha = espacoNomeTitulo + 17;
        qtdeCaracteres = (linha - mensagem.length() - mensagemEscolha) / 2;
        diferenca = linha - mensagem.length() - mensagemEscolha - qtdeCaracteres * 2;
        System.out.print("\n" + gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(mensagem + escolhaIdade);
        System.out.print(gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(gerarCaractere(diferenca, "-") + "\n");
        System.out.print("|ID ");
        System.out.print("|Nome");
        System.out.print(gerarCaractere(espacoNomeTitulo, " "));
        System.out.print("|Idade |\n");
        System.out.print(gerarCaractere(linha, "-"));
        System.out.print("\n");
        for(int i = 0; i < contador; i++){
            if(idades[i] == escolhaIdade){
                System.out.print("|");
                System.out.print(i + 1);
                if(i < 9){
                    qtdeCaracteres = 2;
                }
                else{
                    qtdeCaracteres = 1;
                }
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(nomes[i]);
                qtdeCaracteres = (espacoNomeTabela - nomes[i].length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(idades[i]);
                qtdeCaracteres = (6 - String.valueOf(idades[i]).length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|\n");
            }
        }
        for(int i = 0; i < contador; i++){
            if(idades[i] < escolhaIdade){
                if(i == 0){
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
                else if (nomes[i].length() > espacoNomeTabela) {
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
            }
        }
        mensagem = "Idade Abaixo de: ";
        mensagemEscolha = String.valueOf(escolhaIdade).length();
        espacoNomeTitulo = espacoNomeTabela - 4;
        linha = espacoNomeTitulo + 17;
        qtdeCaracteres = (linha - mensagem.length() - mensagemEscolha) / 2;
        diferenca = linha - mensagem.length() - mensagemEscolha - qtdeCaracteres * 2;
        System.out.print("\n" + gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(mensagem + escolhaIdade);
        System.out.print(gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(gerarCaractere(diferenca, "-") + "\n");
        System.out.print("|ID ");
        System.out.print("|Nome");
        System.out.print(gerarCaractere(espacoNomeTitulo, " "));
        System.out.print("|Idade |\n");
        System.out.print(gerarCaractere(linha, "-"));
        System.out.print("\n");
        for(int i = 0; i < contador; i++){
            if(idades[i] < escolhaIdade){
                System.out.print("|");
                System.out.print(i + 1);
                if(i < 9){
                    qtdeCaracteres = 2;
                }
                else{
                    qtdeCaracteres = 1;
                }
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(nomes[i]);
                qtdeCaracteres = (espacoNomeTabela - nomes[i].length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(idades[i]);
                qtdeCaracteres = (6 - String.valueOf(idades[i]).length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|\n");
            }
        }
        for(int i = 0; i < contador; i++){
            if(pesos[i] > escolhaPeso){
                if(i == 0){
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
                else if (nomes[i].length() > espacoNomeTabela) {
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
            }
        }
        for(int i = 0; i < contador; i++){
            if(pesos[i] == escolhaPeso){
                if(i == 0){
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
                else if (nomes[i].length() > espacoNomeTabela) {
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
            }
        }
        mensagem = "Peso Acima de: ";
        mensagemEscolha = String.valueOf(escolhaPeso).length();
        espacoNomeTitulo = espacoNomeTabela - 4;
        linha = espacoNomeTitulo + 17;
        qtdeCaracteres = (linha - mensagem.length() - mensagemEscolha) / 2;
        diferenca = linha - mensagem.length() - mensagemEscolha - qtdeCaracteres * 2;
        System.out.print("\n" + gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(mensagem + escolhaPeso);
        System.out.print(gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(gerarCaractere(diferenca, "-") + "\n");
        System.out.print("|ID ");
        System.out.print("|Nome");
        System.out.print(gerarCaractere(espacoNomeTitulo, " "));
        System.out.print("|Peso  |\n");
        System.out.print(gerarCaractere(linha, "-"));
        System.out.print("\n");
        for(int i = 0; i < contador; i++){
            if(pesos[i] > escolhaPeso){
                System.out.print("|");
                System.out.print(i + 1);
                if(i < 9){
                    qtdeCaracteres = 2;
                }
                else{
                    qtdeCaracteres = 1;
                }
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(nomes[i]);
                qtdeCaracteres = (espacoNomeTabela - nomes[i].length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(pesos[i]);
                qtdeCaracteres = (6 - String.valueOf(pesos[i]).length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|\n");
            }
        }
        mensagem = "Peso Igual a: ";
        mensagemEscolha = String.valueOf(escolhaPeso).length();
        espacoNomeTitulo = espacoNomeTabela - 4;
        linha = espacoNomeTitulo + 17;
        qtdeCaracteres = (linha - mensagem.length() - mensagemEscolha) / 2;
        diferenca = linha - mensagem.length() - mensagemEscolha - qtdeCaracteres * 2;
        System.out.print("\n" + gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(mensagem + escolhaPeso);
        System.out.print(gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(gerarCaractere(diferenca, "-") + "\n");
        System.out.print("|ID ");
        System.out.print("|Nome");
        System.out.print(gerarCaractere(espacoNomeTitulo, " "));
        System.out.print("|Peso  |\n");
        System.out.print(gerarCaractere(linha, "-"));
        System.out.print("\n");
        for(int i = 0; i < contador; i++){
            if(pesos[i] == escolhaPeso){
                System.out.print("|");
                System.out.print(i + 1);
                if(i < 9){
                    qtdeCaracteres = 2;
                }
                else{
                    qtdeCaracteres = 1;
                }
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(nomes[i]);
                qtdeCaracteres = (espacoNomeTabela - nomes[i].length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(pesos[i]);
                qtdeCaracteres = (6 - String.valueOf(pesos[i]).length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|\n");
            }
        }
        for(int i = 0; i < contador; i++){
            if(pesos[i] < escolhaPeso){
                if(i == 0){
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
                else if (nomes[i].length() > espacoNomeTabela) {
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
            }
        }
        mensagem = "Peso Abaixo de: ";
        mensagemEscolha = String.valueOf(escolhaPeso).length();
        espacoNomeTitulo = espacoNomeTabela - 4;
        linha = espacoNomeTitulo + 17;
        qtdeCaracteres = (linha - mensagem.length() - mensagemEscolha) / 2;
        diferenca = linha - mensagem.length() - mensagemEscolha - qtdeCaracteres * 2;
        System.out.print("\n" + gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(mensagem + escolhaPeso);
        System.out.print(gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(gerarCaractere(diferenca, "-") + "\n");
        System.out.print("|ID ");
        System.out.print("|Nome");
        System.out.print(gerarCaractere(espacoNomeTitulo, " "));
        System.out.print("|Peso  |\n");
        System.out.print(gerarCaractere(linha, "-"));
        System.out.print("\n");
        for(int i = 0; i < contador; i++){
            if(pesos[i] < escolhaPeso){
                System.out.print("|");
                System.out.print(i + 1);
                if(i < 9){
                    qtdeCaracteres = 2;
                }
                else{
                    qtdeCaracteres = 1;
                }
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(nomes[i]);
                qtdeCaracteres = (espacoNomeTabela - nomes[i].length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(pesos[i]);
                qtdeCaracteres = (6 - String.valueOf(pesos[i]).length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|\n");
            }
        }
    }
    static void tabelaMaiorIdadeMedia(){
        int qtdeCaracteres = 0;
        int espacoNomeTabela = 0;
        int espacoNomeTitulo = 0;
        int linha = 0;
        int diferenca = 0;
        String mensagem = "";
        for(int i = 0; i < contador; i++){
            if(idades[i] > mediaIdade()){
                if(i == 0){
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
                else if (nomes[i].length() > espacoNomeTabela) {
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
            }
        }
        mensagem = "Idade Acima da Média:";
        espacoNomeTitulo = espacoNomeTabela - 4;
        linha = espacoNomeTitulo + 17;
        qtdeCaracteres = (linha - mensagem.length()) / 2;
        diferenca = linha - mensagem.length() - qtdeCaracteres * 2;
        System.out.print("\n" + gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(mensagem);
        System.out.print(gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(gerarCaractere(diferenca, "-") + "\n");
        System.out.print("|ID ");
        System.out.print("|Nome");
        System.out.print(gerarCaractere(espacoNomeTitulo, " "));
        System.out.print("|Idade |\n");
        System.out.print(gerarCaractere(linha, "-"));
        System.out.print("\n");
        for(int i = 0; i < contador; i++){
            if(idades[i] > mediaIdade()){
                System.out.print("|");
                System.out.print(i + 1);
                if(i < 9){
                    qtdeCaracteres = 2;
                }
                else{
                    qtdeCaracteres = 1;
                }
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(nomes[i]);
                qtdeCaracteres = (espacoNomeTabela - nomes[i].length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(idades[i]);
                qtdeCaracteres = (6 - String.valueOf(idades[i]).length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|\n");
            }
        }
    }
    static void tabelaMenorIdadeMedia(){
        int qtdeCaracteres = 0;
        int espacoNomeTabela = 0;
        int espacoNomeTitulo = 0;
        int linha = 0;
        int diferenca = 0;
        String mensagem = "";
        for(int i = 0; i < contador; i++){
            if(idades[i] < mediaIdade()){
                if(i == 0){
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
                else if (nomes[i].length() > espacoNomeTabela) {
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
            }
        }
        mensagem = "Idade Abaixo da Média:";
        espacoNomeTitulo = espacoNomeTabela - 4;
        linha = espacoNomeTitulo + 17;
        qtdeCaracteres = (linha - mensagem.length()) / 2;
        diferenca = linha - mensagem.length() - qtdeCaracteres * 2;
        System.out.print("\n" + gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(mensagem);
        System.out.print(gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(gerarCaractere(diferenca, "-") + "\n");
        System.out.print("|ID ");
        System.out.print("|Nome");
        System.out.print(gerarCaractere(espacoNomeTitulo, " "));
        System.out.print("|Idade |\n");
        System.out.print(gerarCaractere(linha, "-"));
        System.out.print("\n");
        for(int i = 0; i < contador; i++){
            if(idades[i] < mediaIdade()){
                System.out.print("|");
                System.out.print(i + 1);
                if(i < 9){
                    qtdeCaracteres = 2;
                }
                else{
                    qtdeCaracteres = 1;
                }
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(nomes[i]);
                qtdeCaracteres = (espacoNomeTabela - nomes[i].length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(idades[i]);
                qtdeCaracteres = (6 - String.valueOf(idades[i]).length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|\n");
            }
        }
    }
    static void tabelaMaiorPesoMedia(){
        int qtdeCaracteres = 0;
        int espacoNomeTabela = 0;
        int espacoNomeTitulo = 0;
        int linha = 0;
        int diferenca = 0;
        String mensagem = "";
        for(int i = 0; i < contador; i++){
            if(pesos[i] > mediaPeso()){
                if(i == 0){
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
                else if (nomes[i].length() > espacoNomeTabela) {
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
            }
        }
        mensagem = "Peso Acima da Média:";
        espacoNomeTitulo = espacoNomeTabela - 4;
        linha = espacoNomeTitulo + 17;
        qtdeCaracteres = (linha - mensagem.length()) / 2;
        diferenca = linha - mensagem.length() - qtdeCaracteres * 2;
        System.out.print("\n" + gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(mensagem);
        System.out.print(gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(gerarCaractere(diferenca, "-") + "\n");
        System.out.print("|ID ");
        System.out.print("|Nome");
        System.out.print(gerarCaractere(espacoNomeTitulo, " "));
        System.out.print("|Peso  |\n");
        System.out.print(gerarCaractere(linha, "-"));
        System.out.print("\n");
        for(int i = 0; i < contador; i++){
            if(pesos[i] > mediaPeso()){
                System.out.print("|");
                System.out.print(i + 1);
                if(i < 9){
                    qtdeCaracteres = 2;
                }
                else{
                    qtdeCaracteres = 1;
                }
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(nomes[i]);
                qtdeCaracteres = (espacoNomeTabela - nomes[i].length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(pesos[i]);
                qtdeCaracteres = (6 - String.valueOf(pesos[i]).length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|\n");
            }
        }
    }
    static void tabelaMenorPesoMedia(){
        int qtdeCaracteres = 0;
        int espacoNomeTabela = 0;
        int espacoNomeTitulo = 0;
        int linha = 0;
        int diferenca = 0;
        String mensagem = "";
        for(int i = 0; i < contador; i++){
            if(pesos[i] < mediaPeso()){
                if(i == 0){
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
                else if (nomes[i].length() > espacoNomeTabela) {
                    espacoNomeTabela = String.valueOf(nomes[i]).length();
                }
            }
        }
        mensagem = "Peso Abaixo da Média:";
        espacoNomeTitulo = espacoNomeTabela - 4;
        linha = espacoNomeTitulo + 17;
        qtdeCaracteres = (linha - mensagem.length()) / 2;
        diferenca = linha - mensagem.length() - qtdeCaracteres * 2;
        System.out.print("\n" + gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(mensagem);
        System.out.print(gerarCaractere(qtdeCaracteres, "-"));
        System.out.print(gerarCaractere(diferenca, "-") + "\n");
        System.out.print("|ID ");
        System.out.print("|Nome");
        System.out.print(gerarCaractere(espacoNomeTitulo, " "));
        System.out.print("|Peso  |\n");
        System.out.print(gerarCaractere(linha, "-"));
        System.out.print("\n");
        for(int i = 0; i < contador; i++){
            if(pesos[i] < mediaPeso()){
                System.out.print("|");
                System.out.print(i + 1);
                if(i < 9){
                    qtdeCaracteres = 2;
                }
                else{
                    qtdeCaracteres = 1;
                }
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(nomes[i]);
                qtdeCaracteres = (espacoNomeTabela - nomes[i].length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|");
                System.out.print(pesos[i]);
                qtdeCaracteres = (6 - String.valueOf(pesos[i]).length());
                System.out.print(gerarCaractere(qtdeCaracteres, " "));
                System.out.print("|\n");
            }
        }
    }
}