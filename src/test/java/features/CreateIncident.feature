Feature: ServiceNow Incident Management

Scenario Outline: Create incident

Given set the endpoint
And add the auth
And add the query parameters as "sysparm_fields" and "sys_id, number"
When post the request with short description as "<short_desc>" and category as "<category>"
Then validate the response

Examples:
|short_desc|category|
|Create incident thru Cucumber eg1|software1|
|Create incident thru Cucumber eg2|software2|