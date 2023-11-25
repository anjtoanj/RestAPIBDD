Feature: ServiceNow Incident Management

Scenario: Get all the incidents

Given set the endpoint
And add the auth
And add the query parameters as "sysparm_fields" and "sys_id, number"
When send the request
Then validate the response