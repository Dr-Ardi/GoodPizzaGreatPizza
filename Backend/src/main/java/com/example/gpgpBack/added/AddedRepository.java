package com.example.gpgpBack.added;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddedRepository extends JpaRepository<Added, Long>{

    @Query("SELECT DISTINCT ad.add_Type FROM Added ad")
    List<String> getAllTypes();
    
    @Query("SELECT ad FROM Added ad WHERE ad.add_Type=?1")
    List<Added> getAdditionsByType(String add_Type);
}
