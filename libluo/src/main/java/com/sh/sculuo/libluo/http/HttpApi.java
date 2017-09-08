package com.sh.sculuo.libluo.http;


import com.sh.sculuo.libluo.http.demomodel.LoginReq;
import com.sh.sculuo.libluo.http.demomodel.LoginRes;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by luoxiaocheng on 2017/5/23.
 */

public interface HttpApi {
//    请求方法注解
//    @GET
//    @POST
//    @PUT
//    @DELETE
//    @PATH
//    @HEAD
//    @OPTIONS
//    @HTTP

//    标记注解，包含
//    @FormUrlEncoded;
//    @Multipart;
//    @Streaming。

//    参数注解
//    @Query
//    @QueryMap
//    @Body
//    @Field
//    @FieldMap
//    @Part
//    @PartMap


//    其他注解，
//    @Path
//    @Header
//    @Headers
//    @Url


    //示例接口  /app/auth/login

    //普通get查询
    // @Query("name") String name  前一个name为对应表单的key值,后一个name为对应表单的value
    // @QueryMap Map<String,String> options  将查询字段集中处理

    @GET("/app/auth/login")
    Call<BaseRes<LoginRes>> login(@Query("name") String name);
    @GET("/app/auth/login")
    Call<BaseRes<LoginRes>> login1(@Query("name") String name, @QueryMap Map<String, String> options);

    @POST("/app/auth/login")
    Call<BaseRes<LoginRes>> login2(@Body LoginReq req);

    //post表单 需结合 @FormUrlEncoded 使用
    // 1.@Field("fileName1") String fileName1   前一个fileName1为对应表单的key值,后一个fileName1为对应表单的value
    // 2.@FieldMap Map<String,String> options  将表单内对应的集中处理
    @FormUrlEncoded
    @POST("/app/auth/login")
    Call<BaseRes<LoginRes>> login3(@Field("fileName1") String fileName1, @Field("fileName1") String fileName2, @FieldMap Map<String, String> options);

    //Path注解  替换对应的占位 (userId即占位符 ,id是具体替换内容)
    @GET("/app/auth/login/{userId}")
    Call<BaseRes<LoginRes>> login4(@Path("userId") String id);

    //post文件上传
    @Multipart
    @POST("/app/auth/login")
    Call<BaseRes<LoginRes>> login5(@Part("description") RequestBody description, @Part MultipartBody.Part file);

    //Heads作为修饰符处理 动态添加header
    @POST("/app/auth/login")
    Call<BaseRes<LoginRes>> login6(@Body LoginReq req, @Header("Authorization") String authorization);


    //Heads作为修饰符处理 静态添加header
    //单个header
//    @Headers("Authorization: authorization")
    //多个
    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @POST("/app/auth/login")
    Call<BaseRes<LoginRes>> login7(@Body LoginReq req);

    //不在定义好的接口中 调用其他外部接口url 如 http://www.baidu.com/search
    @GET
    Call<BaseRes<LoginRes>> login8(@Url String url);

    //下载单个文件 fileUrl为下载路径
    @Streaming
    @GET
    Call<ResponseBody> down(@Url String fileUrl);
}