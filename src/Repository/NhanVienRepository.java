/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.NhanVien;
import Service.InterfaceNhanVien;
import Until.DBconnect;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class NhanVienRepository implements InterfaceNhanVien {

    public static void main(String[] args) {
        NhanVienRepository nhanVienRepository = new NhanVienRepository();
        System.out.println(nhanVienRepository.getChucVu("admin").toString());
    }

    @Override
    public List<NhanVien> getAll() {
        String sql = "SELECT [IDNhanVien], [Ma_NhanVien], [HoTen], [ChucVu], [NgaySinh], [SDT], [Email], [GioiTinh], [DiaChi], [UserName], [MatKhau], [TrangThai] FROM [dbo].[NhanVien]";
        List<NhanVien> lists = new ArrayList<>();
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int IDNhanVien = rs.getInt(1);
                String Ma_NhanVien = rs.getString(2);
                String HoTen = rs.getString(3);
                boolean ChucVu = rs.getBoolean(4);
                Date NgaySinh = rs.getDate(5);
                String SDT = rs.getString(6);
                String Email = rs.getString(7);
                boolean GioiTinh = rs.getBoolean(8);
                String DiaChi = rs.getString(9);
                String UserName = rs.getString(10);
                String MatKhau = rs.getString(11);
                boolean TrangThai = rs.getBoolean(12);

                NhanVien nv = new NhanVien(IDNhanVien, Ma_NhanVien, HoTen, ChucVu, NgaySinh, SDT, Email, GioiTinh, DiaChi, UserName, MatKhau, TrangThai);
                lists.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    @Override
    public List<NhanVien> getChucVu(String username) {
        List<NhanVien> lists = new ArrayList<>();
        String sql = "SELECT [IDNhanVien]\n"
                + "      ,[Ma_NhanVien]\n"
                + "      ,[HoTen]\n"
                + "      ,[ChucVu]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[SDT]\n"
                + "      ,[Email]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[UserName]\n"
                + "      ,[MatKhau]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NhanVien] WHERE UserName = '"+username+"'";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int IDNhanVien = rs.getInt(1);
                String Ma_NhanVien = rs.getString(2);
                String HoTen = rs.getString(3);
                boolean ChucVu = rs.getBoolean(4);
                Date NgaySinh = rs.getDate(5);
                String SDT = rs.getString(6);
                String Email = rs.getString(7);
                boolean GioiTinh = rs.getBoolean(8);
                String DiaChi = rs.getString(9);
                String UserName = rs.getString(10);
                String MatKhau = rs.getString(11);
                boolean TrangThai = rs.getBoolean(12);
                NhanVien nv = new NhanVien(IDNhanVien, Ma_NhanVien, HoTen, ChucVu, NgaySinh, SDT, Email, GioiTinh, DiaChi, UserName, MatKhau, TrangThai);
                lists.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

}
