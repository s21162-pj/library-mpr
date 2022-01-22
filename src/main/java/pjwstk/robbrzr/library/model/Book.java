package pjwstk.robbrzr.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private int year;
    private String loanDate;
    private String endLoanDate;
    private Long user;

    public Book(){

    }

    public Book(Long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.loanDate = "";
        this.endLoanDate = "";
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.loanDate = "";
        this.endLoanDate = "";
    }

    public Book(Long id, String name, String author, int year, String loanDate, String endLoanDate, Long user) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.loanDate = "";
        this.endLoanDate = "";
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public String getEndLoanDate() {
        return endLoanDate;
    }

    public void setEndLoanDate(String endLoanDate) {
        this.endLoanDate = endLoanDate;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Book{" + id +
                "name='" + name + '\'' +
                "author='" + author + '\'' +
                "year='" + year + '\'' +
                "loanDate='" + loanDate + '\'' +
                "endLoanDate='" + endLoanDate + '\'' +
                "user='" + user + '\'' +
                '}';
    }


}
