package com.smallspringproject.spring5webapp.repositories;

import com.smallspringproject.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
