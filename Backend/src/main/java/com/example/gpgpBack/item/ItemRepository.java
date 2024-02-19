package com.example.gpgpBack.item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    
    @Query("SELECT DISTINCT i.type FROM Item i")
    List<String> getEachType();

    @Query("SELECT i FROM Item i WHERE i.id=?1")
    Item getItemById(Long id);
   
}
