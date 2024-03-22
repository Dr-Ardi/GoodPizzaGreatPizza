package com.example.gpgpBack.tables;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TablesRepository extends JpaRepository<Tables, Long>{

    @Query("SELECT t.table_Number FROM Tables t WHERE t.occupied = ?1 ORDER BY t.table_Number ASC")
    List<Long> getAvailableTables(boolean occupied);

    @Query("SELECT t FROM Tables t ORDER BY t.table_Number ASC")
    List<Tables> getAllTables();

    @Query("SELECT t.occupied FROM Tables t WHERE t.table_Number = ?1")
    boolean isWaiterCalled(Long table_Number);

    @Query("SELECT t.finished FROM Tables t WHERE t.table_Number = ?1")
    boolean isTableFinished(Long table_Number);
}
