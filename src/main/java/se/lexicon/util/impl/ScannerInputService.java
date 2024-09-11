package se.lexicon.util.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.util.UserInputService;

import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService {

    private Scanner scanner;

    @Autowired
    public ScannerInputService(Scanner scanner) {
        System.out.println("Scanner object created...");
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        System.out.println("Enter Student Name:");
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        System.out.println("Enter Student ID:");
        return scanner.nextInt();
    }
}
