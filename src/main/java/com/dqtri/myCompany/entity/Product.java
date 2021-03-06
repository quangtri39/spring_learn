package com.dqtri.myCompany.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "tbl_product")
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    private String name;
    private String Description;
    private LocalDate createdDate;

    public void loadFromDto(ProductDto productDto){
        this.name = productDto.getName();
        this.Description = productDto.getDescription();
        this.createdDate = productDto.getCreatedDate();
    }
//
//    @ManyToOne()
//    private Category category;
}
