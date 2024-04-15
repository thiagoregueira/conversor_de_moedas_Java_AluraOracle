package com.conversordemoedas;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.InputStream;
import org.json.JSONObject;
import io.github.cdimascio.dotenv.Dotenv;

public class ConversorDeMoedas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println("Por favor, selecione uma opção:");
        System.out.println("1. Dólar para Real");
        System.out.println("2. Dólar para iene japonês");
        System.out.println("3. Dólar para Euro");
        System.out.println("4. Dólar para dólar australiano");
        System.out.println("5. Dólar para dólar canadense");
        System.out.println("6. Dólar para libra esterlina");

        // Setting URL
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");
        String url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

        try {
            URL url = new URL(url_str);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            Scanner s = new Scanner(isr);
            String json = s.useDelimiter("\\A").next();
            s.close();

            // Parse JSON
            JSONObject jsonObject = new JSONObject(json);
            JSONObject rates = jsonObject.getJSONObject("conversion_rates");
            double usdToBrl = rates.getDouble("BRL");
            double usdToJpy = rates.getDouble("JPY");
            double usdToEur = rates.getDouble("EUR");
            double usdToAud = rates.getDouble("AUD");
            double usdToCad = rates.getDouble("CAD");
            double usdToGbp = rates.getDouble("GBP");


            int option = scanner.nextInt();
            double amount = 0;

            switch (option) {
                case 1:
                    System.out.println("Digite o valor em dólar:");
                    amount = scanner.nextDouble();
                    System.out.println("O valor em real é: " + amount * usdToBrl);
                    break;
                case 2:
                    System.out.println("Digite o valor em dólar:");
                    amount = scanner.nextDouble();
                    System.out.println("O valor em iene japonês é: " + amount * usdToJpy);
                    break;
                case 3:
                    System.out.println("Digite o valor em dólar:");
                    amount = scanner.nextDouble();
                    System.out.println("O valor em euro é: " + amount * usdToEur);
                    break;
                case 4:
                    System.out.println("Digite o valor em dólar:");
                    amount = scanner.nextDouble();
                    System.out.println("O valor em dólar australiano é: " + amount * usdToAud);
                    break;
                case 5:
                    System.out.println("Digite o valor em dólar:");
                    amount = scanner.nextDouble();
                    System.out.println("O valor em dólar canadense é: " + amount * usdToCad);
                    break;
                case 6:
                    System.out.println("Digite o valor em dólar:");
                    amount = scanner.nextDouble();
                    System.out.println("O valor em libra esterlina é: " + amount * usdToGbp);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
