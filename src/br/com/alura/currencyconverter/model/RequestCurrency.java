package br.com.alura.currencyconverter.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestCurrency {
    private String your_key = "YOUR_KEY";

    public void getCurrency(String actualCurrenty, String toConvertCurrency, double value) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/" + your_key + "/latest/" + actualCurrenty;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObj = new Gson().fromJson(response.body(), JsonObject.class);

            JsonObject conversionRatesObj = jsonObj.getAsJsonObject("conversion_rates");

            if (conversionRatesObj != null && conversionRatesObj.has(toConvertCurrency)) {
                double valueRate = conversionRatesObj.get(toConvertCurrency).getAsDouble();
                System.out.println("\nVocê deseja converter $" + value + " " + actualCurrenty);
                System.out.println("A taxa de conversão atual na moeda escolhida é de 1 para " + valueRate);
                System.out.println("O valor em " + toConvertCurrency + " é de $" + value * valueRate);
                System.out.println("Obrigado por usar o Currency Converter");

            } else if (conversionRatesObj == null || value <= 0) {
                System.out.println("Entrada inválida!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
