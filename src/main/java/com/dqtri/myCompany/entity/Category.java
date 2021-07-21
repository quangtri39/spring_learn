package com.dqtri.myCompany.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_category")
@ToString
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    private long id;
    private String name;
    private LocalDate createdDate;

    @OneToMany(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "id"
    )
    private List<Product> products;

    public void loadFromEntity(CategoryDto categoryDto){
        this.name = categoryDto.getName();
        this.createdDate = categoryDto.getCreatedDate();
    }
}
