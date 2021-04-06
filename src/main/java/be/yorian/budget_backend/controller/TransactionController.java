package be.yorian.budget_backend.controller;

import java.util.List;

import be.yorian.budget_backend.entity.Transaction;

public interface TransactionController {

	public List<Transaction> getTransactions();
	public void saveTransaction(Transaction transaction);
	
}
