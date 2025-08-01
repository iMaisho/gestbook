package fr.formation.spring.productservice.controller;

import fr.formation.spring.productservice.entity.Product;
import fr.formation.spring.productservice.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Indique que c'est un contrôleur REST
@RequestMapping("/api/products") // Préfixe pour tous les endpoints de cette classe
public class ProductController {

    // Injection de dépendance de notre repository
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Endpoint pour récupérer tous les produits
    // GET http://localhost:8081/api/products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Endpoint pour récupérer un produit par son ID
    // GET http://localhost:8081/api/products/1
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        // On retourne le produit avec un statut 200 OK,
        // ou un statut 404 Not Found s'il n'existe pas.
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Définit le code de statut HTTP à 201
    public Product createProduct(@RequestBody Product product) {
        // @RequestBody indique à Spring de convertir le JSON
        // du corps de la requête en un objet Product.
        // L'ID du produit entrant sera null.
        // La méthode save() renvoie l'entité persistée,
        // qui inclut maintenant l'ID généré par la base de données.
        return productRepository.save(product);
    }
}