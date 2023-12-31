package br.com.fatecararas.f290_dsm_product_ms.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fatecararas.f290_dsm_product_ms.domain.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    List<Product> findByDescriptionContains(String description);
    Optional<Product> findByBarcode(String barcode);
}
