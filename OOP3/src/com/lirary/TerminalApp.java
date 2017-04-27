package com.lirary;

import java.util.Scanner;

public class TerminalApp {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int answer = 0;
        Library library = null;
        showMenu();
        library = new Library();
        while (!quit) {
            answer = scanner.nextInt();
            switch (answer) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    showMenu();
                    break;
                case 2:
                    library.showAllLibraryBooks();
                    break;
                case 3:
                    library.showBorrowedBooks();
                    break;
                case 4:
                    System.out.println("Enter title: ");
                    String tempTitle = scanner.next();
                    System.out.println("Enter author: ");
                    String tempAuthor = scanner.next();
                    library.borrowBook(tempTitle, tempAuthor);
                    break;
                case 5:
                    System.out.println("Enter title: ");
                    String tempTitle2 = scanner.next();
                    System.out.println("Enter author: ");
                    String tempAuthor2 = scanner.next();
                    library.returnBook(tempTitle2, tempAuthor2);
                    break;
                default:
                    System.out.println("Wrong input key.");
                    break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("---LIBRARY MENU---" +
                "\n0. Exit" +
                "\n1. Show menu" +
                "\n2. Show library books" +
                "\n3. Show borrowed books" +
                "\n4. Borrow book from library" +
                "\n5. Return book to library");
    }
}
