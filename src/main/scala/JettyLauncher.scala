import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.{DefaultServlet, ServletContextHandler}

object JettyLauncher {
  def main(args: Array[String]) {
    val server = new Server(8080)
    val context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS)

    context.addFilter(classOf[CiderEndpointFilter], "/*", 0)
    context.addServlet(classOf[DefaultServlet], "/");
    context.setResourceBase("src/main/webapp")

    server.start
    server.join
  }

}