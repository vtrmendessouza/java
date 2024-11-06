//01: Faça um algoritmo utilizando a estrutura "do while" que imprima na tela os números de 1 à 10.
public class Exe01 {
    public static void main(String[] args) throws Exception {

        int q = 0;

        do{
            for(int i = 0; i < 10; i++){
                q++;
                System.out.printf("%d\n",q);
            }
        }while(q < 10);
    }
}