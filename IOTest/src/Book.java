import java.io.Serializable;

public class Book implements Serializable{

    private long serialVersionUID = 1l;

    private String title;
    private String author;

     public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
