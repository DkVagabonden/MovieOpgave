import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
    private String title;
    private String instructor;
    private String age;
    private String description;
    private ArrayList<String> actors;
    private int theater;
    private int time;

    public Movie(String title, String instructor, String age, String description, ArrayList<String> actors, int theater, int time) {
        this.title = title;
        this.instructor = instructor;
        this.age = age;
        this.description = description;
        this.actors = actors;
        this.theater = theater;
        this.time = time;
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

    public int getTime() {
        return time;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public String getAge() {
        return age;
    }

    public int getTheater() {
        return theater;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setTheater(int theater) {
        this.theater = theater;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}