import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        System.out.println("WITAMY W PROGNOZIE POGODY");
        while (true) {
            System.out.println("Wybierz opcję");
            System.out.println("1: Pokaż szczegóły filmu");
            System.out.println("2: Wyjdź");

            Scanner sc = new Scanner(System.in);
            System.out.print("wybór: ");
            int n = sc.nextInt();

            switch (n) {

                case 1:
                    System.out.print("wyszukaj film po tytule: ");
                    String title = sc.next();
                    try {
                        System.out.println(MovieAPIFetchService.fetchMovieData(title).getMovieDetailsString());
                    } catch (IllegalArgumentException e ) {
                        System.out.println("Nie znaleziono filmu");
                    }
                    break;

                case 2:
                    System.out.println("Zamykanie programu");
                    return;
            }
        }
    }
}
