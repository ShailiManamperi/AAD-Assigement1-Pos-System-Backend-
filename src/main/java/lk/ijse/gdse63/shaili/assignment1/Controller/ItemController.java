package lk.ijse.gdse63.shaili.assignment1.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lk.ijse.gdse63.shaili.assignment1.DTO.ItemDTO;
import lk.ijse.gdse63.shaili.assignment1.Dao.custom.impl.ItemDAOImpl;
import lk.ijse.gdse63.shaili.assignment1.Response.Response;
import lk.ijse.gdse63.shaili.assignment1.Util.GSONConfiguration;
import lk.ijse.gdse63.shaili.assignment1.Util.ResponseConfiguration;
import lk.ijse.gdse63.shaili.assignment1.service.Custom.impl.ItemServiceImpl;
import lk.ijse.gdse63.shaili.assignment1.service.util.ServiceFactory;
import lk.ijse.gdse63.shaili.assignment1.service.util.ServiceTypes;

@WebServlet(urlPatterns = {"/item-Controller"})
public class ItemController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemServiceImpl service = ServiceFactory.getService(ServiceTypes.ITEM_SERVICE);
        System.out.println("done1");
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }

        Jsonb jsonb = JsonbBuilder.create();
        ItemDTO item = jsonb.fromJson(req.getReader(), ItemDTO.class);
        System.out.println(item);
        if (service.add(item)) {
            /*Getting the error msg + status to an object.*/
            Response response = ResponseConfiguration.getInstance().getResponse();
            response.setStatus(true);
            /*Converting it to a JSON object and sending as the response.*/
//            resp.getWriter().println(GSONConfiguration.getInstance().getGSON().toJson(response));
            resp.setStatus(HttpServletResponse.SC_CREATED);
            //the created json is sent to frontend
            resp.setContentType("application/json");
            jsonb.toJson(item,resp.getWriter());
        } else {
            /*Getting the error msg + status to an object.*/
            Response response = ResponseConfiguration.getInstance().getResponse();
            response.setResponseMessage(ItemDAOImpl.getError_Info());
            response.setStatus(false);
            /*Converting it to a JSON object and sending as the response.*/
//            resp.getWriter().println(GSONConfiguration.getInstance().getGSON().toJson(response));
            resp.setStatus(HttpServletResponse.SC_CREATED);
            //the created json is sent to frontend
            resp.setContentType("application/json");
            jsonb.toJson(item,resp.getWriter());
        }



    }

}
