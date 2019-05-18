CREATE SCHEMA sallefitness DEFAULT CHARACTER SET utf8mb4;

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


INSERT INTO sallefitness.coach (nom, prenom, date_debut_coaching, salaire_horaire, recompenses) 
VALUES ('Twight', 'Mark', STR_TO_DATE('01,01,2019','%d,%m,%Y'), 12.95, null);

INSERT INTO sallefitness.coach (nom, prenom, date_debut_coaching, salaire_horaire, recompenses) 
VALUES ('Dizzi', 'Thomas', STR_TO_DATE('09,02,2015','%d,%m,%Y'), 15.45, null);

INSERT INTO sallefitness.coach (nom, prenom, date_debut_coaching, salaire_horaire, recompenses) 
VALUES ('Bouraïma', 'Joël', STR_TO_DATE('01,01,2000','%d,%m,%Y'), 29.95, 'Coach reconnu');

INSERT INTO sallefitness.coach (nom, prenom, date_debut_coaching, salaire_horaire, recompenses) 
VALUES ('Woodward', 'Lucile', STR_TO_DATE('23,12,2010','%d,%m,%Y'), 20, 'Meilleure plus jeune coach 2011');

INSERT INTO sallefitness.nutritionniste (nom, prenom, avis) 
VALUES ('Cohen','Jean-Michel', 'Trés bon nutritionniste');

INSERT INTO sallefitness.nutritionniste (nom, prenom, avis) 
VALUES ('Adam','Eve éché', null);

INSERT INTO sallefitness.nutritionniste (nom, prenom, avis) 
VALUES ('Ange Gardien','Josephine', 'Petite mais correcte');

INSERT INTO sallefitness.responsable (nom, prenom) 
VALUES ('Meurdesoif','Jean');

INSERT INTO sallefitness.responsable (nom, prenom) 
VALUES ('Morrison','Maurice');

INSERT INTO sallefitness.responsable (nom, prenom) 
VALUES ('Youbebi','Agathe');

INSERT INTO sallefitness.responsable (nom, prenom) 
VALUES ('Proviste','Alain');

INSERT INTO sallefitness.responsable (nom, prenom) 
VALUES ('La monet','Aline');

INSERT INTO sallefitness.adresse (code_hash, localite, code_postal, rue, numero) 
VALUES ('15f794bdc437299d7f9ef45b19431fd481fa268e', 'Hondelange', '6780', 'Emile-Kirsch', '29');

INSERT INTO sallefitness.adresse (code_hash, localite, code_postal, rue, numero) 
VALUES ('36877eb2c9634b0b3d4cd19ff510c283719fa7ef', 'Biesme-sous-Thuin', '6531', 'Broussetaille', '6');

INSERT INTO sallefitness.adresse (code_hash, localite, code_postal, rue, numero) 
VALUES ('392f464deb8443422c19915fa2f2d1f326d73902', 'Gesves', '5340', 'Labas', '5');

INSERT INTO sallefitness.adresse (code_hash, localite, code_postal, rue, numero) 
VALUES ('65c28645b3e5173063f5daf30a5de898b2cce0e5', 'Chênée', '4032', 'Reconnaissance', '2');

INSERT INTO sallefitness.adresse (code_hash, localite, code_postal, rue, numero) 
VALUES ('a45f887198803acbc4e348d6d66f0eb5eb351045', 'Cherain', '6673', 'Sterpigny', '65');

INSERT INTO sallefitness.adresse (code_hash, localite, code_postal, rue, numero) 
VALUES ('bf53f617c62ddf8947ac648be30e8755934e3f29', 'Jemelle', '5580', 'Bouleaux', '11');

INSERT INTO sallefitness.adresse (code_hash, localite, code_postal, rue, numero) 
VALUES ('d18d92b334c36c99d4d42f473d490931913abf66', 'Bourseigne-Neuve', '5575', 'Robio', '23');

INSERT INTO sallefitness.adresse (code_hash, localite, code_postal, rue, numero) 
VALUES ('e816db98b2d664457882f883c6985f2c92ce5ff7', 'Wibrin', '6666', 'Copette', '34');

INSERT INTO sallefitness.adresse (code_hash, localite, code_postal, rue, numero) 
VALUES ('e951347e9311501b21f5245bd2bf37695ce019d0', 'Rocourt', '4000', 'Beaumont', '3');

INSERT INTO sallefitness.candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Cook', 'Thomas', STR_TO_DATE('12,12,1995','%d,%m,%Y'), 'h', '0478121212', null, STR_TO_DATE('02,05,2019','%d,%m,%Y'), 4, TRUE, 
		null, 1, 3, 1, 'e816db98b2d664457882f883c6985f2c92ce5ff7');
		
INSERT INTO sallefitness.candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Neymar', 'Jean', STR_TO_DATE('10,11,1998','%d,%m,%Y'), 'h', '0495366554', null, STR_TO_DATE('09,05,2019','%d,%m,%Y'), 2, FALSE, 
		'Scoliose', 2, 1, 1, 'a45f887198803acbc4e348d6d66f0eb5eb351045');
		
INSERT INTO sallefitness.candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Claes', 'Maxime', STR_TO_DATE('25,10,1995','%d,%m,%Y'), 'h', '0485747875', STR_TO_DATE('12,05,2019','%d,%m,%Y'), STR_TO_DATE('09,05,2019','%d,%m,%Y'), 1, TRUE, 
		null, 1, 3, 1, '392f464deb8443422c19915fa2f2d1f326d73902');

INSERT INTO sallefitness.candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Claes', 'Guillaume', STR_TO_DATE('20,06,1998','%d,%m,%Y'), 'h', null, STR_TO_DATE('11,05,2019','%d,%m,%Y'), STR_TO_DATE('09,05,2019','%d,%m,%Y'), 1, FALSE, 
		null, 1, 2, 1, '392f464deb8443422c19915fa2f2d1f326d73902');
		
INSERT INTO sallefitness.candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Auboisdormant', 'Abel', STR_TO_DATE('05,08,1989','%d,%m,%Y'), 'f', '0476652545', null, STR_TO_DATE('06,02,2019','%d,%m,%Y'), 4, TRUE, 
		null, 1, 4, 1, '15f794bdc437299d7f9ef45b19431fd481fa268e');
		
INSERT INTO sallefitness.candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Labrosse', 'Adam', STR_TO_DATE('21,02,2001','%d,%m,%Y'), 'f', null, null, STR_TO_DATE('08,03,2019','%d,%m,%Y'), 5, FALSE, 
		null, 3, 2, 2, '36877eb2c9634b0b3d4cd19ff510c283719fa7ef');
		
INSERT INTO sallefitness.candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Halord', 'Ahmed', STR_TO_DATE('25,09,1993','%d,%m,%Y'), 'h', '0495897867', STR_TO_DATE('20,05,2019','%d,%m,%Y'), STR_TO_DATE('12,05,2019','%d,%m,%Y'), 6, TRUE, 
		null, 4, 5, 3, 'e951347e9311501b21f5245bd2bf37695ce019d0');
		
INSERT INTO sallefitness.candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Gator', 'Ali', STR_TO_DATE('01,02,1956','%d,%m,%Y'), 'h', null, null, STR_TO_DATE('06,05,2019','%d,%m,%Y'), 4, TRUE, 
		null, 2, 2, 2, 'a45f887198803acbc4e348d6d66f0eb5eb351045');
		
INSERT INTO sallefitness.candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Gémlamorte', 'Adèle', STR_TO_DATE('31,12,1991','%d,%m,%Y'), 'f', '0475857577', STR_TO_DATE('14,05,2019','%d,%m,%Y'), STR_TO_DATE('09,05,2019','%d,%m,%Y'), 4, FALSE, 
		null, 3, 1, 3, '65c28645b3e5173063f5daf30a5de898b2cce0e5');

INSERT INTO sallefitness.candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Vent', 'Amida', STR_TO_DATE('21,09,1985','%d,%m,%Y'), 'f', null, null, STR_TO_DATE('11,05,2019','%d,%m,%Y'), 3, FALSE, 
		'Douleurs au mollet', 2, 3, 1, 'd18d92b334c36c99d4d42f473d490931913abf66');
		
INSERT INTO sallefitness.candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Hire de Rire', 'Hamour', STR_TO_DATE('09,02,1989','%d,%m,%Y'), 'h', '0485985632', null, STR_TO_DATE('01,05,2019','%d,%m,%Y'), 5, TRUE, 
		'Mal de dos', 4, 2, 3, 'bf53f617c62ddf8947ac648be30e8755934e3f29');

INSERT INTO sallefitness.candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Wood Chwimgom', 'Ali', STR_TO_DATE('16,10,1995','%d,%m,%Y'), 'f', '081565224', STR_TO_DATE('12,05,2019','%d,%m,%Y'), STR_TO_DATE('12,05,2019','%d,%m,%Y'), 6, FALSE, 
		null, 2, 1, 3, 'e816db98b2d664457882f883c6985f2c92ce5ff7');
		
INSERT INTO sallefitness.candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Cepcion', 'Alex', STR_TO_DATE('12,05,2003','%d,%m,%Y'), 'h', '0478987855', STR_TO_DATE('12,05,2019','%d,%m,%Y'), STR_TO_DATE('12,05,2019','%d,%m,%Y'), 4, TRUE, 
		'Anémie', 3, 4, 3, 'e816db98b2d664457882f883c6985f2c92ce5ff7');

INSERT INTO sallefitness.candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Mudatropserré', 'Albert', STR_TO_DATE('30,04,1996','%d,%m,%Y'), 'h', null, null, STR_TO_DATE('28,03,2019','%d,%m,%Y'), 3, FALSE, 
		'Allergies', 4, 1, 2, '36877eb2c9634b0b3d4cd19ff510c283719fa7ef');
		
INSERT INTO sallefitness.candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Vent', 'Enemida', STR_TO_DATE('06,09,1998','%d,%m,%Y'), 'f', '0498654595', STR_TO_DATE('12,05,2019','%d,%m,%Y'), STR_TO_DATE('12,05,2019','%d,%m,%Y'), 2, FALSE, 
		null, 1, 3, 2, 'd18d92b334c36c99d4d42f473d490931913abf66');
		
INSERT INTO sallefitness.candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Verse', 'Alain', STR_TO_DATE('20,06,2001','%d,%m,%Y'), 'h', null, null, STR_TO_DATE('11,04,2019','%d,%m,%Y'), 3, TRUE, 
		null, 2, 4, 3, '36877eb2c9634b0b3d4cd19ff510c283719fa7ef');
		
INSERT INTO sallefitness.candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Bande', 'Ana', STR_TO_DATE('29,11,1989','%d,%m,%Y'), 'f', '0478126578', STR_TO_DATE('02,05,2019','%d,%m,%Y'), STR_TO_DATE('18,04,2019','%d,%m,%Y'), 4, FALSE, 
		'Diabète', 1, 5, 1, 'bf53f617c62ddf8947ac648be30e8755934e3f29');
		
		