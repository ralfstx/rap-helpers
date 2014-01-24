/*******************************************************************************
 * Copyright (c) 2011, 2014 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    EclipseSource - initial implementation
 ******************************************************************************/
package rwt.simple;

import org.eclipse.rap.rwt.application.AbstractEntryPoint;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;


public class SimpleEntryPoint extends AbstractEntryPoint {

  @Override
  protected void createContents( Composite parent ) {
    parent.setLayout( new GridLayout( 2, false ) );
    Label label = new Label( parent, SWT.NONE );
    label.setText( "Hello" );
    Button button = new Button( parent, SWT.PUSH );
    button.setText( "World" );
  }

}
