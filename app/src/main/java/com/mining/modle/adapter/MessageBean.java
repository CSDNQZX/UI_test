package com.mining.modle.adapter;

/**
 * Created by Zixin on 2019-3-22.
 */
public class MessageBean {
    private  String content_a;
    private  String content_b;
    private  String content_c;
    private  String content_d;
    private  String content_e;
    private  String content_f;
    private  String content_g;
    private  String content_h;
    private  int image;

    public MessageBean() {
        super();
    }

    public MessageBean(String content_a) {
        this.content_a = content_a;
    }

    public MessageBean(String content_a, String content_b) {
        this.content_a = content_a;
        this.content_b = content_b;
    }

    public MessageBean(String content_a, String content_b, String content_c) {
        this.content_a = content_a;
        this.content_b = content_b;
        this.content_c = content_c;
    }

    public MessageBean(String content_a, String content_b, String content_c, String content_d) {
        this.content_a = content_a;
        this.content_b = content_b;
        this.content_c = content_c;
        this.content_d = content_d;
    }
    public MessageBean(String content_a, String content_b, String content_c, String content_d,String content_e) {
        this.content_a = content_a;
        this.content_b = content_b;
        this.content_c = content_c;
        this.content_d = content_d;
        this.content_e = content_e;
    }
    public MessageBean(String content_a, String content_b, String content_c, String content_d,String content_e,String content_f) {
        this.content_a = content_a;
        this.content_b = content_b;
        this.content_c = content_c;
        this.content_d = content_d;
        this.content_e = content_e;
        this.content_f = content_f;
    }
    public MessageBean(String content_a, String content_b, String content_c, String content_d,String content_e,String content_f,String content_g) {
        this.content_a = content_a;
        this.content_b = content_b;
        this.content_c = content_c;
        this.content_d = content_d;
        this.content_e = content_e;
        this.content_f = content_f;
        this.content_g = content_g;
    }
    public MessageBean(String content_a, String content_b, String content_c, String content_d,String content_e,String content_f,String content_g,String content_h) {
        this.content_a = content_a;
        this.content_b = content_b;
        this.content_c = content_c;
        this.content_d = content_d;
        this.content_e = content_e;
        this.content_f = content_f;
        this.content_g = content_g;
        this.content_h = content_h;
    }
    //设置图片
    public MessageBean(int image, String content_b, String content_c, String content_d,String content_e,String content_f) {
        this.image = image;
        this.content_b = content_b;
        this.content_c = content_c;
        this.content_d = content_d;
        this.content_e = content_e;
        this.content_f = content_f;
        this.content_g = content_g;
        this.content_h = content_h;
    }

    public String getContent_a() {
        return content_a;
    }
    public void setContent_a(String content_a) {
        this.content_a = content_a;
    }

    public String getContent_b() {
        return content_b;
    }

    public void setContent_b(String content_b) {
        this.content_b = content_b;
    }

    public String getContent_c() {
        return content_c;
    }

    public void setContent_c(String content_c) {
        this.content_c = content_c;
    }

    public String getContent_d() {
        return content_d;
    }

    public void setContent_d(String content_d) {
        this.content_d = content_d;
    }

    public String getContent_e() {
        return content_e;
    }

    public void setContent_e(String content_e) {
        this.content_e = content_e;
    }

    public String getContent_f() {
        return content_f;
    }

    public void setContent_f(String content_f) {
        this.content_f = content_f;
    }

    public String getContent_g() {
        return content_g;
    }

    public void setContent_g(String content_g) {
        this.content_g = content_g;
    }

    public String getContent_h() {
        return content_h;
    }

    public void setContent_h(String content_h) {
        this.content_h = content_h;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
