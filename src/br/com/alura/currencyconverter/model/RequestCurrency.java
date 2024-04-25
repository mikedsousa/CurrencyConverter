package br.com.alura.currencyconverter.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestCurrency {
    private String your_key = "84008f3c64e3e792cc81b5da";

    public void getCurrency(String actualCurrenty, String toConvertCurrency, double value) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/" + your_key + "/latest/" + toConvertCurrency.toUpperCase();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            var json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
