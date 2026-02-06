import financeiro.*;
import frota.Veiculo;
import oficina.Oficina;
import oficina.Relatorio;
import repositorios.*;

import java.util.*;

import static oficina.Oficina.*;


public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        RepositorioVeiculos repositorioVeiculos = new RepositorioVeiculos();
        carregarFrota(repositorioVeiculos);
        RespositorioClientes repositorioClientes = new RespositorioClientes();
        RepositorioDebitos repositorioDebitos = new RepositorioDebitos();
        ControleFinanceiro controleFinanceiro = new ControleFinanceiro(repositorioDebitos);

        List<Veiculo> frotaParaConcerto = new ArrayList<>(repositorioVeiculos.listarVeiculos());
        Oficina oficina = new Oficina();
        for (Veiculo vrumVrum : frotaParaConcerto) {
            System.out.println(preparacao(vrumVrum));
        }

        RepositorioDebitos repositorioPedidos = new RepositorioDebitos();

        System.out.println(checkup(frotaParaConcerto.get(0)));
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
                                duplicataDados.forEach(Programa::exibirVeiculo);
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
                                alugarVeiculo("A", repositorioVeiculos, repositorioClientes,
                                        repositorioDebitos, controleFinanceiro, sc);
                            }

                            case 2 -> {
                                alugarVeiculo("B", repositorioVeiculos, repositorioClientes,
                                        repositorioDebitos, controleFinanceiro, sc);
                            }

                            case 3 -> {
                                alugarVeiculo("C", repositorioVeiculos, repositorioClientes,
                                        repositorioDebitos, controleFinanceiro, sc);
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
                                System.out.print("Digite o cpf: ");
                                long cpf = sc.nextLong();
                                Pedido pedido = repositorioPedidos.procurarPedido(cpf, false);
                                if (pedido == null) {
                                    System.out.println("Pedido não encontrado.\nDê \"Enter\" para seguir.");
                                    sc.nextLine();
                                } else {
                                    retornarVeiculos(oficina, controleFinanceiro, repositorioDebitos, pedido, sc);
                                }
                                opt2 = 4;
                            }

                            case 2 -> {
                                System.out.print("Informe a placa do veículo: ");
                                String placa = sc.nextLine();
                                Pedido pedido = repositorioPedidos.procurarPedido(placa, false);
                                if (pedido == null) {
                                    System.out.println("Pedido não encontrado.\nDê \"Enter\" para seguir.");
                                    sc.nextLine();
                                } else {
                                    retornarVeiculos(oficina, controleFinanceiro, repositorioDebitos, pedido, sc);
                                }
                                opt2 = 4;
                            }

                            case 3 -> {
                                //Falta também, garantir que, após a locação, o cliente fique inápto
                                List<Debitos> pedidos = repositorioPedidos.listarPedidos(false);
                                if (pedidos.isEmpty()) {
                                    System.out.println("Não há pedidos registrados.\nDê \"Enter\" para seguir.");
                                    sc.nextLine();
                                } else {
                                    listarDebitos(
                                            pedidos,
                                            repositorioVeiculos,
                                            repositorioClientes,
                                            repositorioDebitos,
                                            controleFinanceiro,
                                            sc
                                    );
                                }
                                opt2 = 4;
                            }

                            case 4 -> System.out.println("Voltando..");

                            default -> System.out.println("Opção inválida. Tente novamente ");
                        }
                    }
                }
                // Implementar o pagamento de débitos.
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

    public static void alugarVeiculo(String categoria, AcessoRepositorioVeiculos repositorioVeiculos,
                                     AcessoRepositorioClientes repositorioClientes,
                                     AcessoRepositorioDebitos repositorioDebitos,
                                     AcessoFinanceiro repositorioFinanceiro,
                                     Scanner sc) {
        boolean opt3 = true;
        while (opt3) {
            List<Veiculo> veiculosDisponiveis = new ArrayList<>(repositorioVeiculos.listarVeiculos(categoria,
                    true));
            // Se haver veículos, ele segue o curso. Se não houver, retorna
            if (!veiculosDisponiveis.isEmpty()) {
                for (int i = 1; (i-1) < (veiculosDisponiveis.size()); i++) {
                    System.out.println("""
                                                    ------- ID %d -------
                                                    Veículo: %s
                                                    Em locação: %b
                                                    Em condição de locação: %b
                                                    """.formatted(
                                                            i,
                                                            veiculosDisponiveis.get(i-1),
                                                            veiculosDisponiveis.get(i-1).isEmLocacao(),
                                                            veiculosDisponiveis.get(i-1).isEmCondicaoDeUso()));
                }
                System.out.printf("[%d] Cancelar\n", veiculosDisponiveis.size() + 1);
                System.out.println("Qual veículo deseja?");
                int opt4 = sc.nextInt() - 1;
                if (opt4 == veiculosDisponiveis.size()) {
                    System.out.println("Voltando..");
                    opt3 = false;
                } else if (opt4 > veiculosDisponiveis.size() || opt4 < 0) {
                    System.out.println("--- Digite um valor válido. Tente novamente. ---");
                } else {
                    //Inserir a lógica de cadastro/verificação do cliente
                    System.out.println("Digite o CPF do cliente (ou \"0\" para cancelar):");
                    long cpf = sc.nextLong();
                    if (cpf == 0) {
                        opt3 = false;
                        System.out.println("Cancelando..");
                    } else {
                        Cliente cliente = repositorioClientes.pesquisarCliente(cpf);
                        if(cliente == null) {
                            sc.nextLine();
                            System.out.println("Digite o nome do cliente:");
                            String nome = sc.nextLine();
                            repositorioClientes.salvarCliente(nome, cpf);
                            cliente = repositorioClientes.pesquisarCliente(cpf);
                        } else {
                            System.out.println("Cliente já cadastrado.\n" + cliente);
                        }
                        if (cliente.isAptoLocacao(repositorioFinanceiro)) {
                            System.out.println("Digite por quantos dias será alugado:");
                            int dias = sc.nextInt();
                            double valorTotalDaLocacao = gerarValorLocacao(veiculosDisponiveis.get(opt4), dias);

                            System.out.println("""
                                =====================================
                                Valor total da locação: R$%.2f
                                Valor p/ dia: R$%.2f
                                -------------------------------------
                                Deseja continuar?
                                [\"0 para não\" | 1 para sim]
                                """.formatted(valorTotalDaLocacao, (valorTotalDaLocacao/dias)));
                            int opt5 = sc.nextInt();
                            if (opt5 == 1) {
                                veiculosDisponiveis.get(opt4).serAlugado(cliente);
                                repositorioDebitos.salvarPedido(
                                        cliente,
                                        veiculosDisponiveis.get(opt4),
                                        valorTotalDaLocacao,
                                        "Quer usar para viajar.");
                                cliente.isAptoLocacao(repositorioFinanceiro);
                                System.out.println("""
                                    =====================================
                                    Veículo alugado com sucesso!
                                    """);
                            } else {
                                System.out.println("Cancelando..");
                            }
                        } else {
                            System.out.println("Cliente não é apto a locação no momento." +
                                    "\nDívidas pendentes.");
                        }

                        opt3 = false;
                    }

                }
            } else {
                System.out.println("Não há veículos desta categoria disponíveis.");
                opt3 = false;
            }
        }
    }

    public static double gerarValorLocacao(Veiculo veiculo, int diasLocacao) {
        // A lógica de negócio desta função foi gerada por IA, já que o foco não era este
        // 1. Definimos uma diária base proporcional ao valor de mercado do veículo
        // Exemplo: 0.4% do valor do veículo por dia
        double diariaBase = veiculo.getValor() * 0.004;

        // 2. Ajuste por Categoria de CNH/Veículo
        double multiplicadorCategoria = switch (veiculo.getCategoria().toUpperCase()) {
            case "A" -> 0.7;  // Motos costumam ter diárias mais baratas
            case "B" -> 1.0;  // Padrão (Carros de passeio/SUVs)
            case "C" -> 1.4;  // Caminhões leves/Cargas exigem manutenção e seguro maiores
            default -> 1.0;
        };

        // 3. Cálculo do valor bruto
        double valorFinal = (diariaBase * multiplicadorCategoria) * diasLocacao;

        // 4. Bônus por conservação (Prática de OO)
        // Se o veículo tem quilometragem muito baixa, podemos cobrar um "premium"
        if (veiculo.getQuilometragem() < 5000) {
            valorFinal *= 1.10; // 10% de acréscimo para veículos seminovos (cheirinho de novo!)
        }

        return valorFinal;
    }

    public static void retornarVeiculos(
            Oficina oficina,
            ControleFinanceiro controleFinanceiro,
            RepositorioDebitos repositorioDebitos,
            Pedido pedido,
            Scanner sc) {
        pedido.getVeiculoAlugado().retornar();
        // Pede para a oficina um relatório de condição pós-uso do cliente
        Relatorio relatorio = oficina.revisaoPosUso(pedido);
        // Envia o relatório para o método que verifica se o dano gerado
        // foi passível de multa ao cliente, retornando a multa ou null,
        // caso não deva ser cobrado do mesmo
        Double valorMulta = controleFinanceiro.calcMulta(relatorio, pedido);
        if (valorMulta != null)
            repositorioDebitos.salvarMulta(
                    relatorio,
                    pedido,
                    valorMulta);
        long cpf = pedido.getCliente().getCPF();
        pagarDebitos(cpf, controleFinanceiro, repositorioDebitos, sc);
    }

    public static void pagarDebitos(
            long cpf,
            ControleFinanceiro controleFinanceiro,
            AcessoRepositorioDebitos repositorioDebitos,
            Scanner sc) {
        List<Debitos> debitos = repositorioDebitos.debitosGeraisCliente(cpf, false);
        if (debitos.isEmpty()) {
            System.out.println("Não há débitos vinculados a este CPF.");
        } else {
            System.out.println("=====================================");
            debitos.forEach(System.out::println);
            System.out.println("Valor total da cobrança: " + controleFinanceiro.calcularDebitos(cpf));
            System.out.print("Digite o valor do pagamento:\nR$");
            double pagamento = sc.nextDouble();
            System.out.println(controleFinanceiro.pagarPendencias(cpf, pagamento));
            debitos.get(0).getCliente().isAptoLocacao(controleFinanceiro);
        }
    }

    public static void listarDebitos(List<Debitos> debitos,
                              AcessoRepositorioVeiculos repositorioVeiculos,
                              AcessoRepositorioClientes repositorioClientes,
                              AcessoRepositorioDebitos repositorioDebitos,
                              AcessoFinanceiro controleFinanceiro,
                              Scanner sc) {
        boolean opt3 = true;
        while (opt3) {
            // Se haver veículos, ele segue o curso. Se não houver, retorna
            if (!debitos.isEmpty()) {
                for (int i = 1; (i - 1) < (debitos.size()); i++) {
                    Debitos debito = debitos.get(i - 1);
                    String descricaoAuxiliar;
                    if (debito.getClass().getSimpleName().equals("Multa")) {
                        debito = (Multa) debito;
                        descricaoAuxiliar = """
                                Nível de dano: %d
                                Descrição: %s
                                ---------------------
                                """.formatted(((Multa) debito).getNivelDano(), debito.getDescricao());
                    } else {
                        descricaoAuxiliar = "---------------------";
                    }
                    System.out.println("""
                            ------- ID %d -------
                            Cobrança: %s
                            ---------------------
                            Nome cliente: %s
                            CPF: %d
                            ---------------------
                            Veículo: %s
                            Placa: %s
                            %s
                            Valor: R$ %.2f
                            """.formatted(
                            i,
                            debito.getClass().getSimpleName(),
                            debito.getCliente().getNome(),
                            debito.getCliente().getCPF(),
                            debito.getVeiculoAlugado().getMarca()
                                    + debito.getVeiculoAlugado().getModelo(),
                            debito.getVeiculoAlugado().getPlaca(),
                            descricaoAuxiliar,
                            debito.getValor()
                    ));
                }
                System.out.printf("[%d] Cancelar\n", debitos.size() + 1);
                System.out.println("Qual pendência quer selecionar?");
                int opt4 = sc.nextInt() - 1;
                if (opt4 == debitos.size()) {
                    System.out.println("Voltando..");
                    opt3 = false;
                } else if (opt4 > debitos.size() || opt4 < 0) {
                    System.out.println("--- Digite um valor válido. Tente novamente. ---");
                } else {
                    Debitos debito = debitos.get(opt4);
                    // Mostra não só o pedido ou multa, mas todas as cobranças
                    pagarDebitos(
                            debito.getCliente().getCPF(),
                            (ControleFinanceiro) controleFinanceiro,
                            repositorioDebitos,
                            sc
                    );
                    opt3 = false;
                }
            } else {
                System.out.println("Não há veículos desta categoria disponíveis.");
                opt3 = false;
            }
        }
    }
}
