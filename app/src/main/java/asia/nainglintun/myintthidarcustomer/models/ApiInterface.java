package asia.nainglintun.myintthidarcustomer.models;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface
{
    @GET("customerRegistration.php")
    Call<Customer> performRegistration(@Query("name") String name, @Query("user_name") String userName, @Query("shop_name") String shopName, @Query("phone_number") String phoneNumber, @Query("address") String address, @Query("dob") String dob, @Query("nrc") String nrc, @Query("town_ship") String town, @Query("image") String image);

//    @GET("slae_invoice_userData.php")
//    Call<ImageClass> getCustomerInfo(@Query("user_name") String userName);



    @GET("slae_invoice_userData.php")
    Call<Customer> getCustomerInfo(@Query("user_name") String userName);


    @GET("changePinCode.php")
    Call<Customer> changePinCode(@Query("user_name") String userName, @Query("code") String pinCode);




    @GET("logintest.php")
    Call<Customer> performUserLogin(@Query("user_name") String UserName);

    @GET("sale_invoice_insert_data.php")
    Call<SaleInoviceData> insertSaleInvoice(@Query("sale_user_name") String saleUserName, @Query("voucher_number") String voucherNumber, @Query("sdate") String saleDate, @Query("total_kyat") String totalKyat, @Query("total_pal") String totalPal, @Query("total_yae") String totalYae, @Query("qty") String qty, @Query("point_eight") String pointEight, @Query("total_ayot_kyat") String totalAyotKyat, @Query("total_ayot_pal") String totalAyotPel, @Query("total_ayot_yae") String totalAyotYae, @Query("kyat") String Kyat, @Query("pal") String Pal, @Query("yae") String Yae, @Query("gram") String Gram, @Query("cupon_code") String cuponCode, @Query("customer_id") String customerId,
                                            @Query("previous_remain_kyat") String previousRemainKyat, @Query("previous_remain_pal") String previousRemainPal, @Query("previous_remain_yae") String previousRemainYae, @Query("buy_debit_kyat") String buyDebitKyat, @Query("buy_debit_pal") String buyDebitPal, @Query("buy_debit_yae") String buyDebitYae, @Query("return_gold_kyat") String return_gold_kyat, @Query("return_gold_pal") String return_gold_pal, @Query("return_gold_yae") String return_gold_yae, @Query("net_pay_kayt") String net_pay_kayt, @Query("net_pay_pal") String net_pay_pal, @Query("net_pay_yae") String net_pay_yae, @Query("payment_kyat") String paymentKyat, @Query("payment_pal") String paymentPal, @Query("payment_yae") String paymentYae, @Query("now_remain_kyat") String nowRemainKyat, @Query("now_remain_pal") String nowRemainPal, @Query("now_remain_yae") String nowRemainYae, @Query("note") String note,
                                            @Query("return_gram") String returnGram, @Query("now_remain_gram") String nowRemainGram, @Query("sub_return_kayt") String subReturnKyat, @Query("sub_return_pal") String subReturnPal, @Query("sub_return_yae") String subReturnYae, @Query("return_quantity") String returnQuantity, @Query("return_pointeight") String returnPointEight, @Query("now_remain_quantity") String nowRemainQuantity, @Query("now_remain_pointeight") String nowRemainPointEight, @Query("return_ayot_kyat") String returnAyotKyat, @Query("return_ayot_pal") String returnAyotPal, @Query("return_ayot_yae") String returnAyotYae,
                                            @Query("now_total_ayot_kyat") String nowTotalAyotKyat, @Query("now_total_ayot_pal") String nowTotalAyotPal, @Query("now_total_ayot_yae") String nowTotalAyotYae);


    @GET("order_invoice_insert_data.php")
    Call<OrderInoviceData> insertOrderInvoice(@Query("sale_user_name") String saleUserName, @Query("voucher_number") String voucherNumber, @Query("order_date") String saleDate, @Query("total_kyat") String totalKyat, @Query("total_pal") String totalPal, @Query("total_yae") String totalYae, @Query("qty") String qty, @Query("point_eight") String pointEight, @Query("total_ayot_kyat") String totalAyotKyat, @Query("total_ayot_pal") String totalAyotPel, @Query("total_ayot_yae") String totalAyotYae, @Query("kyat") String Kyat, @Query("pal") String Pal, @Query("yae") String Yae, @Query("gram") String Gram, @Query("cupon_code") String cuponCode, @Query("customer_id") String customerId,
                                              @Query("previous_remain_kyat") String previousRemainKyat, @Query("previous_remain_pal") String previousRemainPal, @Query("previous_remain_yae") String previousRemainYae, @Query("buy_debit_kyat") String buyDebitKyat, @Query("buy_debit_pal") String buyDebitPal, @Query("buy_debit_yae") String buyDebitYae, @Query("payment_kyat") String paymentKyat, @Query("payment_pal") String paymentPal, @Query("payment_yae") String paymentYae, @Query("now_remain_kyat") String nowRemainKyat, @Query("now_remain_pal") String nowRemainPal, @Query("now_remain_yae") String nowRemainYae, @Query("note") String note);

    @GET("salehistory.php")
    Call<List<Salehistory>> getSaleHistoryInfo(@Query("user_name") String userName);



    @GET("orderhistory.php")
    Call<List<Orderhistory>> getOrderHistoryInfo(@Query("user_name") String userName);



    @GET("updatesalehistory.php")
    Call<Salehistory> updateSaleInvoice(@Query("id") String id, @Query("sale_user_name") String sale_user_name, @Query("voucher_number") String voucherNumber, @Query("sdate") String saleDate, @Query("new_total_kyat") String total_kyat,
                                        @Query("new_total_pal") String total_pal, @Query("new_total_yae") String total_yae, @Query("total_qualtity") String quantity, @Query("point_eight") String point_eight, @Query("total_ayot_kyat") String total_ayot_kyat, @Query("total_ayot_pal") String total_ayot_pal
            , @Query("total_ayot_yae") String total_ayot_yae, @Query("kyat") String kyat, @Query("pal") String pal, @Query("yae") String yae, @Query("gram") String gram, @Query("cupon_code") String cupon_code,
                                        @Query("customer_id") String customer_id, @Query("previous_remain_kyat") String previous_remain_kyat, @Query("previous_remain_pal") String previous_remain_pal, @Query("previous_remain_yae") String previous_remain_yae, @Query("buy_debit_kyat") String buy_debit_kyat, @Query("buy_debit_pal") String buy_debit_pal,
                                        @Query("buy_debit_yae") String buy_debit_yae, @Query("return_gold_kyat") String return_gold_kyat, @Query("return_gold_pal") String return_gold_pal, @Query("return_gold_yae") String return_gold_yae, @Query("net_pay_kayt") String net_pay_kayt, @Query("net_pay_pal") String net_pay_pal,
                                        @Query("net_pay_yae") String net_pay_yae, @Query("payment_kyat") String payment_kyat, @Query("payment_pal") String payment_pal, @Query("payment_yae") String payment_yae, @Query("now_remain_kyat") String now_remain_kyat, @Query("now_remain_pal") String now_remain_pal,
                                        @Query("now_remain_yae") String now_remain_yae, @Query("remark") String remark, @Query("return_gram") String return_gram, @Query("now_remain_gram") String now_remain_gram, @Query("sub_return_kyat") String sub_return_kyat, @Query("sub_return_pal") String sub_return_pal, @Query("sub_return_yae") String sub_return_yae, @Query("return_quantity") String return_quantity, @Query("return_pointeight") String return_pointeight,
                                        @Query("now_remain_quantity") String now_remain_quantity, @Query("now_remain_pointeight") String now_remain_pointeight, @Query("return_ayot_kyat") String return_ayot_kyat, @Query("return_ayot_pal") String return_ayot_pal, @Query("return_ayot_yae") String return_ayot_yae,
                                        @Query("now_total_ayot_kyat") String now_total_ayot_kyat, @Query("now_total_ayot_pal") String now_total_ayot_pal, @Query("now_total_ayot_yae") String now_total_ayot_yae,
                                        @Query("customer_shop") String customer_shop, @Query("customer_name") String customer_name, @Query("customer_phone_number") String customer_phone_number, @Query("customer_dob") String customer_dob, @Query("customer_nrc") String customer_nrc, @Query("customer_address") String customer_address, @Query("customer_town") String customer_town, @Query("customer_user_name") String customer_user_name);



    @GET("updateorderhistory.php")
    Call<Orderhistory> updateOrderInvoice(@Query("id") String id, @Query("sale_user_name") String sale_user_name, @Query("voucher_number") String voucherNumber, @Query("sdate") String saleDate, @Query("new_total_kyat") String total_kyat,
                                          @Query("new_total_pal") String total_pal, @Query("new_total_yae") String total_yae, @Query("total_qualtity") String quantity, @Query("point_eight") String point_eight, @Query("total_ayot_kyat") String total_ayot_kyat, @Query("total_ayot_pal") String total_ayot_pal
            , @Query("total_ayot_yae") String total_ayot_yae, @Query("kyat") String kyat, @Query("pal") String pal, @Query("yae") String yae, @Query("gram") String gram, @Query("cupon_code") String cupon_code,
                                          @Query("customer_id") String customer_id, @Query("previous_remain_kyat") String previous_remain_kyat, @Query("previous_remain_pal") String previous_remain_pal, @Query("previous_remain_yae") String previous_remain_yae, @Query("buy_debit_kyat") String buy_debit_kyat, @Query("buy_debit_pal") String buy_debit_pal,
                                          @Query("buy_debit_yae") String buy_debit_yae, @Query("payment_kyat") String payment_kyat, @Query("payment_pal") String payment_pal, @Query("payment_yae") String payment_yae, @Query("now_remain_kyat") String now_remain_kyat, @Query("now_remain_pal") String now_remain_pal,
                                          @Query("now_remain_yae") String now_remain_yae, @Query("remark") String remark,
                                          @Query("customer_shop") String customer_shop, @Query("customer_name") String customer_name, @Query("customer_phone_number") String customer_phone_number, @Query("customer_dob") String customer_dob, @Query("customer_nrc") String customer_nrc, @Query("customer_address") String customer_address, @Query("customer_town") String customer_town, @Query("customer_user_name") String customer_user_name);



//    @GET("updateorderhistory.php")
//    Call<Orderhistory> updateOrderInvoice(@Query("id") String customerId,@Query("voucher_number") String voucherNumber,@Query("order_date") String OrderDate,@Query("cupon_code") String cuponCode,
//                                        @Query("phone_number") String phoneNumber,@Query("name") String customerName,@Query("shop_name") String shopName,@Query("address") String customerAddress,@Query("dob") String Dob,@Query("town_ship") String Township
//            ,@Query("ring_title") String ringTitle,@Query("ring_number") String ringNumber,@Query("ring_point_eight") String ringPointEight,@Query("ring_kyat") String ringKyat,@Query("ring_pal") String ringPal,@Query("ring_yae") String ringYae,
//                                        @Query("bangles_title") String banglesTitle,@Query("bangles_number") String banglesNumber,@Query("bangles_point_eight") String banglesPointEight,@Query("bangles_kyat") String banglesKyat,@Query("bangles_pal") String banglesPal,@Query("bangles_yae") String banglesYae,
//                                        @Query("necklace_title") String necklaceTitle,@Query("necklace_number") String necklaceNumber,@Query("necklace_point_eight") String necklacePointEight,@Query("necklace_kyat") String necklaceKyat,@Query("necklace_pal") String necklacePal,@Query("necklace_yae") String necklaceYae,
//                                        @Query("earring_title") String earringTitle,@Query("earring_number") String earringNumber,@Query("earring_point_eight") String earringPointEight,@Query("earring_kyat") String earringKyat,@Query("earring_pal") String earringPal,@Query("earring_yae") String earringYae,
//                                          @Query("qty") String qty,@Query("point_eight") String pointEight,@Query("kyat") String Kyat,@Query("pal") String Pal,@Query("yae") String Yae,@Query("gram") String Gram);

//    @FormUrlEncoded
//    @POST("upload.php")
//    Call<ImageClass> uploadImage(@Field("title") String title,@Field("image") String image);



    @FormUrlEncoded
    @POST("upload.php")
        Call<ImageClass> uploadImage(@Field("name") String name, @Field("user_name") String userName, @Field("shop_name") String shopName, @Field("phone_number") String phoneNumber, @Field("address") String address, @Field("dob") String DOB, @Field("nrc") String Nrc, @Field("town_ship") String town, @Field("image") String image, @Field("password") String password);
    //Call<ImageClass> uploadImage(@Field("name") String name,@Field("user_name") String userName,@Field("shop_name") String shopName,@Field("phone_number") String phoneNumber,@Field("address") String address,@Field("dob") String DOB,@Field("nrc") String Nrc,@Field("town_ship") String town,@Field("image") String image);


    @FormUrlEncoded
    @POST("update_customer_profile.php")
    Call<ImageClass> UpdateCustomerProfile(@Field("user_name") String userName, @Field("image") String image);


    @FormUrlEncoded
    @POST("update_sales_profile.php")
    Call<Sale> UpdateSaleProfile(@Field("user_name") String userName, @Field("image") String image);


    @FormUrlEncoded
    @POST("get_sales_profile.php")
    Call<Sale> getSaleProfile(@Field("user_name") String userName);



    @GET("read_notification.php")
    Call<List<Notification>> readNotification(@Query("user_name") String Id);


    @GET("read_notification_group.php")
    Call<List<Notification>> readGroupNotification(@Query("city") String city);

    @GET("calculate_point.php")
    Call<Customer> getTotalPoint(@Query("user_name") String customerId);



    @GET("read_Id.php")
    Call<Notification> readId(@Query("user_name") String userName);

   @GET("read_Id.php")
    Call<ImageClass> getQrImage(@Query("user_name") String userName);

}
