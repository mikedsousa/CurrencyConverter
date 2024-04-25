package br.com.alura.currencyconverter.main;

import br.com.alura.currencyconverter.model.RequestCurrency;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String menu = """
                ******************************************************
                Bem-vindo(a) ao Currency Converter.
                
                Abaixo você deve informar a sigla da moeda que você
                  deseja converter e para qual moeda deseja converter,
                  respectivamente.
                 
                USD - Dolar Americano     EUR - Euro
                BRL - Real Brasileiro     CAD - Dolar Canadense
                GBP - Libra Esterlina     JPY - Iene Japonês
                CHF - Franco Suiço        CLP - Peso Chileno
                
                Ou, sinta-se livre para tentar com qualquer outra
                  moeda.
                ******************************************************
                """;

        Scanner scanner = new Scanner(System.in);
        System.out.println(menu);
        System.out.println("Informe a moeda que você quer converter: ");
        String actualCurrenty = scanner.nextLine().toUpperCase(Locale.ROOT);
        System.out.println("Para qual moeda você deseja converter? ");
        String toConvertCurrency = scanner.nextLine().toUpperCase(Locale.ROOT);
        System.out.println("Informe o valor que deseja converter: ");
        double value = scanner.nextDouble();

        RequestCurrency request = new RequestCurrency();

        request.getCurrency(actualCurrenty, toConvertCurrency, value);



    }
}
