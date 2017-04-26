package com.lirary;

import java.util.ArrayList;

public class Library {

   private ArrayList<Book> borrowedBooks = new ArrayList<>();


    public void borrowBook(String title, String author){

        borrowedBooks.add(new Book(title,author));
        System.out.println("Book " + title + " borrowed");

    }

    public void returnBook(String title, String author){

        if(findBook(title,author) >= 0){
            borrowedBooks.remove(findBook(title,author));
        }
        else {
            System.out.println("Not found");
        }

    }

    public void showBorrowedBooks(){
        System.out.println("--------------");
        System.out.println("BORROWED BOOKS");
        System.out.println("--------------");
        for(int i = 0; i < borrowedBooks.size(); i++){
            System.out.println("Author: " + borrowedBooks.get(i).getAuthor() +
                                 "  Title: " + borrowedBooks.get(i).getTitle());

        }
        System.out.println("--------------");


    }

    private int findBook(String title,String author){

        for (int i = 0; i < this.borrowedBooks.size(); i++){
            if(title.equals(this.borrowedBooks.get(i).getTitle()) &&
                    author.equals(this.borrowedBooks.get(i).getAuthor())){
                return i;
            }
        }
        return -1;
    }





}
