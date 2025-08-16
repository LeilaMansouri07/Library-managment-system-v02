package org.example.Library.model;
import org.example.Library.exception.BadEntityException;

import java.util.*;

public class Member extends Person{

    public Member() {}

    public Member(Integer id, String name, Gender gender) {

        super(id, name, gender);
    }

    @Override
    public void readFromConsole() throws BadEntityException {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter Member ID: ");
            this.id = Integer.valueOf(scanner.nextLine().trim());
            System.out.print("Enter Name: ");
            this.name = scanner.nextLine().trim();
            System.out.print("Enter Gender (Male/Female): ");
            String g = scanner.nextLine().trim();
            this.gender = g.equalsIgnoreCase("male") ? Gender.Male : Gender.Female;
        } catch (Exception e) {
            throw new BadEntityException("Invalid member data.");
        }
    }

}



