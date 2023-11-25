Feature: ServiceNow Incident Management

Background:
Given set the endpoint
And add the auth

Scenario: Get all the incidents
Given add the query parameters as "sysparm_fields" and "sys_id, number"
When send the request
Then validate the response

Scenario: Get incident
Given add the query parameters
|sysparm_fields|sys_id, number, category, short_description, description|
|category      |software |
When send the request
Then validate the response