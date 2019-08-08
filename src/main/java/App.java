import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.Scanner;

import static java.lang.System.in;

public class App {
    public static void main(String[] args) {
        System.err.println("asd1");
        //ServerThread thread=new ServerThread();
        // thread.run();
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(8080);
        jettyServer.setHandler(context);
        ServletHolder jerseyServlet = context.addServlet(
                org.glassfish.jersey.servlet.ServletContainer.class, "/pic");
        jerseyServlet.setInitParameter(
                "jersey.config.server.provider.classnames",
                picgetter.class.getCanonicalName());
        try {
            jettyServer.start();
            // jettyServer.join();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //  jettyServer.destroy();
        }
        Scanner scanner = new Scanner(in);
        while (true) {
            System.err.println(scanner.next());
            if (scanner.next().equals("stop")) {
                jettyServer.destroy();
            }
        }
    }
}
