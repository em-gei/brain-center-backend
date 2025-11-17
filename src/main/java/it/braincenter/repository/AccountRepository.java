package it.braincenter.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import it.braincenter.entity.Account;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;


@ApplicationScoped // Rende questa classe un bean iniettabile (come @Repository)
public class AccountRepository implements PanacheRepository<Account> {

    // Metodo custom per trovare un utente dal suo username
    public Optional<Account> findByUsername(String username) {
        return find("username", username).firstResultOptional();
    }
}
