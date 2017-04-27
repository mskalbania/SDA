package com.lirary;

public class Run {

    public static void main(String[] args) {

        Library library = new Library();

        library.borrowBook("AA", "BB");
        library.borrowBook("CC", "DD");
        library.borrowBook("EE", "FF");

        library.showBorrowedBooks();


        library.returnBook("AA", "XX");
        library.returnBook("XX", "AA");
        library.returnBook("AA", "BB");

        library.showBorrowedBooks();

        library.returnBook("CC", "DD");
        library.returnBook("EE", "FF");

        library.showBorrowedBooks();


    }

}
