package bai2;



public class SanPham {
	private String ten;
	private double gia;
	public SanPham(String ten, double gia) {
		super();
		this.ten = ten;
		this.gia = gia;
	}
	public SanPham() {
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
		return gia *0.1;
	}

	public void inThongTin() {
		System.out.println("Tên sản phẩm:      "+getTen());
		System.out.println("Giá sản phẩm:      "+getGia());
		System.out.println("Thuế nhập khẩu:    "+thue());
		System.out.println("-------------------------------------");
	}
}
