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

    public static void saveOrUpdate(BankBranch bankBranchPoint) {
        BankBranch targetBankBranchPoint = findById(bankBranchPoint.getId());
        if (targetBankBranchPoint == null) {
            bankBranchPoints.add(bankBranchPoint);
        } else {
            targetBankBranchPoint = bankBranchPoint;
        }
    }

    public static void delete(BankBranch bankBranchPoint) {
        bankBranchPoints.remove(bankBranchPoint);
    }

    public static BankBranch findById(Long id) {
        return bankBranchPoints.stream().filter(bankBranch -> bankBranch.getId().equals(id)).findFirst().orElse(null);
    }

    public static List<BankBranch> getBankBranchPoints() {
        return bankBranchPoints;
    }

    public static void setBankBranchPoints(List<BankBranch> bankBranchPoints) {
        BankBranchDAOMock.bankBranchPoints = bankBranchPoints;
    }
}
