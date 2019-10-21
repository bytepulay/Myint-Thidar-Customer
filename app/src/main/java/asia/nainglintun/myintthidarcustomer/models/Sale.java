package asia.nainglintun.myintthidarcustomer.models;

import com.google.gson.annotations.SerializedName;

public class Sale {

    @SerializedName("profile")
    private String profile;

    @SerializedName("status")
    private String status;

    @SerializedName("name")
    private String name;


    public String getStatus() {
        return status;
    }

    public String getProfile() {
        return profile;
    }

    public String getName() {
        return name;
    }
}
