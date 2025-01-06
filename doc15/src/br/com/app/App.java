package br.com.app;

import org.apache.commons.lang3.StringUtils;
import br.com.service.Teste;

public class App {
    public static void main(String[] args) throws Exception {
        Teste teste = new Teste();

        limparTela();

        teste.nome = "joão";
        teste.peso = 80.5f;

        System.out.println("Nome: " + StringUtils.capitalize(teste.nome) + " Peso: " + teste.peso);
    }

    public static void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Comando para limpar o console no Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Comando para limpar o console em sistemas Unix/Linux/Mac
                new ProcessBuilder("clear").inheritIO().start().waitFor();

            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar limpar a tela: " + e.getMessage());
        }
    }
}
