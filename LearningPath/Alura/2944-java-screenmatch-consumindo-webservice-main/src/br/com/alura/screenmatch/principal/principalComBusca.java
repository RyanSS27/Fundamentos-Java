package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

/*
    O objetivo é entender o trecho de código que faz as requisições para,
    futuramente, aprofundar.

    API utilizada para pegar os filmes: https://www.omdbapi.com/
    Trecho retirado da doc oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpRequest.html
 */
public class principalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        /*
        CONEXÃO COM A API
         */
        String enderecoAPI = "https://www.omdbapi.com/?apikey=9dbd6ddb&t=";
        System.out.println("Digite o nome do título que deseja em inglês:");
        enderecoAPI += sc.nextLine().trim().replace(" ", "+");
        System.out.println(enderecoAPI);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(enderecoAPI))
                .build();
        /*
        HttpRequest é uma classe abstrata (não instanciável) e, por isso, utilizamos o
        "builder" que cria objetos complexos sem que haja várias opções de sobrecarga
        do método construtor.

        Você constrói este obj complexo dizendo apenas o que ele deve ter:
            - Ele deve ter uma url (.uri(URI.create("http://url-destino"))
         */

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        /*
        response é a "resposta" da chamada que o client declarado lá em cima
        fez na URL do request
         */
        System.out.println(response.body());

        // .body() pega o corpo do retorno (o json em formato de string)

        sc.close();
    }
}
