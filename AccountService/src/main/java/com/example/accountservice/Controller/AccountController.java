package com.example.accountservice.Controller;

import com.example.accountservice.Model.Account;
import com.example.accountservice.Security.SystemSecurity;
import com.example.accountservice.Service.Interface.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/add")
    public ResponseEntity<String> addAccount(@RequestBody Account account){
        return accountService.addAccount(account);
    }

    @GetMapping("/getAll")
    public List<Account> getAll(){
        return accountService.getAll();
    }

    @PutMapping("/{id}/discount")
    public ResponseEntity<String> discount(@RequestHeader("Authorization") String token, @PathVariable("id") String id, @RequestParam("amount") double amount) throws Exception {
        String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
        return accountService.discount(id, amount);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAccount(@RequestParam("id") String account){
        return accountService.deleteAccount(account);
    }

    @PutMapping("/status")
    public ResponseEntity<String> activateOrDeactivateAccount(@RequestHeader("Authorization") String token ,@RequestParam("id") String account, @RequestParam("active") boolean action){
        String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
        return accountService.activateOrDeactivateAccount(account,action);
    }


}
