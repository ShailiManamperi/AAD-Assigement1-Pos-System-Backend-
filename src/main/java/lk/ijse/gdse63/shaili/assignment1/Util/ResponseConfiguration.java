package lk.ijse.gdse63.shaili.assignment1.Util;


import lk.ijse.gdse63.shaili.assignment1.Response.Response;

public class ResponseConfiguration {
    private static ResponseConfiguration responseConfiguration;
    private static Response response;


    private ResponseConfiguration() {
        response = new Response();
    }

    public static ResponseConfiguration getInstance() {
        return responseConfiguration == null ? responseConfiguration = new ResponseConfiguration() : responseConfiguration;


    }

    public Response getResponse() {
        return response;
    }
}
