package ar.edu.utn.d2s.externaldependencies.mappers;

import ar.edu.utn.d2s.externaldependencies.cgp.CenterDTOMock;
import ar.edu.utn.d2s.model.addres.Address;
import ar.edu.utn.d2s.model.points.Cgp;
import ar.edu.utn.d2s.model.points.Commune;

public class CenterDTOToCgpMapper {

    private ServiceDTOToServiceMapper serviceDTOToServiceMapper;

    public CenterDTOToCgpMapper(ServiceDTOToServiceMapper serviceDTOToServiceMapper) {
        this.serviceDTOToServiceMapper = serviceDTOToServiceMapper;
    }

    public Cgp map(CenterDTOMock centerDTO) {
        // TODO Finish implementing
        // TODO Check if there is another way to map so that CGP does not have so many empty fields

        Address address = new Address(centerDTO.getAddress(), null, null, 0, Byte.parseByte("0"),
                Byte.parseByte("0"), Byte.parseByte("0"), 0, null, null, null, null, null);
        // Commune commune = new Commune()

        //return new Cgp("", "", address, )
        return null;
    }
}
