public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Geraldo", 60);
        Pessoa p2 = p1;
        System.out.println(p1);
        p2.setNome("Vagner");
        System.out.println(p1);
        /*
            Aprendendo sobre comportamentos de memória, entendi que:
                1° No Stack da memória ram, temos p1 e p2. P1 recebeu o
                endereço de onde estão alocados os dados do objeto, do
                tipo Pessoa no Heap.

                2° Ao atribuirmos p1 à p2, ele não está recebendo uma
                cópia dos dados, está recebendo o mesmo endereço de
                memória que tinha em p1, logo, aponta para o mesmo objeto

                3° Alterando p2, na verdade, estou alterando o mesmo
                objeto

            Isso ocorre, pois, apenas tipos primitivos e referências são
            alocados no Stack. Logo, você está copiando o endereço de
            memória que aponta para o mesmo objeto
         */
    }
}

