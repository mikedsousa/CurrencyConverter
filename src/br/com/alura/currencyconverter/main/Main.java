package br.com.alura.currencyconverter.main;

import br.com.alura.currencyconverter.model.RequestCurrency;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe a moeda que você quer converter: ");
        String actualCurrenty = scanner.nextLine();
        System.out.println("Para qual moeda você deseja converter? ");
        String toConvertCurrency = scanner.nextLine();
        System.out.println("Informe o valor que deseja converter: ");
        double value = scanner.nextDouble();

        RequestCurrency request = new RequestCurrency();

        request.getCurrency(actualCurrenty, toConvertCurrency, value);


    }
}
