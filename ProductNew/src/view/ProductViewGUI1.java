package view;

import controller.Controller;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductView extends JFrame {
    private static final long serialVersionUID = 1L;
    private Controller controller;
    
    // Các trường nhập liệu
    private JTextField txtMaSanPham;
    private JTextField txtTenSanPham;
    private JTextField txtLoaiSanPham;
    private JTextField txtHangSanXuat;
    private JTextField txtGiaNhap;
    private JTextField txtGiaBan;
    private JTextField txtTonKho;
    private JTextField txtTrangThai;
    private JTextField txtChuThich;
    private JTextArea txtAreaDisplay;

    // Constructor
    public ProductView() {
        controller = new Controller();

        // Thiết lập giao diện
        setTitle("Product Manager");
        setSize(600, 600); // Tăng kích thước cửa sổ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true); // Cho phép thay đổi kích thước cửa sổ

        // Panel chính để chứa các thành phần
        JPanel panel = new JPanel();
        panel.setLayout(null); // Dùng Absolute Layout

        // Mã sản phẩm
        JLabel lblMaSanPham = new JLabel("Mã sản phẩm:");
        lblMaSanPham.setBounds(50, 30, 120, 30);
        panel.add(lblMaSanPham);

        txtMaSanPham = new JTextField(20);
        txtMaSanPham.setBounds(180, 30, 200, 30);
        panel.add(txtMaSanPham);

        // Tên sản phẩm
        JLabel lblTenSanPham = new JLabel("Tên sản phẩm:");
        lblTenSanPham.setBounds(50, 70, 120, 30);
        panel.add(lblTenSanPham);

        txtTenSanPham = new JTextField(20);
        txtTenSanPham.setBounds(180, 70, 200, 30);
        panel.add(txtTenSanPham);

        // Loại sản phẩm
        JLabel lblLoaiSanPham = new JLabel("Loại sản phẩm:");
        lblLoaiSanPham.setBounds(50, 110, 120, 30);
        panel.add(lblLoaiSanPham);

        txtLoaiSanPham = new JTextField(20);
        txtLoaiSanPham.setBounds(180, 110, 200, 30);
        panel.add(txtLoaiSanPham);

        // Hãng sản xuất
        JLabel lblHangSanXuat = new JLabel("Hãng sản xuất:");
        lblHangSanXuat.setBounds(50, 150, 120, 30);
        panel.add(lblHangSanXuat);

        txtHangSanXuat = new JTextField(20);
        txtHangSanXuat.setBounds(180, 150, 200, 30);
        panel.add(txtHangSanXuat);

        // Giá nhập
        JLabel lblGiaNhap = new JLabel("Giá nhập:");
        lblGiaNhap.setBounds(50, 190, 120, 30);
        panel.add(lblGiaNhap);

        txtGiaNhap = new JTextField(20);
        txtGiaNhap.setBounds(180, 190, 200, 30);
        panel.add(txtGiaNhap);

        // Giá bán
        JLabel lblGiaBan = new JLabel("Giá bán:");
        lblGiaBan.setBounds(50, 230, 120, 30);
        panel.add(lblGiaBan);

        txtGiaBan = new JTextField(20);
        txtGiaBan.setBounds(180, 230, 200, 30);
        panel.add(txtGiaBan);

        // Tồn kho
        JLabel lblTonKho = new JLabel("Tồn kho:");
        lblTonKho.setBounds(50, 270, 120, 30);
        panel.add(lblTonKho);

        txtTonKho = new JTextField(20);
        txtTonKho.setBounds(180, 270, 200, 30);
        panel.add(txtTonKho);

        // Trạng thái
        JLabel lblTrangThai = new JLabel("Trạng thái:");
        lblTrangThai.setBounds(50, 310, 120, 30);
        panel.add(lblTrangThai);

        txtTrangThai = new JTextField(20);
        txtTrangThai.setBounds(180, 310, 200, 30);
        panel.add(txtTrangThai);

        // Chú thích
        JLabel lblChuThich = new JLabel("Chú thích:");
        lblChuThich.setBounds(50, 350, 120, 30);
        panel.add(lblChuThich);

        txtChuThich = new JTextField(20);
        txtChuThich.setBounds(180, 350, 200, 30);
        panel.add(txtChuThich);

        // Nút lưu sản phẩm
        JButton btnSave = new JButton("Save");
        btnSave.setBounds(135, 390, 120, 30);
        btnSave.setBackground(new Color(0, 123, 255)); // Màu xanh
        btnSave.setForeground(Color.WHITE); // Màu chữ trắng
        btnSave.setFocusPainted(false);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProduct();
            }
        });
        panel.add(btnSave);

        // Nút hiển thị tất cả sản phẩm
        JButton btnDisplay = new JButton("Display");
        btnDisplay.setBounds(260, 390, 120, 30);
        btnDisplay.setBackground(new Color(40, 167, 69)); // Màu xanh lá
        btnDisplay.setForeground(Color.WHITE); // Màu chữ trắng
        btnDisplay.setFocusPainted(false);
        btnDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayProducts();
            }
        });
        panel.add(btnDisplay);

        // Nút xóa tất cả dữ liệu
        JButton btnDeleteData = new JButton("Delete Data");
        btnDeleteData.setBounds(437, 83, 120, 30);
        btnDeleteData.setBackground(new Color(220, 53, 69)); // Màu đỏ
        btnDeleteData.setForeground(Color.WHITE); // Màu chữ trắng
        btnDeleteData.setFocusPainted(false);
        btnDeleteData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAllData();
            }
        });
        panel.add(btnDeleteData);

        // Nút đóng ứng dụng
        JButton btnClose = new JButton("Close");
        btnClose.setBounds(437, 30, 120, 30);
        btnClose.setBackground(new Color(220, 53, 69)); // Màu đỏ
        btnClose.setForeground(Color.WHITE); // Màu chữ trắng
        btnClose.setFocusPainted(false);
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeApplication();
            }
        });
        panel.add(btnClose);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(57, 431, 500, 100);
        panel.add(scrollPane);

        // Thêm panel vào JFrame
        getContentPane().add(panel);
        
                // Hiển thị danh sách sản phẩm
                txtAreaDisplay = new JTextArea(10, 30);
                txtAreaDisplay.setBounds(60, 425, 481, 184);
                panel.add(txtAreaDisplay);
                txtAreaDisplay.setEditable(false);
    }

    // Phương thức lưu sản phẩm
    private void saveProduct() {
        // Code lưu sản phẩm ở đây
    }

    // Phương thức hiển thị tất cả sản phẩm
    private void displayProducts() {
        List<Product> products = controller.getAllProducts();
        txtAreaDisplay.setText(""); // Clear trước khi hiển thị mới
        if (products.isEmpty()) {
            txtAreaDisplay.append("Không có sản phẩm nào trong cơ sở dữ liệu.\n");
        } else {
            for (Product product : products) {
                txtAreaDisplay.append(product + "\n");
            }
        }
    }

    // Phương thức xóa tất cả dữ liệu
    private void deleteAllData() {
        int confirmation = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa tất cả dữ liệu?", 
                                                         "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            controller.deleteAllProducts();
            JOptionPane.showMessageDialog(this, "Tất cả sản phẩm đã được xóa!");
            txtAreaDisplay.setText(""); // Clear vùng hiển thị
        }
    }

    // Phương thức đóng ứng dụng
    private void closeApplication() {
        System.exit(0); // Đóng ứng dụng
    }
}
