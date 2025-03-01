package com.unir.orders.data;

import com.unir.orders.facade.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
}