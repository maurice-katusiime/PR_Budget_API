package com.example.budgetapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.*;
import java.util.List;




// Handle HTTP requests
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/budgetapi/v1")

public class BudgetController {
    @Autowired //get the repository to handle the data
    //BudgetService budgetService;
    BudgetRepository budgetRepository;
    
    //retrieve budget list
    @GetMapping(path = "/get_budgets")
    public List<BudgetApi> getAllBudgets(){
        //return budgetService.showBudgets();
        return budgetRepository.findAll();
    }
    
    // create a budget 
    @PostMapping(path= "/create_budget")
    public BudgetApi createBudget(@RequestBody BudgetApi budget){
        return budgetRepository.save(budget);
    }
    
    // get budget by id rest api
    @GetMapping("/get_single_budget/{budget_id}")
    public ResponseEntity<BudgetApi> getBudgetById(@PathVariable Integer budget_id){
            // retrieve employee object from db
            BudgetApi budget = budgetRepository.findById(budget_id)
                    
            .orElseThrow(() -> new ResourceNotFoundException("Budget does not exist with that id :" + budget_id));
        
            return  ResponseEntity.ok(budget);
        
    } 
    
    
    // update budget item
    @PutMapping("/update_budget/{budgetId}")
    public ResponseEntity<BudgetApi> update (@RequestBody BudgetApi budgetDetails, @PathVariable Integer budgetId){
        // retrieve employee by id
        BudgetApi budget = budgetRepository.findById(budgetId).
                orElseThrow(() -> new ResourceNotFoundException("Budget item not found with id :" + budgetId));
        
        budget.setBudgetName(budgetDetails.getBudgetName());
        //budget.setItem_amount(budgetDetails.getItem_amount());
        
        
        // save updated data
        BudgetApi updatedBudget = budgetRepository.save(budget);
        
        return ResponseEntity.ok(updatedBudget);
    }
    
    // delete budget item 
    @DeleteMapping("/delete_budget/{budgetId}")
    public ResponseEntity<Map<String, Boolean>> deleteBudgetItem(@PathVariable Integer budgetId){
        BudgetApi budget = budgetRepository.findById(budgetId).
                orElseThrow(() -> new ResourceNotFoundException("Employee doesn't exist with id :" + budgetId));
        
        budgetRepository.delete(budget);
        
        // return message
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        
        // return map to the api
        return ResponseEntity.ok(response);
                
    }






}
