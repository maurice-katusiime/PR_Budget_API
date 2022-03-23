/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.budgetapi;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Cosug-dmuhumuza-lt
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {
    
}
