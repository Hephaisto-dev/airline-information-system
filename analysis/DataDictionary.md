# Data Dictionary

##Flight:##
	Id: unique identifier for each flight
	Flight number: flight number for the airline
	Departure city:  city where the flight departs from
	Arrival city: city where	the flight arrives at
	Departure datetime: time and date when the flight departs.
	Arrival datetime: time and date when the flight arrives.
	Flight duration: Total duration of the flight
	Tickets: Different ticket types for this flight
	Airplane type: Type of airplane used for the flight.
	Capacity: Maximum number of seats in the flight (linked to airplane)
	Status: Current state of the flight (schedules, delayed, cancel…) 
	Ticket id: unique ticket number for the specific flight
##Passenger:##
	Id: unique identifier for each passenger
	Passenger type: The type of the passenger (Adult, child, student)
	First name: first name of the passenger
	Last name: Last name of the passenger
	Email: Email address of the passenger
	Phone: phone number of the passenger
	Passport number: Passport number of the passenger (if applicable)
##Booking:##
	Id: Unique identifier for each booking
	Passenger id: Identifier of the passenger related to the booking.
	Employee id: Identifier of the employee that create the booking.
	Flight id: Identifier of the flight of the booking
	Seat number: seat number assigned to the passenger.
	Booking date: 	date when booking was made.
	Ticket: the ticket of this booking
##Ticket:##
	Seat: The of Seat this ticket
	Price: The price of the ticket
	Baggage: the baggage allowed this ticket
	Discount: The discount of the ticket
##Discount:##
	Static: Whether this discount in status (will take off the value from the price)
	Value: The value of the discount (percentage discount if not static)
##Baggage:##
 	Weight: The maximum weight of the baggage
	Height: The maximum height of the baggage
	Width: The maximum width of the baggage
	Length: The maximum length of the baggage
##Airplane:##
	Id: unique airplane number
	Type: what type of airplanes (Airbus A320, Boeing 737 -> small, medium, large)
	Capacity: number of total seats in the airplane
	Seat mapping: Contains the mapping of the plain seats.
##Seat:## 
	Class: The class of the current seat (1st, 2nd, eco)
	Number: the seat number.
	Row: Row number of the Seat
	Column: Column number of the Seat
	Availability: Whether the seat is available or not
##Employee:##
	id: unique identifier for each employee
	First name: first name of the employee.
	Last name: last name of the employee.
	Birthdate: the birthdate of the employee
	Email: email address of the employee
	Phone: phone number of the employee
	Job title: this defines what a person's job is in the company. 
