--                         (id, address, email, firstname, isemployee, lastname, password, username)
INSERT INTO users VALUES(1, '2721 sw 345 pl, Federal Way, Wa 98023',  'me@ex.com', 'Francisco', 0, 'Radilla Greer', 'pass', 'frg' ),
						   (2, 'Great Tomb of Nazarick', 'boss@ex.com', 'Ainz', 1, 'Owl Gown', 'pass', 'boss'),
						   (3, 'Telsa Factory', 'elon@ex.com', 'Elon', 0, 'Musk', 'pass', 'em'),
						   (4, 'West Virgina', 'vampire@ex.com', 'Shalltear', 0, 'Bloodfallen', 'pass', 'vamp');
					
--						  (id, brand, company, description, mpgcity, mpghwy, price, seats, status, year)
INSERT INTO vehicle VALUES(1, 'Corolla', 'Toyota', 'small blue car.', 31, 40, 19600, 5, 'avaliable', 2020),
						  (2, 'Tundra', 'Toyota', 'Dino blue truck.', 13, 18, 33575, 5, 'avaliable', 2020),
						  (3, 'Accord', 'Honda', 'Black car.', 27, 36, 12177, 5, 'avaliable', 2015),
						  (4, 'Mustang', 'Ford', 'Nice silver mustang.', 18, 26, 7495, 2, 'avaliable', 2010),
						  (5, 'Model X', 'Tesla', 'White with sucicide doors!', 99, 93, 84990, 5, 'sold', 2020),
						  (6, 'Cybertruck', 'Tesla', 'Future!', 250, 500, 1000000, 2, 'avaliable', 2050),
						  (7, 'Falcon', 'Tesla', 'Tesla made rocked witha tesla car.', 1300, 6000, 1000000000, 1, 'sold', 2018),
						  (8, 'Mustang2', 'Ford', 'Nice silver mustang.', 18, 26, 7495, 2, 'sold', 2010);

--							  (id, month, offer, carId, visId)
INSERT INTO application VALUES(1, 6, 1249.17, 4, 1),
							  (2, 3, 28330, 5, 3),
							  (3, 0, 1000000, 6, 3),
							  (4, 0, 1000000000, 7, 3),
							  (5, 10, 1960, 1, 4),
							  (6, 6, 1249.17, 8, 1);