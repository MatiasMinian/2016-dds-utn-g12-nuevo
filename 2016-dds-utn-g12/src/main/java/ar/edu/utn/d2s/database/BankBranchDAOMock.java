package ar.edu.utn.d2s.database;

import ar.edu.utn.d2s.model.points.BankBranch;

import java.util.ArrayList;
import java.util.List;

public class BankBranchDAOMock {

    /**
     * TODO
     * Change this to a BankBranch DAO when implementing real daos with access
     * to the database. Remove al static methods and variables and create
     * instance ones.
     * This class acts like a repository for BankBranch entity that will be persisted in the future.
     */

    public static List<BankBranch> bankBranchPoints = new ArrayList<>();

    //********** METHODS **********//

    public static void saveOrUpdateBankBranchPoint(BankBranch bankBranchPoint) {
        BankBranch targetBankBranchPoint = bankBranchPoints.stream().filter(bankBranch -> bankBranch.getId().equals(bankBranchPoint.getId())).findFirst().orElse(null);
        if (targetBankBranchPoint == null) {
            bankBranchPoints.add(bankBranchPoint);
        } else {
            targetBankBranchPoint = bankBranchPoint;
        }
    }

    public static void deleteBankBranchPoint(BankBranch bankBranchPoint) {
        bankBranchPoints.remove(bankBranchPoint);
    }

    public static List<BankBranch> getBankBranchPoints() {
        return bankBranchPoints;
    }

    public static void setBankBranchPoints(List<BankBranch> bankBranchPoints) {
        BankBranchDAOMock.bankBranchPoints = bankBranchPoints;
    }
}
