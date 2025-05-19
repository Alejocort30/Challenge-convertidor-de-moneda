import java.util.Scanner;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class challenge {
    // Método para convertir monedas
    public static double convertirMoneda(double monto, double tasaCambio) {
        return monto * tasaCambio;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sea bienvenido/a al Conversor de Moneda");

        try {
            String apiKey = "c4fb0531cd8abcb5410b1ee0";
            String baseCurrency = "USD";
            String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency;

            // Uso de HttpClient
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlStr))
                    .header("Accept", "application/json")
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Analizar el JSON
            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject rates = json.getAsJsonObject("conversion_rates");

            // Lista de monedas permitidas
            String[] monedasPermitidas = {"USD", "EUR", "BRL", "JPY", "COP", "MXN", "ARS", "CLP"};

            boolean continuar = true;
            while (continuar) {
                System.out.println("\nOpciones de monedas para convertir:");
                for (int i = 0; i < monedasPermitidas.length; i++) {
                    System.out.println((i + 1) + ". " + monedasPermitidas[i]);
                }
                System.out.println((monedasPermitidas.length + 1) + ". Salir");
                System.out.print("Elija una opción: ");
                int opcion = scanner.nextInt();

                if (opcion == monedasPermitidas.length + 1) {
                    continuar = false;
                    System.out.println("¡Gracias por usar el conversor!");
                } else if (opcion >= 1 && opcion <= monedasPermitidas.length) {
                    String monedaDestino = monedasPermitidas[opcion - 1];
                    System.out.print("Ingrese el monto en USD a convertir: ");
                    double monto = scanner.nextDouble();

                    if (rates.has(monedaDestino)) {
                        double tasaDestino = rates.get(monedaDestino).getAsDouble();
                        double resultado = convertirMoneda(monto, tasaDestino);
                        System.out.println(monto + " USD equivale a " + resultado + " " + monedaDestino);
                    } else {
                        System.out.println("La moneda de destino no es válida.");
                    }
                } else {
                    System.out.println("Elija una opción válida.");
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
