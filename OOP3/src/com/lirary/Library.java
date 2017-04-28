package com.lirary;

import java.util.ArrayList;
import java.util.Objects;

public class Library {

    private ArrayList<Book> allLibraryBooks;
    private ArrayList<Book> borrowedBooks;

    public Library() {
        borrowedBooks = new ArrayList<>();
        allLibraryBooks = new ArrayList<>();

        //Adding books
        for (int i = 1; i < 10; i++) {
            allLibraryBooks.add(new Book("Title" + Integer.toString(1), "Author" + Integer.toString(1)));
            allLibraryBooks.add(new Book("Title" + Integer.toString(2), "Author" + Integer.toString(2)));
            allLibraryBooks.add(new Book("Title" + Integer.toString(3), "Author" + Integer.toString(3)));
            allLibraryBooks.add(new Book("Title" + Integer.toString(4), "Author" + Integer.toString(4)));
        }

        showAllLibraryBooks();

       // removeDuplicates(allLibraryBooks);
        removeDuplicates2(allLibraryBooks);


    }


    public void borrowBook(String title, String author) {

        if (getLibraryBook(title, author, borrowedBooks) == null) { //check in borrowed
            if (getLibraryBook(title, author, allLibraryBooks) == null) { //check in all
                System.out.println("Book not found");
            } else {
                borrowedBooks.add(new Book(title, author));
                System.out.println("Book " + title + " borrowed.");
            }
        } else {
            System.out.println("Book already borrowed");
        }

    }

    public void returnBook(String title, String author) {

        Book tempBook = getLibraryBook(title, author, borrowedBooks);

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


    //getting index of book in specified array list
    private int getLibraryBookIndex(String title, String author, ArrayList<Book> list) {

        for (int i = 0; i < list.size(); i++) {
            if (title.equals(list.get(i).getTitle()) &&
                    author.equals(list.get(i).getAuthor())) {
                return i;
            }
        }
        return -1;
    }

    //getting object book in specified array list
    private Book getLibraryBook(String title, String author, ArrayList<Book> list) {

        for (Book aList : list) {
            if (title.equals(aList.getTitle()) &&
                    author.equals(aList.getAuthor())) {
                return aList;
            }
        }
        return null;
    }

    private void removeDuplicates(ArrayList<Book> checkList) {

        ArrayList<Book> duplicatesList = new ArrayList<>();

        for(int i = 0; i < checkList.size(); i++){
            for(int j = i + 1; j < checkList.size(); j++){ // searches for duplicates under the i element of the list
                if(Objects.equals(checkList.get(i).getTitle(), checkList.get(j).getTitle())){  //check for matching title
                    if(Objects.equals(checkList.get(i).getAuthor(), checkList.get(j).getAuthor())){ //check for matching author
                        duplicatesList.add(checkList.get(j));
                    }
                }
            }
        }

        checkList.removeAll(duplicatesList);
    }

    private void removeDuplicates2(ArrayList<Book> checkList){

        ArrayList<Book> tempList = new ArrayList<>();
        ArrayList<Book> duplicatesList = new ArrayList<>();

        for (int i = 0; i < checkList.size(); i++) {

            if(getLibraryBook(checkList.get(i).getTitle(),checkList.get(i).getAuthor(),tempList) == null){

                tempList.add(checkList.get(i));

            }
            else{
               // checkList.remove(i); not working this way
                duplicatesList.add(checkList.get(i));
            }

        }
        checkList.removeAll(duplicatesList);


    }




}
