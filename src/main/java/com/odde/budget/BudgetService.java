package com.odde.budget;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BudgetService {
    private BudgetRepo budgetRepo;
    public BudgetService(BudgetRepo budgetRepo) {
        this.budgetRepo = budgetRepo;
    }

    public long queryBudget(LocalDate start, LocalDate end) {
        int startYear = start.getYear();
        int endYear = end.getYear();
        int startMouth = start.getMonthValue();
        int endMouth = end.getMonthValue();
        int startDays = start.getDayOfMonth();
        int endDays = end.getDayOfMonth();
        List<Budget> budgets = budgetRepo.findAll();

        long result = 0;
        for (int i = 0; i < budgets.size(); i++) {
            if (startYear == budgets.get(i).getYear() && startMouth == budgets.get(i).getMonth()) {
                int startMouthDay = start.lengthOfMonth();
                result += (long) (startMouthDay - startDays + 1) *budgets.get(i).getAmount()/startMouthDay;
            } else if (endYear > budgets.get(i).getYear() && startYear <= budgets.get(i).getYear()) {
                result += budgets.get(i).getAmount();
            } else if (endYear == budgets.get(i).getYear() && endMouth > budgets.get(i).getMonth()) {
                result += budgets.get(i).getAmount();
            } else if (endYear == budgets.get(i).getYear() && endMouth == budgets.get(i).getMonth()) {
                int endMouthDay = end.lengthOfMonth();
                result += (long) endDays * budgets.get(i).getAmount()/endMouthDay;
            }
        }

        return result;
    }

    public static class  BudgetRepo implements IBudgetRepo {
        private  List<Budget> budgets = new ArrayList<>();
        @Override
        public List<Budget> findAll() {
            return budgets;
        }

        public void addBudegt(Budget budget) {
            budgets.add(budget);
        }
    }
}
