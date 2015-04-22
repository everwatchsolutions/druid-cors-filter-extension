# druid-cors-filter-extension #

This is an extension for the [druid analytics data store](http://druid.io) that enables CORS headers across all of the exposed APIs.  This allows web applications to make AJAX calls to the druid APIs without Cross Site Request issues.  

## Building ##
This extension is build using maven.  To build it:

    mvn package

## Deploying ##
In order to use this extension, we publish the extension to our maven repository and then reference it from druid.  Druid can pull extension from maven repos at runtime and load them.  

    mvn clean package deploy

## Installing ##
Once our extension is available in our maven repo, we can add it to our druid config.  I did this like the following example:

    druid.extensions.coordinates=["net.acesinc.druid.extensions:cors-servlet-filter:0.0.3-SNAPSHOT"]

You may need to preload this extension locally, but that depends on how you are running druid.  

## Running ##
Once you start Druid, you should see your extension load in the logs. The current behavior of the extension is to just allow all origins and requests types though.  Therefore, you should be able to try an AJAX request to something like the broker's API at http://yourhost:broker-port/druid/v2
