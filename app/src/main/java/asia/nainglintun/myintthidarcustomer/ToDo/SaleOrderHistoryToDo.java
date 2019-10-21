package asia.nainglintun.myintthidarcustomer.ToDo;

import java.io.Serializable;

public class SaleOrderHistoryToDo implements Serializable {

    public SaleOrderHistoryToDo(String txtDate, String txtType, String txtAmount, String cuponCode, String shopName, String phoneNumber, String dateOfBirth, String customerName, String password, String voucherNumber, String qualtity, String pointEight, String gram, String kyat, String pal, String yae, String userName) {
        this.txtDate = txtDate;
        this.txtType = txtType;
        this.txtAmount = txtAmount;
        this.cuponCode = cuponCode;
        this.shopName = shopName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.customerName = customerName;
        this.password = password;
        this.voucherNumber = voucherNumber;
        this.qualtity = qualtity;
        this.pointEight = pointEight;
        this.gram = gram;
        this.kyat = kyat;
        this.pal = pal;
        this.yae = yae;
        this.userName = userName;
    }

    private String txtDate,txtType,txtAmount,cuponCode,shopName,phoneNumber,dateOfBirth,customerName,password;
    String voucherNumber,qualtity,pointEight,gram,kyat,pal,yae,userName;

    public String getTxtDate() {
        return txtDate;
    }

    public String getCuponCode() {
        return cuponCode;
    }

    public void setCuponCode(String cuponCode) {
        this.cuponCode = cuponCode;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getQualtity() {
        return qualtity;
    }

    public void setQualtity(String qualtity) {
        this.qualtity = qualtity;
    }

    public String getPointEight() {
        return pointEight;
    }

    public void setPointEight(String pointEight) {
        this.pointEight = pointEight;
    }

    public String getGram() {
        return gram;
    }

    public void setGram(String gram) {
        this.gram = gram;
    }

    public String getKyat() {
        return kyat;
    }

    public void setKyat(String kyat) {
        this.kyat = kyat;
    }

    public String getPal() {
        return pal;
    }

    public void setPal(String pal) {
        this.pal = pal;
    }

    public String getYae() {
        return yae;
    }

    public void setYae(String yae) {
        this.yae = yae;
    }

    public SaleOrderHistoryToDo(String txtDate, String txtType, String txtAmount) {
        this.txtDate = txtDate;
        this.txtType = txtType;
        this.txtAmount = txtAmount;
    }

    public void setTxtDate(String txtDate) {
        this.txtDate = txtDate;
    }

    public String getTxtType() {
        return txtType;
    }

    public void setTxtType(String txtType) {
        this.txtType = txtType;
    }

    public String getTxtAmount() {
        return txtAmount;
    }

    public void setTxtAmount(String txtAmount) {
        this.txtAmount = txtAmount;
    }
}
