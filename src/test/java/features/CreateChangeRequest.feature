Feature: ServiceNow Incident Management

Scenario Outline: Create change_request

Given set the endpoint
And add the auth
And add the query parameters
|sysparm_fields|short_description,sys_id,sys_created_on|
When post the request with short description as "<short_description>" and category as "<category>"
Then validate the response as 201

Examples:
|short_description|category|
|Create incident thru Cucumber eg1|software1|
|Create incident thru Cucumber eg2|software2|