/*******************************************************************************
 * Copyright (c) 2007, 2013 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    EclipseSource - initial API and implementation
 ******************************************************************************/
package com.eclipsesource.singlesourcing.utils;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


public class NLSHelperImpl extends NLSHelper {

  private final static Map<ResourceBundle, Object> map = new HashMap<ResourceBundle, Object>();

  @Override
  public <T> T getLocalizedInstanceInternal( String bundleName, Class<T> clazz ) {
    ClassLoader loader = clazz.getClassLoader();
    ResourceBundle bundle = ResourceBundle.getBundle( bundleName, Locale.getDefault(), loader );
    return internalGet( bundle, clazz );
  }

  @SuppressWarnings( "unchecked" )
  private static <T> T internalGet( ResourceBundle bundle, Class<T> clazz ) {
    T object;
    synchronized( map ) {
      object = ( T )map.get( bundle );
      if( object == null ) {
        object = newInstance( clazz );
        assignFields( clazz, object, bundle );
        map.put( bundle, object );
      }
    }
    return object;
  }

  private static <T> void assignFields( Class<T> clazz, T object, ResourceBundle bundle ) {
    Field[] fields = clazz.getDeclaredFields();
    for( int i = 0; i < fields.length; i++ ) {
      Field field = fields[ i ];
      try {
        if( String.class.isAssignableFrom( field.getType() )
            && Modifier.isPublic( field.getModifiers() )
            && !Modifier.isStatic( field.getModifiers() ) )
        {
          setField( object, field, bundle );
        }
      } catch( Exception exception ) {
        String qualifiedName = clazz.getName() + "#" + field.getName();
        String message = "Failed to load localized message for: " + qualifiedName;
        // TODO logging?
        System.err.println( message );
        exception.printStackTrace();
      }
    }
  }

  private static <T> void setField( T object, Field field, ResourceBundle bundle )
    throws IllegalAccessException
  {
    try {
      String value = bundle.getString( field.getName() );
      if( value != null ) {
        field.setAccessible( true );
        field.set( object, value );
      }
    } catch( MissingResourceException mre ) {
      field.setAccessible( true );
      field.set( object, "" );
      throw mre;
    }
  }

  private static <T> T newInstance( Class<T> type ) {
    T result = null;
    try {
      Constructor<T> constructor = type.getDeclaredConstructor();
      if( !constructor.isAccessible() ) {
        constructor.setAccessible( true );
      }
      result = constructor.newInstance();
    } catch( RuntimeException rte ) {
      throw rte;
    } catch( Exception exception ) {
      String msg = "Failed to create instance of type: " + type.getName();
      throw new RuntimeException( msg, exception );
    }
    return result;
  }

}
