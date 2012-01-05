package com.whiterabbit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
 
import java.io.IOException;
 
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
 
public class WebServerBootstrap extends AbstractHandler {
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) 
    		throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        response.getWriter().println("<h1>Hello World</h1>" + target);
    }
 
    public static void main(String[] args) throws Exception {
    	String portString = System.getenv("PORT");
    	int port = 8080;
    	if(portString != null) {
    		port = Integer.valueOf(portString);
    	}
        Server server = new Server(port);
        server.setHandler(new WebServerBootstrap());
 
        server.start();
        server.join();
    }
}