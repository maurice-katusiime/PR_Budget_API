/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.budgetapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Cosug-dmuhumuza-lt
 */
@Entity
@Table(name="budget_item")
public class Item {
    // item fields
    private int budget_id;
    private int item_id;
    private String item_name;
    private String description;
    private double item_cost;
    
    public Item(int budget_id, int item_id, String item_name, String description, double item_cost){
        this.budget_id = budget_id;
        this.item_name = item_name;
        this.item_id = item_id;
        this.description = description;
        this.item_cost = item_cost;
    }
    
    
    // getters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getItemId(){
        return this.item_id;
    }
    public int getBudgetId(){
        return this.budget_id;
    }
    
    public String getItemName(){
        return this.item_name;
    }
    
    public String getDescription(){
        return this.description;
    } 
    
    public double getItemCost(){
        return this.item_cost;
    }
    
    // setters
    public void setBudgetId(int budget_id){
        this.budget_id = budget_id;
    }
    
    public void setItemName(String item){
        this.item_name = item_name;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void setItemCost(double item_cost){
        this.item_cost = item_cost;
    }
    
    public void setItemId(int item_id){
        this.item_id = item_id;
    }
    
    
}
