package ar.edu.utn.d2s.externaldependencies.cgp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CenterDTOMock {

    private int communeNumber;
    private Set<String> includedZones;
    private String directorName;
    private String address;
    private String phone;
    private List<ServiceDTOMock> services;

    //********** GETTERS & SETTERS **********//


    public int getCommuneNumber() {
        return communeNumber;
    }

    public void setCommuneNumber(int communeNumber) {
        this.communeNumber = communeNumber;
    }

    public Set<String> getIncludedZones() {
        if (includedZones == null) {
            includedZones = new HashSet<>();
        }
        return includedZones;
    }

    public void setIncludedZones(Set<String> includedZones) {
        this.includedZones = includedZones;
    }

    public String getDirectorName() {
        if (directorName == null) {
            directorName = "";
        }
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getAddress() {
        if (address == null) {
            address = "";
        }
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        if (phone == null) {
            phone = "";
        }
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<ServiceDTOMock> getServices() {
        if (services == null) {
            services = new ArrayList<>();
        }
        return services;
    }

    public void setServices(List<ServiceDTOMock> services) {
        this.services = services;
    }
}
