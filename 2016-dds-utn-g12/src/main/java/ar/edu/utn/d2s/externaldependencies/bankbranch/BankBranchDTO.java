package ar.edu.utn.d2s.externaldependencies.bankbranch;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BankBranchDTO {

    private String bank;
    private double x;
    private double y;
    private String branch;
    private String manager;
    private Set<String> services;

    public String getBank() {
        if (bank == null) {
            bank = "";
        }
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getBranch() {
        if (branch == null) {
            branch = "";
        }
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getManager() {
        if (manager == null) {
            manager = "";
        }
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Set<String> getServices() {
        if (services == null) {
            services = new HashSet<>();
        }
        return services;
    }

    public void setServices(Set<String> services) {
        this.services = services;
    }
}
