package mataram.padam.sugarormsample.entity;


import com.orm.SugarRecord;

/**
 * Created by Hendro Steven on 19/03/2017.
 */

public class Book extends SugarRecord {
    private String title;
    private String author;
    private double price;

    public Book(){

    }

    public Book(String title, String author, double price){
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
