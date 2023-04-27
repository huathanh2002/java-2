package bai4;

public class Product implements Dao {

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
		return gia * 0.1;
	}

	public void xuat() {
		System.out.println("Tên sp:    " + getTen());
		System.out.println("Giá sp:    " + getGia());
		System.out.println("Thuế sp:   " + thue());
		System.out.println("------------------------");
	}

	@Override
	public void insert() {
		System.out.println("Thêm mới thành công!");
		
	}

	@Override
	public void update() {
		System.out.println("Cập nhật thành công!");		
	}

	@Override
	public void delete() {
		System.out.println("Xóa thành công!");		
	}

	@Override
	public void select() {
		System.out.println("Chọn thành công!");		
	}

}
