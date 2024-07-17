package lesson4.task2.service;

import lesson4.task2.exception.CustomerNotFoundException;
import lesson4.task2.exception.InvalidQuantityException;
import lesson4.task2.exception.ProductNotFoundException;
import lesson4.task2.model.Customer;
import lesson4.task2.model.Order;
import lesson4.task2.model.Product;

public class OrderService {
    private Customer[] customers;
    private Product[] products;
    private Order[] orders;
    private int orderCount;

    public OrderService(Customer[] customers, Product[] products) {
        this.customers = customers;
        this.products = products;
        this.orders = new Order[10];
    }

    public Order makePurchase(String customerName, String productName, int quantity)
            throws CustomerNotFoundException, ProductNotFoundException, InvalidQuantityException {
        if (quantity < 0) {
            throw new InvalidQuantityException("Quantity cannot be negative.");
        }

        Customer customer = findCustomerByName(customerName);
        Product product = findProductByName(productName);

        Order order = new Order(customer, product, quantity);
        orders[orderCount++] = order;
        return order;
    }

    private Customer findCustomerByName(String name) throws CustomerNotFoundException {
        for (Customer c : customers) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        throw new CustomerNotFoundException("Customer not found: " + name);
    }

    private Product findProductByName(String name) throws ProductNotFoundException {
        for (Product p : products) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        throw new ProductNotFoundException("Product not found: " + name);
    }

    public int getOrderCount() {
        return orderCount;
    }
}
