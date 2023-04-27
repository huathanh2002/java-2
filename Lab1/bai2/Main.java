package bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<SanPham>list =new ArrayList<>();
		for(int i=0;i<=4;i++) {
			SanPham sp = new SanPham();
			System.out.print("Mời nhập tên sp thứ "+(i+1)+":");
			sp.setTen(sc.nextLine());
			System.out.print("Mời nhập giá sp thứ "+(i+1)+":");
			sp.setGia(sc.nextDouble());
			sc.nextLine(); //đọc kí tự thừa
			list.add(sp);
		}
		for (SanPham sanPham : list) {
			sanPham.inThongTin();
		}
	}
}
