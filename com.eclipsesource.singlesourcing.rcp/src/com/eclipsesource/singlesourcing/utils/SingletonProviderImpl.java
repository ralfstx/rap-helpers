/*******************************************************************************
 * Copyright (c) 2010, 2013 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     EclipseSource - initial API and implementation
 ******************************************************************************/
package com.eclipsesource.singlesourcing.utils;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;


public class SingletonProviderImpl extends SingletonProvider {

  private final static Class<?>[] EMPTY_PARAMS = new Class[ 0 ];

  private final Map<Class<?>, Object> instances = new HashMap<Class<?>, Object>();

  @Override
  @SuppressWarnings("unchecked")
  <T> T getSessionInstanceInternal( Class<T> type ) {
    T instance;
    synchronized( instances ) {
      instance = ( T )instances.get( type );
      if( instance == null ) {
        instance = instantiate( type );
        instances.put( type, instance );
      }
    }
    return instance;
  }

  private <T> T instantiate( Class<T> type ) {
    T result;
    try {
      Constructor<T> constructor = type.getDeclaredConstructor( EMPTY_PARAMS );
      if( constructor.isAccessible() ) {
        result = type.newInstance();
      } else {
        constructor.setAccessible( true );
        result = constructor.newInstance( ( Object[] )null );
      }
    } catch( Exception e ) {
      throw new RuntimeException( "Could not instantiate " + type.getName() );
    }
    return result;
  }

}
