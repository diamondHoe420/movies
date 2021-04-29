import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Program {
    public static void main(String[] args) {
        System.out.println(MovieAPIFetchService.fetchMovieJsonString("scarface"));
    }
}
