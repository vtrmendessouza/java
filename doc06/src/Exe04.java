import java.util.Scanner;
public class Exe04 {
    public static void main(String[] args) throws Exception {
            Scanner teclado = new Scanner(System.in);

            int vidasRestantes = 6;
            String letrasCertas = "";
            String letrasTentadas = "";
            char letraChutada;
            String palavra = "treme";

            //contagem de vidas
            do {
                System.out.println("\n\nVidas Restantes: " + vidasRestantes);
                System.out.println("Letras já Tentadas: " + letrasTentadas + "\n");

                exibeForca(vidasRestantes);
                exibePalavraTela(palavra, letrasCertas);

                System.out.println("\n\n");
                System.out.print("\nDigite uma letra: "); 
                //TODO 02: caso o usuario digite uma letra ja tentada, peça uma nova letra
                //ate que seja informado uma letra que ainda nao foi tentada

                letraChutada = teclado.nextLine().toLowerCase().charAt(0);
                
                //atualiza a lista de letras tentadas
                letrasTentadas += letraChutada;

                //atualiza a lista de letras certas
                if (acertouLetra(palavra, letraChutada))
                    letrasCertas += letraChutada;
                else 
                    //tira uma vida
                    vidasRestantes--;
                
                exibePalavraTela(palavra, letrasCertas);
     
                //TODO 03: implemente um bloco de código que verifique
                //se o usuario já descobriu todas as letras da palavra.
                //Uma possibilidade seria aproveitar o exibePalavraTela
                //para descobrir isto. Provavelmente tenha que mudar de void
                //para um metodo que retorna o valor


                System.out.println();
            } while (vidasRestantes > 0);


            //TODO 04: implemente aqui neste ponto, um bloco de comandos
            //que informe uma mensagem dizendo se o jogador ganhou ou perdeu
            //se ele perdeu além da mensagem deve ser exibido a forca completa

            teclado.close();
    }
          
    static boolean acertouLetra(String palavra, char letraChutada){
        return palavra.contains(Character.toString(letraChutada));
    }

    static void exibePalavraTela(String palavraSecreta, String letrasCertas){
        char letra;
        System.out.println("\n\n");

        for (int posicaoLetra = 0; posicaoLetra < palavraSecreta.length(); posicaoLetra++) {
            letra = palavraSecreta.charAt(posicaoLetra);

            if (letrasCertas.contains(Character.toString(letra))) {
                System.out.print("  _" + letra + "_  ");
            } else {
                System.out.print("  ____  ");
            }

        }
    }

    static void exibeForca(int contagemErro){
        switch (contagemErro) {
            case 6:
                System.out.println("""        
                        +---+
                        |   |
                            |
                            |
                            |
                            |
                    ========= """);
                break;
            //TODO 01: implemente aqui o desenho da forca quando a 
            //qtde de vidas restantes for 5, 4, 3, 2, 1
            default:
                break;
        }
    }

        
        //     +---+
        //     |   |
        //         |
        //         |
        //         |
        //         |
        //   =========
           
        //     +---+
        //     |   |
        //     O   |
        //         |
        //         |
        //         |
        //   =========
           
        //     +---+
        //     |   |
        //     O   |
        //     |   |
        //         |
        //         |
        //   =========
           
        //     +---+
        //     |   |
        //     O   |
        //    /|   |
        //         |
        //         |
        //   =========
           
        //     +---+
        //     |   |
        //     O   |
        //    /|\\  |
        //         |
        //         |
        //   =========
           
        //     +---+
        //     |   |
        //     O   |
        //    /|\\  |
        //    /    |
        //         |
        //   =========
           
        //     +---+
        //     |   |
        //     O   |
        //    /|\\  |
        //    / \\  |
        //         |
        //   ========= 
          
            
}
