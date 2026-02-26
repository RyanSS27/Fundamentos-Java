package entities;

import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Worker {
    private String nome;
    private WorkerLevel level;
    private double baseSalary;
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(String nome, WorkerLevel level, double baseSalary, Department department) {
        this.nome = nome;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public void addContract(HourContract contract) {contracts.add(contract);}
    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }
    public double income(int month, int year) {
        if(contracts.isEmpty()) {
            System.out.println("Não há contratos registrados");
            return 0.0;
        }

        List<HourContract> filteredContracts =
                contracts.stream()
                .filter(x -> x.getDate().getYear() == year && x.getDate().getMonthValue() == month)
                        .toList();

        if(filteredContracts.isEmpty()) {
            System.out.println("Não há contratos registrados nestas datas");
            return 0.0;
        }

        double contractsOfValue = 0.0;
        for (HourContract contract : filteredContracts) {
            contractsOfValue += contract.totalValue();
        }

        return contractsOfValue + baseSalary;
    }
}
