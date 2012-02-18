/*******************************************************************************
 * Copyright (c) 2011, 2012 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    EclipseSource - initial implementation
 ******************************************************************************/
package rwt.simple;

import org.eclipse.rwt.application.ApplicationConfiguration;
import org.eclipse.rwt.application.ApplicationConfigurator;
import org.eclipse.rwt.branding.AbstractBranding;


public class SimpleConfigurator implements ApplicationConfigurator {

  public void configure( ApplicationConfiguration configuration ) {
    configuration.addEntryPoint( "/simple", SimpleEntryPoint.class );
    configuration.addBranding( new AbstractBranding() {
      @Override
      public String getServletName() {
        return "simple";
      }
      @Override
      public String getTitle() {
        return "Simple RWT Example";
      }
    } );
  }

}
