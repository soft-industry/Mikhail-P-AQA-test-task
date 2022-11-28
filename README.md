# Automation sframework based on Cucumber and Serenity

This framework allows to test the https://waarkoop-server.herokuapp.com API. We ave implementation for the following endpoints: apple, mango, tofu and checn non existing one.

## Execution
There are several options to run automation scripts: 
* all locally
* all on CI
* one locally by tag

To run all test locally just execute `mvn clear verify` in the console.

To run locally only particular one executhe the following `mvn clean verify -Dcucumber.filter.tags="@mango"` and test according to specific endpoint will be launched

To execute all test on CI go to the project pipeline using following URL - https://gitlab.com/mikhail-prykhodko/soft-industry/-/pipelines. Then hit the "Run pipeline" button. You may select the branch but usually it is "main" one.

## Reporting

For local execution the report may be found in the following directory ${project_root}/target/site/serenity/index.html. You do not need to do any additional steps, just open the index file and you will get the results.

For CI execution the report may be found in the artifacts for each pipeline. Go To the CI/CD -> Pipelines on GitLub. Hit the arrow down icon on specific pipeline and then click verify:artifact inside dialog box. After that you will have the same report as on local run.

## Changes
1. Remove gradle entities
2. Update libs version
3. Change Feature name
4. Add base url to config (in future may be different environments dev, stage, prod)
5. Add Enum for endpoints
6. Added glue to TestRunner
7. DTOs for different response entities
8. Add SoftAssertion library for better attributes verification

