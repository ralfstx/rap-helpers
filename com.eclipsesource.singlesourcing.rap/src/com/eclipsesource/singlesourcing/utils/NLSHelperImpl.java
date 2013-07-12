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


public class NLSHelperImpl {

  public <T> T getTranslatedInstance( Class<T> clazz, String bundleName ) {
    return org.eclipse.rap.rwt.RWT.NLS.getISO8859_1Encoded( bundleName, clazz );
  }

}
