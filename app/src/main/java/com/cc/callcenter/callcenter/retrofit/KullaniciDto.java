package com.cc.callcenter.callcenter.retrofit;

/**
 * Created by vektorel on 01.07.2018.
 */

public class KullaniciDto {

    private Long id;
    private String ad;
    private String soyad;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "KullaniciDto{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
