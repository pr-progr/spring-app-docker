package com.realt.course.spring.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.realt.course.spring.model.Author;
import com.realt.course.spring.model.Book;
import com.realt.course.spring.model.Publisher;
import com.realt.course.spring.repositories.AuthorRepository;
import com.realt.course.spring.repositories.BookRepositoory;
import com.realt.course.spring.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{
	
	private final AuthorRepository authorRepository;
	private final BookRepositoory bookRepositoory;
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepositoory bookRepositoory,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepositoory = bookRepositoory;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Publisher publisher =new Publisher();
		publisher.setCap("81100");
		publisher.setCity("Caserta");
		publisher.setName("Oxa");
		
		publisherRepository.save(publisher);
	
		
		Author eric = new Author("eric", "eric");
		Book ddd = new Book("Test Spring Framework", "1223455");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		publisher.getBooks().add(ddd);
		ddd.setPublisher(publisher);
		
		authorRepository.save(eric);
		bookRepositoory.save(ddd);
		
		Author steve = new Author("steve","jobs");
		Book b = new Book("Life","46565");
		steve.getBooks().add(b);
		b.getAuthors().add(steve);
		b.setPublisher(publisher);
		publisher.getBooks().add(b);
		
		authorRepository.save(steve);
		bookRepositoory.save(b);		
		
		System.out.println("Start BootStrap");
		System.out.println("Number of Books " + bookRepositoory.count());
		System.out.println("Book of publisher " + publisher.getBooks().size());
		System.out.println("number of publisher " + publisherRepository.count());

	}

}
