package org.example.Library.dAO;

import org.example.Library.exception.EntityNotFoundException;
import org.example.Library.model.Book;
import org.example.Library.model.Entity;
import org.example.Library.model.Member;

public interface Library {

    void save(Entity entity);
    void update(Entity entity) throws EntityNotFoundException;
    void delete(Entity entity) throws EntityNotFoundException;
    Entity[] find(Entity example);
    void borrow(Member member, Book book);
    void giveBack(Member member, Book book);
}

