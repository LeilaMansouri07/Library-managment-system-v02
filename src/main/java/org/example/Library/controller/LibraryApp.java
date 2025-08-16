package org.example.Library.controller;

import org.example.Library.model.Book;
import org.example.Library.model.Entity;
import org.example.Library.model.Gender;
import org.example.Library.model.Member;
import org.example.Library.service.LibraryImpl;

import java.util.*;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryImpl library = new LibraryImpl();

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Member");
            System.out.println("2. Add Book");
            System.out.println("3. Edit Member");
            System.out.println("4. Edit Book");
            System.out.println("5. Delete Member");
            System.out.println("6. Delete Book");
            System.out.println("7. Search Member");
            System.out.println("8. Search Book");
            System.out.println("9. Borrow Book");
            System.out.println("10. Return Book");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();

            try {
                if (choice.equals("1")) {
                    Member m = new Member();
                    m.readFromConsole();
                    library.save(m);
                } else if (choice.equals("2")) {
                    Book b = new Book();
                    b.readFromConsole();
                    library.save(b);
                } else if (choice.equals("3")) {
                    Member m = new Member();
                    m.readFromConsole();
                    library.update(m);
                } else if (choice.equals("4")) {
                    Book b = new Book();
                    b.readFromConsole();
                    library.update(b);
                } else if (choice.equals("5")) {
                    Member m = new Member();
                    m.readFromConsole();
                    library.delete(m);
                } else if (choice.equals("6")) {
                    Book b = new Book();
                    b.readFromConsole();
                    library.delete(b);
                } else if (choice.equals("7")) {
                    Member m = new Member();
                    System.out.print("Enter member name to search: ");
                    m.setName(scanner.nextLine());
                    Entity[] results = library.find(m);
                    for (int i = 0; i < results.length; i++) {
                        results[i].showOnConsole();
                    }
                } else if (choice.equals("8")) {
                    Book b = new Book();
                    System.out.print("Enter book title to search: ");
                    b.setTitle(scanner.nextLine());
                    Entity[] results = library.find(b);
                    for (int i = 0; i < results.length; i++) {
                        results[i].showOnConsole();
                    }
                } else if (choice.equals("9")) {
                    System.out.print("Enter Member ID: ");
                    Integer mid = Integer.valueOf(scanner.nextLine());
                    System.out.print("Enter Book ID: ");
                    Integer bid = Integer.valueOf(scanner.nextLine());

                    Member member = null;
                    Book book = null;

                    Entity[] members = library.find(new Member(mid, "", Gender.Male));
                    for (int i = 0; i < members.length; i++) {
                        if (members[i] instanceof Member) {
                            member = (Member) members[i];
                        }
                    }

                    Entity[] books = library.find(new Book(bid, "", ""));
                    for (int i = 0; i < books.length; i++) {
                        if (books[i] instanceof Book) {
                            book = (Book) books[i];
                        }
                    }

                    if (member != null && book != null) {
                        library.borrow(member, book);
                    }
                } else if (choice.equals("10")) {
                    System.out.print("Enter Member ID: ");
                    Integer mid = Integer.valueOf(scanner.nextLine().trim());
                    System.out.print("Enter Book ID: ");
                    Integer bid = Integer.valueOf(scanner.nextLine().trim());

                    Member member = null;
                    Book book = null;

                    Entity[] members = library.find(new Member(mid, "", Gender.Male));
                    for (int i = 0; i < members.length; i++) {
                        if (members[i] instanceof Member) {
                            member = (Member) members[i];
                        }
                    }

                    Entity[] books = library.find(new Book(bid, "", ""));
                    for (int i = 0; i < books.length; i++) {
                        if (books[i] instanceof Book) {
                            book = (Book) books[i];
                        }
                    }

                    if (member != null && book != null) {
                        library.giveBack(member, book);
                    }
                } else if (choice.equals("0")) {
                    System.out.println("Exiting...");
                    break;
                } else {
                    System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}