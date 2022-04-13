ASGwrapper-asgtools
---------------------

ASGwrapper-asgtools is a library which helps to decouple ASGtools from each other by providing a calling interface.

It supports
* ASGbreeze2stg v1.0+
* ASGdelaymatch v1.4+
* ASGdrivestrength v1.1+
* ASGlogic v0.3+
* ASGresyn v1.3+
* DesiJ v3.3+

To avoid of circular dependencies, these tools are not included in this release.

### Build instructions ###

To build ASGwrapper-asgtools, Apache Maven v3.1.1 (or later) and the Java Development Kit (JDK) v1.8 (or later) are required.

1. Build [ASGcommon](https://github.com/hpiasg/asgcommon)
2. Build [ASGprotocols](https://github.com/hpiasg/asgprotocols)
3. Execute `mvn clean install -DskipTests`