package com.example.watersupply.pack;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

import retrofit2.http.POST;
import retrofit2.http.Path;


public interface API {
        String url = "http://192.168.43.235:8080/watersupply/";

        @POST("getjson.php")
        @FormUrlEncoded
        Call <String>  checkLogin(@Field("r_email") String r_email, @Field("r_pwd") String r_pwd);

    @POST("insert.php")
    @FormUrlEncoded
    Call <String> add(@Field("a_cbottle") String a_cbottle, @Field("a_hbottle") String a_hbottle,@Field("a_amount") String a_amount);

    @POST("addinsert.php")
    @FormUrlEncoded
    Call <String> insert(@Field("c_name") String c_name, @Field("c_add") String c_add,
                            @Field("c_phone") String c_phone,@Field("c_date") String c_date,
                            @Field("c_cbottle") String c_cbottle,@Field("c_hbottle") String c_hbottle,
                            @Field("c_pcbottle") String c_pcbottle,@Field("c_phbottle") String c_phbottle,
                            @Field("c_rcbottle") String c_rcbottle,@Field("c_rhbottle") String c_rhbottle,
                            @Field("c_credit") String c_credit,@Field("c_debit") String c_debit,
                            @Field("c_total") String c_total,@Field("c_status") String c_status);


    @POST("customer_detail.php")
    Call <String> customer();

    @POST("customer.php")
    @FormUrlEncoded
    Call <String> customerdetails(@Field("c_name") String c_name);

    @POST("update_customer.php")
    @FormUrlEncoded
    Call <String> updatecustomer(@Field("c_name") String c_name, @Field("c_add") String c_add,
                                 @Field("c_phone") String c_phone,
                                 @Field("c_cbottle") String c_cbottle,@Field("c_hbottle") String c_hbottle,
                                 @Field("c_pcbottle") String c_pcbottle,@Field("c_phbottle") String c_phbottle,
                                 @Field("c_credit") String c_credit,@Field("c_debit") String c_debit,
                                 @Field("c_total") String c_total,@Field("c_status") String c_status);


}
