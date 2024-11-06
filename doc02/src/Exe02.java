import java.util.Scanner;
public class Exe02{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
          
        double salarioMinimo = 0, salarioFuncionario = 0, salarioProporcional = 0;
            
        System.out.print("Informe o valor do salário mínimo em reais: ");
        salarioMinimo = teclado.nextDouble();
        System.out.print("Informe o valor do salário do funcionário em reais: ");
        salarioFuncionario = teclado.nextDouble();
            
        salarioProporcional = salarioFuncionario / salarioMinimo;
    
        System.out.printf("O funcionário recebe: %.1f salarios mínimos.\n", salarioProporcional);
        teclado.close();
    }
}
