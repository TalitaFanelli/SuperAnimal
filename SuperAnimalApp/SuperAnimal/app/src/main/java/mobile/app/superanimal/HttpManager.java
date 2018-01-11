package mobile.app.superanimal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Talita on 22/11/2017.
 */

public class HttpManager {

    public static String getRetorno(String uri) {

        BufferedReader reader = null;

        try {
            URL url = new URL(uri);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            StringBuilder stringBuilder = new StringBuilder();

            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
}