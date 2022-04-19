/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.budgetapi;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Cosug-dmuhumuza-lt
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Query(value = "SELECT * FROM budget_item WHERE budget_id = :budget_id", nativeQuery = true)
    List<Item> findItemByBudgetId(@Param("budget_id")Integer budget_id);
        
    
    
}
