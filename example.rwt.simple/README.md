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
0  ACTIVE      org.eclipse.osgi_3.8.0.v20120312-2035
1	ACTIVE      org.eclipse.jetty.server_8.1.1.v20120215
2	ACTIVE      org.apache.felix.gogo.shell_0.8.0.v201110170705
3	ACTIVE      org.eclipse.equinox.http.servlet_1.1.300.v20111202-1521
4	ACTIVE      org.eclipse.jetty.util_8.1.1.v20120215
5	ACTIVE      org.eclipse.equinox.ds_1.4.0.v20120112-1400
6	ACTIVE      org.eclipse.jetty.http_8.1.1.v20120215
7	ACTIVE      javax.servlet_3.0.0.v201112011016
8	ACTIVE      org.apache.felix.gogo.command_0.8.0.v201108120515
9	ACTIVE      org.eclipse.jetty.security_8.1.1.v20120215
10	ACTIVE      org.eclipse.equinox.console_1.0.0.v20111215-1210
11	ACTIVE      org.eclipse.equinox.http.jetty_3.0.0.v20120216-2249
12	ACTIVE      org.eclipse.rap.rwt_1.5.0.qualifier
13	ACTIVE      org.eclipse.equinox.util_1.0.300.v20111010-1614
14	ACTIVE      org.apache.felix.gogo.runtime_0.8.0.v201108120515
15	ACTIVE      example.rwt.simple_1.0.0.qualifier
16	ACTIVE      org.eclipse.jetty.continuation_8.1.1.v20120215
17	ACTIVE      org.eclipse.osgi.services_3.3.0.v20120307-2102
18	ACTIVE      org.eclipse.rap.rwt.osgi_1.5.0.qualifier
19	ACTIVE      org.eclipse.jetty.servlet_8.1.1.v20120215
20	ACTIVE      org.eclipse.jetty.io_8.1.1.v20120215
```

* Make sure the service is registered:

```
osgi> services *ApplicationConfiguration
{org.eclipse.rwt.application.ApplicationConfiguration}={component.name=rwt.simple.SimpleConfiguration, component.id=0, service.id=52}
  "Registered by bundle:" example.rwt.simple_1.0.0.qualifier [15]
  "Bundles using service"
    org.eclipse.rap.rwt.osgi_1.5.0.qualifier [18]
```
