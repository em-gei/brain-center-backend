package it.braincenter.resource;

import it.braincenter.dto.AccountDto;
import it.braincenter.service.AccountService;
import jakarta.inject.Inject;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

    @Inject // Iniettiamo il service
    AccountService accountService;

    @Path("/{id}")
    @GET
    public AccountDto getAccount(@PathParam("id") @NotNull Long id) {
        System.out.println("CIAOOOOOOOOOOO");
        return accountService.getAccountById(id);
    }
}
