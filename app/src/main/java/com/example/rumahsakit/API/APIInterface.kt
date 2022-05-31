package com.example.restapi

import com.example.rumahsakit.Model.*
import retrofit2.Call
import retrofit2.http.*

interface APIInterface {
        //post
        @FormUrlEncoded
        @POST("students")
        fun login(
                @Field("username") username:String,
                @Field("password") password:String,
        ):Call<UserModel>

        @FormUrlEncoded
        @POST("user")
        fun tambah(
                @Field("username") username:String,
                @Field("password") password:String,
        ): Call<UserModel>

        @FormUrlEncoded
        @POST("reservasi")
        fun tambahreservasi(
                @Field("nama") nama:String,
                @Field("jam") jam:String,
                @Field("id_dokter") id_dokter:String,
        ): Call<ReservasiModel>

        @GET("dokter")
        fun getdokter(): Call<ArrayList<DokterModel>>

        @GET("obat")
        fun getobat(): Call<ArrayList<ObatModel>>

        @GET("pasien")
        fun getpasien(): Call<ArrayList<PasienModel>>

        @GET("reservasi")
        fun getreservasi(): Call<ArrayList<ReservasiModel>>



}
