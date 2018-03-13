import java.io.Serializable;

public class Theater implements Serializable {

    private String[][] seats;
    private int id;
    private String movieName;
    private int whichTeater;

    public Theater(String[][] seats, int id, String movieName, int whichTeater) {
        this.seats = seats;
        this.id = id;
        this.movieName = movieName;
        this.whichTeater = whichTeater;
    }

    public Theater() {
    }

    public int getWhichTeater() {
        return whichTeater;
    }

    public void setWhichTeater(int whichTeater) {
        this.whichTeater = whichTeater;
    }

    public String[][] getSeats() {
        return seats;
    }

    public void setSeats(String[][] seats) {
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
