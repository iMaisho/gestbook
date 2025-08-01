package fr.formation.spring.productservice.repository;

import fr.formation.spring.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// On étend JpaRepository en spécifiant l'entité (Product)
// et le type de sa clé primaire (Long).
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Spring Data JPA va automatiquement implémenter les méthodes
    // comme findAll(), findById(), save(), deleteById(), etc.
}