import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        Caneta c1 = new Caneta();
        //        c1.marca = "BIC";
        //        c1.cor = "Azul";
        //        c1.ponta = 0.7f;
        //        c1.carga = 80;
        //        c1.aberta = false; //começando tampada
        System.out.println("DIGITE AS INFORMAÇÕES DA CANETA");
        System.out.println("Marca: ");
        c1.marca = sc.nextLine();

        System.out.println("Cor: ");
        c1.cor = sc.nextLine();

        System.out.println("Ponta: ");
//        c1.ponta = sc.nextFloat();

        sc.nextLine();
        System.out.println("Carga (exemplo: 25%): ");
        String carga = sc.nextLine();

        //MOSTRANDO O OBJETO
        c1.mostrarCaneta();

        //CANETA RABISCA
        c1.tampar();
        c1.escrever();
        c1.destampar();
        c1.escrever();

        //MOSTANDO DE NOVO
        c1.mostrarCaneta();

        sc.close();
    }
}
