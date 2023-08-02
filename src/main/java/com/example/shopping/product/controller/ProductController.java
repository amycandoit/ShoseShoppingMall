package com.example.shopping.product.controller;

import com.example.shopping.product.domain.entity.Product;
import com.example.shopping.product.domain.request.ProductRequest;
import com.example.shopping.product.domain.request.ProductUpdateRequest;
import com.example.shopping.product.domain.response.ProductResponse;
import com.example.shopping.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
@CrossOrigin("*")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }

    @PutMapping("{productSeq}")
    public ProductResponse update(@PathVariable("productSeq") Long productSeq, @RequestBody ProductUpdateRequest productUpdateRequest) {
        return productService.update(productSeq, productUpdateRequest);
    }
    @PostMapping
    public void save(@RequestBody ProductRequest productRequest) {
        System.out.println(productRequest.toString());

        productService.save(productRequest);
    }

    @DeleteMapping("{productSeq}")
    private void delete(@PathVariable("productSeq") Long productSeq) {
        productService.delete(productSeq);
    }

// 방법1) 상품검색 : jpa
    @GetMapping("/searchProduct")
    public List<ProductResponse> searchProductByKeyword(@RequestParam("productName")String productName){
        return productService.searchProductByKeyword(productName);
    }
// 방법2) 상품검색 : query
    @GetMapping("/searchProduct2")
    public List<ProductResponse> searchProductByHnameAndEname(@RequestParam("productName")String productName){
        return productService.searchProductByHnameAndEname(productName);
    }
}
