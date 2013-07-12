/*******************************************************************************
 * Copyright (c) 2010, 2013 EclipseSource
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    EclipseSource - initial API and implementation
 ******************************************************************************/
package com.eclipsesource.singlesourcing.utils;


public abstract class SingletonProvider {

  private static final SingletonProvider IMPL
    = ImplementationLoader.createInstance( SingletonProvider.class );

  public static <T> T getSessionInstance( Class<T> type ) {
    return IMPL.getSessionInstanceInternal( type );
  }

  abstract <T> T getSessionInstanceInternal( Class<T> type );

}
