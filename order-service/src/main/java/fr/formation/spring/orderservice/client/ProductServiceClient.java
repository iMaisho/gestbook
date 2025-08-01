package fr.formation.spring.orderservice.client;

import fr.formation.spring.orderservice.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// @FeignClient est la clé !
// name = "product-service" : C'est le nom de l'application cible,
// tel qu'il est enregistré dans Eureka. C'est ici que la magie opère.
// Feign va demander à Eureka : "Donne-moi l'adresse de 'product-service'".
@FeignClient(name = "product-service")
public interface ProductServiceClient {

    // La signature de cette méthode doit correspondre à l'endpoint
    // du ProductController dans product-service.
    // GET /api/products/{id}
    @GetMapping("/api/products/{id}")
    ProductDTO findProductById(@PathVariable("id") Long id);

    @GetMapping("/api/products")
    List<ProductDTO> findAllProducts();
}