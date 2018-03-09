import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
    private String title;
    private String instructor;
    private String age;
    private String description;
    private ArrayList<String> actors;
    private String theater;
    private String time;

    public Movie(String title, String instructor, String age, String description, ArrayList<String> actors, String theater, String time) {
        this.title = title;
        this.instructor = instructor;
        this.age = age;
        this.description = description;
        this.actors = actors;
        this.theater = theater;
        this.time = time;
    }

    public String toString(){


        String actorlist = "";

        if (actors != null){
            for (String actor : actors){
                actorlist += actor + ", ";
            }
            actorlist = actorlist.substring(0, actorlist.length() - 2);
        }

        return "Movie title: " + title + " | Movie instructor: " + instructor + " | Minimum age: " + age + " | Movie description " + description + " | Theater: " + theater + "| Show Time: " + time + " | Actors: " + actorlist;
    }



    public Movie(){

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getTime() {
        return time;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public String getAge() {
        return age;
    }

    public String getTheater() {
        return theater;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}