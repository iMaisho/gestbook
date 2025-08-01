package fr.formation.spring.productservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity     // Indique que cette classe est une entité JPA
@Data       // Lombok : génère getters, setters, toString, etc.
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id // Clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrément
    private Long id;

    private String name;    // Nom du livre
    private String author;  // Auteur du livre
    private String isbn;    // ISBN du livre
    private double price;   // Prix du livre
    private int stock;      // Quantité en stock
}