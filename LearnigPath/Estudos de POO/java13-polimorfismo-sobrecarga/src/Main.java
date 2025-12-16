public class Main {
    public static void main(String[] args) {
        Notificador n = new Notificador();

        n.enviar("Ficamos contentes que tenha assinado conosco! Este é só o começo de uma bela parceria.");
        System.out.println("===========================");
        n.enviar("""
                \n        NOTA FISCAL
                ===========================
                Valor: xxxx
                Data: dd/mm/aaaa
                Cartão: nanana
                Destinatário: taltaltal
                Serviço contratado: plano 2 
                """, "email");
        System.out.println("===========================");
        n.enviar("Você terá acesso livre acesso as funcionalidades até dia 28/4." + 2);
    }
}