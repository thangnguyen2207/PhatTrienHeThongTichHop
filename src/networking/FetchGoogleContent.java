package networking;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class FetchGoogleContent {
    public static void main(String[] args) {
        try {
            // Use the URI constructor to ensure proper syntax handling
            URI uri = new URI("https://www.google.com");
            URL url = uri.toURL();

            // Open HTTP connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method
            connection.setRequestMethod("GET");

            // Add a User-Agent header
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            // Check HTTP response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            // Read the response if HTTP response code is OK (200)
            // Print the response content
            System.out.println("Response Content:");
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                }
                in.close();

            } else {
                System.out.println("Failed to fetch content. HTTP Error Code: " + responseCode);
            }

        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
