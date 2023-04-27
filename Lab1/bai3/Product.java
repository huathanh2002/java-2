package bai3;

public class Product {
	private String ten;
	private double gia;
	public Product(String ten, double gia) {
		super();
		this.ten = ten;
		this.gia = gia;
	}
	public Product() {
		super();
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public double thue() {
		return gia*0.1;
	}
	public void xuat() {
		System.out.println("Tên sp:    "+getTen());
		System.out.println("Giá sp:    "+getGia());
		System.out.println("Thuế sp:   "+thue());
		System.out.println("------------------------");
	}
}
