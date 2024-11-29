package model;
import java.util.ArrayList;
import java.util.List;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.query.Query;

public class ProductService {

    private static final String DB_FILE_PATH = "ProductDB";  // Đường dẫn tới cơ sở dữ liệu DB4o

    // Lưu sản phẩm vào cơ sở dữ liệu DB4o
    public static void saveProductToDB(Product product) {
        ObjectContainer db = null;
        try {
            // Mở kết nối đến cơ sở dữ liệu DB4o
            db = Db4o.openFile(DB_FILE_PATH);
            
            // Kiểm tra xem cơ sở dữ liệu có mở thành công không
            if (db == null) {
                System.out.println("Không thể mở kết nối đến cơ sở dữ liệu.");
                return;
            }
            
            // Lưu sản phẩm vào cơ sở dữ liệu
            db.store(product);
            
            // Commit để lưu các thay đổi vào cơ sở dữ liệu
            db.commit();  // Đảm bảo dữ liệu được ghi vào DB

            System.out.println("Sản phẩm đã được lưu thành công.");
            System.out.println("DB file path: " + new java.io.File(DB_FILE_PATH).getAbsolutePath());
        } catch (Exception e) {
            // Log lỗi nếu có
            System.err.println("Lỗi khi lưu sản phẩm vào cơ sở dữ liệu.");
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng kết nối sau khi thao tác xong
            if (db != null) {
                db.close();
            }
        }
    }


    // Lấy tất cả các sản phẩm từ cơ sở dữ liệu DB4o
    public static List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        ObjectContainer db = null;
        
        try {
            // Mở kết nối với cơ sở dữ liệu DB4o
            db = Db4o.openFile(DB_FILE_PATH);
            
            if (db == null) {
                System.out.println("Không thể mở kết nối đến cơ sở dữ liệu.");
                return products;  // Trả về danh sách rỗng nếu không mở được kết nối
            }
            
            // Tạo truy vấn và tìm tất cả sản phẩm
            Query query = db.query();
            query.constrain(Product.class);
            
            // Thực thi truy vấn và lấy danh sách sản phẩm
            products = query.execute();
            
            // Nếu không có sản phẩm, trả về danh sách rỗng (tránh null)
            if (products == null) {
                products = new ArrayList<>();
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi truy xuất sản phẩm từ cơ sở dữ liệu.");
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();  // Đảm bảo đóng kết nối sau khi thao tác xong
            }
        }
        
        return products;
    }


	public static boolean hasDataInDB() {
		// TODO Auto-generated method stub
		return false;
	}

}
