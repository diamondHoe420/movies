import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class MovieData {
    private String title;
    private int year;
    private String duration;
    private String genre;
    private String rating;
    private String director;
    private ArrayList<String> actors;

    public MovieData(String jsonString) {
        JSONObject obj = new JSONObject(jsonString);
        try {
            title = obj.getString("Title");
            year = obj.getInt("Year");
            duration = obj.getString("Runtime");
            genre = obj.getString("Genre");
            rating = obj.getString("Rated");
            director = obj.getString("Director");
            String actorsString = obj.getString("Actors");
            actors = new ArrayList<String>(Arrays.asList((String[]) actorsString.split(", ")));
        } catch(JSONException e) {
            e.printStackTrace();
        }
    }

    public String getMovieDetailsString() {
        String str =
                title + " " + year + "\n" +
                director + "\n" +
                "Gatunek:" + genre + "\n" +
                "Kategoria Wiekowa: " + rating + "\n" +
                "Czas trwania " + duration + "\n";
        str += "Występują:  " + "\n";
        for (String actor : actors)
            str += actor + "\n";
        return str;
    }

    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
    public String getRating() {
        return rating;
    }
    public String getDuration() {
        return duration;
    }
    public String getDirector() {
        return director;
    }
    public String[] getActors() {
        return (String[]) actors.toArray();
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "MovieData{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", duration='" + duration + '\'' +
                ", genre='" + genre + '\'' +
                ", rating='" + rating + '\'' +
                ", director='" + director + '\'' +
                ", actors=" + actors +
                '}';
    }
}
