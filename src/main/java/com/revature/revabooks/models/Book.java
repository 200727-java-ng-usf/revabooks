package com.revature.revabooks.models;

import java.util.List;
import java.util.Objects;

public class Book {
    private Integer id;
    private String isbn;
    private String title;
    private Author author;
    private List<Genre> genre;
    private Integer stockCount;

    public Book(){
        super();
    }

    public Book(String isbn, String title, Author author, List<Genre> genre, Integer stockCount) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.stockCount = stockCount;
    }


    public Book(Integer id, String isbn, String title, Author author, List<Genre> genre, Integer stockCount) {
        this(isbn, title,author,genre,stockCount);
        this.stockCount = stockCount;
    }

    //copy convenience method
    public Book(Book copy){
        this(copy.id, copy.isbn, copy.title, copy.author, copy.genre, copy.stockCount);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getId(), book.getId()) &&
                Objects.equals(getIsbn(), book.getIsbn()) &&
                Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getGenre(), book.getGenre()) &&
                Objects.equals(getStockCount(), book.getStockCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIsbn(), getTitle(), getAuthor(), getGenre(), getStockCount());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", genre=" + genre +
                ", stockCount=" + stockCount +
                '}';
    }
}
