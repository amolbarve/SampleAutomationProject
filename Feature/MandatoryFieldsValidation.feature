Feature: Mandatory Fields Validation

  Scenario Outline: UserName Validation
    Given User is on google UK home page as "<url>"
    When User navigates to gmail link
    And User enters "<firstname>" "<lastname>" "<password>" "<birthday>" "<birthyear>" "<recoveryPhoneNumber>" "<skipcaptcha>" "<TermsofService>" "<gender>" "<birthMonth>" "<country>"
    And user clicks on create account button
    Then Username Mandatory Message shoudl be displayed to the user.

    Examples: 
      | url                      | firstname | lastname | password        | birthday | birthyear | recoveryPhoneNumber | skipcaptcha | TermsofService | gender | birthMonth | country |
      | https://www.google.co.uk | test      | test     | gmailpass@12345 | 12       | 1987      | 8805668799          | True        | True           | male   | 6          | India   |
 
