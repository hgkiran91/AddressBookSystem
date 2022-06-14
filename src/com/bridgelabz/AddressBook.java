package com.bridgelabz;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;

public class AddressBook {

    private String addressBookName;
    static Scanner scanner = new Scanner(System.in);
    List<Contacts> contactsList = new CopyOnWriteArrayList<>();
    //Map<String, Contacts> contactsMap = new HashMap<>();

    public AddressBook() {
    }

    public String getAddressBookName() {
        return addressBookName;
    }

    public void setAddressBookName(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "addressBookName='" + addressBookName + '\'' +
                '}';
    }

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
        contactsList.stream().forEach(contacts -> {
            if (fName.equals(contacts.getFirstName())) {
                updateContacts(contacts);
            } else {
                System.out.println("Entered contact is not present");
                addContact();
            }
        });
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
        contactsList.add(contacts);
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
            } else {
                System.out.println("No such contacts....");
            }
        }
    }

    public void deleteContact() {
        Contacts contacts;
        System.out.println("Enter first name: ");
        String firstName = scanner.next();
        for (int i = 0; i < contactsList.size(); i++) {
            contacts = contactsList.get(i);
            if (contacts.getFirstName().equals(firstName)) {
                contactsList.remove(i);
                System.out.println("Deleted contact successfully");
            }
        }
    }

    public void addMultipleContact() {
//        Contacts contacts = new Contacts();
        addContact();
        checkDuplicateEntry();
//        contactsMap.put(contacts.getFirstName(), contacts);
    }

    public void displayAddressBook() {
        System.out.println("Address Book Name: " + addressBookName);
    }

    public void checkDuplicateEntry() {
        System.out.println("Enter the First Name:");
        String fName = scanner.next();
        contactsList.stream().forEach(x -> {
            if (x.getFirstName().equals(fName)) {
                System.out.println("Name already exists:");
            }else {
                addContact();
            }
        });
    }

}

