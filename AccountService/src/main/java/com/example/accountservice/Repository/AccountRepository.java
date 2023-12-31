package com.example.accountservice.Repository;

import com.example.accountservice.Model.Account;
import com.example.accountservice.Model.MercadoPago;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository("accountRepository")
public interface AccountRepository extends MongoRepository<Account, String> {


}
