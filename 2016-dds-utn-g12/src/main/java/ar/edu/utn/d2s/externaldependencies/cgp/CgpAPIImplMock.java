package ar.edu.utn.d2s.externaldependencies.cgp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CgpAPIImplMock implements CgpAPIMock {

    private static List<CenterDTOMock> centersDTO = new ArrayList<>();

    {
        initializeCenters();
    }

    private static void initializeCenters() {
        // TODO Create some centerDTO objects and add them to the centersDTO list
    }

    @Override
    public List<CenterDTOMock> searchCgps(String param) {
        return centersDTO.stream().filter(center -> center.getIncludedZones().contains(param) || center.getAddress().startsWith(param)).collect(Collectors.toList());
    }
}
