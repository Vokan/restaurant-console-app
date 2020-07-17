create table PLAT 
	(
		ID INT(11) not null primary key auto_increment, 
		NOM VARCHAR(100) not null unique,
		prixEnCentimesEuros INT(7) not null
);