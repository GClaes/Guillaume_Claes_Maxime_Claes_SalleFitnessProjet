CREATE TABLE sallefitness.adresse (
	code_hash VARCHAR(40),
	localite VARCHAR(255) NOT NULL,
	code_postal VARCHAR(4) NOT NULL,
	rue VARCHAR(255) NOT NULL,
	numero VARCHAR(7) NOT NULL,
	constraint adresse_code_hash PRIMARY KEY (code_hash)
);

CREATE TABLE sallefitness.responsable (
	matricule INT AUTO_INCREMENT,
	nom VARCHAR(255) NOT NULL,
	prenom VARCHAR(255) NOT NULL,
	constraint responsable_matricule PRIMARY KEY (matricule)
);

CREATE TABLE sallefitness.nutritionniste (
	num_reference INT AUTO_INCREMENT,
	nom VARCHAR(255) NOT NULL,
	prenom VARCHAR(255) NOT NULL,
	avis VARCHAR(255),
	constraint nutritionniste_num_reference_pk PRIMARY KEY (num_reference)
);

CREATE TABLE sallefitness.coach (
	matricule INT AUTO_INCREMENT,
	nom VARCHAR(255) NOT NULL,
	prenom VARCHAR(255) NOT NULL,
	recompenses VARCHAR(255),
	salaire_horaire DOUBLE NOT NULL check(salaire_horaire >= 0),
	date_debut_coaching DATE NOT NULL,
	constraint coach_matricule_pk PRIMARY KEY (matricule)
);

CREATE TABLE sallefitness.candidat (
	num_inscription INT AUTO_INCREMENT,
	nom VARCHAR(255) NOT NULL,
	prenom VARCHAR(255) NOT NULL,
	date_naissance DATE NOT NULL,
	sexe CHAR(1) NOT NULL check(sexe = 'h' OR sexe = 'f'),
	num_gsm VARCHAR(10),
	date_test_valide DATE,
	date_inscription DATE NOT NULL,
	nb_heures_coaching INT NOT NULL check(nb_heures_coaching >= 1 AND nb_heures_coaching <= 20),
	debutant BIT NOT NULL,
	maladies_chroniques VARCHAR(255),
	coach_matricule INT NOT NULL,
	responsable_matricule INT NOT NULL,
	nutritionniste_num_reference INT NOT NULL,
	adresse_code_hash VARCHAR(40) NOT NULL,
	constraint candidat_num_inscription PRIMARY KEY (num_inscription),
	constraint coach_matricule_fk FOREIGN KEY (coach_matricule) references coach(matricule),
	constraint responsable_matricule_fk FOREIGN KEY (responsable_matricule) references responsable(matricule),
	constraint nutritionniste_num_reference_fk FOREIGN KEY (nutritionniste_num_reference) references nutritionniste(num_reference),
	constraint adresse_code_hash_fk FOREIGN KEY (adresse_code_hash) references adresse(code_hash)
);

alter table sallefitness.candidat
add constraint check(date_test_valide is null OR date_test_valide >= date_inscription);
