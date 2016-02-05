Proof of concept demo of Silverware application
===

This demo could be found here: <https://github.com/mswiech/s2i-silverware-camel-qs>

## How-to


### Manual run

Prerequisities:
Install JBoss A-MQ, tested with version 6.2.1.redhat-084.
Start the broker with `bin/standalone.sh`.
Add an admin user mqtt/mqtt:

```
JBossA-MQ:karaf@root> amq:create-admin-user
Please specify a user...
New user name: mqtt
Password for mqtt: 
Verify password for mqtt: 
```

Compile with:

`mvn clean package`

There are those run properties:

* mqtt.user - mqtt user that you have configured (see prerequisities)
* mqtt.pass - password of mqtt user that you have configured (see prerequisities)
* mqtt.host - host and port of mqtt service (e.g. localhost:1883 )

Run the jar file in target:

`java -Dmqtt.user=mqtt -Dmqtt.user=mqtt -Dmqtt.host=localhost:1883 -jar target/s2i-silverware-camel-qs-1.0.jar`


### OpenShift deploy

Prerequisities:
Mqtt broker with configured user:
 
* you can use some mqtt broker outside of OpenShift (see manual run)
* or you can deploy mqtt broker (A-MQ server) on OpenShift

Add new template into OpenShift:

```
oc login
oc create -f quickstart-template.json -n projectname
```

Login into your project on web interface of OpenShift.

Click on a button "Add to Project" and find just added template "s2i-silverware-camel-quickstart"

Set MQTT_USER, MQTT_PASS and MQTT_HOST and click on a button "Create"

You can see build progress when you navigte into Browse -> Builds -> s2i-silverware-camel-quickstart -> just running build -> Logs

After build there will be new POD with this application.


## Main knowledge resources

Silverware: <https://github.com/px3/SilverWare>

Silverware quickstarts: <https://github.com/px3/SilverWare-Demos>

Openshift documentation:
* main page: <https://docs.openshift.com/enterprise/3.1/welcome/index.html>
* using xpaas images: <https://docs.openshift.com/enterprise/3.1/using_images/xpaas_images/fuse.html> (java-simple-mainclass-archetype 2.2.0.redhat-079)

