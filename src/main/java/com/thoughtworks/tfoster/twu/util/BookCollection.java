package com.thoughtworks.tfoster.twu.util;

import com.thoughtworks.tfoster.twu.Book;

import java.util.Collection;
import java.util.Iterator;

public class BookCollection implements Iterable<Book> {

    private Collection<Book> books;

    public BookCollection(Collection<Book> books) {
        this.books = books;
    }

    //  This is a smell; needs to be refactored
    @Override
    public Iterator<Book> iterator() {
        return books.iterator();
    }

    public void moveToCollection(String title, BookCollection other) {
        Book book = getBookWithTitle(title);
        if(books.remove(book))
            other.books.add(book);
    }

    public boolean contains(String title) {
        return getBookWithTitle(title) != null;
    }

    private Book getBookWithTitle(String title) {
        for(Book book : books)
            if(book.hasTitle(title))
                return book;
        return null;
    }
}
