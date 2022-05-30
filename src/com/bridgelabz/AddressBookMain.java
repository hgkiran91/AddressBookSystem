package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class AddressBookMain {

    Map<String, AddressBook> addressBookMap = new HashMap<>();
    public void addMultipleAddressBook(){

    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        AddressBook addressBook = new AddressBook();
        addressBook.contactOperation();
    }
}