# Data Dictionary

## Airplane:

    Id: unique airplane number
	Capacity: number of total seats in the airplane
	Seat mapping: Contains the mapping of the plain seats
    Type: what type of airplanes (Airbus A320, Boeing 737 -> small, medium, large)

## Baggage:

	Id:
	Height: The maximum height of the baggage
	Length: The maximum length of the baggage
    Weight: The maximum weight of the baggage
    Width: The maximum width of the baggage

	Carry on:
	Car go:

## Booking:

    Id: Unique identifier for each booking
	Employee id: Identifier of the employee that create the booking.
    Flight id: Identifier of the flight of the booking
	Passenger id: Identifier of the passenger related to the booking.
	Ticket: the ticket of this booking
	Booking date: date when booking was made.
	Seat number: seat number assigned to the passenger.

## Discount:

	id:
	Static: Whether this discount in status (will take off the value from the price)
	Dynamic:
	Value: The value of the discount (percentage discount if not static)

## Employee:

    id: unique identifier for each employee
	First name: first name of the employee.
	Last name: last name of the employee.
	Birthdate: the birthdate of the employee
	Phone: phone number of the employee.
	Email: email address of the employee
    Job title: this defines what a person's job is in the company.


## Flight:

    Id: unique identifier for each flight
	Arrival: city where the flight arrives at
	Departure: city where the flight departs from
    Arrival datetime: time and date when the flight arrives.
    Airplane: Type of airplane used for the flight.
    Capacity: Maximum number of seats in the flight (linked to airplane)
	Departure datetime: time and date when the flight departs.
	Flight duration: Total duration of the flight
    Flight number: flight number for the airline
    Status: Current state of the flight (schedules, delayed, cancel…)
	Tickets: Different ticket types for this flight 
	Ticket id: unique ticket number for the specific flight
	Coast:
	Gate:


## Passenger:

    Id: unique identifier for each passenger
	First name: first name of the passenger
	Last name: Last name of the passenger
	Nationality:
	Passport/ID number: Passport number of the passenger (if applicable)
	Phone: phone number of the passenger
	Email: Email address of the passenger
    Passenger type: The type of the passenger (Adult, child, student)

## Seat:

	Availability: Whether the seat is available or not
    Class: The class of the current seat (1st, 2nd, eco)
    Column: Column number of the Seat
	Row: Row number of the Seat
	Number: the seat number.
	Door of entrance:

## Ticket:

	Baggage: the baggage allowed this ticket
	Discount: The discount of the ticket
    Price: The price of the ticket
    Seat: The of Seat this ticket
	Currency:

## Route

	Flights:
	Route duration:
	Route coast:
	Tranzit times:
