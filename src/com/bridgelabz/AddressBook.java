package com.bridgelabz;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class AddressBook extends Contacts {

    static Scanner scanner = new Scanner(System.in);
    List<Contacts> contactsList = new CopyOnWriteArrayList<>();
    Map<String, Contacts> contactsMap = new HashMap<>();

//    static Contacts contacts = new Contacts();
//    static Contacts contacts1 = new Contacts();

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
    }

    public void editContact() {
        System.out.println("Please enter the first name to edit the contact: ");
        String fName = scanner.next();
        Contacts contacts = new Contacts();
        for (Contacts contacts1 : contactsList) {
            if (fName.equals(contacts.getFirstName())) {
                updateContacts(contacts);
            } else {
                System.out.println("Entered Name is not present in the Address Book to edit");
                System.out.println("Please enter if you want to add New Contact to the Address Book:");
                addContact();
            }
        }
    }

    public void updateContacts(Contacts contacts) {

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
    }

    public void contactOperation() {
        int choice;
        do {
            System.out.println("Enter the choice");
            System.out.println("1: Add Contacts to Address Book");
            System.out.println("2: Edit Contacts in Address Book");
            System.out.println("3: Display Contacts in Address Book");
            System.out.println("4: Delete Contacts in Address Book");
            System.out.println("5: ADD Multiple Contact to Address Book");
            System.out.println("6: Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    editContact();
                    break;
                case 3:
                    showContacts();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    addMultipleContact();
                    break;
                case 6:
                    System.exit(5);
                    break;
                default:
                    System.out.println("Enter choice between 1-5");
                    contactOperation();
            }
        } while (choice != 6);
    }

    public void showContacts() {
        System.out.println("Enter the first name: ");
        String fName = scanner.next();
        for (Contacts contacts : contactsList) {
            if (fName.equals(contacts.getFirstName())) {
                contacts.displayContacts();
                break;
            }
//            else {
//                System.out.println("Entered Name is not present in the Address Book");
//                System.out.println("Please enter if you want to add New Contact to the Address Book:");
//                addContact();
//            }
        }
    }

    public void deleteContact() {
        System.out.println("Enter the first name to search and delete: ");
        String fName = scanner.next();
        contactsList.stream().forEach(contacts -> {
            if (contacts.getFirstName() == fName) {
                contactsList.remove(contacts);
            }
        });
    }

    public void addMultipleContact() {

        Contacts contacts = new Contacts();
        addContact();
        contactsMap.put(contacts.getFirstName(), contacts);
    }
}

