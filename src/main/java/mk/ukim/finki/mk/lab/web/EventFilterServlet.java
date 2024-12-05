package mk.ukim.finki.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.mk.lab.service.EventService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(urlPatterns = "/eventFilter")
public class EventFilterServlet extends HttpServlet {
    private final EventService eventService;
    private final SpringTemplateEngine springTemplateEngine;

    public EventFilterServlet(EventService eventService, SpringTemplateEngine springTemplateEngine) {
        this.eventService = eventService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange exchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(exchange);

        String text = req.getParameter("categories");

//        if(text.contains("All")) {
//            context.setVariable("events", eventService.listAll());
//        }else{
//            context.setVariable("events", eventService.searchCategory(text));
//        }


        context.setVariable("categories", eventService.listCategories());
        springTemplateEngine.process("listEvents.html", context, resp.getWriter());
    }
}
