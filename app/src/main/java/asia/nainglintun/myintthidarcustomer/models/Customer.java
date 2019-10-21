package asia.nainglintun.myintthidarcustomer.models;

import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName("response")
    private String Response;


    @SerializedName("qualtity")
    private String qualtity;

    @SerializedName("point_eight")
    private String PointEight;


    @SerializedName("image")
    private String Image;

    //json name ah time call ya mal
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("user_name")
    private String userName;


   @SerializedName("shop_name")
    private String shopName;


   @SerializedName("phone_number")
    private String phoneNumber;


   @SerializedName("address")
    private String address;

    @SerializedName("dob")
    private String dob;


    @SerializedName("nrc")
    private String nrc;

    @SerializedName("town_ship")
    private String town;

    @SerializedName("path")
    private String path;

    @SerializedName("profile")
    private String profile;


    @SerializedName("debit_kyat")
    private String debitKyat;

    @SerializedName("debit_pal")
    private String debitPal;

    @SerializedName("debit_yae")
    private String debitYae;

    @SerializedName("password")
    private String password;

    @SerializedName("update_voucher")
    private String updateVoucher;

    @SerializedName("update_saleDate")
    private String updateSaleDate;

    @SerializedName("update_sale_name")
    private String updateSaleName;

    @SerializedName("code")
    private String code;

    @SerializedName("status_condition")
    private String status;

    @SerializedName("total_point")
    private String total_point;

    public String getTotal_point() {
        return total_point;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getUpdateVoucher() {
        return updateVoucher;
    }

    public String getUpdateSaleDate() {
        return updateSaleDate;
    }

    public String getUpdateSaleName() {
        return updateSaleName;
    }

    public String getDebitKyat() {
        return debitKyat;
    }

    public String getPassword() {
        return password;
    }

    public String getDebitPal() {
        return debitPal;
    }

    public String getDebitYae() {
        return debitYae;
    }

    public String getQualtity() {
        return qualtity;
    }

    public String getPointEight() {
        return PointEight;
    }

    public String getImage() {
        return Image;
    }

    public String getResponse() {
        return Response;
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getProfile() {
        return profile;
    }
}
