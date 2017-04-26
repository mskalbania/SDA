package com.lirary;

public class Run {

    public static void main(String[] args) {

        Library library = new Library();

        library.borrowBook("AA","BB");
        library.borrowBook("CC","DD");
        library.borrowBook("EE","FF");

        library.showBorrowedBooks();

        library.returnBook("XX","XX");

        library.returnBook("AA","BB");
        library.returnBook("CC","DD");
        library.returnBook("EE","FF");

        library.showBorrowedBooks();


    }

}
