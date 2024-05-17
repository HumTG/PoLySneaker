package Model;

import java.util.Date;

public class NhanVien {
    private int IDNhanVien;
    private String Ma_NhanVien;
    private String HoTen;
    private boolean ChucVu;
    private Date NgaySinh;
    private String SDT;
    private String Email;
    private boolean GioiTinh;
    private String DiaChi;
    private String UserName;
    private String MatKhau;
    private boolean TrangThai;

    // Constructor
    public NhanVien(int IDNhanVien, String Ma_NhanVien, String HoTen, boolean ChucVu, Date NgaySinh, String SDT, String Email, boolean GioiTinh, String DiaChi, String UserName, String MatKhau, boolean TrangThai) {
        this.IDNhanVien = IDNhanVien;
        this.Ma_NhanVien = Ma_NhanVien;
        this.HoTen = HoTen;
        this.ChucVu = ChucVu;
        this.NgaySinh = NgaySinh;
        this.SDT = SDT;
        this.Email = Email;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.UserName = UserName;
        this.MatKhau = MatKhau;
        this.TrangThai = TrangThai;
    }

    // Getter và Setter (nếu cần)
    public int getIDNhanVien() {
        return IDNhanVien;
    }

    public void setIDNhanVien(int IDNhanVien) {
        this.IDNhanVien = IDNhanVien;
    }

    public String getMa_NhanVien() {
        return Ma_NhanVien;
    }

    public void setMa_NhanVien(String Ma_NhanVien) {
        this.Ma_NhanVien = Ma_NhanVien;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public boolean isChucVu() {
        return ChucVu;
    }

    public void setChucVu(boolean ChucVu) {
        this.ChucVu = ChucVu;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    // Phương thức in thông tin
    public void inThongTin() {
        System.out.println("Thông tin nhân viên:");
        System.out.println("ID: " + IDNhanVien);
        System.out.println("Mã nhân viên: " + Ma_NhanVien);
        System.out.println("Họ tên: " + HoTen);
        System.out.println("Chức vụ: " + (ChucVu ? "Quản lý" : "Nhân Viên"));
        System.out.println("Ngày sinh: " + NgaySinh);
        System.out.println("Số điện thoại: " + SDT);
        System.out.println("Email: " + Email);
        System.out.println("Giới tính: " + (GioiTinh ? "Nam" : "Nữ"));
        System.out.println("Địa chỉ: " + DiaChi);
        System.out.println("Username: " + UserName);
        System.out.println("Mật khẩu: " + MatKhau);
        System.out.println("Trạng thái: " + (TrangThai ? "Hoạt động" : "Không hoạt động"));
    }

    // Ví dụ về sử dụng
    public static void main(String[] args) {
        // Lấy ngày hiện tại
        Date ngaySinh = new Date();

        // Tạo một đối tượng nhân viên mới
        NhanVien nhanVien1 = new NhanVien(1, "NV001", "Nguyen Van A", true, ngaySinh, "0123456789", "nv1@example.com", true, "Hanoi", "user1", "pass1", true);
        
        // In thông tin nhân viên
        nhanVien1.inThongTin();
    }

    @Override
    public String toString() {
        return "NhanVien{" + "IDNhanVien=" + IDNhanVien + ", Ma_NhanVien=" + Ma_NhanVien + ", HoTen=" + HoTen + ", ChucVu=" + ChucVu + ", NgaySinh=" + NgaySinh + ", SDT=" + SDT + ", Email=" + Email + ", GioiTinh=" + GioiTinh + ", DiaChi=" + DiaChi + ", UserName=" + UserName + ", MatKhau=" + MatKhau + ", TrangThai=" + TrangThai + '}';
    }
    
}
