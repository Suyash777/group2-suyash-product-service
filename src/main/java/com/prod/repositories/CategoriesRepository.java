package com.prod.repositories;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prod.entities.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {

	Categories findByCategoryKey(String categoryKey);

}
