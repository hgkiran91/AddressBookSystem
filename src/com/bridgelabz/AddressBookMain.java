package com.bridgelabz;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.stream.Collectors;


public class AddressBookMain {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, AddressBook> addressBookMap = new HashMap<>();

    static Map<String, List<Contacts>> cityContactMap = new HashMap<>();

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
        } else {
            System.out.println("Address Book name already exists:");
        }
    }

    static void searchPerson() {
        //UC8
        AddressBook addressBook = new AddressBook();
        for (Map.Entry<String, AddressBook> addressBookEntry : addressBookMap.entrySet()) {
            AddressBook addressBook1 = addressBookEntry.getValue();
            addressBook1.contactsList.stream().forEach(x -> {
                if (cityContactMap.containsKey(x.getCity())) {
                    List<Contacts> contactsList = cityContactMap.get(x.getCity());
                    contactsList.add(x);
                } else {
                    List<Contacts> contactsList = new ArrayList<>();
                    contactsList.add(x);
                    cityContactMap.put(x.getCity(), contactsList);
                }
            });
            System.out.println();
            System.out.println();
        }
        System.out.println(addressBook.contactsList);
        System.out.println("City Patient Map");
        System.out.println(cityContactMap);

        System.out.println(addressBook.contactsList);
    }

    static void viewPerson() {
        AddressBook addressBook = new AddressBook();
        for (Map.Entry<String, AddressBook> addressBookEntry : addressBookMap.entrySet()) {
            AddressBook addressBook1 = addressBookEntry.getValue();
            addressBook1.contactsList.stream().forEach(x -> {
                if (cityContactMap.containsKey(x.getCity())) {
                    System.out.println(cityContactMap.get(x.getFirstName()));
                }
            });
        }
    }

    private static int countOfContact(String cityStateName, Map<String, List<Contacts>> addressBookHashMap) {
        AtomicInteger cityCounter = new AtomicInteger();
        addressBookHashMap
                .values()
                .forEach(value -> {
                    value.forEach(x -> {
                        if (x.getCity().equals(cityStateName) || x.getState().equals(cityStateName))
                            cityCounter.getAndIncrement();
                    });
                });
        return cityCounter.get();
    }

    static void addressBookOperation() {
        int choice;
        do {
            System.out.println("Enter Choice");
            System.out.println("1: To add Multiple Address Book");
            System.out.println("2: Search Person by City");
            System.out.println("3: View Person by city");
            System.out.println("4: Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addMultipleAddressBook();
                    break;
                case 2:
                    searchPerson();
                    break;
                case 3:
                    viewPerson();
                    break;
                case 4:
                    System.exit(4);
                default:
                    System.out.println("Enter choices");
                    addressBookOperation();
            }
        } while (choice != 4);
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