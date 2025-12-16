public final class Notificador {
    // Notificação comum
    public final void enviar(String mensagem) {
        System.out.println(mensagem);
    }

    // Notificação enviada por um meio
    public final void enviar(String mensagem, String meio) {
        if (meio.equals("email")) {
            System.out.println("Verifique o seu email, por gentileza.");
            System.out.println("Inbox do email: " + mensagem);
        } else {
            System.out.println("Verifique sua caixa de mensagens");
            System.out.println("Caixa de mensagens: " + mensagem);
        }
    }

    // Notificação por prioridade
    public final void enviar(String mensagem, int prioridade) {
        if (prioridade == 3) {
            // Confirmar acesso à conta
            System.out.println("Foi você quem fez o login no dispositivo " + mensagem + "?");
        } else if (prioridade == 2) {
            // Usado para notificações que informem ações ocorridas na conta
            System.out.println("Ei, fique de olho: " + mensagem);
        } else {
            // Usado para informar novas funcionalidades
            System.out.println("Novidade chegando!");
        }
    }
}
