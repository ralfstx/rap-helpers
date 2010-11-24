/*******************************************************************************
 * Copyright (c) 2010 EclipseSource
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     EclipseSource - initial API and implementation
 ******************************************************************************/
package com.eclipsesource.singlesourcing.utils;


public abstract class SessionSingletonProvider {

  private static final SessionSingletonProvider IMPL
    = ( SessionSingletonProvider )ImplementationLoader.createInstance( SessionSingletonProvider.class );

  public static <T> T getInstance( Class<T> type ) {
    return IMPL.getInstanceInternal( type );
  }

  abstract <T> T getInstanceInternal( Class<T> type );
}
