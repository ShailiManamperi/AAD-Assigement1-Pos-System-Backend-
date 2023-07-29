package lk.ijse.gdse63.shaili.assignment1.Util;

import com.google.gson.Gson;

public class GSONConfiguration {
    private static GSONConfiguration gsonConfiguration;
    private static  Gson gson;


    private GSONConfiguration() {
        gson = new Gson();
    }

    public static GSONConfiguration getInstance() {
        return gsonConfiguration == null ? gsonConfiguration = new GSONConfiguration() : gsonConfiguration;

    }

    public  Gson getGSON() {
        return gson;

    }


}
