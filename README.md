# druid-cors-filter-extension #

This is an extension for the [druid analytics data store](http://druid.io) that enables CORS headers across all of the exposed APIs.  This allows web applications to make AJAX calls to the druid APIs without Cross Site Request issues.  

## Installing ##
Once our extension is available in our maven repo, we can add it to our druid config.  I did this like the following example:

    druid.extensions.coordinates=["net.acesinc.druid.extensions:cors-servlet-filter:1.0.0"]

You may need to preload this extension locally, but that depends on how you are running druid.  

## Running ##
Once you start Druid, you should see your extension load in the logs. The current behavior of the extension is to just allow all origins and requests types though.  Therefore, you should be able to try an AJAX request to something like the broker's API at http://yourhost:broker-port/druid/v2


## For Development ##
### Building ###
This extension is build using maven.  To build it:

    mvn package

### Deploying ###
In order to use this extension, we publish the extension to maven central and then reference it from druid.  Druid can pull extension from maven repos at runtime and load them.  In order to release a new version of this extension, the following needs to be done:

First, we need to prepare the release.  Make sure you have all your changes committed before running the prepare.  This prepare will do the following: Remove the -SNAPSHOT suffix, commit and tag the code on github, then update the project version to nextversion-SNAPSHOT.

    mvn clean release:prepare
    
If the prepare succeeded, we are ready to release.  This will only work if you have been set up with permissions in the Sonatype Nexus repo for our organization:

	mvn release:perform
	
Next, log into [Sonatype Nexus](https://oss.sonatype.org) and find your artifacts under Staging Repositories. Select your Staging Repo and click the "Release" button at the top.  

Sonatype syncs their Open Source Repo with Maven Central every few hours.  So you are done and just have to wait for the next version to be live!


