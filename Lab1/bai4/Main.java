package bai4;

import java.util.ArrayList;
import java.util.Scanner;

import bai4.NoTaxProduct;
import bai4.Product;

public class Main {

	public static void main(String[] args) {
		ArrayList<Product> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i <= 2; i++) {
			System.out.print("Nếu sp có tính thuế hãy chọn c còn không thì bỏ qua(enter): ");
			String chon = sc.nextLine();
			if (chon.equalsIgnoreCase("c")) {
				Product sp = new Product();
				System.out.print("Mời nhập tên sp thứ " + (i + 1) + ":");
				sp.setTen(sc.nextLine());
				System.out.print("Mời nhập giá sp thứ " + (i + 1) + ":");
				sp.setGia(sc.nextDouble());
				sc.nextLine();
				list.add(sp);
				sp.insert();
				sp.update();
				sp.delete();
				sp.select();
			} else {
				Product sp = new NoTaxProduct();
				System.out.print("Mời nhập tên sp thứ " + (i + 1) + ":");
				sp.setTen(sc.nextLine());
				System.out.print("Mời nhập giá sp thứ " + (i + 1) + ":");
				sp.setGia(sc.nextDouble());
				sc.nextLine();
				list.add(sp);
				sp.insert();
				sp.update();
				sp.delete();
				sp.select();
			}
		}
		for (Product product : list) {
			product.xuat();
		}
	}

}
