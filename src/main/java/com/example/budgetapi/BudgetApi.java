package com.example.budgetapi;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project_budget")
public class BudgetApi {
    private int budget_id;
    private int project_id;
    private String budget_name;
    //private double item_amount; {not necessary since we'll be getting items from another table }
   

    // empty constructor
    public BudgetApi(){

    }



    public BudgetApi(int budget_id, int project_id, String budget_name){
        this.budget_id = budget_id;
        this.project_id = project_id;
        this.budget_name = budget_name;
        
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getBudget_id(){
        return budget_id;
    }

    public void setBudget_id(int budget_id) {
        this.budget_id = budget_id;
    }
    
    public int getProjectId(){
        return this.project_id;
    }
    
    public void setProjectId(int project_id){
        this.project_id = project_id;
    }

    public String getBudgetName() {
        return budget_name;
    }

    public void setBudgetName(String budget_name) {
        this.budget_name = budget_name;
    }

    /*public double getItem_amount() {
        return item_amount;
    }

    public void setItem_amount(double item_amount) {
        this.item_amount = item_amount;
    }*/

    
}
