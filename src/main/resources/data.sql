INSERT INTO kommuner(id,kommune_navn)
VALUES
(8305,'Samsø kommune');

INSERT INTO partier(id,party_name,party_letter,kommune_id)
VALUES
(1,'Socialdemokratiet','A',8305),
(2,'Det konservative Folkeparti','C',8305),
(3,'SF, Socialistisk Folkeparti','F',8305),
(4,'Dansk Folkeparti','O',8305),
(5,'Venstre, Danmarks Liberale Parti','V',8305),
(6,'Enhedslisten + De Rød Grønne','Ø',8305);

INSERT INTO kandidater(kandidat_id,votes,name,parti_id)
VALUES
(1,10,'Marcel Meijer',1),
(2,10,'Michael Kristensen',1),
(3,10,'Helle Hansen',1),
(4,10,'Karina Knobelauch',1),
(5,10,'Stefan Hafstein Wolffbrandt',1),
(6,10,'Robert V. Rasmussen',1),
(7,10,'Pia Ramsing',1),
(8,10,'Anders Baun Sørensen',1),
(9,10,'Per Urban Olsen',2),
(10,10,'Peter Askjær',2),
(11,10,'Martin Sørensen',2),
(12,10,'Louise Bramstorp',2),
(13,10,'Sigfred Jensen',2),
(14,10,'Jørn C. Nissen',2),
(15,10,'Morten Ø. Kristensen',2),
(16,10,'Susanne Andersen',2),
(17,10,'Iulian V. Paiu',2),
(18,10,'Per Hingel',2),
(19,10,'Ulla Holm',3),
(20,10,'Kjeld Bønkel',3),
(21,10,'Anne Grethe Olsen',3),
(22,10,'Lone Krag',3),
(23,10,'Børge S. Buur',3),
(24,10,'Per Mortensen',4),
(25,10,'Søren Wiese',5),
(26,10,'Anita Elgaard Højholt Olesen',5),
(27,10,'Carsten Bruun',5),
(28,10,'Mogens Exner',5),
(29,10,'Anja Guldborg',5),
(30,10,'Klaus Holdorf',5),
(31,10,'Katrine Høegh Mc Quaid',6),
(32,10,'Jette M. Søgaard',6),
(33,10,'Søren Caspersen',6),
(34,10,'Pia Birkmand',6);