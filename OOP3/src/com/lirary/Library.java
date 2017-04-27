package com.lirary;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> borrowedBooks = new ArrayList<>();


    public void borrowBook(String title, String author) {

        borrowedBooks.add(new Book(title, author));
        System.out.println("Book " + title + " borrowed");

    }

    public void returnBook(String title, String author) {

        int tempBookIndex = findBook(title, author);

        if (tempBookIndex >= 0) {
            borrowedBooks.remove(tempBookIndex);
            System.out.println("Book " + title + " returned.");
        } else {
            System.out.println("Book " + title + " not found.");
        }

    }

    public void showBorrowedBooks() {
        System.out.println("\n--------------");
        System.out.println("BORROWED BOOKS");
        System.out.println("--------------");
        if(borrowedBooks.isEmpty()){
            System.out.println("No books borrowed.");
        }
        else {
            for (int i = 0; i < borrowedBooks.size(); i++) {
                System.out.println((i + 1) + "# Author: " + borrowedBooks.get(i).getAuthor() +
                        "  Title: " + borrowedBooks.get(i).getTitle());

            }
        }
        System.out.println("--------------\n");


    }

    private int findBook(String title, String author) {

        for (int i = 0; i < this.borrowedBooks.size(); i++) {
            if (title.equals(this.borrowedBooks.get(i).getTitle()) &&
                    author.equals(this.borrowedBooks.get(i).getAuthor())) {
                return i;
            }
        }
        return -1;
    }


}
