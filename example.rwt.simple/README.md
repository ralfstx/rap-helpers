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
0	ACTIVE      org.eclipse.osgi_3.8.0.v20111111-1618
1	ACTIVE      org.eclipse.rap.rwt.osgi_1.5.0.20111213-2043
2	ACTIVE      org.eclipse.equinox.ds_1.3.100.v20111122-1358
3	ACTIVE      org.eclipse.rap.rwt_1.5.0.20111213-2043
4	ACTIVE      org.apache.felix.gogo.command_0.8.0.v201108120515
5	ACTIVE      org.eclipse.osgi.services_3.3.0.v20111117-1210
6	ACTIVE      org.eclipse.jetty.io_8.1.0.RC1
7	ACTIVE      org.eclipse.jetty.continuation_8.1.0.RC1
8	ACTIVE      org.apache.felix.gogo.runtime_0.8.0.v201108120515
9	ACTIVE      org.eclipse.jetty.server_8.1.0.RC1
10	ACTIVE      org.eclipse.jetty.http_8.1.0.RC1
11	ACTIVE      example.rwt.simple_1.0.0.qualifier
12	ACTIVE      org.eclipse.equinox.http.servlet_1.1.300.v20111202-1521
13	ACTIVE      org.eclipse.jetty.servlet_8.1.0.RC1
14	ACTIVE      org.eclipse.equinox.console_1.0.0.v20111107-1631
15	ACTIVE      org.apache.felix.gogo.shell_0.8.0.v201110170705
16	ACTIVE      org.eclipse.equinox.util_1.0.300.v20111010-1614
17	ACTIVE      javax.servlet_3.0.0.v201112011016
18	ACTIVE      org.eclipse.jetty.security_8.1.0.RC1
19	ACTIVE      org.eclipse.equinox.http.jetty_3.0.0.v20111202-1436
20	ACTIVE      org.eclipse.jetty.util_8.1.0.RC1
```

* Make sure the service is registered

```
osgi> services org.eclipse.rwt.engine.Configurator
{org.eclipse.rwt.engine.Configurator}={component.name=rwt.simple.SimpleConfigurator, component.id=0, service.id=37}
  Registered by bundle: example.rwt.simple_1.0.0.qualifier [9]
  Bundles using service:
    org.eclipse.rap.rwt.osgi_1.0.0.201108131707 [10]
```
