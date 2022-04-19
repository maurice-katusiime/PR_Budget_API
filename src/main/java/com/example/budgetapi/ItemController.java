/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.budgetapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cosug-dmuhumuza-lt
 */
// Handle HTTP requests
@CrossOrigin(origins = "*")

@RequestMapping(path = "/budgetapi/v1")
@RestController
public class ItemController {
    @Autowired //get the repository to handle the data
    //BudgetRepository budgetRepository;
    ItemRepository itemRepository;
    BudgetRepository budgetRepository;
    
    //retrieve budget items
    @GetMapping(path = "/get")
    public List<Item> items(){
        //show all budget items 
         return itemRepository.findAll();
   }
    
    
    
    
    // create a budget item
    @PostMapping(path= "/create_budget_item")
    public Item createBudgetItem(@RequestBody Item item){
        return itemRepository.save(item);
    }
    
    // get budget item belonging to a specific budget
    @GetMapping("/get_single_budget_item")
    public ResponseEntity<List> findItemByBudgetId(Integer budget_id){
            // retrieve employee object from db
            List item = itemRepository.findItemByBudgetId(1);
                    
            //.orElseThrow(() -> new ResourceNotFoundException("Item does not exist with that id :" + budget_id));
        
            return  ResponseEntity.ok(item);
        
    } 
    
    
    
    // update budget item
    @PutMapping("/update_budget_item/{item_id}")
    public ResponseEntity<Item> updateItem (@RequestBody Item itemDetails, @PathVariable int item_id){
        // retrieve employee by id
        Item item = itemRepository.findById(item_id).
                orElseThrow(() -> new ResourceNotFoundException("Item not found with id :" + item_id));
        
        item.setItemName(itemDetails.getItemName());
        item.setDescription(itemDetails.getDescription());
        item.setItemCost(itemDetails.getItemCost());
        item.setBudgetId(itemDetails.getBudgetId());
        
        // save updated data
        Item updatedBudgetItem = itemRepository.save(item);
        
        return ResponseEntity.ok(updatedBudgetItem);
    }
       
    // delete budget item 
    @DeleteMapping("/delete_budget_item/{item_id}")
    public ResponseEntity<Map<String, Boolean>> deleteBudgetItem(@PathVariable int item_id){
        Item item = itemRepository.findById(item_id).
                orElseThrow(() -> new ResourceNotFoundException("Item doesn't exist with id :" + item_id));
        
        itemRepository.delete(item);
        
        // return message
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        
        // return map to the api
        return ResponseEntity.ok(response);
                
    }



}
