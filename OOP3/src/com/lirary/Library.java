package com.lirary;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> allLibraryBooks = new ArrayList<>();
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Library() {
        allLibraryBooks.add(new Book("Title1", "Author1"));
        allLibraryBooks.add(new Book("Title2", "Author2"));
        allLibraryBooks.add(new Book("Title3", "Author3"));
    }


    public void borrowBook(String title, String author) {

        Book tempBook = getLibraryBook(title, author,allLibraryBooks);
        if(tempBook == null){
            System.out.println("Book not found");
        }
        else{
            borrowedBooks.add(new Book(title,author));
            System.out.println("Book " + title + " borrowed.");
        }
    }

    public void returnBook(String title, String author) {

        Book tempBook = getLibraryBook(title, author,borrowedBooks);

        if (tempBook == null) {
            System.out.println("Book " + title + " " + author + " not found.");
        } else {
            borrowedBooks.remove(tempBook);
            System.out.println("Book " + title + " returned.");
        }
    }

    public void showAllLibraryBooks() {
        System.out.println("\n--------------");
        System.out.println("LIBRARY BOOKS");
        System.out.println("--------------");

        for (int i = 0; i < allLibraryBooks.size(); i++) {
            System.out.println((i + 1) + "# Author: " + allLibraryBooks.get(i).getAuthor() +
                    "  Title: " + allLibraryBooks.get(i).getTitle());
        }
    }


    public void showBorrowedBooks() {

        System.out.println("\n--------------");
        System.out.println("BORROWED BOOKS");
        System.out.println("--------------");

        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed.");
        } else {
            for (int i = 0; i < borrowedBooks.size(); i++) {
                System.out.println((i + 1) + "# Author: " + borrowedBooks.get(i).getAuthor() +
                        "  Title: " + borrowedBooks.get(i).getTitle());
            }
        }
        System.out.println("--------------\n");

    }


    //getting index of book in array list
    private int getLibraryBookIndex(String title, String author, ArrayList<Book> list) {

        for (int i = 0; i < list.size(); i++) {
            if (title.equals(list.get(i).getTitle()) &&
                    author.equals(list.get(i).getAuthor())) {
                return i;
            }
        }
        return -1;
    }

    //getting object book in array list
    private Book getLibraryBook(String title, String author, ArrayList<Book> list){

        for (int i = 0; i < list.size(); i++) {
            if (title.equals(list.get(i).getTitle()) &&
                    author.equals(list.get(i).getAuthor())) {
                return list.get(i);
            }
        }
        return null;
    }

}
