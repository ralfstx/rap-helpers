package rwt.simple;

import org.eclipse.rwt.branding.AbstractBranding;
import org.eclipse.rwt.engine.Configurator;
import org.eclipse.rwt.engine.Context;


public class SimpleConfigurator implements Configurator {

  public void configure( Context context ) {
    context.addEntryPoint( "default", SimpleEntryPoint.class );
    context.addBranding( new AbstractBranding() {
      @Override
      public String getServletName() {
        return "rwt";
      }
    } );
  }

}
