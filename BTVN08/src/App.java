import java.util.ArrayList;
import java.util.Scanner;

import model.Customer;
import model.Oder;
import model.Product;

public class App {

    private static Scanner sc = new Scanner(System.in);

    private static ArrayList<Product> cuaHang = new ArrayList<>();
    private static ArrayList<Oder> donHang = new ArrayList<>();
    private static ArrayList<Customer> khachHang = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        int choice;

        do {
            System.out.println("1. Add new product to the Store.");
            System.out.println("2. Update price for a particular product.");
            System.out.println("3. A list of all available products in the Store.");
            System.out.println("4. Create a new Order.");
            System.out.println("5. Print information of an Order by Order ID.");
            System.out.println("6. Sort all products by product price as ascending.");
            System.out.println("7. Print information of all Customer (Name, Sex, Language).");
            System.out.println("8.. Quit.");
            System.out.println("Mời bạn chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addProduct();
                    break;

                case 2:
                    updatePrice();
                    break;
                case 3:
                    allProductInStore();
                    break;
                case 4:
                    createOder();
                    break;
                case 5:
                    printInfo();
                    break;
                case 6:
                    sortPrice();
                    break;
                    case 7: 
                    printInfoKh();
                    break;
                    case 8:
                    System.out.println("Tạm Biệt");

                default:
                    System.out.println("Vui lòng nhập từ 1-8.");
                    break;
            }

        } while (choice != 8);
    }

    public static void addProduct() {
        System.out.println("Mời bạn nhập mã ID: ");
        String id = sc.nextLine();
        System.out.println("Mời bạn nhập tên: ");
        String name = sc.nextLine();
        System.out.println("Mời bạn nhập giá sản phẩm: ");
        double priceP = Double.parseDouble(sc.nextLine());
        Product sanPhamProduct = new Product(id, name, priceP);
        cuaHang.add(sanPhamProduct);
        System.out.println("Thêm Thành Công.");
        for (Product product : cuaHang) {
            System.out.println(product);

        }

    }

    public static void updatePrice() {
        for (Product product : cuaHang) {
            System.out.println(product);
        }
        System.out.println("Mời bạn nhập id sản phẩm cần thay đổi giá: ");
        String idSet = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < cuaHang.size(); i++) {
            if (idSet.equals(cuaHang.get(i).getId())) {
                System.out.println("Mời bạn nhập giá thay đổi: ");
                Double giaThayDoi = Double.parseDouble(sc.nextLine());
                cuaHang.get(i).setPrice(giaThayDoi);
                found = true;
                System.out.println("Giá Sản Phẩm được thay đổi.");
                break;
            }

        }
        if (found == false)
            System.out.println("Sản Phẩm không tồn tại.");
    }

    public static void allProductInStore() {
        for (Product product : cuaHang) {
            System.out.println(product);
        }
    }

    public static Customer addKh() {
        System.out.println("Mời bạn nhập tên: ");
        String name = sc.nextLine();
        System.out.println("Mời bạn nhập tuổi: ");
        String age = sc.nextLine();
        System.out.println("Mời bạn nhập giới tính: ");
        String sex = sc.nextLine();
        System.out.println("Mời bạn nhập quốc tịch: ");
        String country = sc.nextLine();

        Customer khachCustomer = new Customer(name, age, sex, country);
        khachHang.add(khachCustomer);
        System.out.println("Thêm khách hàng thành công.");
        return khachCustomer;

    }

    public static Product searchSanPham(Product tn) {
        for (Product tungsanpham : cuaHang) {
            if (tungsanpham.getId().compareTo(tn.getId()) == 0) {
                System.out.println("Thêm Thành Công");
                return tungsanpham;

            }
        }
        System.out.println("Không tồn tại spham");
        return null;
    }

    public static void createOder() {

        System.out.println("Mời bạn nhập mã OderID: ");
        String OdId = sc.nextLine();
        System.out.println("Mời bạn nhập ngày Oder: ");
        String date = sc.nextLine();
        Customer khachhang = addKh();
        int x = 1;
        ArrayList<Product> listsanPhamDuocChon = new ArrayList<>();
        do {
            System.out.println("Sản phẩm khách hàng chọn: ");
            String id = sc.nextLine();
            Product sanphamduocchon = new Product(id, null, 0);
            sanphamduocchon = searchSanPham(sanphamduocchon);
            listsanPhamDuocChon.add(sanphamduocchon);
            System.out.println("Nhập 1 để chọn thêm sản phẩm, Nhập 0 để kết thúc");
            x = Integer.parseInt(sc.nextLine());

        } while (x != 0);
        Oder thongtindonhang = new Oder(OdId, date, khachhang, listsanPhamDuocChon);
        donHang.add(thongtindonhang);

    }

    public static void printInfo() {
        System.out.println("Mời bạn nhập ID đơn hàng: ");
        String iddonhang = sc.nextLine();
        for (int i = 0; i < donHang.size(); i++) {
            if (donHang.get(i).getOderId().compareTo(iddonhang) == 0) {
                System.out.println(donHang.toString());
            } else
                System.out.println("Không tồn tại ID");
        }
    }

    public static void sortPrice() {
        Product temp = new Product(null, null, 0);
        for (int i = 0; i < cuaHang.size() - 1; i++) {
            for (int j = i + 1; j < cuaHang.size(); j++) {
                int t = cuaHang.get(i).compareTo(cuaHang.get(j));
                if (t > 0) {
                    temp = cuaHang.get(i);
                    cuaHang.set(i, cuaHang.get(j));
                    cuaHang.set(j, temp);

                }
            }
        }
        System.out.println("Sắp xếp giá tăng dần thành công.");
    }
    public static void printInfoKh(){
        for (Customer kHCustomer : khachHang) {
            System.out.println(kHCustomer.toString());
        }
    }

}
