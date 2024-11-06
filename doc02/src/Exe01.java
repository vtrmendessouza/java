import java.util.Scanner;
public class Exe01{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
            
        double comprimento = 0, largura = 0, valorMetroQuadrado = 0, areaTotal = 0, valorFinal = 0;
            
        System.out.print("Informe o comprimento do terreno em metros: ");
        comprimento = teclado.nextDouble();
        System.out.print("Informe a largura do terreno em metros: ");
        largura = teclado.nextDouble();
        System.out.print("Informe o valor do metro quadrado em reais: ");
        valorMetroQuadrado = teclado.nextDouble();
            
        areaTotal= comprimento * largura;
        valorFinal= areaTotal * valorMetroQuadrado;
            
        System.out.printf("O tamanho do terreno é de: %.2f metros.\n", areaTotal);
        System.out.printf("O valor do terreno é de : %.2f reais.\n", valorFinal);
        teclado.close();
    }
}
