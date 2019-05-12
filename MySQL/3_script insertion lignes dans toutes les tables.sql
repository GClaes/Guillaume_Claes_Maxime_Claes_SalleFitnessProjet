INSERT INTO coach (nom, prenom, date_debut_coaching, salaire_horaire, recompenses) 
VALUES ('Twight', 'Mark', STR_TO_DATE('01,01,2019','%d,%m,%Y'), 12.95, null);

INSERT INTO coach (nom, prenom, date_debut_coaching, salaire_horaire, recompenses) 
VALUES ('Dizzi', 'Thomas', STR_TO_DATE('09,02,2015','%d,%m,%Y'), 15.45, null);

INSERT INTO coach (nom, prenom, date_debut_coaching, salaire_horaire, recompenses) 
VALUES ('Bouraïma', 'Joël', STR_TO_DATE('01,01,2000','%d,%m,%Y'), 29.95, 'Coach reconnu');

INSERT INTO coach (nom, prenom, date_debut_coaching, salaire_horaire, recompenses) 
VALUES ('Woodward', 'Lucile', STR_TO_DATE('23,12,2010','%d,%m,%Y'), 20, 'Meilleure plus jeune coach 2011');

INSERT INTO nutritionniste (nom, prenom, avis) 
VALUES ('Cohen','Jean-Michel', 'Trés bon nutritionniste');

INSERT INTO nutritionniste (nom, prenom, avis) 
VALUES ('Adam','Eve éché', null);

INSERT INTO nutritionniste (nom, prenom, avis) 
VALUES ('Ange Gardien','Josephine', 'Petite mais correcte');

INSERT INTO responsable (nom, prenom) 
VALUES ('Meurdesoif','Jean');

INSERT INTO responsable (nom, prenom) 
VALUES ('Morrison','Maurice');

INSERT INTO adresse (code_hash, localite, code_postal, rue, numero) 
VALUES ('15f794bdc437299d7f9ef45b19431fd481fa268e', 'Hondelange', '6780', 'Emile-Kirsch', '29');

INSERT INTO adresse (code_hash, localite, code_postal, rue, numero) 
VALUES ('36877eb2c9634b0b3d4cd19ff510c283719fa7ef', 'Biesme-sous-Thuin', '6531', 'Broussetaille', '6');

INSERT INTO adresse (code_hash, localite, code_postal, rue, numero) 
VALUES ('392f464deb8443422c19915fa2f2d1f326d73902', 'Gesves', '5340', 'Labas', '5');

INSERT INTO adresse (code_hash, localite, code_postal, rue, numero) 
VALUES ('65c28645b3e5173063f5daf30a5de898b2cce0e5', 'Chênée', '4032', 'Reconnaissance', '2');

INSERT INTO adresse (code_hash, localite, code_postal, rue, numero) 
VALUES ('a45f887198803acbc4e348d6d66f0eb5eb351045', 'Cherain', '6673', 'Sterpigny', '65');

INSERT INTO adresse (code_hash, localite, code_postal, rue, numero) 
VALUES ('bf53f617c62ddf8947ac648be30e8755934e3f29', 'Jemelle', '5580', 'Bouleaux', '11');

INSERT INTO adresse (code_hash, localite, code_postal, rue, numero) 
VALUES ('d18d92b334c36c99d4d42f473d490931913abf66', 'Bourseigne-Neuve', '5575', 'Robio', '23');

INSERT INTO adresse (code_hash, localite, code_postal, rue, numero) 
VALUES ('e816db98b2d664457882f883c6985f2c92ce5ff7', 'Wibrin', '6666', 'Copette', '34');

INSERT INTO adresse (code_hash, localite, code_postal, rue, numero) 
VALUES ('e951347e9311501b21f5245bd2bf37695ce019d0', 'Rocourt', '4000', 'Beaumont', '3');

INSERT INTO candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Cook', 'Thomas', STR_TO_DATE('12,12,1995','%d,%m,%Y'), 'h', '0478121212', null, STR_TO_DATE('02,05,2019','%d,%m,%Y'), 4, TRUE, 
		null, 1, 1, 1, 'e816db98b2d664457882f883c6985f2c92ce5ff7');
		
INSERT INTO candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Neymar', 'Jean', STR_TO_DATE('10,11,1998','%d,%m,%Y'), 'h', '0495366554', null, STR_TO_DATE('09,05,2019','%d,%m,%Y'), 2, FALSE, 
		'Scoliose', 1, 1, 1, 'a45f887198803acbc4e348d6d66f0eb5eb351045');
		
INSERT INTO candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Claes', 'Maxime', STR_TO_DATE('25,10,1995','%d,%m,%Y'), 'h', '0485747875', STR_TO_DATE('12,05,2019','%d,%m,%Y'), STR_TO_DATE('09,05,2019','%d,%m,%Y'), 1, TRUE, 
		null, 1, 1, 1, '392f464deb8443422c19915fa2f2d1f326d73902');

INSERT INTO candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Claes', 'Guillaume', STR_TO_DATE('20,06,1998','%d,%m,%Y'), 'h', null, STR_TO_DATE('11,05,2019','%d,%m,%Y'), STR_TO_DATE('09,05,2019','%d,%m,%Y'), 1, FALSE, 
		null, 1, 1, 1, '392f464deb8443422c19915fa2f2d1f326d73902');
		
INSERT INTO candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Auboisdormant', 'Abel', STR_TO_DATE('05,08,1989','%d,%m,%Y'), 'f', '0476652545', null, STR_TO_DATE('06,02,2019','%d,%m,%Y'), 4, TRUE, 
		null, 1, 1, 1, '15f794bdc437299d7f9ef45b19431fd481fa268e');
		
INSERT INTO candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Labrosse', 'Adam', STR_TO_DATE('21,02,2001','%d,%m,%Y'), 'f', null, null, STR_TO_DATE('08,03,2019','%d,%m,%Y'), 5, FALSE, 
		null, 3, 2, 2, '36877eb2c9634b0b3d4cd19ff510c283719fa7ef');
		
INSERT INTO candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Halord', 'Ahmed', STR_TO_DATE('25,09,1993','%d,%m,%Y'), 'h', '0495897867', STR_TO_DATE('20,05,2019','%d,%m,%Y'), STR_TO_DATE('12,05,2019','%d,%m,%Y'), 6, TRUE, 
		null, 4, 2, 3, 'e951347e9311501b21f5245bd2bf37695ce019d0');
		
INSERT INTO candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Gator', 'Ali', STR_TO_DATE('01,02,1956','%d,%m,%Y'), 'h', null, null, STR_TO_DATE('06,05,2019','%d,%m,%Y'), 4, TRUE, 
		null, 2, 2, 2, 'a45f887198803acbc4e348d6d66f0eb5eb351045');
		
INSERT INTO candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Gémlamorte', 'Adèle', STR_TO_DATE('31,12,1991','%d,%m,%Y'), 'f', '0475857577', STR_TO_DATE('14,05,2019','%d,%m,%Y'), STR_TO_DATE('09,05,2019','%d,%m,%Y'), 4, FALSE, 
		null, 3, 1, 3, '65c28645b3e5173063f5daf30a5de898b2cce0e5');

INSERT INTO candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Vent', 'Amida', STR_TO_DATE('21,09,1985','%d,%m,%Y'), 'f', null, null, STR_TO_DATE('11,05,2019','%d,%m,%Y'), 3, FALSE, 
		'Douleurs au mollet', 2, 1, 1, 'd18d92b334c36c99d4d42f473d490931913abf66');
		
INSERT INTO candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Hire de Rire', 'Hamour', STR_TO_DATE('09,02,1989','%d,%m,%Y'), 'h', '0485985632', null, STR_TO_DATE('01,05,2019','%d,%m,%Y'), 5, TRUE, 
		'Mal de dos', 4, 2, 3, 'bf53f617c62ddf8947ac648be30e8755934e3f29');

INSERT INTO candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Wood Chwimgom', 'Ali', STR_TO_DATE('16,10,1995','%d,%m,%Y'), 'f', '081565224', STR_TO_DATE('12,05,2019','%d,%m,%Y'), STR_TO_DATE('12,05,2019','%d,%m,%Y'), 6, FALSE, 
		null, 2, 1, 3, 'e816db98b2d664457882f883c6985f2c92ce5ff7');
		
INSERT INTO candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Cepcion', 'Alex', STR_TO_DATE('12,05,2003','%d,%m,%Y'), 'h', '0478987855', STR_TO_DATE('12,05,2019','%d,%m,%Y'), STR_TO_DATE('12,05,2019','%d,%m,%Y'), 4, TRUE, 
		'Anémie', 3, 1, 3, 'e816db98b2d664457882f883c6985f2c92ce5ff7');

INSERT INTO candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Mudatropserré', 'Albert', STR_TO_DATE('30,04,1996','%d,%m,%Y'), 'h', null, null, STR_TO_DATE('28,03,2019','%d,%m,%Y'), 3, FALSE, 
		'Allergies', 4, 1, 2, '36877eb2c9634b0b3d4cd19ff510c283719fa7ef');
		
INSERT INTO candidat (nom, prenom, date_naissance, 
					sexe, num_gsm, date_test_valide, date_inscription, nb_heures_coaching, 
                    debutant, maladies_chroniques, coach_matricule, responsable_matricule, 
                    nutritionniste_num_reference, adresse_code_hash) 
VALUES ('Vent', 'Enemida', STR_TO_DATE('06,09,1998','%d,%m,%Y'), 'f', '0498654595', STR_TO_DATE('12,05,2019','%d,%m,%Y'), STR_TO_DATE('12,05,2019','%d,%m,%Y'), 2, FALSE, 
		null, 1, 1, 2, 'd18d92b334c36c99d4d42f473d490931913abf66');
		
