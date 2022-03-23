/*  This repository holds the budget records */
package com.example.budgetapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<BudgetApi, Integer> {
}
