package ar.edu.utn.d2s.externaldependencies.mappers;

import ar.edu.utn.d2s.externaldependencies.cgp.ServiceRangeDTOMock;
import ar.edu.utn.d2s.model.openhours.DayEnum;
import ar.edu.utn.d2s.model.openhours.TimeSchedule;
import ar.edu.utn.d2s.model.openhours.WorkHours;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceRangeDTOsToTimeScheduleMapper {

    public TimeSchedule map(List<ServiceRangeDTOMock> serviceRangeDTOs) {

        Map<DayEnum, WorkHours> openHours = new HashMap<>();

        serviceRangeDTOs.forEach(serviceRangeDTO -> openHours.put(mapDay(serviceRangeDTO), mapHours(serviceRangeDTO)));

        return new TimeSchedule(openHours);
    }

    private DayEnum mapDay(ServiceRangeDTOMock serviceRangeDTO) {
        switch (serviceRangeDTO.getDayNumber()) {
            case 1:
                return DayEnum.MONDAY;
            case 2:
                return DayEnum.TUESDAY;
            case 3:
                return DayEnum.WEDNESDAY;
            case 4:
                return DayEnum.THURSDAY;
            case 5:
                return DayEnum.FRIDAY;
            case 6:
                return DayEnum.SATURDAY;
            case 7:
                return DayEnum.SUNDAY;
            default:
                throw new RuntimeException("Field serviceRangeDTO does not have correct dayNumber assigned");
        }
    }

    private WorkHours mapHours(ServiceRangeDTOMock serviceRangeDTO) {
        return new WorkHours(
                LocalTime.of(serviceRangeDTO.getFromHours(), serviceRangeDTO.getFromMinutes()),
                LocalTime.of(serviceRangeDTO.getToHours(), serviceRangeDTO.getToMinutes())
        );
    }
}
