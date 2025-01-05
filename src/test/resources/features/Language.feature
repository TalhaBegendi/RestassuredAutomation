Feature: Api Cases

  Scenario: Post language and download file
    Given Post language after get field from response
    And Convert language file to UTF-8 using get response "code" and set response "codeFile"
    And Get language file download before variable set response "codeFile"


