/*******************************************************************************
 * Copyright (c) 2010, 2013 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    EclipseSource - initial API and implementation
 ******************************************************************************/
package com.eclipsesource.singlesourcing.utils;


/**
 * Helper class for single sourcing with fragments.
 */
public final class ImplementationLoader {

  private ImplementationLoader() {
    // helper class, must not be instantiated
  }

  /**
   * Creates a new instance of the implementation of the given abstract base
   * class. The implementation is found by the following naming convention:
   * <ul>
   * <li>The implementation class must have the name of the abstract base class
   * suffixed with <code>Impl</code>. E.g. class <code>FooImpl</code> is the
   * implementation of the base class <code>Foo</code>.</li>
   * <li>The implementation class must reside in the same package as the
   * abstract base class.</li>
   * </ul>
   *
   * @param type the abstract class to load the implementation for
   * @return a new instance of the implementation class
   * @throws RuntimeException if no implementation could be found
   */
  @SuppressWarnings("unchecked")
  public static <T> T createInstance( Class<T> type ) {
    String name = type.getName();
    ClassLoader classLoader = type.getClassLoader();
    try {
      Class<T> clazz = ( Class<T> )classLoader.loadClass( name + "Impl" );
      return clazz.newInstance();
    } catch( Throwable t ) {
      String message = "Could not load implementation for " + name;
      throw new RuntimeException( message, t );
    }
  }

}
