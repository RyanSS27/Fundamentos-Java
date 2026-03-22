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

        // Declaração do client
        HttpClient client = HttpClient.newHttpClient();
        // Efetua a requisição
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Resposta http, do tipo request
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        // .body() é o corpo/json
        System.out.println(response.body());

        sc.close();
    }
}
