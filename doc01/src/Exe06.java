import java.util.Scanner;
public class Exe06{
	public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        double a, b, c;
        a = teclado.nextDouble();
        b = teclado.nextDouble();
        c = teclado.nextDouble();
        
        System.out.printf("TRIANGULO: %.3f\n", a * c / 2);
        System.out.printf("CIRCULO: %.3f\n", c * c * 3.14159);
        System.out.printf("TRAPEZIO: %.3f\n", (a + b) * c / 2);
        System.out.printf("QUADRADO: %.3f\n", b * b);
        System.out.printf("RETANGULO: %.3f\n", a * b);
        teclado.close();
    }
}