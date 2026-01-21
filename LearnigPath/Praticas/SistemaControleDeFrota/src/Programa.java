import frota.CategoriaA;
import frota.CategoriaB;
import frota.CategoriaC;
import frota.Veiculo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.lang.Comparable;

public class Programa {
    public static void main(String[] args) {

        // Criando a lista que armazenará a frota e preenchendo suas informações
        List<Veiculo> frota = new ArrayList<>();

        // --- 6 Motos (Categoria A) ---
        frota.add(new CategoriaA("Honda", "CB 500", "MOT-1001", 1500.5f, 17.0f));
        frota.add(new CategoriaA("Yamaha", "Fazer 250", "MOT-1002", 500.0f, 14.0f));
        frota.add(new CategoriaA("BMW", "G310 GS", "MOT-1003", 120.0f, 11.0f));
        frota.add(new CategoriaA("Kawasaki", "Ninja 400", "MOT-1004", 3400.2f, 14.0f));
        frota.add(new CategoriaA("Suzuki", "V-Strom 650", "MOT-1005", 8900.0f, 20.0f));
        frota.add(new CategoriaA("Ducati", "Scrambler", "MOT-1006", 450.7f, 13.5f));

        // --- 6 Carros (Categoria B) ---
        frota.add(new CategoriaB("Toyota", "Corolla", "CAR-2001", 15000.0f, 50.0f));
        frota.add(new CategoriaB("Volkswagen", "Golf", "CAR-2002", 22500.8f, 51.0f));
        frota.add(new CategoriaB("Honda", "Civic", "CAR-2003", 5400.0f, 56.0f));
        frota.add(new CategoriaB("Hyundai", "HB20", "CAR-2004", 32000.5f, 50.0f));
        frota.add(new CategoriaB("Chevrolet", "Onix", "CAR-2005", 1200.0f, 44.0f));
        frota.add(new CategoriaB("Ford", "Focus", "CAR-2006", 45600.3f, 55.0f));

        // --- 4 Vans (Categoria C) ---
        frota.add(new CategoriaC("Mercedes", "Sprinter", "VAN-3001", 67000.0f, 75.0f));
        frota.add(new CategoriaC("Renault", "Master", "VAN-3002", 12000.4f, 80.0f));
        frota.add(new CategoriaC("Ford", "Transit", "VAN-3003", 5400.9f, 80.0f));
        frota.add(new CategoriaC("Iveco", "Daily", "VAN-3004", 89000.2f, 90.0f));

        Collections.sort(frota);
        System.out.println(frota);

        frota.sort(Comparator.comparing(Veiculo::getCategoria));
        System.out.println(frota);
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

    }
}
