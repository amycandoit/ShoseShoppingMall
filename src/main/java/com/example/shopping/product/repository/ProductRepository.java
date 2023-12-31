package com.example.shopping.product.repository;

import com.example.shopping.product.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    Optional<Product> findById(Long productSeq);

    //@Query("select p from Product p where p.hname like '%productName%' OR p.ename LIKE '%productName%'")
    @Query("SELECT p FROM Product p WHERE p.hname LIKE %:productName% OR p.ename LIKE %:productName%")
    List<Product> searchProductByHnameAndEname(String productName);


    @Query("SELECT p.hname, p.ename, p.imgUrl, p.detailImgUrl, p.createAt, p.brand, p.price, o1.size, o2.color " +
            "FROM Product p " +
            "LEFT JOIN p.productOptions o1 " +
            "LEFT JOIN p.productOptions2 o2 " +
            "WHERE o1.size IN :sizes " +
            "AND o2.color IN :colors")
    List<Object[]> searchSizeAndColor(@Param("sizes") List<Integer> sizes, @Param("colors") List<String> colors);


}
