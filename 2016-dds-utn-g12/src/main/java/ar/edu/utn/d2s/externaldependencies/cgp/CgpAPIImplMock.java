package ar.edu.utn.d2s.externaldependencies.cgp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CgpAPIImplMock implements CgpAPIMock {

    private static CgpAPIImplMock instance = null;

    private List<CenterDTOMock> centersDTO = new ArrayList<>();

    public CgpAPIImplMock() {
        initializeCenters();
    }

    public static CgpAPIImplMock getInstance() {
        if (instance == null) {
            instance = new CgpAPIImplMock();
        }
        return instance;
    }

    private void initializeCenters() {
        // TODO Create some centerDTO objects and add them to the centersDTO list
    }

    @Override
    public List<CenterDTOMock> searchCgps(String param) {
        return centersDTO.stream().filter(center -> center.getIncludedZones().contains(param) || center.getAddress().startsWith(param)).collect(Collectors.toList());
    }
}
