public class Main {
    public static void main(String[] args) {
        // Pessoa p = new Pessoa();
        // Por ser uma classe abstrata, ela serve apenas de progenitora para outras

        Bolsista alunoBolsista = new Bolsista();
        System.out.println("   BOLSISTA SHOW");
        System.out.println("===================");

        alunoBolsista.setNome("Gregório");
        alunoBolsista.setIdade(19);
        alunoBolsista.setSexo('m');
        alunoBolsista.setMatricula(987654321);
        alunoBolsista.setCurso("Pedreiro de Software");
        System.out.println(alunoBolsista.toString());
        alunoBolsista.renovarBolsa();
        alunoBolsista.pagarMensalidade();

        System.out.println("   TÉCNICO SHOW  ");
        System.out.println("==================");
        Tecnico alunoTecnico = new Tecnico();
        alunoTecnico.setNome("Robervaldo");
        alunoTecnico.setIdade(24);
        alunoTecnico.setSexo('s');
        alunoTecnico.setMatricula(123456789);
        alunoTecnico.setCurso("Elétrica");
        alunoTecnico.setRegistroProfissional("É o brabo da elétrica. Quando Deus disse: \"Que faça-se a luz!\", estava pedindo para ele.\nCaprichoso. Instalou uma lâmpada tão bem localizada que hoje chamamos ela de Sol.");
        System.out.println(alunoTecnico.toString());
        alunoTecnico.pagarMensalidade();
        alunoTecnico.praticar();
    }
}