package unc.group16.controller.servlets;

import unc.group16.controller.interfaces.AbstractDatabaseManager;
import unc.group16.controller.managers.oracle.OracleDrinksManager;
import unc.group16.data.entity.Drink;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/export")
public class ExportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Preprocess request: we actually don't need to do any business stuff, so just display JSP.
        request.getRequestDispatcher("/export.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Postprocess request: gather and validate submitted data and display the result in the same JSP.

        Map<String, String> messages = new HashMap<>();
        try{
            request.setAttribute("messages", messages);
            messages.put("success", "Download started");
            String table = request.getParameter("table");

            //Как и что тут делать?
//            Creator[] creators = {new DrinksManagerCreator(), new ClientsManagerCreator()};
//            for (Creator creator: creators){
//                Создали
//                AbstractDatabaseManager<?> abstractDatabaseManager = creator.factoryMethod();
//            }


            //Пока что сделано только для Drink, будет переделано.
            OracleDrinksManager oracleDrinksManager = new OracleDrinksManager();
            Drink[] drinkRecords = oracleDrinksManager.readAll() ;
            for (Drink drinkRecord : drinkRecords) {
                System.out.println("ID: " + drinkRecord.getId());
                System.out.println("Volume: " + drinkRecord.getVolume());
                System.out.println("Price: " + drinkRecord.getPrice());
                System.out.println("Title: " + drinkRecord.getTitle());
                System.out.println("Description: " + drinkRecord.getDescription());
            }
            System.out.println(table);
        }
        catch (Exception e){
            messages.put("error","Error during downloading: " + e);
        }


        request.getRequestDispatcher("/export.jsp").forward(request, response);
    }


}
