/*******************************************************************************
 * Copyright (c) 2011 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    EclipseSource - initial implementation
 ******************************************************************************/
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
