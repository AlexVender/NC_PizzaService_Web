package unc.group16.controller.servlets;

import unc.group16.controller.interfaces.Manager;
import unc.group16.controller.managers.oracle.OracleManagerFactory;
import unc.group16.controller.managers.xml.utils.EntitiesFactory;
import unc.group16.controller.managers.xml.utils.XmlParser;
import unc.group16.data.interfaces.TableRecord;
import unc.group16.data.interfaces.TableRecords;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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

        response.setContentType("application/octet-stream");


        Map<String, String> messages = new HashMap<>();
        try{
            request.setAttribute("messages", messages);
            messages.put("success", "Download started");


            OracleManagerFactory factory = new OracleManagerFactory();
            Manager manager = factory.getManager(request.getParameter("table"));
            EntitiesFactory entitiesFactory = new EntitiesFactory();
            TableRecord[] selectedArr = manager.readAll();
            TableRecords tableRecords = entitiesFactory.getManager(request.getParameter("table"), selectedArr);
            XmlParser xmlParser = new XmlParser();
            File file = xmlParser.marshal(tableRecords);

            response.setHeader("Content-Disposition","inline; filename=\"" + file.getName() + "\"");

            FileInputStream fileInputStream = new FileInputStream(file.getPath());
            PrintWriter out = response.getWriter();
            int i;
            while ((i = fileInputStream.read()) != -1) {
                out.write(i);
            }
            fileInputStream.close();
            out.close();

        }
        catch (Exception e){
            messages.put("error","Error during downloading: " + e);
        }


        //request.getRequestDispatcher("/export.jsp").forward(request, response);
    }
}
