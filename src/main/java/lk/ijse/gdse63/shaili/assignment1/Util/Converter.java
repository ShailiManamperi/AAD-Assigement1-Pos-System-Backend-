package lk.ijse.gdse63.shaili.assignment1.Util;

import lk.ijse.gdse63.shaili.assignment1.DTO.CustomerDTO;
import lk.ijse.gdse63.shaili.assignment1.DTO.ItemDTO;
import lk.ijse.gdse63.shaili.assignment1.Entity.Customer;
import lk.ijse.gdse63.shaili.assignment1.Entity.Item;

public class Converter {
    public static ItemDTO fromItem(Item item){
        return new ItemDTO(item.getId(), item.getName(), item.getQty(), item.getPrice());
    }
    public static Item toItem(ItemDTO itemDTO){
        return new Item(itemDTO.getId(), itemDTO.getName(), itemDTO.getQty(), itemDTO.getPrice());
    }

    public static Customer toCustomer(CustomerDTO customerDTO){
        return new Customer(customerDTO.getId(),  customerDTO.getName(), customerDTO.getAddress(), customerDTO.getContact());
    }

    public static CustomerDTO fromCustomer(Customer customer){
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(), customer.getContact());
    }
}

