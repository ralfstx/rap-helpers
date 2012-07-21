RAP Helpers
===========

This repository includes some code examples for RAP.

Simple RAP applications
-----------------------

*example.rwt.simple* is a simple RWT example application that uses the RWT-OSGi integration.
This bundle uses a bundle activator to register its configuration as a service.

*example.rwt.simple.ds* is a copy of this bundle that uses a declarative service.

Single sourcing
---------------

*com.eclipsesource.singlesourcing* is a bundle to be shared by both RAP-based and RCP-based applications.
*com.eclipsesource.singlesourcing.rap* and *com.eclipsesource.singlesourcing.rcp* are the corresponding fragments for RAP and RCP.
Add both the bundle itself and the one fragment that matches the respective platform to the deployment.
You can then instantiate a class like this:

    ShoppingCart cart = SessionSingletonProvider.getInstance( ShoppingCart.class );

For every different session in RAP, a new instance will be created.
Whenever you call this method from the same session, you will receive the same instance.
In RCP, there will only be a single instance.

You can find further information in the single sourcing guide at <http://eclipsesource.com/en/eclipse/eclipse-rap/>.

Other examples
--------------

*test.additionalhttpservice* is a bundle that starts up a Jetty HTTP server programmatically on port 10001.
This is useful to test RAP with different HTTP services (see [bug 241210](https://bugs.eclipse.org/bugs/show_bug.cgi?id=241210 "Should be possible to filter HttpService instance")).


