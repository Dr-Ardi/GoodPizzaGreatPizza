package com.example.gpgpBack.sizes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SizesRepository extends JpaRepository<Sizes, Long> {

    @Query("SELECT DISTINCT s.item_Type FROM Sizes s WHERE s.item_Type = ?1")
    String checkSize(String item_Type);

    @Query("SELECT s FROM Sizes s WHERE s.item_Type = ?1")
    List<Sizes> findSizes(String item_Type);
}
