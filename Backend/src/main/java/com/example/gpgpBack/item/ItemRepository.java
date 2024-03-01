package com.example.gpgpBack.item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT DISTINCT i.id FROM Item i WHERE i.id=?1")
    Long checkId(Long id);

    @Query("SELECT DISTINCT i.name FROM Item i WHERE i.name=?1")
    String checkName(String name);
    
    @Query("SELECT DISTINCT i.type FROM Item i")
    List<String> getEachType();

    @Query("SELECT i FROM Item i WHERE i.id=?1")
    Item getItemById(Long id);

    @Query("SELECT i FROM Item i WHERE i.name=?1")
    Item getItemByName(String name);
   
}
