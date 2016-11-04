package ar.edu.utn.d2s.externaldependencies.mappers;

import ar.edu.utn.d2s.externaldependencies.cgp.CenterDTOMock;
import ar.edu.utn.d2s.model.addres.Address;
import ar.edu.utn.d2s.model.points.Cgp;
import ar.edu.utn.d2s.model.points.Commune;
import ar.edu.utn.d2s.model.points.Service;

import java.util.HashSet;
import java.util.Set;

public class CenterDTOToCgpMapper {

    private ServiceDTOToServiceMapper serviceDTOToServiceMapper = new ServiceDTOToServiceMapper();

    public Cgp map(CenterDTOMock centerDTO) {
        // TODO Finish implementing

        Address address = new Address(centerDTO.getAddress(), null, null, 0, Byte.parseByte("0"),
                Byte.parseByte("0"), Byte.parseByte("0"), 0, null, null, null, null, null);
        Commune commune = new Commune(String.valueOf(centerDTO.getCommuneNumber()), null);
        Set<Service> services = new HashSet<>();
        centerDTO.getServices().forEach(serviceDTOMock -> services.add(serviceDTOToServiceMapper.map(serviceDTOMock)));

        //return new Cgp("", "", address, )
        return new Cgp("", "", address, commune, services);
    }
}
