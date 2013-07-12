/*******************************************************************************
 * Copyright (c) 2013 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    EclipseSource - initial API and implementation
 ******************************************************************************/
package com.eclipsesource.singlesourcing.utils;


public abstract class NLSHelper {

  private static final NLSHelper IMPL = ImplementationLoader.createInstance( NLSHelper.class );

  /**
   * Returns a translated instance of the given message bundle accessor class. All public,
   * non-static, String-typed fields of the returned object will be set to values that are read
   * from the given resource bundle with the current system locale.
   *
   * @param bundleName the resource bundle to load.
   * @param clazz the class of the NLS object to load.
   */
  public static <T> T getLocalizedInstance( String bundleName, Class<T> type ) {
    return IMPL.getLocalizedInstanceInternal( bundleName, type );
  }

  abstract <T> T getLocalizedInstanceInternal( String bundleName, Class<T> clazz );

}
