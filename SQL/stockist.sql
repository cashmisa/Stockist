CREATE SCHEMA IF NOT EXISTS `stockist` DEFAULT CHARACTER SET utf8;
USE `stockist`;

CREATE TABLE IF NOT EXISTS `stockist`.`user` (     
`userName` VARCHAR( 20 ) NOT NULL,    
`role` VARCHAR( 20 ) NOT NULL ,     
`password` VARCHAR( 20 ) NOT NULL,         
PRIMARY KEY (`userName`),
INDEX `userName` (`userName`))
ENGINE=INNODB
DEFAULT CHARACTER SET = utf8;

INSERT INTO user VALUES ('admin1','admin','admin1pass');
INSERT INTO user VALUES ('admin2','admin','admin2pass');
INSERT INTO user VALUES ('chunket','mechanic','ckpass');
INSERT INTO user VALUES ('gray','mechanic','graypass');
INSERT INTO user VALUES ('mengguan','mechanic','mengpass');
INSERT INTO user VALUES ('nathan','mechanic','npass');
INSERT INTO user VALUES ('raji','mechanic','rajipass');
INSERT INTO user VALUES ('xiaowen','mechanic','xwpass');
INSERT INTO user VALUES ('zinko','mechanic','maypass');

CREATE TABLE IF NOT EXISTS `stockist`.`supplier` (     
`supplierId` INT NOT NULL AUTO_INCREMENT,   
`supplierName` VARCHAR( 45 ) NOT NULL ,     
`contactName` VARCHAR( 45 ) NOT NULL, 
`phoneNumber` VARCHAR( 20 ) NOT NULL,   
`email` VARCHAR( 65 ) NOT NULL,
`website` VARCHAR ( 65 ) NULL,           
PRIMARY KEY (`supplierId`),
INDEX `supplierId` (`supplierId`))
ENGINE=INNODB
DEFAULT CHARACTER SET = utf8;
ALTER TABLE `supplier` AUTO_INCREMENT=100;

INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`) VALUES ('aims','chee say huay',62896272,'aims@nus.sg','www.aims.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`) VALUES ('aladdin','lauren han',62806776,'aladdin@nus.sg','www.aladdin.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`)  VALUES ('amazon','joey li',66751611,'amazon@nus.sg','www.amazon.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`) VALUES ('autoplicity','hafizah soh',62388535,'autoplicity@nus.sg','www.autoplicity.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`) VALUES ('b2c','ma lye',65488200,'b2c@nus.sg','www.b2c.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`) VALUES ('baxter','nicole ong',63748885,'baxter@nus.sg','www.baxter.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`) VALUES ('factorydepot','erica tan',62712357,'factorydepot@nus.sg','www.factorydepot.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`) VALUES ('gear245','amanda teoh',64681884,'gear245@nus.sg','www.gear245.com');
INSERT INTO supplier  (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`)VALUES ('gplusmotor','serena lok',65472168,'gplusmotor@nus.sg','www.gplusmotor.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`) VALUES ('hotride','jessica poon',69399488,'hotride@nus.sg','www.hotride.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`) VALUES ('lifeproshop','fang hua yi',69126580,'lifeproshop@nus.sg','www.lifeproshop.com');
INSERT INTO supplier  (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`)VALUES ('midway','gilbert oh',66142702,'midway@nus.sg','www.midway.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`) VALUES ('mocity','harrison sun',66360666,'mocity@nus.sg','www.mocity.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`) VALUES ('northern','ee wei ling',69766949,'northern@nus.sg','www.northern.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`) VALUES ('overdrive','sheldon schirmer',66252405,'overdrive@nus.sg','www.overdrive.com');
INSERT INTO supplier  (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`)VALUES ('partshawk','lawrence aw',64291716,'partshawk@nus.sg','www.partshawk.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`) VALUES ('provalue','garett eng',64890105,'provalue@nus.sg','www.provalue.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`) VALUES ('stockwise','davin tay',65998261,'stockwise@nus.sg','www.stockwise.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`) VALUES ('virota','zhen weida',69501594,'virota@nus.sg','www.virota.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`) VALUES ('the part giant','wallace ho',63282461,'thepartgiant@nus.sg','www.thepartgiant.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`) VALUES ('autopartszilla','esther choo',68855909,'autopartszilla@nus.sg','www.autopartszilla.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`)VALUES ('true blue','louis klass',66305022,'trueblue@nus.sg','www.trueblue.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`) VALUES ('windy city','thafiq hassan',65475718,'windycity@nus.sg','www.windycity.com');
INSERT INTO supplier (`supplierName`,`contactName`,`phoneNumber`,`email`,`website`) VALUES ('mad dog','isabella sharil',62599174,'maddog@nus.sg','www.maddog.com');

CREATE TABLE IF NOT EXISTS `stockist`.`product` (     
`partNumber` INT NOT NULL AUTO_INCREMENT,   
`partName` VARCHAR( 45 ) NOT NULL ,     
`brand` VARCHAR( 20 ) NOT NULL, 
`supplierId` INT NOT NULL,
`qty` INT NOT NULL,
`minOrderQty` INT NOT NULL,   
`reOrderQty` INT NOT NULL,
`price` DOUBLE NOT NULL,   
`shelfLocation` VARCHAR ( 5 ) NOT NULL,       
PRIMARY KEY (`partNumber`),
FOREIGN KEY (`supplierId`) REFERENCES `supplier` (`supplierId`) ON UPDATE CASCADE, 
INDEX `partNumber` (`partNumber`))
ENGINE=INNODB
DEFAULT CHARACTER SET = utf8;
ALTER TABLE `product` AUTO_INCREMENT=1000;


INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('abs control unit','bosch',100,8,5,10,35,'b2');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('ac compressor','mophorn',102,8,5,10,90,'m5');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('alternator','magneti marelli',106,7,5,10,60,'m1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('axle shaft','victory lap',114,8,5,10,42,'v1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('ball joint','moog',116,11,5,10,16,'m4');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('blower motor','tyc',101,9,5,10,27,'t2');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('brake caliper','power stop',116,11,5,10,25,'p2');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('brake light switch','acdelco',103,23,10,20,7,'a1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('brake rotor','wagner',113,7,5,10,20,'w1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('camshaft','melling',113,1,1,2,109,'m3');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('camshaft position sensor','dorman',116,13,5,10,15,'d5');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES('clutch','exedy',103,11,5,10,82,'e2');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('control arm','acdelco',106,3,5,10,30,'a1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('crankshaft','moog',105,1,1,2,190,'m4');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('crankshaft seal','toyota',111,21,10,20,4,'t1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('door lock actuator','dorman',118,9,5,10,20,'d5');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('driveshaft','apa',111,1,1,2,145,'a2');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('engine control unit','toyota',110,8,5,10,90,'t1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('exhaust manifold gasket','acdelco',109,22,10,20,9,'a1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('flywheel','exedy',102,11,5,10,35,'e2');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('fuel pump','delphi',112,4,1,5,60,'d1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('gas cap','gates',106,15,10,20,7,'g1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('head gasket','evergreen',108,8,5,10,40,'e1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('heater core','tyc',105,11,5,10,25,'t2');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('hose','acdelco',116,25,10,20,6,'a1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('ignition coil','denso',103,15,10,20,7,'d2');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('ignition switch','motorcraft',112,9,5,10,15,'m6');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('intake manifold gasket','acdelco',116,14,10,20,7,'a1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('license plate light','partsam',115,22,10,20,2,'p1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('mass air flow sensor','walker products',101,12,5,10,30,'w2');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('motor mount','westar',115,12,5,10,12,'w3');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('muffler','flowtech',108,9,5,10,24,'f1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('oxygen sensor','bosch',118,13,5,10,11,'b2');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('oil cooler','derale',106,9,5,10,30,'d3');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('piston ring','mahle original',108,12,5,10,25,'m2');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('power steering pump','drivestar',107,12,5,10,60,'d6');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('power window switch','dorman',103,18,10,20,8,'d5');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('pressure sensor','autex',108,12,5,10,18,'a3');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('radiator','tyc',104,13,5,10,40,'t2');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('shock absorber','bilstein',117,12,5,10,21,'b1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('spark plug','bosch',115,15,10,20,3,'b2');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('starter motor','magneti marelli',104,11,5,10,40,'m1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('steering angle sensor','general motors',101,25,10,20,12,'g2');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('steering rack','detroit axle',105,1,1,2,115,'d4');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('sway bar link','moog',104,8,5,10,10,'m4');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('temperature sensor','delphi',113,12,5,10,10,'d1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('thermostat','stant',103,12,10,20,8,'s1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('water pump','acdelco',105,11,5,10,35,'a1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('wheel speed sensor','autex',110,7,5,10,10,'a3');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('wiper motor','wexco',106,7,5,10,30,'w4');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('wiper blade','bosch',121,6,5,10,18,'b2');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('jump starter','gooloo',123,12,5,10,46,'g3');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('windshield','carlite',119,1,2,2,400,'c1');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('headlight','foxelli',120,4,2,2,145,'f2');
INSERT INTO product (`partName`, `brand`, `supplierId`, `qty`, `minOrderQty`, `reOrderQty`, `price`, `shelfLocation`) VALUES ('serpentine belt','moca',122,8,5,10,15,'m7');


CREATE TABLE IF NOT EXISTS `stockist`.`transaction` (     
`transactionId` INT NOT NULL AUTO_INCREMENT,     
`userName` VARCHAR( 20 ) NOT NULL,     
`partNumber` INT NOT NULL,     
`qty` INT NOT NULL,     
`transactionType` VARCHAR( 20 ) NOT NULL,     
`date` DATETIME NOT NULL,     
`customer` VARCHAR( 45 ) NULL,     
`remarks` VARCHAR( 255 ) NULL,          
PRIMARY KEY (`transactionId`),
FOREIGN KEY (`userName`) REFERENCES `user` (`userName`) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (`partNumber`) REFERENCES `product` (`partNumber`) ON UPDATE CASCADE ON DELETE CASCADE,
INDEX `transactionId` (`transactionId`))
ENGINE=INNODB
DEFAULT CHARACTER SET = utf8;

INSERT INTO transaction (`userName`,`partNumber`,`qty`,`transactionType`,`date`,`customer`,`remarks`) VALUES ('nathan',1007,2,'used','2017-10-17 14:14:14','lim',NULL);
INSERT INTO transaction (`userName`,`partNumber`,`qty`,`transactionType`,`date`,`customer`,`remarks`) VALUES ('admin1',1024,10,'received','2017-10-18 14:14:15',NULL,NULL);
INSERT INTO transaction (`userName`,`partNumber`,`qty`,`transactionType`,`date`,`customer`,`remarks`) VALUES ('chunket',1032,1,'used','2017-10-19 14:14:16','hock',NULL);
INSERT INTO transaction (`userName`,`partNumber`,`qty`,`transactionType`,`date`,`customer`,`remarks`) VALUES ('xiaowen',1003,2,'used','2017-10-20 14:14:17','adrian',NULL);
INSERT INTO transaction (`userName`,`partNumber`,`qty`,`transactionType`,`date`,`customer`,`remarks`) VALUES ('mengguan',1049,2,'used','2017-10-21 14:14:18','zaidin',NULL);
INSERT INTO transaction (`userName`,`partNumber`,`qty`,`transactionType`,`date`,`customer`,`remarks`) VALUES ('gray',1019,1,'used','2017-10-22 14:14:19','tan',NULL);
INSERT INTO transaction (`userName`,`partNumber`,`qty`,`transactionType`,`date`,`customer`,`remarks`) VALUES ('zinko',1012,1,'used','2017-10-23 14:14:20','peter',NULL);
INSERT INTO transaction (`userName`,`partNumber`,`qty`,`transactionType`,`date`,`customer`,`remarks`) VALUES ('raji',1011,1,'used','2017-10-24 14:14:21','rami',NULL);
INSERT INTO transaction (`userName`,`partNumber`,`qty`,`transactionType`,`date`,`customer`,`remarks`) VALUES ('admin2',1009,1,'returned','2017-10-25 14:14:22',NULL,'received as damaged');
INSERT INTO transaction (`userName`,`partNumber`,`qty`,`transactionType`,`date`,`customer`,`remarks`) VALUES ('nathan',1038,3,'used','2017-10-26 14:14:23','lim',NULL);
