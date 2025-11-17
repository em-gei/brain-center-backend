package it.braincenter.service.impl;

import it.braincenter.dto.AccountDto;
import it.braincenter.entity.Account;
import it.braincenter.repository.AccountRepository;
import it.braincenter.service.AccountService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;


@ApplicationScoped
public class AccountServiceImpl implements AccountService {

    @Inject
    AccountRepository accountRepository;

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository
            .findByIdOptional(id)
            .orElseThrow(() -> new NotFoundException("Account not found"));
        return AccountDto.builder().id(account.getId()).username(account.getUsername()).build();
    }
}
