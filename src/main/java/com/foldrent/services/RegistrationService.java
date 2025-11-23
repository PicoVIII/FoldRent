package com.foldrent.services;

import com.foldrent.models.Landlords;
import com.foldrent.models.Tenants;

public class RegistrationService {
    private AuthService authService;
    private TenantService tenantService;
    private LandlordService landlordService;

    public RegistrationService(AuthService authService, TenantService tenantService, LandlordService landlordService) {
        this.authService = authService;
        this.tenantService = tenantService;
        this.landlordService = landlordService;
    }

    public boolean registerLandlord(String username, String password, String firstName, 
        String lastName, char midInitial, String email, String phone){

            int landlordId = landlordService.addLandlord(firstName, lastName, midInitial, email, phone);
            if(landlordId <= 0){
                return false; //failed to add landlord
            }
            return authService.registerUser(username, password, "LANDLORD", 0, landlordId);
         }

    public boolean registerTenant(String username, String password, String firstName,
         String lastName, char middleInitial, String email, String phone){
            int tenantId = tenantService.addTenant(firstName, lastName, middleInitial, email, phone);
            if(tenantId <= 0){
                return false; //failed to add tenant
            }
            return authService.registerUser(username, password, "TENANT", tenantId, 0);
         }
}

