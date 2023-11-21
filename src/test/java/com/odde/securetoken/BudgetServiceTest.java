package com.odde.securetoken;

//import org.junit.jupiter.api.Test;

//import static org.junit.Assert.assertFalse;

import com.odde.budget.Budget;
import com.odde.budget.BudgetService;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.YearMonth;


public class BudgetServiceTest {


    @Test
    public void test_20231101_20231130() {
        // given
        Budget budget = new Budget(YearMonth.of(2023, 11), 30);
        BudgetService.BudgetRepo budgetRepo = new BudgetService.BudgetRepo();
        budgetRepo.addBudegt(budget);

        // when
        BudgetService budgetService = new BudgetService(budgetRepo);
        long amount = budgetService.queryBudget(LocalDate.of(2023, 11, 1),LocalDate.of(2023, 11, 30));

        // then
        Assert.assertEquals(30, amount);
    }


    @Test
    public void test_20231101_20231231() {
        // given
        Budget budget11 = new Budget(YearMonth.of(2023, 11), 30);
        Budget budget12 = new Budget(YearMonth.of(2023, 12), 31);
        BudgetService.BudgetRepo budgetRepo = new BudgetService.BudgetRepo();
        budgetRepo.addBudegt(budget11);
        budgetRepo.addBudegt(budget12);

        // when
        BudgetService budgetService = new BudgetService(budgetRepo);
        long amount = budgetService.queryBudget(LocalDate.of(2023, 11, 1),LocalDate.of(2023, 12, 31));

        // then
        Assert.assertEquals(61, amount);
    }


    @Test
    public void test_20231101_20241231() {
        // given
        Budget budget11 = new Budget(YearMonth.of(2023, 11), 30);
        Budget budget12 = new Budget(YearMonth.of(2023, 12), 31);
        Budget budget2412 = new Budget(YearMonth.of(2024, 12), 31);
        BudgetService.BudgetRepo budgetRepo = new BudgetService.BudgetRepo();
        budgetRepo.addBudegt(budget11);
        budgetRepo.addBudegt(budget12);
        budgetRepo.addBudegt(budget2412);

        // when
        BudgetService budgetService = new BudgetService(budgetRepo);
        long amount = budgetService.queryBudget(LocalDate.of(2023, 11, 1),LocalDate.of(2024, 12, 31));

        // then
        Assert.assertEquals(92, amount);
    }

    @Test
    public void test_20231105_20241231_budget_1() {
        // given
        Budget budget11 = new Budget(YearMonth.of(2023, 11), 30);
        Budget budget12 = new Budget(YearMonth.of(2023, 12), 31);
        Budget budget2412 = new Budget(YearMonth.of(2024, 12), 31);
        BudgetService.BudgetRepo budgetRepo = new BudgetService.BudgetRepo();
        budgetRepo.addBudegt(budget11);
        budgetRepo.addBudegt(budget12);
        budgetRepo.addBudegt(budget2412);

        // when
        BudgetService budgetService = new BudgetService(budgetRepo);
        long amount = budgetService.queryBudget(LocalDate.of(2023, 11, 5),LocalDate.of(2024, 12, 31));

        // then
        Assert.assertEquals(88, amount);
    }


    @Test
    public void test_20231105_20241231_budget_10() {
        // given
        Budget budget11 = new Budget(YearMonth.of(2023, 11), 30);
        Budget budget12 = new Budget(YearMonth.of(2023, 12), 310);
        Budget budget2412 = new Budget(YearMonth.of(2024, 12), 31);
        BudgetService.BudgetRepo budgetRepo = new BudgetService.BudgetRepo();
        budgetRepo.addBudegt(budget11);
        budgetRepo.addBudegt(budget12);
        budgetRepo.addBudegt(budget2412);

        // when
        BudgetService budgetService = new BudgetService(budgetRepo);
        long amount = budgetService.queryBudget(LocalDate.of(2023, 11, 5),LocalDate.of(2024, 12, 31));

        // then
        Assert.assertEquals(367, amount);
    }

    @Test
    public void test_20231105_20241210_budget_10() {
        // given
        Budget budget11 = new Budget(YearMonth.of(2023, 11), 30);
        Budget budget12 = new Budget(YearMonth.of(2023, 12), 310);
        Budget budget2412 = new Budget(YearMonth.of(2024, 12), 31);
        BudgetService.BudgetRepo budgetRepo = new BudgetService.BudgetRepo();
        budgetRepo.addBudegt(budget11);
        budgetRepo.addBudegt(budget12);
        budgetRepo.addBudegt(budget2412);

        // when
        BudgetService budgetService = new BudgetService(budgetRepo);
        long amount = budgetService.queryBudget(LocalDate.of(2023, 11, 5),LocalDate.of(2024, 12, 10));

        // then
        Assert.assertEquals(346, amount);
    }

    @Test
    public void test_20221105_20221210_budget_10() {
        // given
        Budget budget11 = new Budget(YearMonth.of(2023, 11), 30);
        Budget budget12 = new Budget(YearMonth.of(2023, 12), 310);
        Budget budget2412 = new Budget(YearMonth.of(2024, 12), 31);
        BudgetService.BudgetRepo budgetRepo = new BudgetService.BudgetRepo();
        budgetRepo.addBudegt(budget11);
        budgetRepo.addBudegt(budget12);
        budgetRepo.addBudegt(budget2412);

        // when
        BudgetService budgetService = new BudgetService(budgetRepo);
        long amount = budgetService.queryBudget(LocalDate.of(2022, 11, 5),LocalDate.of(2022, 12, 10));

        // then
        Assert.assertEquals(0, amount);
    }

    @Test
    public void test_20251105_20251210_budget_10() {
        // given
        Budget budget11 = new Budget(YearMonth.of(2023, 11), 30);
        Budget budget12 = new Budget(YearMonth.of(2023, 12), 310);
        Budget budget2412 = new Budget(YearMonth.of(2024, 12), 31);
        BudgetService.BudgetRepo budgetRepo = new BudgetService.BudgetRepo();
        budgetRepo.addBudegt(budget11);
        budgetRepo.addBudegt(budget12);
        budgetRepo.addBudegt(budget2412);

        // when
        BudgetService budgetService = new BudgetService(budgetRepo);
        long amount = budgetService.queryBudget(LocalDate.of(2025, 11, 5),LocalDate.of(2025, 12, 10));

        // then
        Assert.assertEquals(0, amount);
    }

    @Test
    public void test_20241230_20251210_budget_10() {
        // given
        Budget budget11 = new Budget(YearMonth.of(2023, 11), 30);
        Budget budget12 = new Budget(YearMonth.of(2023, 12), 310);
        Budget budget2412 = new Budget(YearMonth.of(2024, 12), 31);
        BudgetService.BudgetRepo budgetRepo = new BudgetService.BudgetRepo();
        budgetRepo.addBudegt(budget11);
        budgetRepo.addBudegt(budget12);
        budgetRepo.addBudegt(budget2412);

        // when
        BudgetService budgetService = new BudgetService(budgetRepo);
        long amount = budgetService.queryBudget(LocalDate.of(2024, 12, 30),LocalDate.of(2025, 12, 10));

        // then
        Assert.assertEquals(2, amount);
    }
}
