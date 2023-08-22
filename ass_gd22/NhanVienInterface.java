/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ass_gd22;

import java.util.List;

/**
 *
 * @author An Dong PC
 */
public interface NhanVienInterface {
    List<NhanVien> getAll();
    String addNV(NhanVien nv);
    String deleteNV(int index);
    String updateNV(int index, NhanVien nv);
    int timNV(String ma);
    String WriteFile(String path);
    String ReadFile(String path);
    int dem();
    
    
}
