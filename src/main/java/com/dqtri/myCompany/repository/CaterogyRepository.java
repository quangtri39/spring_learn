package com.dqtri.myCompany.repository;

import com.dqtri.myCompany.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaterogyRepository extends JpaRepository<Category, Long> {

}
