INSERT INTO "F" VALUES('ABC','EF','false','Impliciet leidt E tot D, waardoor elke waarde gebruikt is');
INSERT INTO "F" VALUES('E','D','true','De attributen B en C missen in de afhankelijkheid');
INSERT INTO "F" VALUES('D','A','true','De attributen B, C, E en F missen in de afhankelijkheid');
CREATE TABLE R1 (A INT, B INT, C INT, E INT, F INT);
CREATE TABLE R2 (E INT, D INT);
CREATE TABLE R3 (D INT, A INT);
CREATE TABLE F1 (x VARCHAR(10), y VARCHAR(10), violation BOOLEAN, motivation VARCHAR(200));
CREATE TABLE F2 (x VARCHAR(10), y VARCHAR(10), violation BOOLEAN, motivation VARCHAR(200));
CREATE TABLE F3 (x VARCHAR(10), y VARCHAR(10), violation BOOLEAN, motivation VARCHAR(200));
INSERT INTO "F1" VALUES('ABC','EF','false','Impliciet leidt E tot D, waardoor elke waarde gebruikt is');
INSERT INTO "F2" VALUES('E','D','false','Geen attributen missen in de afhankelijkheid');
INSERT INTO "F3" VALUES('D','A','false','Geen attributen missen in de afhankelijkheid');