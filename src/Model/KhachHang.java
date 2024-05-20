/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class KhachHang {
    private int IDKhachHang;
    private String tenKhachHang;
    private String sdt;
    private java.util.Date ngaySinh;
    private String email;
    private String diaChi;
    private boolean trangThai;

    // Constructor mặc định
    public KhachHang() {
    }

    // Constructor có tham số
    public KhachHang(int IDKhachHang, String tenKhachHang, String sdt, java.util.Date ngaySinh, String email, String diaChi, boolean trangThai) {
        this.IDKhachHang = IDKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

    // Getter và Setter cho IDKhachHang
    public int getIDKhachHang() {
        return IDKhachHang;
    }

    public void setIDKhachHang(int IDKhachHang) {
        this.IDKhachHang = IDKhachHang;
    }

    // Getter và Setter cho tenKhachHang
    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    // Getter và Setter cho sdt
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    // Getter và Setter cho ngaySinh
    public java.util.Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(java.util.Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    // Getter và Setter cho email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter và Setter cho diaChi
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    // Getter và Setter cho trangThai
    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    // Phương thức toString để in thông tin KhachHang
    @Override
    public String toString() {
        return "KhachHang{" +
                "IDKhachHang=" + IDKhachHang +
                ", tenKhachHang='" + tenKhachHang + '\'' +
                ", sdt='" + sdt + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", email='" + email + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", trangThai=" + trangThai +
                '}';
    }
}

