package be.yorian.budget_backend.service;

import be.yorian.budget_backend.entity.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> filterTransactions(List<Transaction> transactions);
}
