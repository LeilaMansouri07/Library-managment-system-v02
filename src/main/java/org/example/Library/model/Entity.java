package org.example.Library.model;

import org.example.Library.exception.BadEntityException;

public interface Entity {

    Integer getID();

    void readFromConsole() throws BadEntityException;

    void showOnConsole();
}
