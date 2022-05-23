package com.bridgelabz;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    static Scanner scanner = new Scanner(System.in);
    List<Contacts> contactsList = new ArrayList<>();
    static Contacts contacts = new Contacts();

    public void addContact() {

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

    public void editContact() {

        System.out.println("Please enter the first name to edit the contact: ");
        String fName = scanner.next();
        for (int i = 0; i < contactsList.size(); i++){
            if(fName.equals(contacts.getFirstName())){
                while (true){
                    System.out.println("Enter choice to edit: 1)firstName\n2)lastName\n3)address\n4)city\n5)state\n6)zip\n7)phoneNumber\n8)email\n9)exit");
                    int choice = scanner.nextInt();
                    switch (choice){
                        case 1:
                            System.out.println("Enter the first Name: ");
                            contacts.setFirstName(scanner.next());
                            break;
                        case 2:
                            System.out.println("Enter the last name: ");
                            contacts.setLastName(scanner.next());
                            break;
                        case 3:
                            System.out.println("Enter the new address: ");
                            contacts.setAddress(scanner.next());
                            break;
                        case 4:
                            System.out.println("Enter the new city: ");
                            contacts.setCity(scanner.next());
                            break;
                        case 5:
                            System.out.println("Enter the new state: ");
                            contacts.setState(scanner.next());
                            break;
                        case 6:
                            System.out.println("Enter the new zip: ");
                            contacts.setZip(scanner.next());
                            break;
                        case 7:
                            System.out.println("Enter the new phone number: ");
                            contacts.setPhoneNumber(scanner.next());
                            break;
                        case 8:
                            System.out.println("Enter the new email: ");
                            contacts.setEmail(scanner.next());
                            break;
                    }
                    if(choice==9);
                    break;
                }
                contactsList.set(i,contacts);
                System.out.println("After editing........");
                System.out.println(contactsList);
            }
        }
    }
}
