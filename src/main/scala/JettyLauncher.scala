import org.eclipse.jetty.server.Server
import org.eclipse.jetty.webapp.WebAppContext

object JettyLauncher {
  def main(args: Array[String]) {
    val port = sys.env.get("PORT").map(_.toInt).getOrElse(8080)

    val server = new Server(port)
    val context = new WebAppContext()
    context setContextPath "/"
    context.setResourceBase("src/main/webapp")
    context.addEventListener(new org.scalatra.servlet.ScalatraListener)

    server.setHandler(context)

    server.start
    server.join
  }

}
