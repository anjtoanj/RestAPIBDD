Feature: ServiceNow Incident Management

Scenario: Get all the incidents with multi query params
Given add the query parameters as "sysparm_fields" and "sys_id, number"
When send the request
Then validate the response

Scenario: Get incident
Given add the query parameters
|sysparm_fields|sys_id, number, category, short_description, description|
|category      |software |
When send the request
Then validate the response