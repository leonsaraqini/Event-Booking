package mk.ukim.finki.mk.lab.web;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.mk.lab.service.EventBookingService;
import mk.ukim.finki.mk.lab.service.EventService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(urlPatterns = "/servlet/events")
public class EventListServlet extends HttpServlet {
    private final EventService eventService;
    private final EventBookingService eventBookingService;
    private final SpringTemplateEngine springTemplateEngine;

    public EventListServlet(EventService eventService, EventBookingService eventBookingService, SpringTemplateEngine springTemplateEngine) {
        this.eventService = eventService;
        this.eventBookingService = eventBookingService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        String text = req.getParameter("text");

        if(text == null)
            context.setVariable("events", eventService.listAll());
        else
//            context.setVariable("events", eventService.searchEvents(text));

        context.setVariable("categories", eventService.listCategories());
        springTemplateEngine.process("listEvents.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String input = req.getParameter("event");
        String numOfTickets = req.getParameter("numTickets");

        if(input != null && numOfTickets != null)
            eventBookingService.addBooking(input,"Leon", req.getRemoteAddr(), Long.parseLong(numOfTickets));

        resp.sendRedirect("/eventBooking");
    }
}
