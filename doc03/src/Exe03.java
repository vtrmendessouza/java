/*
Exercício 03:
Uma loja de venda de frutas está vendendo frutas com a seguinte tabela de preços:
Até 5 Kg: Morango R$ 2,50 por Kg e Maçã R$ 1,80 por Kg.
Acima de 5 Kg: Morango R$ 2,20 por Kg e Maçã R$ 1,50 por Kg.
Se o cliente comprar mais de 8 Kg em frutas ou o valor total da compra ultrapassar R$ 25,00
receberá ainda um desconto de 10% sobre este total.
Escreva um algoritmo para ler a quantidade (em Kg) de morangos,
e a quantidade (em Kg) de maças adquiridas e escreva o valor a ser pago pelo cliente.
*/
import java.util.Scanner;
import java.util.InputMismatchException;
public class Exe03{
    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        int senhaSistema = 1234, senhaAdministrador = 0, respostaUsuario = 0;
        float precoMorango = 2.5f, metaDescontoMorango = 5, descontoMorango = 0.12f, quantidadeMorango = 0, valorFinalMorango = 0;
        float precoMaca = 1.8f, metaDescontoMaca = 5, descontoMaca = 0.17f, quantidadeMaca = 0, valorFinalMaca = 0;
        float metaDescontoPeso = 8, metaDescontoValor = 25, descontoFinal = 0.1f, valorFinalMaior = 0, ValorFinalDefinitivo = 0;

        System.out.print("Bem vindo!\n");
//Verificação de usuário:
        do{
            try{
                System.out.print("Digite 1 para cliente, 2 para administrador ou 3 para encerrar: ");
                respostaUsuario = teclado.nextInt();
                teclado.nextLine();
                if(respostaUsuario != 1 && respostaUsuario != 2 && respostaUsuario != 3){
                    System.out.print("Dados incorretos.\n");
                }
            }
            catch(InputMismatchException variavelDivergente){
                System.out.print("Dados incorretos.\n");
                teclado.nextLine();
            }
        }
        while(respostaUsuario != 1 && respostaUsuario != 2 && respostaUsuario != 3);
        if(respostaUsuario == 3){
            System.out.print("Até breve!");
            teclado.close();
            System.exit(0);
        }
//Verificação de senha:
        if(respostaUsuario == 2){
            do{
                try{
                    System.out.print("Digite a senha ou 0 para encerrar: ");
                    senhaAdministrador = teclado.nextInt();
                    teclado.nextLine();
                    if(senhaAdministrador != senhaSistema && senhaAdministrador != 0){
                        System.out.print("Dados incorretos.\n");
                    }
                }
                catch(InputMismatchException variavelDivergente){
                    System.out.print("Dado incorreto.\n");
                    teclado.nextLine();
                }
            }
            while(senhaAdministrador != senhaSistema && senhaAdministrador != 0);
            if(senhaAdministrador == 0){
                System.out.print("Até breve!");
                teclado.close();
                System.exit(0);
            }
//Início de alterações:
            if(senhaAdministrador == senhaSistema){
//Decisão de preço de morango:
                System.out.print("Deseja alterar o preço do morango?\n");
                do{
                    try{
                        System.out.print("Digite 1 para SIM ou 2 para NAO: ");
                        respostaUsuario = teclado.nextInt();
                        teclado.nextLine();
                        if(respostaUsuario != 1 && respostaUsuario != 2){
                            System.out.print("Dados incorretos.\n");
                        }
                    }
                    catch(InputMismatchException variavelDivergente){
                        System.out.print("Dados incorretos.\n");
                        teclado.nextLine();
                    }
                }
                while(respostaUsuario != 1 && respostaUsuario != 2);
//Alteração de preço de morango:
                if(respostaUsuario == 1){
                    do{
                        try{
                            System.out.print("Digite o preço do morango: ");
                            precoMorango = teclado.nextFloat();
                            teclado.nextLine();
                            if(precoMorango <= 0){
                                System.out.print("Dados incorretos.\n");
                            }
                        }
                        catch(InputMismatchException variavelDivergente){
                            System.out.print("Dados incorretos.\n");
                            teclado.nextLine();
                        }
                    }
                    while (precoMorango <= 0);
                }
//Decisão de peso máximo sem desconto de morango:
                System.out.print("Deseja alterar o peso máximo sem desconto do morango?\n");
                do{
                    try{
                        System.out.print("Digite 1 para SIM ou 2 para NAO: ");
                        respostaUsuario = teclado.nextInt();
                        teclado.nextLine();
                        if(respostaUsuario != 1 && respostaUsuario != 2){
                            System.out.print("Dados incorretos.\n");
                        }
                    }
                    catch(InputMismatchException variavelDivergente){
                        System.out.print("Dados incorretos.\n");
                        teclado.nextLine();
                    }
                }
                while(respostaUsuario != 1 && respostaUsuario != 2);
//Alteração de peso máximo sem desconto de morango:
                if(respostaUsuario == 1){
                    do{
                        try{
                            System.out.print("Digite o peso máximo sem desconto no morango: ");
                            metaDescontoMorango = teclado.nextFloat();
                            teclado.nextLine();
                            if(metaDescontoMorango <= 0){
                                System.out.print("Dados incorretos.\n");
                            }
                        }
                        catch(InputMismatchException variavelDivergente){
                            System.out.print("Dados incorretos.\n");
                            teclado.nextLine();
                        }
                    }
                    while (metaDescontoMorango <= 0);
                }
//Decisão de desconto de morango:
                System.out.print("Deseja alterar o desconto do morango?\n");
                do{
                    try{
                        System.out.print("Digite 1 para SIM ou 2 para NAO: ");
                        respostaUsuario = teclado.nextInt();
                        teclado.nextLine();
                        if(respostaUsuario != 1 && respostaUsuario != 2){
                            System.out.print("Dados incorretos.\n");
                        }
                    }
                    catch(InputMismatchException variavelDivergente){
                        System.out.print("Dados incorretos.\n");
                        teclado.nextLine();
                    }
                }
                while(respostaUsuario != 1 && respostaUsuario != 2);
//Alteração de desconto de morango:
                if(respostaUsuario == 1){
                    do{
                        try{
                            System.out.print("Digite o desconto para o morango: ");
                            descontoMorango = teclado.nextFloat();
                            teclado.nextLine();
                            if(descontoMorango <= 0){
                                System.out.print("Dados incorretos.\n");
                            }
                        }
                        catch(InputMismatchException variavelDivergente){
                            System.out.print("Dados incorretos.\n");
                        teclado.nextLine();
                        }
                    }
                    while (descontoMorango <= 0);
                }
//Decisão de preço de maçã:
                System.out.print("Deseja alterar o preço da maçã?\n");
                do{
                    try{
                        System.out.print("Digite 1 para SIM ou 2 para NAO: ");
                        respostaUsuario = teclado.nextInt();
                        teclado.nextLine();
                        if(respostaUsuario != 1 && respostaUsuario != 2){
                            System.out.print("Dados incorretos.\n");
                        }
                    }
                    catch(InputMismatchException variavelDivergente){
                        System.out.print("Dados incorretos.\n");
                        teclado.nextLine();
                    }
                }
                while(respostaUsuario != 1 && respostaUsuario != 2);
//Alteração de preço de maçã:
                if(respostaUsuario == 1){
                    do{
                        try{
                            System.out.print("Digite o preço da maçã: ");
                            precoMaca = teclado.nextFloat();
                            teclado.nextLine();
                            if(precoMaca <= 0){
                                System.out.print("Dados incorretos.\n");
                            }
                        }
                        catch(InputMismatchException variavelDivergente){
                            System.out.print("Dados incorretos.\n");
                            teclado.nextLine();
                        }
                    }
                    while (precoMaca <= 0);
                }
//Decisão de peso máximo sem desconto de maçã:
                System.out.print("Deseja alterar o peso máximo sem desconto da maçã?\n");
                do{
                    try{
                        System.out.print("Digite 1 para SIM ou 2 para NAO: ");
                        respostaUsuario = teclado.nextInt();
                        teclado.nextLine();
                        if(respostaUsuario != 1 && respostaUsuario != 2){
                            System.out.print("Dados incorretos.\n");
                        }
                    }
                    catch(InputMismatchException variavelDivergente){
                        System.out.print("Dados incorretos.\n");
                        teclado.nextLine();
                    }
                }
                while(respostaUsuario != 1 && respostaUsuario != 2);
//Alteração de peso máximo sem desconto de maçã:
                if(respostaUsuario == 1){
                    do{
                        try{
                            System.out.print("Digite o peso máximo sem desconto na maçã: ");
                            metaDescontoMaca = teclado.nextFloat();
                            teclado.nextLine();
                            if(metaDescontoMaca <= 0){
                                System.out.print("Dados incorretos.\n");
                            }
                        }
                        catch(InputMismatchException variavelDivergente){
                            System.out.print("Dados incorretos.\n");
                            teclado.nextLine();
                        }
                    }
                    while (metaDescontoMaca <= 0);
                }
//Decisão de desconto de maçã:
                System.out.print("Deseja alterar o desconto da maçã?\n");
                do{
                    try{
                        System.out.print("Digite 1 para SIM ou 2 para NAO: ");
                        respostaUsuario = teclado.nextInt();
                        teclado.nextLine();
                        if(respostaUsuario != 1 && respostaUsuario != 2){
                            System.out.print("Dados incorretos.\n");
                        }
                    }
                    catch(InputMismatchException variavelDivergente){
                        System.out.print("Dados incorretos.\n");
                        teclado.nextLine();
                    }
                }
                while(respostaUsuario != 1 && respostaUsuario != 2);
//Alteração de desconto de maçã:
                if(respostaUsuario == 1){
                    do{
                        try{
                            System.out.print("Digite o desconto para a maçã: ");
                            descontoMaca = teclado.nextFloat();
                            teclado.nextLine();
                            if(descontoMaca <= 0){
                                System.out.print("Dados incorretos.\n");
                            }
                        }
                        catch(InputMismatchException variavelDivergente){
                            System.out.print("Dados incorretos.\n");
                            teclado.nextLine();
                        }
                    }
                    while (descontoMaca <= 0);
                }
//Decisão de peso mínimo total para desconto:
                System.out.print("Deseja alterar o peso total mínimo para desconto?\n");
                do{
                    try{
                        System.out.print("Digite 1 para SIM ou 2 para NAO: ");
                        respostaUsuario = teclado.nextInt();
                        teclado.nextLine();
                        if(respostaUsuario != 1 && respostaUsuario != 2){
                            System.out.print("Dados incorretos.\n");
                        }
                    }
                    catch(InputMismatchException variavelDivergente){
                        System.out.print("Dados incorretos.\n");
                        teclado.nextLine();
                    }
                }
                while(respostaUsuario != 1 && respostaUsuario != 2);
//Alteração de peso mínimo total para desconto:
                if(respostaUsuario == 1){
                    do{
                        try{
                            System.out.print("Digite o peso total mínimo para desconto: ");
                            metaDescontoPeso = teclado.nextFloat();
                            teclado.nextLine();
                            if(metaDescontoPeso <= 0){
                                System.out.print("Dados incorretos.\n");
                            }
                        }
                        catch(InputMismatchException variavelDivergente){
                            System.out.print("Dados incorretos.\n");
                            teclado.nextLine();
                        }
                    }
                    while (metaDescontoPeso <= 0);
                }
//Decisão de valor mínimo total para desconto:
                System.out.print("Deseja alterar o valor total mínimo para desconto?\n");
                do{
                    try{
                        System.out.print("Digite 1 para SIM ou 2 para NAO: ");
                        respostaUsuario = teclado.nextInt();
                        teclado.nextLine();
                        if(respostaUsuario != 1 && respostaUsuario != 2){
                            System.out.print("Dados incorretos.\n");
                        }
                    }
                    catch(InputMismatchException variavelDivergente){
                        System.out.print("Dados incorretos.\n");
                        teclado.nextLine();
                    }
                }
                while(respostaUsuario != 1 && respostaUsuario != 2);
//Alteração de valor total mínimo para desconto:
                if(respostaUsuario == 1){
                    do{
                        try{
                            System.out.print("Digite o valor total mínimo para desconto: ");
                            metaDescontoValor = teclado.nextFloat();
                            teclado.nextLine();
                            if(metaDescontoValor <= 0){
                                System.out.print("Dados incorretos.\n");
                            }
                        }
                        catch(InputMismatchException variavelDivergente){
                            System.out.print("Dados incorretos.\n");
                            teclado.nextLine();
                        }
                    }
                    while (metaDescontoValor <= 0);
                }
//Decisão de valor mínimo total para desconto:
                System.out.print("Deseja alterar o desconto final?\n");
                do{
                    try{
                        System.out.print("Digite 1 para SIM ou 2 para NAO: ");
                        respostaUsuario = teclado.nextInt();
                        teclado.nextLine();
                        if(respostaUsuario != 1 && respostaUsuario != 2){
                            System.out.print("Dados incorretos.\n");
                        }
                    }
                    catch(InputMismatchException variavelDivergente){
                        System.out.print("Dados incorretos.\n");
                        teclado.nextLine();
                    }
                }
                while(respostaUsuario != 1 && respostaUsuario != 2);
//Alteração de desconto final:
                if(respostaUsuario == 1){
                    do{
                        try{
                            System.out.print("Digite o desconto final: ");
                            descontoFinal = teclado.nextFloat();
                            teclado.nextLine();
                            if(descontoFinal <= 0){
                                System.out.print("Dados incorretos.\n");
                            }
                        }
                        catch(InputMismatchException variavelDivergente){
                            System.out.print("Dados incorretos.\n");
                            teclado.nextLine();
                        }
                    }
                    while(descontoFinal <= 0);
                }
                System.out.print("Dados atualizados.\n");
            }
        }
//Opção de iniciar compra ou encerrar após ateração de dados:
        do{
            try{
                System.out.print("Digite 1 para cliente, ou 2 para encerrar: ");
                respostaUsuario = teclado.nextInt();
                teclado.nextLine();
                if(respostaUsuario != 1 && respostaUsuario != 2 && respostaUsuario != 3){
                    System.out.print("Dados incorretos.\n");
                }
            }
            catch(InputMismatchException variavelDivergente){
                System.out.print("Dados incorretos.\n");
                teclado.nextLine();
            }
        }
        while(respostaUsuario != 1 && respostaUsuario != 2);
        if(respostaUsuario == 2){
            System.out.print("Até breve!");
            teclado.close();
            System.exit(0);
        }
//Início da compra:
//Decisão de morango:
        do{
            System.out.print("Deseja adicionar morango?\n");
            do{
                try{
                    System.out.print("Digite 1 para SIM ou 2 para NAO: ");
                    respostaUsuario = teclado.nextInt();
                    teclado.nextLine();
                    if(respostaUsuario != 1 && respostaUsuario != 2){
                        System.out.print("Dados incorretos.\n");
                    }
                }
                catch(InputMismatchException variavelDivergente){
                    System.out.print("Dados incorretos.\n");
                    teclado.nextLine();
                }
            }
            while(respostaUsuario != 1 && respostaUsuario != 2);
//Quantidade de morango:
            if(respostaUsuario == 1){
                do{
                    try{
                    System.out.print("Digite a quantidade de morango em quilos: ");
                    quantidadeMorango = teclado.nextFloat();
                    teclado.nextLine();
                        if(quantidadeMorango <= 0){
                            System.out.print("Dados incorretos.\n");
                        }
                    }
                    catch(InputMismatchException variavelDivergente){
                        System.out.print("Dados incorretos.\n");
                        teclado.nextLine();
                    }
                }
                while (quantidadeMorango <= 0);
            }
//Decisão de maçã:
            System.out.print("Deseja adicionar maçã?\n");
            do{
                try{
                    System.out.print("Digite 1 para SIM ou 2 para NAO: ");
                    respostaUsuario = teclado.nextInt();
                    teclado.nextLine();
                    if(respostaUsuario != 1 && respostaUsuario != 2){
                        System.out.print("Dados incorretos.\n");
                    }
                }
                catch(InputMismatchException variavelDivergente){
                    System.out.print("Dados incorretos.\n");
                    teclado.nextLine();
                }
            }
            while(respostaUsuario != 1 && respostaUsuario != 2);
//Quantidade de maçã:
            if(respostaUsuario == 1){
                do{
                    try{
                        System.out.print("Digite a quantidade de maçã em quilos: ");
                        quantidadeMaca = teclado.nextFloat();
                        teclado.nextLine();
                        if(quantidadeMaca <= 0){
                            System.out.print("Dados incorretos.\n");
                        }
                    }
                    catch(InputMismatchException variavelDivergente){
                        System.out.print("Dados incorretos.\n");
                        teclado.nextLine();
                    }
                }
            while (quantidadeMaca <= 0);
            }
//Cálculo de morango:
            if(quantidadeMorango > metaDescontoMorango){
                valorFinalMorango = quantidadeMorango * (precoMorango - (precoMorango * descontoMorango));
            }
            else{
                valorFinalMorango = quantidadeMorango * precoMorango;
            }
//Cálculo de maçã:
            if(quantidadeMaca > metaDescontoMaca){
                valorFinalMaca = quantidadeMaca * (precoMaca - (precoMaca * descontoMaca));

            }
            else{
                valorFinalMaca = quantidadeMaca * precoMaca;
            }
//Cálculo de total:
            valorFinalMaior = (quantidadeMorango * precoMorango) + (quantidadeMaca * precoMaca);
            ValorFinalDefinitivo = valorFinalMorango + valorFinalMaca;
            if(ValorFinalDefinitivo >= metaDescontoValor || (quantidadeMorango + quantidadeMaca) >= metaDescontoPeso){
                ValorFinalDefinitivo = ValorFinalDefinitivo - (ValorFinalDefinitivo * descontoFinal);
            }
            System.out.printf("Valor total: R$%.2f\n", ValorFinalDefinitivo);
            if(ValorFinalDefinitivo < valorFinalMaior){
                System.out.printf("Você economizou: R$%.2f\n", valorFinalMaior - ValorFinalDefinitivo);
            }
            else{
                System.out.print("Não houve desconto.\n");
            }
//Decisão de nova compra:
            System.out.print("Deseja refazer sua compra?\n");
            do{
                try{
                    System.out.print("Digite 1 para SIM ou 2 para NAO: ");
                    respostaUsuario = teclado.nextInt();
                    teclado.nextLine();
                    if(respostaUsuario != 1 && respostaUsuario != 2){
                        System.out.print("Dados incorretos.\n");
                    }
                }
                catch(InputMismatchException variavelDivergente){
                    System.out.print("Dados incorretos.\n");
                    teclado.nextLine();
                }
            }
            while(respostaUsuario != 1 && respostaUsuario != 2);
        }
        while(respostaUsuario == 1);
//Encerramento:
        System.out.print("Até breve!");
        teclado.close();
        System.exit(0);
    }
}