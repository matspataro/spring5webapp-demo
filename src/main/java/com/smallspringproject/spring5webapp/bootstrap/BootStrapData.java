package com.smallspringproject.spring5webapp.bootstrap;

import com.smallspringproject.spring5webapp.model.Author;
import com.smallspringproject.spring5webapp.model.Book;
import com.smallspringproject.spring5webapp.model.Publisher;
import com.smallspringproject.spring5webapp.repositories.AuthorRepository;
import com.smallspringproject.spring5webapp.repositories.BookRepository;
import com.smallspringproject.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Driven Domain Design", "123456");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development", "456789");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: "+ bookRepository.count());

        Publisher penguin = new Publisher("Penguin", "Siempre Viva 123", "Springfied", "Oregon", "1234");

        publisherRepository.save(penguin);

        ddd.setPublisher(penguin);
        penguin.getBooks().add(ddd);
        publisherRepository.save(penguin);

        noEJB.setPublisher(penguin);
        penguin.getBooks().add(noEJB);
        publisherRepository.save(penguin);

        System.out.println();
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Penguin Publisher number of books: " + penguin.getBooks().size());

    }
}
