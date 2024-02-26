package com.example.gpgpBack.addables;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddablesRepository extends JpaRepository<Addables, Long>{
    
    @Query("SELECT a FROM Addables a WHERE item_Type=?1")
    Addables getAddablesByType(String item_Type);
}
