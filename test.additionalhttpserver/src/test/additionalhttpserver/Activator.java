package test.additionalhttpserver;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.equinox.http.jetty.JettyConfigurator;
import org.eclipse.equinox.http.jetty.JettyConstants;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


public class Activator implements BundleActivator {

  private static final int CUSTOM_PORT = 10001;

  public void start( BundleContext context ) throws Exception {
    startHttpServer( CUSTOM_PORT );
  }

  public void stop( BundleContext context ) throws Exception {
    stopHttpServer( CUSTOM_PORT );
  }

  private static void startHttpServer( int port ) throws Exception {
    Dictionary< String, Object > settings = new Hashtable< String, Object >( 3 );
    settings.put( JettyConstants.HTTP_ENABLED, Boolean.TRUE );
    settings.put( JettyConstants.HTTP_PORT, Integer.valueOf( port ) );
    settings.put( JettyConstants.OTHER_INFO, "custom-jetty" );
    JettyConfigurator.startServer( getId( port ), settings );
  }

  private static void stopHttpServer( int port ) throws Exception {
    JettyConfigurator.stopServer( getId( port ) );
  }

  private static String getId( int port ) {
    return Activator.class.getName() + "-" + port;
  }
}
