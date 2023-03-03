# USE CASES

---

### Use Case Template <Assignee?>

#### Name
>   Template

#### Actor
>   Developers

#### Description
>   *The void stares back at you*

#### Pre-condition
>   Understanding how to write these

#### Scenario
>1. Open the .md file in Visual Studio Code
>2. VSCode opens the code
>3. Edit the file to include the new Use Case and save
>4. Switch to GitHub Desktop and click on the "Fetch origin" button, wait for it to finish
>5. After asserting that there are no issues / conflicts, name the commit, add brief description if needed and commit

#### Result
>   The Use Cases have been updated, by adding, editing or deletion of one or multiple Use Cases

#### Exceptions
>5. If there is an issue, handle it before committing
<!-- Here we need to double check if this'd be an exception for 4. or 5.-->

---
<!-- Further Use Cases can be edited now-->


### Use Case Purchase Ticket

#### Name
>   Purchase Ticket

#### Actor
>   Sales Employee

#### Description
>   Actor buys a ticket for a person standing near them

#### Pre-condition
>   Logged in as Sales Employee

#### Scenario
>1. Actor selects the "Purchase Ticket" option
>2. System provides the according GUI
>3. Actor asks for and selects the flight their customer demands
>4. System shows that this flight has been selected and asks if there are further questions
>5. Actor denies the question
>6. System provides the ticket and returns back to initial screen

#### Result
>   The Sales Employee gets a ticket to the according flight for their customer

#### Extensions
>5. Actor selects the option "Apply discount". Handled by the Use Case "Apply discount"

>5. Actor selects the option "Apply voucher". Handled by the use Case "Apply voucher"

>5. Actor selects the option "Add extras". Handled by the Use Case "Apply extras"

#### Exceptions
>5. Actor cancels the ticket selction. System moves back to the initial screen
---
