package ar.edu.utn.d2s.model.processes;

import ar.edu.utn.d2s.database.StoreDAOMock;
import ar.edu.utn.d2s.model.points.Store;
import ar.edu.utn.d2s.model.users.Administrator;

import java.io.*;
import java.net.URL;
import java.util.*;

public class UpdateStoresProcess implements SingleProcess {

    public static final String UPDATE_STORES_PROCESS_NAME = "Update stores";

    @Override
    public void execute(Administrator administrator) {

        Calendar startTime = Calendar.getInstance();

        URL url = getClass().getResource(ProcessConfig.UPDATE_STORES_FILE_PATH);
        try(BufferedReader buffer = new BufferedReader(new FileReader(url.getPath()))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                processLine(line);
            }
            buffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processLine(String line) {

        String store;
        String[] keywords;
        String[] lineArr = line.split(";");

        if(lineArr.length > 0) {
            store = lineArr[0];
            keywords = lineArr[1].split(" ");
            updateStore(store, keywords);
        }
    }

    private void updateStore(String storeName, String[] keywords) {

        // TODO Access with real DAO
        List<Store> stores = StoreDAOMock.getStorePoints();
        Store targetStore = stores.stream().filter(store -> store.getName().equalsIgnoreCase(storeName)).findFirst().orElse(null);
        Set<String> newKeywords =  new HashSet<>(Arrays.asList(keywords));

        if (targetStore != null) {
            targetStore.setKeywords(newKeywords);
        } else {
            // TODO How to create a store if there isn't enough information
            //Store store = new Store(storeName, "", null, null, cat, newKeywords);
        }
    }
}
