/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass_gd22;

import java.io.Serializable;

/**
 *
 * @author An Dong PC
 */
public class NhanVien implements Serializable{
    private String maNV, hoTenNV;
    private double tuoi;
    private String emailNV;
    private double luong;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTenNV, double tuoi, String emailNV, double luong) {
        this.maNV = maNV;
        this.hoTenNV = hoTenNV;
        this.tuoi = tuoi;
        this.emailNV = emailNV;
        this.luong = luong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTenNV() {
        return hoTenNV;
    }

    public void setHoTenNV(String hoTenNV) {
        this.hoTenNV = hoTenNV;
    }

    public double getTuoi() {
        return tuoi;
    }

    public void setTuoi(double tuoi) {
        this.tuoi = tuoi;
    }

    public String getEmailNV() {
        return emailNV;
    }

    public void setEmailNV(String emailNV) {
        this.emailNV = emailNV;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
    Object[] toDataRow(){
        return new Object[]{this.getMaNV(),this.getHoTenNV(),this.getTuoi(),this.getEmailNV(),this.getLuong()};
    }
}
