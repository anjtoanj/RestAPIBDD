Feature: ServiceNow Incident Management

Scenario: Get all the incidents with multi query parameters

Given add the query parameters as "sysparm_fields" and "sys_id, number"
When send the request
Then validate the response as 200

Scenario: Get all incidents and validate the response

Given add the query parameters
|sysparm_fields|sys_id, number, category, short_description, description|
|category      |software |
When send the request
Then validate the response for below
|result.sys_created_by|admin   |
|result.sys_class_name|incident|
|result.sys_urgency   |3       |