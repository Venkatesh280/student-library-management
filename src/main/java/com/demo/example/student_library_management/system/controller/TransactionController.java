package com.demo.example.student_library_management.system.controller;


import com.demo.example.student_library_management.system.requestdto.TransactionRequestDto;
import com.demo.example.student_library_management.system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction/api")
public class TransactionController {


    @Autowired
    private TransactionService transactionService;

    @PostMapping("/save")
    public String saveTransaction(@RequestBody TransactionRequestDto transactionRequestDto) {

        String response=transactionService.addTransaction(transactionRequestDto);
        return response;
    }
}
