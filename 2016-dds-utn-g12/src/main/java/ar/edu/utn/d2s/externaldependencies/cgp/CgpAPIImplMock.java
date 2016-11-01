package ar.edu.utn.d2s.externaldependencies.cgp;

import java.util.ArrayList;
import java.util.List;

public class CgpAPIImplMock implements CgpAPIMock {

    private static List<CenterDTOMock> centersDTO = new ArrayList<>();

    {
        initializeCenters();
    }

    public List<CenterDTOMock> search(String param) {
        return centersDTO;
    }

    private void initializeCenters() {
        // TODO Create some centerDTO objects
    }
}
