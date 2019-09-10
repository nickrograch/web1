package servlets;

import util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NewServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> pageVariables = createPageVariablesMap(request);

        String value = request.getParameter("value");
        //response.setContentType("text/html;charset=utf-8");

        if (value == null || value.isEmpty()){
            value = String.valueOf(0);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        else{
            int intValue = Integer.parseInt(value);
            intValue *= 2;
            value = String.valueOf(intValue);
            response.setStatus(HttpServletResponse.SC_OK);
        }

        pageVariables.put("value", value);

//        response.getOutputStream().print(value);
        response.getWriter().print(value);


    }


    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        return pageVariables;
    }
}
