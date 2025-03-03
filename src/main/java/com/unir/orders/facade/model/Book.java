package com.unir.orders.facade.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {
	@Id
	private Long id;
	private String titulo;
	private String autor;
	private String isbn;
	private String categoria;
	private Long valoracion;
	private LocalDate fechapublica;
	private Boolean visible;
}