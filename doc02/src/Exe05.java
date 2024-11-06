import java.util.Scanner;
public class Exe05{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
            
        double quantidadeFrango = 0;
            
        System.out.print("Informe a quantidade de frangos: ");
        quantidadeFrango = teclado.nextDouble();

        System.out.printf("O custo para identificar os frangos é de: R$ %.2f.\n", quantidadeFrango * (4 + (3.5 * 2)));
        teclado.close();
    }
}
