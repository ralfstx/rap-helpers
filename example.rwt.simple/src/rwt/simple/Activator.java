/*******************************************************************************
 * Copyright (c) 2012 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    EclipseSource - initial implementation
 ******************************************************************************/
package rwt.simple;

import org.eclipse.rap.rwt.application.ApplicationConfiguration;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {

  private ServiceRegistration<?> registration;

  @Override
  public void start( BundleContext bundleContext ) throws Exception {
    ApplicationConfiguration configuration = new SimpleConfiguration();
    registration = bundleContext.registerService( ApplicationConfiguration.class.getName(),
                                                  configuration,
                                                  null );
  }

  @Override
  public void stop( BundleContext bundleContext ) throws Exception {
    registration.unregister();
  }
}
