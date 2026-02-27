package program;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.println("Digite o nome do funcionário:");
        String name = sc.nextLine();

        System.out.println("Informe a base salarial:");
        double baseSalary = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite o nível do funcionário");
        WorkerLevel level = WorkerLevel.valueOf(sc.nextLine());

        System.out.println("Digite o departamento:");
        Department department = new Department(sc.nextLine());

        Worker worker = new Worker(name, level, baseSalary, department);
        System.out.println("+-------------------------------+");
        System.out.println("Quantos contratos o funcionário terá");
        int quantity = sc.nextInt();
        sc.nextLine();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (int i = 0; i < quantity; i++) {
            System.out.println("+-------------------------------+");
            System.out.println("Entre com a data (dd/mm/yyyy):");
            LocalDate date = LocalDate.parse(sc.nextLine(), format);
            System.out.println("Entre com o valor p/ hora:");
            double valuePerHour = sc.nextDouble();
            sc.nextLine();
            System.out.println("Entre com a quantidade de horas:");
            int hours = sc.nextInt();
            sc.nextLine();
            worker.addContract(new HourContract(date, valuePerHour, hours));
        }

        System.out.println("+-------------------------------+");
        System.out.println("Informe o mês e o ano para calcular o salário");
        System.out.print("Mês: ");
        int month = sc.nextInt();
        System.out.print("Ano: ");
        int year = sc.nextInt();
        System.out.println("R$" + worker.income(month, year));

        sc.close();
    }
}
