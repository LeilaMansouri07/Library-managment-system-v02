package org.example.Library.service;

import org.example.Library.exception.EntityNotFoundException;
import org.example.Library.model.Book;
import org.example.Library.model.Entity;
import org.example.Library.model.Member;
import org.example.Library.dAO.Library;

import java.util.*;

public class LibraryImpl implements Library {

    private List<Entity> entities = new ArrayList<>();
    private List<String> borrowed = new ArrayList<>();

    public void save(Entity entity) {
        entities.add(entity);
    }

    public void update(Entity e) throws EntityNotFoundException {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getClass() == e.getClass() && entities.get(i).getID().equals(e.getID())) {
                entities.set(i, e);
                return;
            }
        }
        throw new EntityNotFoundException("Entity not found for update.");
    }

    public void delete(Entity e) throws EntityNotFoundException {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getClass() == e.getClass() && entities.get(i).getID().equals(e.getID())) {
                entities.remove(i);
                return;
            }
        }
        throw new EntityNotFoundException("Entity not found for delete.");
    }

    public Entity[] find(Entity example) {
        List<Entity> results = new ArrayList<>();
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            if (example instanceof Member && e instanceof Member) {
                Member m = (Member) e;
                Member ex = (Member) example;
                if (ex.getName() != null && m.getName().toLowerCase().contains(ex.getName().toLowerCase())) {
                    results.add(m);
                }
            } else if (example instanceof Book && e instanceof Book) {
                Book b = (Book) e;
                Book ex = (Book) example;
                if (ex.getTitle() != null && b.getTitle().toLowerCase().contains(ex.getTitle().toLowerCase())) {
                    results.add(b);
                }
            }
        }
        return results.toArray(new Entity[0]);
    }

    public void borrow(Member member, Book book) {
        String key = member.getID() + "-" + book.getID();
        if (!borrowed.contains(key)) {
            borrowed.add(key);
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    public void giveBack(Member member, Book book) {
        String key = member.getID() + "-" + book.getID();
        if (borrowed.contains(key)) {
            borrowed.remove(key);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not borrowed.");
        }
    }

}

