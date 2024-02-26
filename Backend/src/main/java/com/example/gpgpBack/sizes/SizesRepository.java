package com.example.gpgpBack.sizes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SizesRepository extends JpaRepository<Sizes, Long> {
    @Query("SELECT DISTINCT s FROM Sizes s WHERE item_Type = ?1")
    List<Sizes> findSizes(String item_Type);
}
