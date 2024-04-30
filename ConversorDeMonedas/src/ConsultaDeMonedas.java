import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsultaDeMonedas {

public Plata consulta(String moneda) throws IOException {

    String url_str = "https://v6.exchangerate-api.com/v6/45b7a239679c729b029f8b26/latest/"+moneda;

    URL url = new URL(url_str);
    HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

    JsonParser jp = new JsonParser();
    JsonElement root = null;

    root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
    JsonObject jsonobj = root.getAsJsonObject();
    String req_result = jsonobj.get("result").getAsString();

    Plata plata = new Gson().fromJson(jsonobj.get("conversion_rates"), Plata.class);

    return plata;
   }


}
