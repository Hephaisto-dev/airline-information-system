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
#### Name
>   Login

#### Actor
>   Sales employee

#### Description
>   A sales employee logins in to gain access to their account

#### Pre-condition
>   sales employee has a account and is logged out

#### Scenario
>1. Actor opens the application.
>2. The system displays the homepage of the application
>3. The actor navigates to the log in page.
>4. The system displays the log in page
>5. The actor fills in the required fields with his credentials.
>6. The system indicates the success of the login

#### Result
>   The actor has successfully logged in.

#### Exceptions
>5. The system informs the user that his credentials were incorrect.
---
#### Name
>   Access previous flight records

#### Actor
>   Sales employee

#### Description
>   A sales employee is able to see the flight information of flights that already happened

#### Pre-condition
>  Sales employee is logged in

#### Scenario
>1. Actor navigates to the previous flight records
>2. The system displays the previous flight records page. 
>3. The actor navigates to a flight which already happened. 
>4. .the system displays the flight information for the selected flight. 


#### Result
>   The actor can look at the records of previous flights
#### Exceptions
>2. system notifies that there are no previous flights
    2.1 case ends


#### Name
>   Start sales process

#### Actor
>   Sales Officer 

#### Description
>   A sales officer can start the sales process for the sales employee to see 

#### Pre-condition
>  Sales officer is logged in

#### Scenario
>1. Actor opens the application. 
>2. The system displays the homepage of the application. 
>3. The actor navigates to the flights. 
>4. the system displays all upcoming flights.
>5. the actor selects a flight. 
>6. the system shows the selected flight.
>7. the actor activates the sales process
>8. the system indicates it was successfully activated.


#### Result
>   The sales process has successfully begun
#### Exceptions
>3. system notifies that there are no active flights.
3.1 case ends
---
