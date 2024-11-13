Feature:Registration page feature
  Background:
    Given User is on the Registration Page
    Scenario:Fill First and Last name
      When Fill "shiv" in First Name
      And Fill "Kant" in Last Name
