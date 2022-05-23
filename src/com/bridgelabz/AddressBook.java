package com.bridgelabz;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    static Scanner scanner = new Scanner(System.in);

    List<Contacts> contactsList = new ArrayList<>();

    public void addContact() {
        Contacts contacts = new Contacts();

        System.out.println("Please enter your first name: ");
        contacts.setFirstName(scanner.next());
        System.out.println("Please enter your last name: ");
        contacts.setLastName(scanner.next());
        System.out.println("Please enter your address: ");
        contacts.setAddress(scanner.next());
        System.out.println("Please enter your city: ");
        contacts.setCity(scanner.next());
        System.out.println("Please enter your state: ");
        contacts.setState(scanner.next());
        System.out.println("Please enter your zip: ");
        contacts.setZip(scanner.next());
        System.out.println("Please enter your phone number: ");
        contacts.setPhoneNumber(scanner.next());
        System.out.println("Please enter your email: ");
        contacts.setEmail(scanner.next());

        contactsList.add(contacts);
        System.out.println(contactsList);
    }
}
