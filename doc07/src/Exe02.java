//02: Faça um algoritmo utilizando a estrutura "while" que imprima na tela os números de 1 à 10.
public class Exe02 {
    public static void main(String[] args) throws Exception {

        int q = 0;
        while(q < 10){
            for(int i = 0; i < 10; i++){
                q++;
                System.out.printf("%d\n",q);
            }
        }
    }
}