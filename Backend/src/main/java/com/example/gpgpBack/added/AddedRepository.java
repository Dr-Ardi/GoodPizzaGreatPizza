package com.example.gpgpBack.added;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddedRepository extends JpaRepository<Added, Long>{
    
    @Query("SELECT ad FROM Added ad WHERE add_Type=?1")
    List<Added> getAdditionsByType(String add_Type);
}
