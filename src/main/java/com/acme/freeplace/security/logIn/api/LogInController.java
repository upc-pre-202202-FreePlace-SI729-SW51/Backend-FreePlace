package com.acme.freeplace.security.logIn.api;


import com.acme.freeplace.security.logIn.resource.AccountResource;
import com.acme.freeplace.security.register.domain.model.Business;
import com.acme.freeplace.security.register.domain.service.BusinessService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/logIn")
public class LogInController {
    private final BusinessService businessService;


    public LogInController(BusinessService businessService) {
        this.businessService = businessService;
    }

    //at 90% have little problems with the DB
    @PostMapping("/businesses")
        public Business getAccountBusiness(@RequestBody AccountResource resource){
            if (businessService.getAccount(resource.getEmail(), resource.getPassword()) != null){
                System.out.println(businessService.getAccount(resource.getEmail(), resource.getPassword()));
                return businessService.getAccount(resource.getEmail(),resource.getPassword());
            }
            return null;
        }

}
