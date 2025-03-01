package com.unir.orders.service;

import com.unir.orders.data.BookJpaRepository;
import com.unir.orders.data.OrderJpaRepository;
import com.unir.orders.data.model.Order;
import com.unir.orders.controller.model.OrderRequest;
import com.unir.orders.facade.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrdersServiceImpl implements OrdersService {

  @Autowired
  private BookJpaRepository bookRepository;

  @Autowired
  private OrderJpaRepository repository;

  @Override
  public Order createOrder(OrderRequest request) {
    // Buscar libros directamente en la base de datos local
    List<Book> books = request.getBooks().stream()
            .map(id -> bookRepository.findById(Long.valueOf(id)).orElse(null))
            .filter(Objects::nonNull)
            .filter(Book::getVisible)
            .toList();

    if(books.size() != request.getBooks().size()) {
      return null;
    } else {
      Order order = Order.builder()
              .books(books.stream().map(Book::getId).collect(Collectors.toList()))
              .build();
      repository.save(order);
      return order;
    }
  }

  @Override
  public Order getOrder(String id) {
    return repository.findById(Long.valueOf(id)).orElse(null);
  }

  @Override
  public List<Order> getOrders() {
    List<Order> orders = repository.findAll();
    return orders.isEmpty() ? null : orders;
  }
}