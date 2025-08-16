package org.example.Library.model;

import org.example.Library.exception.BadEntityException;

import java.util.*;

public class Book implements Entity {

    private Integer id;
    private String title;
    private String author;

    public Book() {
    }

    public Book(Integer id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Integer getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void readFromConsole() throws BadEntityException {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter Book ID: ");
            this.id = Integer.valueOf(scanner.nextLine());
            System.out.print("Enter Title: ");
            this.title = scanner.nextLine();
            System.out.print("Enter Author: ");
            this.author = scanner.nextLine();
        } catch (Exception e) {
            throw new BadEntityException("Invalid book data.");
        }
    }

    @Override
    public void showOnConsole() {
        System.out.println("Book ID: " + id + " | Title: " + title + " | Author: " + author);
    }
}



