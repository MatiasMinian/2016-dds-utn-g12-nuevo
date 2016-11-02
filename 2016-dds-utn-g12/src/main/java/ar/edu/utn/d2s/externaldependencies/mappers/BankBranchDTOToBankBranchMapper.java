package ar.edu.utn.d2s.externaldependencies.mappers;

import ar.edu.utn.d2s.externaldependencies.bankbranch.BankBranchDTO;
import ar.edu.utn.d2s.model.addres.Address;
import ar.edu.utn.d2s.model.config.PointOfInterestConfig;
import ar.edu.utn.d2s.model.openhours.TimeSchedule;
import ar.edu.utn.d2s.model.openhours.WorkHours;
import ar.edu.utn.d2s.model.points.BankBranch;
import org.uqbar.geodds.Point;

import java.time.LocalTime;

public class BankBranchDTOToBankBranchMapper {

    public BankBranch map(BankBranchDTO bankBranchDTO) {

        Address address = new Address("", "", "", 0, Byte.parseByte("0"), Byte.parseByte("0"),
                Byte.parseByte("0"), 0, bankBranchDTO.getBranch(), "", "", "",
                new Point(bankBranchDTO.getX(), bankBranchDTO.getY()));

        TimeSchedule timeSchedule = TimeSchedule.forBusinessWeek(new WorkHours(
                LocalTime.of(PointOfInterestConfig.BANKS_START_HOURS, PointOfInterestConfig.BANKS_START_MINUTES),
                LocalTime.of(PointOfInterestConfig.BANKS_END_HOURS, PointOfInterestConfig.BANKS_END_MINUTES)));

        return new BankBranch(bankBranchDTO.getBank(), "", address, bankBranchDTO.getServices(), timeSchedule);
    }
}
