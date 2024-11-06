import java.util.Scanner;
public class Exe06{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
            
        double quantidadeSanduiche = 0;
            
        System.out.print("Informe a quantidade de sanduíches: ");
        quantidadeSanduiche = teclado.nextDouble();

        System.out.printf("Para produzir %.0f sanduíches será necessário:\n", quantidadeSanduiche);
        System.out.printf("%.2f kilos de mussarela.\n", quantidadeSanduiche * 2 * 0.05);
        System.out.printf("%.2f kilos de presunto.\n", quantidadeSanduiche * 0.05);
        System.out.printf("%.2f kilos de hambúrgues.\n", quantidadeSanduiche * 0.12);
        teclado.close();
    }
}
