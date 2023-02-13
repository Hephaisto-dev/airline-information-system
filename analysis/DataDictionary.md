# Data Dictionary

## Airplane:
	Capacity: number of total seats in the airplane
    Id: unique airplane number
	Seat mapping: Contains the mapping of the plain seats
    Type: what type of airplanes (Airbus A320, Boeing 737 -> small, medium, large)
## Baggage:
	Height: The maximum height of the baggage
	Length: The maximum length of the baggage
    Weight: The maximum weight of the baggage
    Width: The maximum width of the baggage
## Booking:
	Booking date: 	date when booking was made.
    Employee id: Identifier of the employee that create the booking.
    Flight id: Identifier of the flight of the booking
    Id: Unique identifier for each booking
	Passenger id: Identifier of the passenger related to the booking.
	Seat number: seat number assigned to the passenger.
	Ticket: the ticket of this booking
## Discount:
	Static: Whether this discount in status (will take off the value from the price)
	Value: The value of the discount (percentage discount if not static)
## Employee:
	Birthdate: the birthdate of the employee
    Email: email address of the employee
    First name: first name of the employee.
    id: unique identifier for each employee
    Job title: this defines what a person's job is in the company.
	Last name: last name of the employee.
	Phone: phone number of the employee
## Flight:
	Arrival city: city where	the flight arrives at
    Arrival datetime: time and date when the flight arrives.
    Airplane type: Type of airplane used for the flight.
    Capacity: Maximum number of seats in the flight (linked to airplane)
    Departure city:  city where the flight departs from
	Departure datetime: time and date when the flight departs.
	Flight duration: Total duration of the flight
    Flight number: flight number for the airline
    Id: unique identifier for each flight
    Status: Current state of the flight (schedules, delayed, cancel…)
	Tickets: Different ticket types for this flight 
	Ticket id: unique ticket number for the specific flight
	
## Passenger:
	Email: Email address of the passenger
	First name: first name of the passenger
    Id: unique identifier for each passenger
	Last name: Last name of the passenger
    Passenger type: The type of the passenger (Adult, child, student)
	Passport number: Passport number of the passenger (if applicable)
    Phone: phone number of the passenger
## Seat:
	Availability: Whether the seat is available or not
    Class: The class of the current seat (1st, 2nd, eco)
    Column: Column number of the Seat
	Number: the seat number.
	Row: Row number of the Seat
## Ticket:
	Baggage: the baggage allowed this ticket
	Discount: The discount of the ticket
    Price: The price of the ticket
    Seat: The of Seat this ticket
