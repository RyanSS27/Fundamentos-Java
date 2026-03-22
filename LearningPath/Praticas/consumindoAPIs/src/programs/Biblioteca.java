package programs;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        // Endpoint: https://www.googleapis.com/books/v1/volumes
        // Chave:

        String url = "https://www.googleapis.com/books/v1/volumes?q=";
        String key = "sua-chave";
        System.out.println("Digite o nome do livro e o autor (ex. 1984 Geord Orwell):");
        url += sc.nextLine().trim().replace(" ", "+");
        url += "&key=" + key;
        System.out.println(url);

        // Declaração do client (aquele que vai até a API)
        HttpClient client = HttpClient.newHttpClient();
        // Monta a requisição (como se fosse a lita de desejos)
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Inicia a requisição com o '.send(request, ...)' e guarda a response (resposta)
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        // .body() é o corpo/json
        System.out.println(response.body());

        // Ao que entendi, o .send(request, ...) "manda" o client até a API para que ele entregue o
        // pedido (HttpRequest) e retorne com os itens desejados (response)
        sc.close();
    }
}
