/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass_gd22;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author An Dong PC
 */
public class NhanVienService implements NhanVienInterface {

    private List<NhanVien> listNV = new ArrayList<>();

    public NhanVienService() {
        listNV.add(new NhanVien("nv01", "Hua Quoc Thanh", 20, "huaquocthanh@gmail.com", 7000000));
        listNV.add(new NhanVien("nv02", "Nguyen Van Tai", 30, "nguyenvantai@gmail.com", 9000000));
        listNV.add(new NhanVien("nv03", "Pham Thi Hoa", 27, "phamthihoa@gmail.com", 6000000));
        listNV.add(new NhanVien("nv04", "Tran Van Tuan", 21, "tranvantuan@gmail.com", 5000000));
    }

    @Override
    public List<NhanVien> getAll() {
        return listNV;
    }

    @Override
    public String addNV(NhanVien nv) {
        if (nv != null) {
            listNV.add(nv);
            return "thêm thành công !";
        } else {
            return "thêm thất bại !";
        }
    }

    @Override
    public String deleteNV(int index) {
        if (index >= 0) {
            listNV.remove(index);
            return "Delete thành công !";
        } else {
            return "Delete thất bại( hãy chọn nhân viên ở form ) !";
        }
    }

    @Override
    public String updateNV(int index, NhanVien nv) {
        if (index >= 0 && nv != null) {
            listNV.set(index, nv);
            return "Update thành công !";
        } else {
            return "Update thất bại !";
        }
    }

    @Override
    public int timNV(String ma) {
        int index =-1;
        for (int i = 0; i < listNV.size(); i++) {
            if(listNV.get(i).getMaNV().equalsIgnoreCase(ma)){
                index=i;
                break;
            }
        }
        return index;
    }

    @Override
    public String WriteFile(String path) {
        try {
            FileOutputStream fo = new FileOutputStream(path);
            ObjectOutputStream ofo = new ObjectOutputStream(fo);

            ofo.writeObject(listNV);
            ofo.close();

            return "ghi file thanh cong";
        } catch (Exception e) {
            return "loi ghi file";
        }
    }

    @Override
    public String ReadFile(String path) {
        try {
            FileInputStream fi = new  FileInputStream(path);
            ObjectInputStream ifi= new ObjectInputStream(fi);
            
            listNV=(List<NhanVien>) ifi.readObject();
            ifi.close();
            return "doc file thanh cong";
        } catch (Exception e) {
            return "loi doc file";
        }
    }

    
    @Override
    public int dem() {
        return listNV.size();
    }

    
}