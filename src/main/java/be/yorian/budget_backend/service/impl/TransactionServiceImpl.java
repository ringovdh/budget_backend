package be.yorian.budget_backend.service.impl;

import be.yorian.budget_backend.entity.Transaction;
import be.yorian.budget_backend.helper.TransactionHelper;
import be.yorian.budget_backend.repository.CommentRepository;
import be.yorian.budget_backend.repository.TransactionRepository;
import be.yorian.budget_backend.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    CommentRepository commentRepository;
    TransactionHelper transactionHelper;

    @Override
    public List<Transaction> filterTransactions(List<Transaction> transactions) {
        List<Transaction> filteredTransactions = new ArrayList<>();
        transactionHelper = new TransactionHelper(commentRepository);

        for (Transaction tx : transactions) {
            if (!checkTransaction(tx.getDate(), tx.getNumber())) {
                tx = transactionHelper.prepareTransaction(tx);
                filteredTransactions.add(tx);
            }
        }
        return filteredTransactions;
    }


    private boolean checkTransaction(Date date, String number) {

        Transaction tx = transactionRepository.findByDateAndNumber(date, number);
        if (tx != null) {
            return true;
        }

        return false;
    }
}
