package ar.edu.utn.d2s.externaldependencies.bankbranch;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BankBranchAPIImplMock implements BankBranchAPIMock {

    // Each String corresponds to a bank branch represented as a JSON
    private static List<String> bankBranchesJSON = new ArrayList<>();

    {
        initializeBankBranches();
    }

    private static void initializeBankBranches() {
        // TODO Create some Bank Branches, each one as a JSON, and add them to the bankBranchesJSON list
    }

    @Override
    public String searchBankBranches(String bank, String service) {
        List<String> filteredBankBranchesJSON = bankBranchesJSON.stream().filter(bankBranchJSON -> bankMatchesValues(bankBranchJSON, bank, service)).collect(Collectors.toList());
        StringBuilder finalJSONBankBranches = new StringBuilder();
        finalJSONBankBranches.append("[");
        if (!filteredBankBranchesJSON.isEmpty()) {
            filteredBankBranchesJSON.forEach(bankBranchJSON -> finalJSONBankBranches.append(bankBranchJSON));
        }
        finalJSONBankBranches.append("]");
        return finalJSONBankBranches.toString();
    }

    private boolean bankMatchesValues(String bankBranchJSON, String bank, String service) {
        // TODO Test if this implementation is OK
        JsonNode rootNode = null;
        try {
            rootNode = (new ObjectMapper()).readTree(bankBranchJSON);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String bankName = rootNode.path("bank").asText();

        JsonNode servicesNode = rootNode.path("services");
        List<String> services = new ArrayList<>();
        servicesNode.elements().forEachRemaining(jsonNode -> services.add(jsonNode.asText()));

        return bankName.equalsIgnoreCase(bank) && services.contains(service);
    }
}
