public class Mirian {
   

static void exibirVitoriaUsuario() {
    System.out.println("usuario Venceu!");
    System.out.println("""
        \t\t\t          /////////
        \t\t\t    \\\\|/////////
        \t\t\t     \\/////////
        \t\t\t     |         |
        \t\t\t    (| --- --- |)
        \t\t\t     |  0   0  |
        \t\t\t     |    .    |
        \t\t\t     |  |___|  |
        \t\t\t     |_________|
        \t\t\t        |   |
        \t\t\t        |   |
        \t\t\t       /     \\\
        \t\t\t      /       \\\

            \n\n\n""");


    }

 static void exibirVitoriaComputador() {
    System.out.println("o computador venceu!");
    System.out.println("""
            \t\t\t    +---------------+
            \t\t\t    | +-----------+ |
            \t\t\t    | | __    __  | |
            \t\t\t    | |  0    0   | |
            \t\t\t    | |    -      | |
            \t\t\t    | |   |__|    | |
            \t\t\t    | |           | |
            \t\t\t    | +-----------+ |
            \t\t\t    +-----+---+-----+
            \t\t\t    ____|/    \\|____
            \t\t\t   /                \\
            \t\t\t  /  --------------- \\
            \t\t\t /   ---------------  \\
            \t\t\t +---------------------+     \n\n""");
    }

public static void main(String[] args){
      exibirVitoriaComputador();
      exibirVitoriaUsuario();
}



}
