package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;


public class AddressBookMain {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, AddressBook> addressBookMap = new HashMap<>();

    static void addAddressBook() {
        AddressBook addressBook = new AddressBook();
        System.out.println("Enter Address Book Name: ");
        addressBook.setAddressBookName(scanner.next());
        addressBookMap.put(addressBook.getAddressBookName(), addressBook);
        System.out.println(addressBookMap);
    }

    static void addMultipleAddressBook() {
        AddressBook addressBook = new AddressBook();
        if (addressBookMap.get(addressBook.getAddressBookName()) == null) {
            addAddressBook();
            addressBook.contactOperation();
        } else{
            System.out.println("Address Book name already exists:");
        }
    }

    static void addressBookOperation() {
        int choice;
        do {
            System.out.println("Enter Choice");
            System.out.println("1: To add Multiple Address Book");
            System.out.println("2: Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addMultipleAddressBook();
                    break;
                case 2:
                    System.exit(2);
                default:
                    System.out.println("Enter choices");
                    addressBookOperation();
            }
        } while (choice != 2);
    }


    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        AddressBook addressBook = new AddressBook();
        //addressBook.contactOperation();
        addressBookOperation();
//        addressBook.addContact();
//        addressBook.checkDuplicateEntry();
    }
}