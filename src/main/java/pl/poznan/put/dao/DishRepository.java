package pl.poznan.put.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.poznan.put.model.Dish;

@Repository
public interface  DishRepository extends JpaRepository<Dish,Long> {
	List<Dish> findByType(String type);
	List<Dish> findByName(String name);
}
