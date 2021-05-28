package by.mazan.servlet;

import by.mazan.dataBase.DemoEntity;
import by.mazan.exception.DeleteException;
import by.mazan.service.DataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet("/data")
public class DataServlet extends HttpServlet {

    private final static Logger LOG = Logger.getLogger(DataServlet.class.getName());
    private final DataService dataService;

    public DataServlet() {
        dataService = new DataService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.println(dataService.getAllEntitiesForResponse());
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setName(req.getParameter("name"));
        demoEntity.setSpecialty(req.getParameter("specialty"));
        demoEntity.setSalary(Integer.parseInt(req.getParameter("salary")));
        try {
            dataService.addEntity(demoEntity);
            resp.sendRedirect(req.getContextPath() + "/form/infoPage.jsp");
        } catch (Exception e) {
            LOG.warning(e.getMessage());
            resp.setStatus(400);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        try {
            dataService.deleteEntity(id);
        } catch (DeleteException e) {
            LOG.warning(e.getMessage());
            resp.setStatus(400);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}