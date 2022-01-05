CREATE TABLE flight (flight_id INT AUTO_INCREMENT,
					flight_number VARCHAR(20) NOT NULL,
                    plane_id INT NOT NULL,
                    departure_airport_id INT NOT NULL,
                    arrival_airport_id INT NOT NULL,
                    departure_time DATETIME NOT NULL,
                    arrival_time DATETIME NOT NULL,
                    captain_name VARCHAR(256),
                    second_pilot_name VARCHAR(256),
                    PRIMARY KEY (flight_id)
                    ) ;

 CREATE TABLE passenger (passenger_id INT NOT NULL AUTO_INCREMENT,
						passport_id INT NOT NULL UNIQUE,
						first_name VARCHAR(256),
						last_name VARCHAR(256),
						middle_name VARCHAR(256),
						email VARCHAR(50),
						phone VARCHAR(20),
						PRIMARY KEY (passenger_id)
						);

 CREATE TABLE flight_passenger (flight_id INT NOT NULL,
								passenger_id INT NOT NULL,
                                PRIMARY KEY (flight_id,passenger_id)
                                );

 CREATE TABLE airport (airport_id INT NOT NULL,
						location VARCHAR(256),
                        name VARCHAR(256),
                        PRIMARY KEY (airport_id)
                        );

CREATE TABLE plane (plane_id INT NOT NULL,
					type VARCHAR(20),
                    number_of_seats INT NOT NULL,
                    airline_id INT NOT NULL,
                    PRIMARY KEY (plane_id)
                    );

CREATE TABLE airline (airline_id INT NOT NULL,
					name VARCHAR(256),
                    PRIMARY KEY (airline_id)
                    );