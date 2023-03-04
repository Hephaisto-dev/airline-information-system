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
>   Actor buys a ticket for a person

#### Pre-condition
>   Logged in as Sales Employee

#### Scenario
>1. Actor navigates to the "Purchase Ticket" option
>2. System provides the according GUI
>3. Actor selects the flight their customer desires
>4. System shows that this flight has been selected and asks if there's anything else
>5. Actor denies the question
>6. System provides the GUI to enter the personal information for the ticket
>7. Actor either enters the information on behalf of the customer or lets them do it themselves and finalises the purchase
>7. System provides the ticket and returns back to initial screen

#### Result
>   The Sales Employee gets a ticket to the according flight for their customer

#### Extensions
>5.a. Actor selects the option "Apply discount". Handled by the Use Case "Apply discount"

>5.b. Actor selects the option "Apply voucher". Handled by the use Case "Apply voucher"

>5.c. Actor selects the option "Add extras". Handled by the Use Case "Apply extras"

#### Exceptions
>5. Actor cancels the ticket selction. System moves back to the initial screen

---
### Use Case "Apply discount"

#### Name
>   Apply discount

#### Actor
>   Sales Employee

#### Description
>   Actor applies a discount on a ticket before continuing with the sale of the ticket

#### Pre-condition
>   Logged in as Sales Employee
>   Selected option to "Apply discount" in Use Case "Purchase Ticket"

#### Scenario
>1. Actor informs the system of what discount needs to be added
>2. System asks the actor to fill in the amount of the discount that is to be applied
>3. Actor fills in what the correct amount is
>4. System asks actor to confirm if the shown amount is the cirrect amount
>5. Actor confirms this
>6. System puts the actor back to the previous page

#### Result
>   A discount has been applied to the ticket that is being bought

#### Exceptions
>4.a.   If the actor enters an amount greater than or equal to the price of the ticket, the system informs them of this and asks them to enter a viable amount

>5.a.   Should the actor deny this as a correct amount, the system reverts back to step 2.

#### Extensions
>   None

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

---

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


### Use Case Search For Booking <Mathias\>

#### Name
>   Search For Booking

#### Actor
>   Sales employee

#### Description
>   Sales employee search for one booking

#### Pre-condition
>   Sales employee is signed in to his account.

#### Scenario
>   1. Actor selects to search for booking.
>   2. System asks the actor to enter booking details
>   3. Actor enter some booking details.
>   4. System searches for all the booking that match the enter booking details.
>   5. System shows the reservations found.
>   6. Actor select one of the bookings shown.
>   7. System shows the booking details for the selected booking.

#### Result
>   Sales employee has successfully retrieved the booking details.

#### Extensions
>   None.

#### Exceptions
>   3. System informs user no booking was found.
>>      3.1 Use case ends here.
---

---

### Use Case Use Management Dashboard <Mathias\>

#### Name
>   Use Management Dashboard

#### Actor
>   Sales manager

#### Description
>   Sales manager uses the management dashboard to view key performance indicators.

#### Pre-condition
>   Sales manager is signed into his account.

#### Scenario
>   1. Actor selects management dashboard.
>   2. System displays the management dashboard.
>   3. Actor interact with the dashboard (e.g., <isn>[view financial sheets in statistics](Use%20Cases.md#use-case-view-financial-sheets-in-statistics--mathias))</isn>.

#### Result
>   Sales manager viewed the key performance indicators and other important data.

#### Extensions
>   None.

#### Exceptions
>   3. System shows that an error occurred when using the dashboard.
>>      3.1 Use case ends here.
---


### Use Case View Financial Sheets In Statistics <Mathias\>

#### Name
>   View Financial Sheets In Statistics.

#### Actor
>   Sales manager.

#### Description
>   Sales manager views a financial sheet of a flight.

#### Pre-condition
>   Sales manager is using the dashboard.

#### Scenario
>   1. Actor select to view financial sheets.
>   2. System asks the actor to select a flight.
>   3. Actor selects a flight.
>   4. System shows financial sheet of the selected flight.

#### Result
>   Sales manager successfully viewed the financial sheet for the flight selected.

#### Extensions
>   None.

#### Exceptions
>   None.

---

## [Back to Table of Contents](https://github.com/FontysVenlo/prj2-2023-prj2-2023-17/blob/main/TableOfContents.md)
