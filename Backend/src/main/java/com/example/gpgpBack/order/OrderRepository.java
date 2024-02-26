package com.example.gpgpBack.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    
    @Query("SELECT o FROM Order o WHERE table_Number = ?1 ORDER BY o.priority ASC")
    List<Order> getTableOrders(Long table_Number);

}
