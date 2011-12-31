/*******************************************************************************
 * Copyright (c) 2011 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    EclipseSource - initial implementation
 ******************************************************************************/
package rwt.simple;

import org.eclipse.rwt.lifecycle.IEntryPoint;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;


public class SimpleEntryPoint implements IEntryPoint {

  public int createUI() {
    // Create a maximized top-level shell without trimmings that represents the main "page"
    Display display = new Display();
    Shell page = new Shell( display, SWT.NO_TRIM );
    page.setMaximized( true );
    page.setLayout( new GridLayout() );
    // Create contents of main shell
    Label label = new Label( page, SWT.NONE );
    label.setText( "Hello" );
    Button button = new Button( page, SWT.PUSH );
    button.setText( "World" );
    // Open the top-level shell and run the main loop to process events
    page.layout();
    page.open();
    return 0;
  }

}
