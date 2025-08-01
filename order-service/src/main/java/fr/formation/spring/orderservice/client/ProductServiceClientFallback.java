package fr.formation.spring.orderservice.client;

import fr.formation.spring.orderservice.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component // Doit être un bean Spring pour que Feign puisse l'injecter
public class ProductServiceClientFallback implements ProductServiceClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            ProductServiceClientFallback.class
    );

    @Override
    public ProductDTO findProductById(Long id) {
        // Logique de repli : on logue l'erreur et on retourne un objet par défaut
        LOGGER.error(
                "Fallback for findProductById: product-service is down. ProductId: {}",
                id
        );

        ProductDTO fallbackProduct = new ProductDTO();
        fallbackProduct.setId(id);
        fallbackProduct.setName("Produit temporairement indisponible");
        // On met des valeurs par défaut pour éviter les NullPointerException
        fallbackProduct.setPrice(0.0);
        fallbackProduct.setStock(0);

        return fallbackProduct;
    }

    @Override
    public List<ProductDTO> findAllProducts(){
        LOGGER.error(
                "Fallback for findAllProducts : product-service is down."
        );

        ProductDTO fallbackProduct = new ProductDTO();
        fallbackProduct.setId(0L);
        fallbackProduct.setName("Produit temporairement indisponible");
        // On met des valeurs par défaut pour éviter les NullPointerException
        fallbackProduct.setPrice(0.0);
        fallbackProduct.setStock(0);

        List<ProductDTO> fallbackArray = new ArrayList<>();
        fallbackArray.add(fallbackProduct);
        return fallbackArray;
    }
}