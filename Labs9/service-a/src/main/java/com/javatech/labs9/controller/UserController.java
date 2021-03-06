package com.javatech.labs9.controller;

import com.javatech.labs9.annotations.CacheControlConfig;
import com.javatech.labs9.annotations.JWTTokenRequired;
import com.javatech.labs9.dtos.AccountDTO;
import com.javatech.labs9.dtos.AccountLoginDTO;
import com.javatech.labs9.dtos.AccountRegisterDTO;
import com.javatech.labs9.exceptions.AccountAlreadyExistsException;
import com.javatech.labs9.exceptions.AccountInvalidCredentialsException;
import com.javatech.labs9.exceptions.AccountNotFoundException;
import com.javatech.labs9.pemissions.Role;
import com.javatech.labs9.service.AccountService;
import com.javatech.labs9.tokens.TokenHandler;
import com.javatech.labs9.utils.ResponseEntityPayload;
import com.javatech.labs9.utils.ResponsePayload;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;

@Path("/users")
@RequestScoped
public class UserController {
    @Inject
    AccountService accountService;

    @Inject
    @CacheControlConfig(maxAge = 20)
    CacheControl cc;

    @GET
    @Produces("application/json")
    @JWTTokenRequired(Permissions = {
            Role.AUTHOR,Role.ADMIN,Role.REVIEWER})
    public Response getAccounts() {
        List<AccountDTO> accounts = accountService.gets();

        ResponseEntityPayload<AccountDTO> entity = new ResponseEntityPayload<>(
                "SUCCESS",
                "Accounts fetched successfully",
                accounts);

        return Response
                .status(Response.Status.OK)
                .entity(entity)
                .build();

    }

    @GET
    @Path("/{accountId}")
    @Produces("application/json")
    @JWTTokenRequired(Permissions = {
            Role.AUTHOR,Role.ADMIN,Role.REVIEWER})
    public Response getAccount(@PathParam("accountId") Long accountId) throws AccountNotFoundException {

        AccountDTO account = accountService.get(accountId);
        ResponseEntityPayload<AccountDTO> entity = new ResponseEntityPayload<>(
                "SUCCESS",
                "Account fetched successfully",
                Collections.singletonList(account));

        return Response
                .status(Response.Status.OK)
                .entity(entity)
                .build();

    }


    @POST
    @Path("/authenticate")
    @Consumes("application/json")
    @Produces("application/json")
    public Response authenticate(AccountLoginDTO user) throws AccountInvalidCredentialsException, AccountNotFoundException {

        Long id = accountService.validate(user);

        String token = TokenHandler.issue(id);

        ResponseEntityPayload<String> payload = new ResponseEntityPayload<String>(
                "SUCCESS",
                "User logged in successfully",
                Collections.singletonList(token)
        );

        return Response
                .status(Response.Status.OK)
                .entity(payload)
                .build();

    }

    @POST
    @Path("/register")
    @Consumes("application/json")
    @Produces("application/json")
    public Response register(AccountRegisterDTO user) throws AccountAlreadyExistsException {

        accountService.create(user);

        ResponsePayload payload = new ResponsePayload (
                "SUCCESS",
                "Account successfully created!");

        return Response
                .status(Response.Status.OK)
                .entity(payload)
                .build();
    }


    @DELETE
    @Path("/{id}")
    @JWTTokenRequired(Permissions = {
            Role.ADMIN})
    @Produces("application/json")
    public Response delete(@PathParam("id") long id) throws AccountNotFoundException {


        accountService.remove(id);
        ResponsePayload payload = new ResponsePayload(
                "SUCCESS",
                "Account successfully deleted"
        );

        return Response
                .status(Response.Status.OK)
                .entity(payload)
                .build();
    }

    @GET
    @Path("welcome")
    public Response getHello() {
        ResponsePayload payload = new ResponsePayload(
                "SUCCESS",
                "Hello from API"
        );
        return Response
                .status(Response.Status.OK)
                .entity(payload)
                .build();
    }


}
