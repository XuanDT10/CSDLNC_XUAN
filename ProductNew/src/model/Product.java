package model;

public class Product {
    private String maSanPham;
    private String tenSanPham;
    private String loaiSanPham;
    private String hangSanXuat;
    private double giaNhap;
    private double giaBan;
    private int tonKho;
    private String trangThai;
    private String chuThich;

    // Constructor
    public Product(String maSanPham, String tenSanPham, String loaiSanPham, 
                   String hangSanXuat, double giaNhap, double giaBan, 
                   int tonKho, String trangThai, String chuThich) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.loaiSanPham = loaiSanPham;
        this.hangSanXuat = hangSanXuat;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.tonKho = tonKho;
        this.trangThai = trangThai;
        this.chuThich = chuThich;
    }

    // Getters and Setters
    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getTonKho() {
        return tonKho;
    }

    public void setTonKho(int tonKho) {
        this.tonKho = tonKho;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getChuThich() {
        return chuThich;
    }

    public void setChuThich(String chuThich) {
        this.chuThich = chuThich;
    }

    // Override toString to make the object representation clearer
    @Override
    public String toString() {
        return "Product{maSanPham='" + maSanPham + "', tenSanPham='" + tenSanPham + "', loaiSanPham='" + loaiSanPham + 
               "', hangSanXuat='" + hangSanXuat + "', giaNhap=" + giaNhap + ", giaBan=" + giaBan + 
               ", tonKho=" + tonKho + ", trangThai='" + trangThai + "', chuThich='" + chuThich + "'}";
    }
}
