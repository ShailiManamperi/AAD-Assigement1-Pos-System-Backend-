package lk.ijse.gdse63.shaili.assignment1.Util;

import lk.ijse.gdse63.shaili.assignment1.DTO.ItemDTO;
import lk.ijse.gdse63.shaili.assignment1.Entity.Item;

public class Converter {
    public static ItemDTO fromItem(Item item){
        return new ItemDTO(item.getId(), item.getName(), item.getQty(), item.getPrice());
    }

    public static Item toItem(ItemDTO itemDTO){
        return new Item(itemDTO.getId(), itemDTO.getName(), itemDTO.getQty(), itemDTO.getPrice());
    }
}
