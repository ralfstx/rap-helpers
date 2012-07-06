/*******************************************************************************
 * Copyright (c) 2010, 2012 EclipseSource
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    EclipseSource - initial API and implementation
 ******************************************************************************/
package com.eclipsesource.singlesourcing.utils;

import org.eclipse.rwt.SessionSingletonBase;

import com.eclipsesource.singlesourcing.utils.SessionSingletonProvider;


public class SessionSingletonProviderImpl extends SessionSingletonProvider {

  @Override
  <T> T getInstanceInternal( Class<T> type ) {
    return SessionSingletonBase.getInstance( type );
  }
}
