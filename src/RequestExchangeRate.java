import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestExchangeRate {
    public RequestsData requisitarMoedaCambio (String base_Code_pairs, double ammount) throws IOException, InterruptedException {
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/24d43b47f0e33718763a0330/pair/"+base_Code_pairs+ammount);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();


        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), RequestsData.class);
        } catch (Exception e) {
            throw new RuntimeException("Não conseguir achar a cotação dessa moeda!!");
        }

    }
}
