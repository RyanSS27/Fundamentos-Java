public class Main {
    public static void main(String[] args) {
        Video videos[] = {
            new Video("Aula 01 do curso de Java"),
            new Video("Tutorial avançado para quem não é iniciante de minecraft"),
            new Video("Highlights do Rodrigo Garro 2024.")
        };

        Gafanhoto mano1 = new Gafanhoto("Olavo", 18,  'm', "olavin6969@hotmyemail.com");
        System.out.println(mano1.toString());
        System.out.println(videos[1]);
        Visualizar newView = new Visualizar(mano1, videos[1]);
        newView.avaliar(); // chamada que, por padrão, dá a nota 5
        newView.avaliar(45.0f); // passa uma porcentagem que teoricamente seria o quanto do vídeo o espectador assistiu
        newView.avaliar(10); // nota que o espectador atribuiu
        System.out.println("======================================");
        System.out.println(mano1.toString());
        System.out.println(videos[1]);
    }
}