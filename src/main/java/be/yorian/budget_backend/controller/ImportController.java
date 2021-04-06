package be.yorian.budget_backend.controller;

import be.yorian.budget_backend.entity.Transaction;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImportController {

    List<Transaction> importTransactions(MultipartFile file);
}
