package exercicioGerirEstoque;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Produtos[] estoque = new Produtos[3];
        estoque[0] = new Produtos("Notebook", "Esse é bom, roda tudo, tem vaŕias RAMs, processadores e tal.", 4500.0f, 8);
        estoque[1] = new Produtos("Celular", "Tem ZapZap, facebook e storys e camera boa.", 1750.0f, 19);
        estoque[2] = new Produtos("Tablet", "Grandão ele, para compensar aquele seu negócio pequeno.", 3275.0f, 12);
        Scanner sc = new Scanner(System.in);
        int opt = 0;
        do {
            System.out.printf("""
                    =============================
                          SISTEMA DE VENDAS
                    =============================
                    [1] Conferir estoque
                    [2] Vender
                    [3] Sair
                    =============================
                    """);
            System.out.printf("Digite uma opção: ");
            opt = sc.nextInt();
            sc.nextLine();
            System.out.println("=============================");
            switch (opt) {
                case 1 -> {
                    System.out.printf("""
                                       ESTOQUE
                            =============================
                            """);
                    for (int i = 0; i < estoque.length; i++) {
                        System.out.println("--------- Produto " + i + " ---------\n" + estoque[i]);
                    }
                    System.out.println("=============================\nDê enter para voltar.");
                    sc.nextLine();
                }

                case 2 -> {
                    System.out.println("""
                                       VENDER
                            =============================
                            """);
                    for (int i = 0; i < estoque.length; i++) {
                        System.out.println("[" + (i+1) + "]" + estoque[i].getNome() + "R$" + estoque[i].getPreco());
                    }
                    System.out.printf("[%d]Voltar\n", estoque.length+1);
                    boolean teste = true;
                    do {
                        System.out.printf("=============================\nDigite uma opção: ");
                        int opcaoCompra = sc.nextInt();
                        sc.nextLine();
                        System.out.println("=============================");
                        System.out.println("-----------------------------");

                        if (opcaoCompra == estoque.length+1 || estoque[opcaoCompra-1].getQtdeEstoque() == 0) {
                            System.out.println(opcaoCompra == 4 ?
                                    "Compra cancelada."
                                    :"Não quantidade suficiente do produto em estoque.");
                            break;
                        } else if (opcaoCompra > estoque.length+1 || opcaoCompra <= 0) {
                            System.out.println("Opção inválida, tente novamente.");
                        } else {
                            opcaoCompra--;
                            System.out.println(estoque[opcaoCompra]);
                            System.out.println("-----------------------------");
                            int quantidade;
                            do {
                                System.out.println("Digite a quantidade desejada: ");
                                quantidade = sc.nextInt();
                                if (quantidade == 0) {
                                    break;
                                } else if (quantidade > 0 && quantidade < estoque[opcaoCompra].getQtdeEstoque()) {
                                    //If do pagamento
                                    System.out.printf("Compra no valor de R$%.2f.\n", estoque[opcaoCompra].getPreco()*quantidade);
                                    System.out.print("Digite o valor do pagamento: ");
                                    float pagamento = sc.nextFloat();
                                    if (pagamento >= quantidade*estoque[opcaoCompra].getPreco()) {
                                        //Pagamento válido
                                        System.out.println(estoque[opcaoCompra].serVendido(pagamento, quantidade)? "Compra realizada com sucesso!": "Venda negada");
                                        System.out.println("Troco de R$" + (pagamento - (quantidade*estoque[opcaoCompra].getPreco())));
                                        teste = false;
                                    } else {
                                        //Pagamento inválido
                                        System.out.println("Tá duro é? Pagamento insuficiente.");
                                        break;
                                    }
                                } else {
                                    System.out.println("Valor inválido. Tente novamente.");
                                }
                            } while (quantidade < 0 || quantidade > estoque[opcaoCompra].getQtdeEstoque());
                        }
                    } while (teste);
                }
                case 3 -> System.out.println("Encerrando...");

                default -> System.out.println("Valor inválido");
            }

        } while (opt != 3);
        sc.close();
    }
}
