# Building the application

## ContractViz is extending the Eclipse Trace Compass so that the added features based on the functionalities of the existing tool have been tailored to smart contract analysis.
## Step 1: Get Eclipse Trace Compass Running Up 
### Compiling manually

The Maven project build requires version 3.9 or later. It can be downloaded from
<https://maven.apache.org> or from the package management system of your distro.

It also requires Java version 11 or later.

To build the project manually using Maven, simply run the following command from
the top-level directory, to skip them you can append `-Dmaven.test.skip=true` to the
`mvn` command:

```
mvn clean install -Dmaven.test.skip=true
```
try this command if the test-skipping process is not successful in the previous step:

```
mvn clean install -Dmaven.test.skip=true -DskipTests
```

Stand-alone application (RCP) packages will be placed in
`rcp/org.eclipse.tracecompass.rcp.product/target/products`.

### Once the Eclipse Trace Compass has been compiled, navigate to this place
### (the following example is in a MacOS system)
`org.eclipse.tracecompass/rcp/org.eclipse.tracecompass.rcp.product/target/products/org.eclipse.tracecompass.rcp/macosx/cocoa/aarch64/trace-compass.app/Contents/MacOS`.
### then run this command to get the software running 
```
./tracecompass
```

## Step 2: Loading processed data file to the software from 'additionalFiles' folder
### Load in trace files 
Under 'Project Explorer', right-click 'Trace folder' on the software interface's left panel and load in 'traceOnlyFlippedts.json'

Make sure this add-on has been installed: "Trace Compass TraceEvent Parser (incubator)"

### Add in the XY Chart Analysis
Right-click on the 'Trace folder,' and select 'Manage XML analyses...', import 'gas_cost_per_function_call.xml' and apply this file. 
Then the Ethereum Gas Fee Per Function analysis will be generated, and the XY chart will be shown as the 'Ethereum Fee Per Function'.
