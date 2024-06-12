package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Order {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public Date moment;
    private OrderStatus status;
    private List<OrderItem> items = new ArrayList<OrderItem>();
    private Client client;

    public Order(){

    }

    public Order(Client client, Date moment, OrderStatus status) {
        this.client = client;
        this.moment = moment;
        this.status = status;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public Double valorTotal(){
        double soma = 0;
        for( OrderItem t : items){
            soma += t.subTotal();
        }
        return soma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data do pedido: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Status do pedido: ");
        sb.append(status + "\n");
        sb.append("Cliente: ");
        sb.append(client + "\n");
        sb.append("Itens do pedido:\n");
        for (OrderItem item : items) {
            sb.append(item + "\n");
        }
        sb.append("Preço Total: $");
        sb.append(String.format("%.2f", valorTotal()));
        return sb.toString();
    }
}
