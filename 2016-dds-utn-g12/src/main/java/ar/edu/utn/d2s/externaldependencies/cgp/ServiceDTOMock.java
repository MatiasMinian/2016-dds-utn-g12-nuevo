package ar.edu.utn.d2s.externaldependencies.cgp;

import java.util.ArrayList;
import java.util.List;

public class ServiceDTOMock {

    private String name;
    private List<ServiceRangeDTOMock> ranges;

    //********** GETTERS & SETTERS **********//


    public String getName() {
        if (name == null) {
            name = "";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ServiceRangeDTOMock> getRanges() {
        if (ranges == null) {
            ranges = new ArrayList<>();
        }
        return ranges;
    }

    public void setRanges(List<ServiceRangeDTOMock> ranges) {
        this.ranges = ranges;
    }
}
