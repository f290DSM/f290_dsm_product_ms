package br.com.fatecararas.f290_dsm_product_ms.resources;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatecararas.f290_dsm_product_ms.domain.entities.Product;
import br.com.fatecararas.f290_dsm_product_ms.repositories.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductResource {

    private final ProductRepository repository;

    public ProductResource(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Product>> getAll(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size) {

        PageRequest pageable = PageRequest.of(page, size, Sort.Direction.ASC, "description");

        Page<Product> products = repository.findAll(pageable);

        if (products.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();

        return ResponseEntity.ok().body(products);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody Product product) {
        repository.save(product);
    }
}
