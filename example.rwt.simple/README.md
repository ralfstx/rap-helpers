Simple RWT Example
==================

A simple RWT example application that uses the new RWT-OSGi integration.
The bundle uses a declarative service to register with RWT.

Running the example
-------------------

* Use the included launch configuration

* Point your browser at http://localhost:8080/simple

In case of problems
-------------------

* Open the OSGi console

* Check that all bundles are running:

```
osgi> ss

Framework is launched.

id	State       Bundle
0	ACTIVE      org.eclipse.osgi_3.8.0.v20110726-1606
1	ACTIVE      org.eclipse.rap.rwt_1.5.0.201108131707
2	ACTIVE      org.eclipse.osgi.services_3.3.0.v20110711-1243
3	ACTIVE      org.mortbay.jetty.server_6.1.23.v201012071420
4	ACTIVE      javax.servlet_2.5.0.v201103041518
5	ACTIVE      org.eclipse.equinox.http.jetty_2.0.100.v20110502
6	ACTIVE      org.mortbay.jetty.util_6.1.23.v201012071420
7	ACTIVE      org.eclipse.equinox.util_1.0.300.v20110502
8	ACTIVE      org.eclipse.equinox.http.servlet_1.1.200.v20110502
9	ACTIVE      example.rwt.simple_1.0.0.qualifier
10	ACTIVE      org.eclipse.rap.rwt.osgi_1.0.0.201108131707
11	ACTIVE      org.eclipse.equinox.ds_1.3.100.v20110705
```

* Make sure the service is registered

```
osgi> services org.eclipse.rwt.engine.Configurator
{org.eclipse.rwt.engine.Configurator}={component.name=rwt.simple.SimpleConfigurator, component.id=0, service.id=37}
  Registered by bundle: example.rwt.simple_1.0.0.qualifier [9]
  Bundles using service:
    org.eclipse.rap.rwt.osgi_1.0.0.201108131707 [10]
```
