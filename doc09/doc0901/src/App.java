import org.apache.commons.lang3.StringUtils;

public class App {
    public static void main(String[] args) {
        String texto = "   Hello, World!   ";
        // Remover espaços extras no começo e no final
        String textoTrimmed = StringUtils.trim(texto);
        System.out.println("Texto original: '" + texto + "'");
        System.out.println("Texto sem espaços extras: '" + textoTrimmed + "'");

        // Verificar se a string é vazia
        if (StringUtils.isEmpty(textoTrimmed)) {
            System.out.println("Texto está vazio!");
        } else {
            System.out.println("Texto não está vazio.");
        }

        // Inverter a string
        String textoInvertido = StringUtils.reverse(textoTrimmed);
        System.out.println("Texto invertido: " + textoInvertido);
    }
}