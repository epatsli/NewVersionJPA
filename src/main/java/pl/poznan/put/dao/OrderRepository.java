package pl.poznan.put.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.poznan.put.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
	List<Order> findByStatus(String type);
}
