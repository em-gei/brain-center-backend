package it.braincenter.service;

import it.braincenter.dto.AccountDto;
import jakarta.validation.constraints.NotNull;


public interface AccountService {

    AccountDto getAccountById(@NotNull Long id);
}
