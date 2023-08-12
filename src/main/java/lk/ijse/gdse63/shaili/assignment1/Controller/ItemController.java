package lk.ijse.gdse63.shaili.assignment1.Controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


import com.google.gson.Gson;
import lk.ijse.gdse63.shaili.assignment1.DTO.ItemDTO;
import lk.ijse.gdse63.shaili.assignment1.service.Custom.ItemService;
import lk.ijse.gdse63.shaili.assignment1.service.util.ServiceFactory;
import lk.ijse.gdse63.shaili.assignment1.service.util.ServiceTypes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ItemController extends HttpServlet {
    ItemService service = ServiceFactory.getService(ServiceTypes.ITEM_SERVICE);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        try {
            ItemDTO item = getItem(req);
            System.out.println(item);
            boolean add = service.add(item);
            if (add){
                resp.setStatus(HttpServletResponse.SC_OK);
            }
            System.out.println(item.getId());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)  {
        try{
            ItemDTO itemDTO = getItem(req);
            System.out.println(itemDTO);
            boolean update = service.update(itemDTO);
            System.out.println(update);
            if (update){
                resp.setStatus(HttpServletResponse.SC_OK);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        resp.setStatus(HttpServletResponse.SC_OK);
    }


    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp)  {
        System.out.println("Do Option Called");
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("Do Delete called");
        ItemDTO itemDTO = null;
        try {
            itemDTO = getItem(req);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(itemDTO);
        boolean delete = service.delete(itemDTO.getId());
        System.out.println(delete);
        if (delete) {
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }

    public ItemDTO getItem(HttpServletRequest req) throws IOException {
        BufferedReader reader = req.getReader();
        StringBuilder builder = new StringBuilder();
        String data;
        while ((data=reader.readLine())!=null){
            builder.append(data);
        }
        Gson gson = new Gson();
        return gson.fromJson(builder.toString(),ItemDTO.class);
    }




}
