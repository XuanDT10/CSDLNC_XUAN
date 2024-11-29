ddddddddd
package view;

import java.awt.EventQueue;
import model.Product;
import model.ProductService;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ProductViewGUI1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtProductId;
    private JTextField txtPrice;
    private JLabel lblMessage;
    private JTextArea txtAreaProducts; // Declare a JTextArea for displaying products
	private Product product;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProductViewGUI1 frame = new ProductViewGUI1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ProductViewGUI1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // Save Button
        JButton btnSave = new JButton("Save");
        btnSave.setBounds(196, 93, 89, 23);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveProduct();
            }
        });
        contentPane.add(btnSave);
        
        // Product ID Label and TextField
        JLabel lblProductId = new JLabel("Mã Sản Phẩm");
        lblProductId.setBounds(84, 14, 67, 14);
        contentPane.add(lblProductId);
        
        txtProductId = new JTextField();
        txtProductId.setBounds(186, 11, 96, 20);
        contentPane.add(txtProductId);
        txtProductId.setColumns(10);
        
        // Price Label and TextField
        JLabel lblPrice = new JLabel("Giá bán");
        lblPrice.setBounds(84, 55, 49, 14);
        contentPane.add(lblPrice);
        
        txtPrice = new JTextField();
        txtPrice.setBounds(186, 52, 96, 20);
        contentPane.add(txtPrice);
        txtPrice.setColumns(10);

        // Message Label
        lblMessage = new JLabel("");
        lblMessage.setBounds(84, 160, 300, 14);
        contentPane.add(lblMessage);

        // JTextArea for displaying all products
        txtAreaProducts = new JTextArea();
        txtAreaProducts.setBounds(84, 180, 300, 70);
        txtAreaProducts.setEditable(false);  // Make it non-editable
        contentPane.add(txtAreaProducts);
        
        // Display Button
        JButton btnDisplay = new JButton("Display");
        btnDisplay.setBounds(186, 127, 89, 23);
        btnDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                displayAllProducts();
            }
        });
        contentPane.add(btnDisplay);
    }

    // Save the product to the database
    private void saveProduct() {
        String productID = txtProductId.getText();
        String priceStr = txtPrice.getText();
        
        if (!productID.isEmpty() && !priceStr.isEmpty()) {
            try {
                double price = Double.parseDouble(priceStr);
                Product product = new Product(productID, price);
                ProductService.saveProductToDB(product);  // Save to DB4o
                lblMessage.setText("Sản phẩm đã được lưu!");
            } catch (NumberFormatException ex) {
                lblMessage.setText("Vui lòng nhập giá hợp lệ.");
            }
        } else {
            lblMessage.setText("Vui lòng nhập đầy đủ thông tin.");
        }
    }

    // Display all products in the JTextArea
    private void displayAllProducts() {
    
    	 lblMessage.setText("du lieu hien thi nhu sau");

    	 if (ProductService.hasDataInDB()) {
    		    System.out.println("Cơ sở dữ liệu có dữ liệu.");
    		} else {
    		    System.out.println("Cơ sở dữ liệu không có dữ liệu.");
    		}
    }
     
  	}
      

   
