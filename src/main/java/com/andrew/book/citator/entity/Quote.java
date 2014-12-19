package com.andrew.book.citator.entity;

import javax.persistence.*;

@Entity
@Table(name = "quote", schema = "citator")
public class Quote {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idQuote;

    @Column(name = "quote", nullable = false)
    private String quote;

    @Column(name = "idUser", nullable = false)
    private int idUser;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "idBook")
    private Book book;

    public int getIdQuote() {
        return idQuote;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

}
