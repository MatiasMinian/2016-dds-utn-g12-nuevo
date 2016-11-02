package ar.edu.utn.d2s.externaldependencies.mappers;

import ar.edu.utn.d2s.externaldependencies.cgp.ServiceDTOMock;
import ar.edu.utn.d2s.model.openhours.TimeSchedule;
import ar.edu.utn.d2s.model.points.Service;

public class ServiceDTOToServiceMapper {

    private ServiceRangeDTOsToTimeScheduleMapper serviceRangeDTOsToTimeScheduleMapper;

    public ServiceDTOToServiceMapper(ServiceRangeDTOsToTimeScheduleMapper serviceRangeDTOsToTimeScheduleMapper) {
        this.serviceRangeDTOsToTimeScheduleMapper = serviceRangeDTOsToTimeScheduleMapper;
    }

    public Service map(ServiceDTOMock serviceDTO) {

        TimeSchedule timeSchedule = serviceRangeDTOsToTimeScheduleMapper.map(serviceDTO.getRanges());
        return new Service(serviceDTO.getName(), timeSchedule);
    }
}
