Feature: ServiceNow Incident Management

Scenario: Get incident

Given set the endpoint
And add the auth
And add the query parameters
|sysparm_fields|sys_id, number, category, short_description, description|
|category      |software |
When send the request
Then validate the response
