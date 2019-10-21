package asia.nainglintun.myintthidarcustomer.models;


import com.google.gson.annotations.SerializedName;

public class Notification {

    @SerializedName("customer_id")
    private String customer_id;

    @SerializedName("city")
    private String city;


    @SerializedName("noti_one")
    private String noti_one;

    @SerializedName("noti_group")
    private String noti_group;


    @SerializedName("title")
    private String title_one;

    @SerializedName("noti_date")
    private String date_one;


    @SerializedName("noti_group_date")
    private String date_group;

    @SerializedName("group_title")
    private String title_group;

    public String getTitle_one() {
        return title_one;
    }

    public String getDate_one() {
        return date_one;
    }

    public String getDate_group() {
        return date_group;
    }

    public String getTitle_group() {
        return title_group;
    }

    public String getNoti_one() {
        return noti_one;
    }

    public String getNoti_group() {
        return noti_group;
    }

    public String getCustomer_id() {
        return customer_id;
    }
}
