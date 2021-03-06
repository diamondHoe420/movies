import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MovieAPIFetchService {

    public static String fetchMovieJsonString(String movieName) {
        try {
            URL url = new URL("http://www.omdbapi.com/?t="+movieName+"&apikey=f5b3f356");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            if (con.getResponseCode() == 200) {

                InputStream responseStream = con.getInputStream();
                ByteArrayOutputStream responseString = new ByteArrayOutputStream();

                byte[] buffer = new byte[8192];
                int length;

                while ((length = responseStream.read(buffer)) != -1) {
                    responseString.write(buffer, 0, length);
                }
                String str = responseString.toString();
                return str;
            }
            else {
                return "{}";
            }
        } catch(Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }

    public static MovieData fetchMovieData(String movieName) throws IllegalArgumentException {
        String json = fetchMovieJsonString(movieName);
        JSONObject obj = new JSONObject(json);
        if (obj.getBoolean("Response") == true) {
            return new MovieData(json);
        } else {
            throw new IllegalArgumentException();
        }
    }

}
