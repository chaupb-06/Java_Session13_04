package bt04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("******************* MENU QUẢN LÝ ĐƠN HÀNG ********************");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Sửa đơn hàng");
            System.out.println("3. Xóa đơn hàng");
            System.out.println("4. Hiển thị danh sách đơn hàng");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    String id1;
                    do {
                        System.out.println("Nhập mã đơn hàng:");
                        id1 = sc.nextLine();
                        if (id1.isEmpty()) {
                            System.out.println("Vui lòng không để trống !");
                        }
                    }while (id1.isEmpty());
                    if (manager.isExist(id1)) {
                        System.out.println("Đơn hàng đã tồn tại!");
                        break;
                    }
                    String name1;
                    do {
                        System.out.println("Nhập tên khách hàng:");
                        name1 = sc.nextLine();
                        if (name1.isEmpty()) {
                            System.out.println("Vui lòng không để trống !");
                        }
                    }while (name1.isEmpty());
                    manager.add(new Order(id1, name1));
                    System.out.println("Đơn hàng đã được thêm thành công.");
                    break;
                case 2:
                    for (int i = 0; i < manager.list.size(); i++) {
                        System.out.println(i+1 + ". Mã đơn hàng: " + manager.list.get(i).getOrderId() + ", Tên khách hàng: " + manager.list.get(i).getCustomerName());
                    }
                    String id2;
                    do {
                        System.out.println("Nhập mã đơn hàng cần sửa:");
                        id2 = sc.nextLine();
                        if (id2.isEmpty()) {
                            System.out.println("Vui lòng không để trống !");
                        }
                    }while (id2.isEmpty());
                    if (!manager.isExist(id2)) {
                        System.out.println("Đơn hàng không tồn tại!");
                        break;
                    }
                    String name2;
                    do {
                        System.out.println("Nhập tên khách hàng mới:");
                        name2 = sc.nextLine();
                        if (name2.isEmpty()) {
                            System.out.println("Vui lòng không để trống !");
                        }
                    }while (name2.isEmpty());
                    for (int i = 0; i < manager.list.size(); i++) {
                        if (manager.list.get(i).getOrderId().equals(id2)) {
                            manager.update(i, new Order(id2, name2));
                            System.out.println("Đơn hàng đã được sửa thành công.");
                            break;
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < manager.list.size(); i++) {
                        System.out.println(i+1 + ". Mã đơn hàng: " + manager.list.get(i).getOrderId() + ", Tên khách hàng: " + manager.list.get(i).getCustomerName());
                    }
                    String id3;
                    do {
                        System.out.println("Nhập mã đơn hàng cần xóa:");
                        id3 = sc.nextLine();
                        if (id3.isEmpty()) {
                            System.out.println("Vui lòng không để trống !");
                        }
                    }while (id3.isEmpty());
                    if (!manager.isExist(id3)) {
                        System.out.println("Đơn hàng không tồn tại!");
                        break;
                    }
                    for (int i = 0; i < manager.list.size(); i++) {
                        if (manager.list.get(i).getOrderId().equals(id3)) {
                            manager.delete(i);
                            System.out.println("Đơn hàng đã được xóa thành công.");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Order List:");
                    manager.display();
                    break;
                case 5:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
