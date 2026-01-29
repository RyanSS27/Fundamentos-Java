import frota.Veiculo;
import oficina.Oficina;
import oficina.Relatorio;
import repositorios.RepositorioVeiculos;
import utilitarios.Debitos;
import utilitarios.Multa;
import utilitarios.Pedido;

import java.util.*;


public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        RepositorioVeiculos repositorioVeiculos = new RepositorioVeiculos();
        carregarFrota(repositorioVeiculos);

        List<Veiculo> frotaParaConcerto = new ArrayList<>(repositorioVeiculos.listarVeiculos());
        Oficina oficina = new Oficina();
        for (Veiculo vrumVrum : frotaParaConcerto) {
            System.out.println(oficina.preparacao(vrumVrum));
        }

        List<Debitos> pedidos = new ArrayList<>();

        System.out.println(Oficina.checkup(frotaParaConcerto.get(0)));
        int opt = 0;
        while (opt != 5) {
            System.out.print("""
                    =====================================
                              ALUGUEL DE CARROS
                    =====================================
                    [1] Listar veículos
                    [2] Alugar veículo
                    [3] Registrar retorno / pagar pedidos
                    [4] Pagar multas e débitos
                    [5] Encerrar programa
                    =====================================
                    Digite:""");
            opt = sc.nextInt();
            switch (opt) {
                case 1 -> {
                    int opt2 = 0;
                    while (opt2 > 5 || opt2 <= 0) {
                        System.out.print("""
                                  ALUGUEL DE CARROS
                        =====================================
                        [1] Listar todos
                        [2] Listar categoria A
                        [3] Listar categoria B
                        [4] Listar categoria C
                        [5] Voltar
                        =====================================
                        Digite:""");
                        opt2 = sc.nextInt();
                        switch (opt2) {
                            case 1 -> {
                                List<Veiculo> duplicataDados = new ArrayList<>(repositorioVeiculos.listarVeiculos());
                                duplicataDados.forEach(v -> exibirVeiculo(v));
                                System.out.println("Pressione qualquer tecla para voltar.");
                                // Consome a quebra de linha do buffer
                                sc.nextLine();
                                // Consome o que o usuário digitar
                                sc.nextLine();
                                opt2 = 5;
                            }

                            case 2 -> {
                                List<Veiculo> categoriaA = new ArrayList<>(repositorioVeiculos.listarVeiculos("A"));
                                listarVeiculos(categoriaA);
                                System.out.println("Pressione qualquer tecla para voltar.");
                                // Consome a quebra de linha do buffer
                                sc.nextLine();
                                // Consome o que o usuário digitar
                                sc.nextLine();
                                opt2 = 5;
                            }

                            case 3 -> {
                                List<Veiculo> categoriaB = new ArrayList<>(repositorioVeiculos.listarVeiculos("B"));
                                listarVeiculos(categoriaB);
                                System.out.println("Pressione qualquer tecla para voltar.");
                                // Consome a quebra de linha do buffer
                                sc.nextLine();
                                // Consome o que o usuário digitar
                                sc.nextLine();
                                opt2 = 5;
                            }

                            case 4 -> {
                                List<Veiculo> categoriaC = new ArrayList<>(repositorioVeiculos.listarVeiculos("C"));
                                listarVeiculos(categoriaC);
                                System.out.println("Pressione qualquer tecla para voltar.");
                                // Consome a quebra de linha do buffer
                                sc.nextLine();
                                // Consome o que o usuário digitar
                                sc.nextLine();
                                opt2 = 5;
                            }

                            case 5 -> System.out.println("Voltando..");
                            default -> System.out.println("Opção inválida");
                        }
                    }
                }
                case 2 -> {
                    int opt2 = 0;
                    while (opt2 != 4) {
                        System.out.println("""
                            =====================================
                                      ALUGUEL DE CARROS
                            =====================================
                            [1] Alugar Moto
                            [2] Alugar Veículo de passeio
                            [3] Alugar Caminhão ou Van
                            [4] Cancelar
                            =====================================
                            Digite:""");
                        opt2 = sc.nextInt();
                        System.out.println("=====================================");
                        switch (opt2) {
                            case 1 -> {
                                alugarVeiculo("A", repositorioVeiculos, sc);
                            }

                            case 2 -> {
                                alugarVeiculo("B", repositorioVeiculos, sc);
                            }

                            case 3 -> {
                                alugarVeiculo("C", repositorioVeiculos, sc);
                            }

                            case 4 -> System.out.println("Cancelando..");
                            default -> System.out.println("Opção inválida, tente novamente.");
                        }
                    }
                }
                case 3 -> {
                    int opt2 = 0;
                    while (opt2 != 4) {
                        System.out.print("""
                                =====================================
                                          ALUGUEL DE CARROS
                                =====================================
                                [1] Procurar pedido por CPF
                                [2] Procurar pedido por placa
                                [3] Listar pedidos
                                [4] Voltar
                                =====================================
                                Digite:""");
                        opt2 = sc.nextInt();
                        switch (opt2) {
                            case 1 -> {
                                System.out.print("Digite o CPF: ");
                                int CPF = sc.nextInt();
                                Pedido pedido = pedidos.stream().filter(x -> CPF == x.getCliente().getCPF()).findFirst().orElse(null);
                                if (pedido == null) {
                                    System.out.println("Pedido não encontrado.\nDê \"Enter\" para seguir.");
                                    sc.nextLine();
                                    opt2 = 4;
                                } else {
                                    pedido.getVeiculoAlugado().retornar();
                                    pagar(pedido, sc);
                                    // Pede para a oficina um relatório de condição pós-uso do cliente
                                    Relatorio relatorio = oficina.revisaoPosUso(pedido);
                                    // Envia o relatório para o método estático que verifica se o dano
                                    // gerado foi passível de multa ao cliente, retornando a multa ou
                                    // null, caso não deva ser cobrado do mesmo
                                    Multa multa = Multa.calcMulta(relatorio, pedido);
                                    if (multa != null)
                                        pedido.getCliente().setMultas(multa);
                                    // Falta chamar a função que pede o pagamento das dívidas
                                }
                            }

                            case 2 -> {
                                System.out.print("Informe a placa do veículo: ");
                                String placa = sc.nextLine();
                                Debitos pedido = pedidos.stream().filter(x -> placa.equals(x.getVeiculoAlugado().getPlaca())).findFirst().orElse(null);
                                if (pedido == null) {
                                    System.out.println("Pedido não encontrado.\nDê \"Enter\" para seguir.");
                                    sc.nextLine();
                                } else {
                                    pagar(pedido, sc);
                                }
                                opt2 = 4;
                            }
                            // Falta alterar o veículo para que conste que ele não esteja mais em locação
                            case 3 -> {
                                if (pedidos.size() == 0) {
                                    System.out.println("Não há pedidos registrados.\nDê \"Enter\" para seguir.");
                                    sc.nextLine();
                                } else {
                                    // Lista os pedidos
                                    for (int i = 1; i <= pedidos.size(); i++) {
                                        System.out.println(pedidos.get(i-1));
                                    }
                                    System.out.println("""
                                            =====================================
                                            Digite qual pedido deseja:
                                            """);
                                    int opcao = sc.nextInt()-1;
                                    if (opcao < pedidos.size() && opcao >= 0) {
                                        pagar(pedidos.get(opcao), sc);
                                    } else {
                                        System.out.println("Opção inválida.\nDê \"Enter\" para seguir.");
                                        sc.nextLine();
                                    }
                                }
                                opt2 = 4;
                            }

                            case 4 -> System.out.println("Voltando..");

                            default -> System.out.println("Opção inválida. Tente novamente ");
                        }
                    }
                }
                case 5 -> System.out.println("Encerrando o programa..");
                default -> System.out.println("Opção inválida");
            }
        }


        /*
            Conter 2 tipos de acesso:
            1° Acesso
                - Cadastrar clientes;
                - Listar veículos;
                - Deve permitir alugar os veículos listados disponíveis;
                - Registrar o retorno do veículo;
                - Enviar carros para a revisão pós uso para fechar
                a conta do cliente;
                - Receber pagamentos;
            2° Acesso - Gestor de frota
                - Ter acesso à quantidade total de veículos de cada Categoria
                e os que estão disponíveis para locação.
                - Poder verificar quantos veículos estão quebrados e listá-los
                - Enviar esses veículos para manutenção
            3° Acesso - Gerente
                - Registra a chegada de gasolina
                - Tem acesso às contas da empresa e o lucro
         */

        sc.close();
    }

    public static void carregarFrota(RepositorioVeiculos repositorioVeiculos) {
        // --- 6 Motos (Categoria A) ---
        repositorioVeiculos.salvarVeiculo("Honda", "CB 500", "MOT-1001", 1500.5f, 17.0f, "A", 2, 35000.0f);
        repositorioVeiculos.salvarVeiculo("Yamaha", "Fazer 250", "MOT-1002", 500.0f, 14.0f, "A", 2, 22000.0f);
        repositorioVeiculos.salvarVeiculo("BMW", "G310 GS", "MOT-1003", 120.0f, 11.0f, "A", 2, 38000.0f);
        repositorioVeiculos.salvarVeiculo("Kawasaki", "Ninja 400", "MOT-1004", 3400.2f, 14.0f, "A", 2, 34000.0f);
        repositorioVeiculos.salvarVeiculo("Suzuki", "V-Strom 650", "MOT-1005", 8900.0f, 20.0f, "A", 2, 45000.0f);
        repositorioVeiculos.salvarVeiculo("Ducati", "Scrambler", "MOT-1006", 450.7f, 13.5f, "A", 2, 55000.0f);

        // --- 6 Carros (Categoria B) ---
        repositorioVeiculos.salvarVeiculo("Toyota", "Corolla", "CAR-2001", 15000.0f, 50.0f, "B", 4, 120000.0f);
        repositorioVeiculos.salvarVeiculo("Volkswagen", "Golf", "CAR-2002", 22500.8f, 51.0f, "B", 4, 95000.0f);
        repositorioVeiculos.salvarVeiculo("Honda", "Civic", "CAR-2003", 5400.0f, 56.0f, "B", 4, 110000.0f);
        repositorioVeiculos.salvarVeiculo("Hyundai", "HB20", "CAR-2004", 32000.5f, 50.0f, "B", 4, 70000.0f);
        repositorioVeiculos.salvarVeiculo("Chevrolet", "Onix", "CAR-2005", 1200.0f, 44.0f, "B", 4, 65000.0f);
        repositorioVeiculos.salvarVeiculo("Ford", "Focus", "CAR-2006", 45600.3f, 55.0f, "B", 5, 80000.0f);

        // --- 4 Vans (Categoria C) ---
        repositorioVeiculos.salvarVeiculo("Mercedes", "Sprinter", "VAN-3001", 67000.0f, 75.0f, "C", 2, 180000.0f);
        repositorioVeiculos.salvarVeiculo("Renault", "Master", "VAN-3002", 12000.4f, 80.0f, "C", 2, 160000.0f);
        repositorioVeiculos.salvarVeiculo("Ford", "Transit", "VAN-3003", 5400.9f, 80.0f, "C", 2, 155000.0f);
        repositorioVeiculos.salvarVeiculo("Iveco", "Daily", "VAN-3004", 89000.2f, 90.0f, "C", 2, 170000.0f);
    }
    public static void exibirVeiculo(Veiculo v) {
        System.out.printf("""
                            -------------
                            Veículo: %s
                            Em locação: %b
                            Em condição de locação: %b
                        """.formatted(v, v.isEmLocacao(), v.isEmCondicaoDeUso()));
    }

    public static void listarVeiculos(List<Veiculo> veiculos) {
        veiculos.forEach(v -> exibirVeiculo(v));
    }

    public static void alugarVeiculo(String categoria, RepositorioVeiculos repositorioVeiculos, Scanner sc) {
        int opt3 = 0;
        while (opt3 != 5) {
            List<Veiculo> veiculosDisponiveis = new ArrayList<>(repositorioVeiculos.listarVeiculos(categoria, true));
            // Se haver veículos, ele segue o curso. Se não houver, retorna
            if (veiculosDisponiveis.size() > 0) {
                for (int i = 1; i-1<veiculosDisponiveis.size(); i++) {
                    System.out.println("""
                                                    ------- ID %d -------
                                                    Veículo: %s
                                                    Em locação: %b
                                                    Em condição de locação: %b
                                                    """.formatted(i, veiculosDisponiveis.get(i-1), veiculosDisponiveis.get(i-1).isEmLocacao(), veiculosDisponiveis.get(i-1).isEmCondicaoDeUso()));
                }
                System.out.printf("[%d] Cancelar", veiculosDisponiveis.size() + 1);
                System.out.println("Qual veículo deseja?");
                opt3 = sc.nextInt() - 1;
                if (opt3 == veiculosDisponiveis.size()) {
                    System.out.println("Voltando..");
                    opt3 = 5;
                } else if (opt3 > veiculosDisponiveis.size() || opt3 < 0) {
                    System.out.println("--- Digite um valor válido. Tente novamente. ---");
                } else {
                    //Inserir a lógica de cadastro/verificação do cliente
                    veiculosDisponiveis.get(opt3).serAlugado(null);
                }
            } else {
                System.out.println("Não há veículos desta categoria disponíveis.");
                opt3 = 5;
            }
        }
    }

    public static void pagar(Debitos debito, Scanner sc) {
        System.out.println(debito);
        System.out.print("Digite o valor do pagamento:\nR$");
        double pagamento = sc.nextDouble();
        System.out.println(debito.pagar(pagamento));
        if (!debito.isPaga()) {
            System.out.println("Cliente ficará em dívida e não poderá alugar demais veículos.");
        }
    }
}
