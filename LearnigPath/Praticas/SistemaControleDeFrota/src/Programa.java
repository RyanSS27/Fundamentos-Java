import frota.Veiculo;

import java.util.*;
import java.lang.Comparable;


public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        Repositorio repositorio = new Repositorio();
        // --- 6 Motos (Categoria A) ---
        repositorio.salvarVeiculo("Honda", "CB 500", "MOT-1001", 1500.5f, 17.0f, "A", 2);
        repositorio.salvarVeiculo("Yamaha", "Fazer 250", "MOT-1002", 500.0f, 14.0f, "A", 2);
        repositorio.salvarVeiculo("BMW", "G310 GS", "MOT-1003", 120.0f, 11.0f, "A", 2);
        repositorio.salvarVeiculo("Kawasaki", "Ninja 400", "MOT-1004", 3400.2f, 14.0f, "A", 2);
        repositorio.salvarVeiculo("Suzuki", "V-Strom 650", "MOT-1005", 8900.0f, 20.0f, "A", 2);
        repositorio.salvarVeiculo("Ducati", "Scrambler", "MOT-1006", 450.7f, 13.5f, "A", 2);

        // --- 6 Carros (Categoria B) ---
        repositorio.salvarVeiculo("Toyota", "Corolla", "CAR-2001", 15000.0f, 50.0f, "B", 4);
        repositorio.salvarVeiculo("Volkswagen", "Golf", "CAR-2002", 22500.8f, 51.0f, "B", 4);
        repositorio.salvarVeiculo("Honda", "Civic", "CAR-2003", 5400.0f, 56.0f, "B", 4);
        repositorio.salvarVeiculo("Hyundai", "HB20", "CAR-2004", 32000.5f, 50.0f, "B", 4);
        repositorio.salvarVeiculo("Chevrolet", "Onix", "CAR-2005", 1200.0f, 44.0f, "B", 4);
        repositorio.salvarVeiculo("Ford", "Focus", "CAR-2006", 45600.3f, 55.0f, "B", 5);

        // --- 4 Vans (Categoria C) ---
        repositorio.salvarVeiculo("Mercedes", "Sprinter", "VAN-3001", 67000.0f, 75.0f, "C", 2);
        repositorio.salvarVeiculo("Renault", "Master", "VAN-3002", 12000.4f, 80.0f, "C", 2);
        repositorio.salvarVeiculo("Ford", "Transit", "VAN-3003", 5400.9f, 80.0f, "C", 2);
        repositorio.salvarVeiculo("Iveco", "Daily", "VAN-3004", 89000.2f, 90.0f, "C", 2);


        System.out.printf("""
                          ALUGUEL DE CARROS
                =====================================
                [1] Listar veículos
                =====================================
                Digite: 
                """);
        int opt = sc.nextInt();
        switch (opt) {
            case 1 -> {
                int opt2 = 0;
                while (opt2 > 5 || opt2 <= 0) {
                    System.out.printf("""
                                  ALUGUEL DE CARROS
                        =====================================
                        [1] Listar todos
                        [2] Listar categoria A
                        [3] Listar categoria B
                        [4] Listar categoria C
                        [5] Voltar
                        =====================================
                        Digite: 
                    """);
                    opt2 = sc.nextInt();
                    switch (opt2) {
                        case 1 -> {
                            List<Veiculo> duplicataDados = new ArrayList<>(repositorio.listarVeiculos());
                            duplicataDados.forEach(v -> exibirVeiculo(v));
                        }

                        case 2 -> {
                            List<Veiculo> categoriaA = new ArrayList<>(repositorio.listarVeiculos("A"));
                            listarCategoria(categoriaA, "A");
                        }

                        case 3 -> {
                            List<Veiculo> categoriaB = new ArrayList<>(repositorio.listarVeiculos("A"));
                            listarCategoria(categoriaB, "B");
                        }

                        case 4 -> {
                            List<Veiculo> categoriaC = new ArrayList<>(repositorio.listarVeiculos("A"));
                            listarCategoria(categoriaC, "C");
                        }

                        case 5 -> System.out.println("Voltando..");
                        default -> System.out.println("Opção inválida");
                    }

                }
            }
            default -> System.out.println("Opção inválida");
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
    public static void exibirVeiculo(Veiculo v) {
        System.out.printf("""
                            -------------
                            Veículo: %s
                            Em locação: %b
                            Em condição de locação: %b
                        """.formatted(v, v.isEmLocacao(), v.isEmCondicaoDeUso()));
    }

    public static void listarCategoria(List<Veiculo> veiculos, String categoria) {
        veiculos.forEach(v -> exibirVeiculo(v));
    }
}
