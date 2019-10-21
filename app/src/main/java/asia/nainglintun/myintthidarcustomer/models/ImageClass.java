package asia.nainglintun.myintthidarcustomer.models;

import com.google.gson.annotations.SerializedName;

public class ImageClass {

    @SerializedName("customer_id")
    private String Id;

    private String Title;

    @SerializedName("image_path")
    private String Image;

    @SerializedName("response_registration")
    private String Response;


    private String name;


    private String userName;



    private String shopName;



    private String phoneNumber;



    private String address;


    private String dob;



    private String nrc;


    private String town;

    private String password;

    public String getPassword() {
        return password;
    }

    @SerializedName("profile")
    private String profile;

    public String getId() {
        return Id;
    }

    public String getProfile() {
        return profile;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getShopName() {
        return shopName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public String getNrc() {
        return nrc;
    }

    public String getTown() {
        return town;
    }

    public String getTitle() {
        return Title;
    }

    public String getImage() {
        return Image;
    }

    public String getResponse() {
        return Response;
    }
}
