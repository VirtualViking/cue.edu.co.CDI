package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(value="/test")
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        resp.setContentType("text/html");
        String metodoHttp = req.getMethod();
        String requestUri = req.getRequestURI();
        String requestUrl = req.getRequestURL().toString();
        String contexPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String ipCliente = req.getRemoteAddr();
        String ip = req.getLocalAddr();
        int port = req.getLocalPort();
        String scheme = req.getScheme();
        String host = req.getHeader("host");
        String url = scheme + "://" + host + contexPath + servletPath;
        String url2 = scheme + "://" + ip + ":" + port + contexPath + servletPath;
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>"); /*informa al navegador qué versión de HTML (o XML) se usó para escribir el documento.
            Doctype es una declaración no una etiqueta. Además, podemos referirnos a ella como "document type declaration" */
            
            out.println("<html>"); /* es el código que se utiliza para estructurar 
            y desplegar una página web y sus contenidos*/
            
            out.println(" <head>"); /*provee información general
            acerca del documento, incluyendo su título y enlaces a scripts y hojas de estilos*/
            out.println(" <meta charset=\"UTF-8\">");

            out.println(" <title> Cabeceras HTTP Request</title>"); /*El elemento <title> HTML define el título del documento
            que se muestra en un browser la barra de título o la pestaña de una página.*/

            out.println(" </head>"); /*Indica la parte del cuerpo del contenido de un documento HTML. Es una etiqueta esencial
            para cualquier documento ya que indica donde empieza el contenido visible del documento.*/
            out.println(" <body>");

            out.println(" <h1> Cabeceras HTTP Request!</h1>"); /*Una etiqueta H1 es un encabezado HTML
            que se utiliza para marcar el tema principal de una página.*/

            out.println("<ul>"); /*ul de "unordered list" -lista no ordenada . crea una lista no ordenada.*/

            out.println("<li>metodo http: " + metodoHttp + "</li>"); /*Dentro de las listas, los elementos se identifican
            con la etiqueta LI.*/

            out.println("<li>request uri: " + requestUri + "</li>"); /* proporcionan un medio para localizar
            y recuperar recursos de información en una red*/

            out.println("<li>request url: " + requestUrl + "</li>");

            out.println("<li>context path: " + contexPath + "</li>"); /*El server. contextPath establece la ruta contexto
             para acceso a la aplicación, desde un navegador*/

            out.println("<li>servlet path: " + servletPath + "</li>"); /* (ruta del servlet) se refiere a la parte de la
            URL que identifica el servlet específico que manejará la solicitud dentro del contexto de la aplicación web.*/

            out.println("<li>ip local: " + ip + "</li>"); /*Una dirección IP es una dirección única que identifica a un dispositivo
            en Internet o en una red local. IP significa “protocolo de Internet”*/

            out.println("<li>ip cliente: " + ipCliente + "</li>"); /*Una direccion ip cliente describen solo la computadora que se utiliza,
            no el usuario . Si varios usuarios comparten la misma computadora, serán indistinguibles.*/

            out.println("<li>puerto local: " + port + "</li>");
            out.println("<li>scheme: " + scheme + "</li>");
            out.println("<li>host: " + host + "</li>"); /*Un hosting es un servicio de alojamiento para sitios web. En lugar de alojar personas,
            el hosting web aloja los contenidos de tu web y tu correo electrónico para que puedan ser visitados */

            out.println("<li>url: " + url + "</li>"); /*las URL es uno de los conceptos claves de la Web. Es el mecanismo usado por los navegadores
            para obtener cualquier recurso publicado en la web.*/
            out.println("<li>url2: " + url2 + "</li>");

            Enumeration<String> headerNames = req.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String cabecera = headerNames.nextElement();
                out.println("<li>"+ cabecera + ": " + req.getHeader(cabecera) + "</li>");
            }
            out.println("</ul>");
            out.println(" </body>");
            out.println("</html>");
        }
    }
}
