CREATE TABLE adresse (
	code_hash VARCHAR(50) NOT NULL,
	localite VARCHAR(50) NOT NULL,
	code_postal VARCHAR(4) NOT NULL,
	rue VARCHAR(50) NOT NULL,
	numero VARCHAR(10) NOT NULL,
	PRIMARY KEY (code_hash)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE responsable (
	matricule INT NOT NULL AUTO_INCREMENT,
	nom VARCHAR(50) NOT NULL,
	prenom VARCHAR(50) NOT NULL,
	PRIMARY KEY (matricule)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE nutritionniste (
	num_reference INT NOT NULL AUTO_INCREMENT,
	nom VARCHAR(50) NOT NULL,
	prenom VARCHAR(50) NOT NULL,
	avis VARCHAR(255),
	PRIMARY KEY (num_reference)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE coach (
	matricule INT NOT NULL AUTO_INCREMENT,
	nom VARCHAR(50) NOT NULL,
	prenom VARCHAR(50) NOT NULL,
	recompenses VARCHAR(255),
	salaire_horaire DOUBLE NOT NULL,
	date_debut_coaching DATE NOT NULL,
	PRIMARY KEY (matricule)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE candidat (
	num_inscription INT NOT NULL AUTO_INCREMENT,
	nom VARCHAR(50) NOT NULL,
	prenom VARCHAR(50) NOT NULL,
	date_naissance DATE NOT NULL,
	sexe CHAR(1) NOT NULL,
	num_gsm VARCHAR(10),
	date_test_valide DATE,
	date_inscription DATE NOT NULL,
	nb_heures_coaching INT NOT NULL,
	debutant BIT,
	maladies_chroniques VARCHAR(255),
	coach_matricule INT NOT NULL,
	responsable_matricule INT NOT NULL,
	nutritionniste_num_reference INT NOT NULL,
	adresse_code_hash VARCHAR(50) NOT NULL,
	PRIMARY KEY (num_inscription),
	FOREIGN KEY (coach_matricule) references coach(matricule),
	FOREIGN KEY (responsable_matricule) references responsable(matricule),
	FOREIGN KEY (nutritionniste_num_reference) references nutritionniste(num_reference),
	FOREIGN KEY (adresse_code_hash) references adresse(code_hash)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;