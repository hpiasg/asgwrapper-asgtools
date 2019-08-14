ASGwrapper-asgtools
---------------------

ASGwrapper-asgtools is a helper library to abstract the internal tool calls of the ASGtools

It supports
* ASGbreeze2stg v1.0+
* ASGdelaymatch v1.4+
* ASGdrivestrength v1.1+
* ASGlogic v0.3+
* ASGresyn v1.3+
* DesiJ v3.2+


### Build instructions ###

To build ASGwrapper-asgtools, Apache Maven v3 (or later) and the Java Development Kit (JDK) v1.7 (or later) are required.

1. Build [ASGcommon](https://github.com/hpiasg/asgcommon)
2. Build [ASGprotocols](https://github.com/hpiasg/asgprotocols)
4. Execute `mvn clean install -DskipTests`