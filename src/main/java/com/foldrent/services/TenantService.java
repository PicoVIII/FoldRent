package com.foldrent.services;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import com.foldrent.models.Tenants;
import com.foldrent.database.JsonDatabase;

public class TenantService {
    private List<Tenants> tenants; //store tenants in memory
    private JsonDatabase database; //handles file operations
    private int nextTenantId;

    public TenantService(){
        this.database = new JsonDatabase();
        this.tenants = database.loadTenants();

        if(tenants.isEmpty()){
            this.nextTenantId = 1;
        } else{
            int maxId = 0;
            for (int i = 0; i < tenants.size(); i++){
                Tenants tenant = tenants.get(i);
                if(tenant.getTenantID() > maxId){
                    maxId = tenant.getTenantID();
                }
            }
            this.nextTenantId = maxId + 1;
        }
    }

    public boolean addTenant(String firstName, String lastName, double rentAmount){
        Tenants newTenant = new Tenants(nextTenantId, firstName, lastName, rentAmount);
        tenants.add(newTenant);
        nextTenantId++;
        return saveData();
    }

    public boolean updateTenant(int id, String firstName, 
                                String lastName, double rentAmount){
        Tenants tenant = findTenantById(id);

        if (tenant != null){
            tenant.setTenantFirstName(firstName);
            tenant.setTenantLastName(lastName);
            tenant.setRentAmount(rentAmount);

            return saveData();
        }
        return false; //tenant not found
    }

    public boolean deleteTenant(int id){
        Tenants tenant = findTenantById(id);

        if(tenant != null){
            //soft delete (wont fully delete the tenant)
            tenant.setActive(false);
            tenant.setMoveOutDate(LocalDate.now());

            //save changes
            return saveData();
        }
        return false; //tenant not found
    }

    public List<Tenants> getActiveTenants(){
        List<Tenants> activeTenants = new ArrayList<>();

        for(int i = 0; i < tenants.size(); i++){
            Tenants tenant = tenants.get(i);
            if(tenant.isActive()){
                activeTenants.add(tenant);
            }
        }
        return activeTenants;
    }

    public Tenants findTenantById(int id){
        for(int i = 0; i < tenants.size(); i++){
            Tenants tenant = tenants.get(i);
            if(tenant.getTenantID() == id && tenant.isActive()){
                return tenant;
            }
        }
        return null; //not found
    }

    public boolean saveData(){
        try {
            database.saveTenants(tenants);
            return true;
        } catch(Exception e){
            System.out.println("Error saving data: "+ e.getMessage());
            return false;
        }
    }
}
