package model;
 public class Product
{
	
	private String maSanPham;
	private double giaBan;
	public Product  (String maSanPham,double  giaBan) 
	{
	this.maSanPham=maSanPham;
	this.giaBan=giaBan;		
		
	}
	
	public String getMaSanPham ()
	{
		return maSanPham;
	}
	public double getGiaBan ()
	{
		return giaBan;
	}
	public double setGiaBan (double giaBan)
	{
		if (giaBan>0)
		{
			return this.giaBan;
		}
		System.out.println(" gia ko hop ly");
		return giaBan;
	}
	
	public static void main(String[] args) {
        Product product = new Product("ABAC", 500000);
        System.out.println("Mã sản phẩm là: " + product.getMaSanPham());
        System.out.println("Giá sản phẩm là: " + product.getGiaBan());

        // Test setting invalid price
        product.setGiaBan(-100);  // Should print "Gia không hợp lý"
    }

	}
	