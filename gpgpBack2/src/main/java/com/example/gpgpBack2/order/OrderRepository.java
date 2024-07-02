package com.example.gpgpBack2.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

    @Query("SELECT DISTINCT o.table_Number FROM Order o WHERE o.table_Number = ?1")
    Long checkTable(Long table_Number);
    
    @Query("SELECT o FROM Order o WHERE o.table_Number = ?1 ORDER BY o.priority ASC")
    List<Order> getTableOrders(Long table_Number);
    
    @Query("SELECT SUM(o.order_Cost) FROM Order o WHERE o.table_Number = ?1")
    double getFinalPrice(Long table_Number);

    @Query("DELETE FROM Order o WHERE o.table_Number = ?1")
    Void deleteTableOrder(Long table_Number);
}
