import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.Scanner;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class NameAnalyzer {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Write a name: ");

            String name = scanner.nextLine();
            String encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8);

            URL url = new URL("https://api.nationalize.io?name="+ encodedName);


            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            int data = reader.read();
            StringBuilder response = new StringBuilder();
            while (data != -1) {
                response.append((char) data);
                data = reader.read();
            }
            reader.close();




            Gson gson = new Gson();
            ApiResponse apiResponse = gson.fromJson(response.toString(), ApiResponse.class);

            System.out.println("Όνομα: " + apiResponse.name);
            for (CountryInfo c : apiResponse.country) {
                System.out.println("Χώρα: " + c.country_id + " (πιθανότητα: " + c.probability + ")");
            }

//test

    } catch (Exception e) {
            e.printStackTrace();
        }
    }
}