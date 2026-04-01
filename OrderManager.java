package bt04;

import java.util.ArrayList;

public class OrderManager implements Manage<Order>{
    ArrayList<Order> list = new ArrayList<>();

    @Override
    public void add(Order item) {
        list.add(item);
    }

    @Override
    public void update(int index, Order item) {
        list.set(index, item);
    }

    @Override
    public void delete(int index) {
        list.remove(index);
    }

    @Override
    public void display() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+1 + ". Order ID: " + list.get(i).getOrderId() + " | Customer: " + list.get(i).getCustomerName());
        }
    }
    @Override
    public boolean isExist(String id) {
        for (Order order : list) {
            if (order.getOrderId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}