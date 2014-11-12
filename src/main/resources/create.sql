DROP DATABASE IF EXISTS server_java;
CREATE DATABASE server_java DEFAULT CHARACTER SET utf8;
use server_java;

drop table categories;
drop table items;
drop table cartItems;

create table categories (
  id int(11) NOT NULL auto_increment,
  name varchar(30) NOT NULL,
  PRIMARY KEY  (id)
);

create table items (
  id int(11) NOT NULL auto_increment,
  name varchar(30) NOT NULL,
  price double NOT NULL,
  unit varchar(4) NOT NULL,
  categoryId int(11) NOT NULL,
  PRIMARY KEY (id),
  foreign key(categoryId) references categories(id)
);

create table cartItems (
  id int(11) NOT NULL auto_increment,
  itemId int(11) NOT NULL,
  num int(11) NOT NULL,
  PRIMARY KEY (id),
  foreign key(itemId) references items(id)
);

insert into categories values(null,'饮品');
insert into categories values(null,'水果');
insert into categories values(null,'零食');
insert into categories values(null,'生活用品');

insert into items values(null, '葡萄', 6.5, '斤', 2);
insert into items values(null, '雪碧', 3.5, '瓶', 1);
insert into items values(null, '可口可乐', 3.0, '瓶', 1);
insert into items values(null, '方便面', 4.0, '袋', 3);
insert into items values(null, '电池', 2.0, '个', 4);
insert into items values(null, '苹果', 3.5, '斤', 2);

insert into cartItems values(null, 1, 5);
insert into cartItems values(null, 2, 3);
insert into cartItems values(null, 6, 3);
insert into cartItems values(null, 4, 2);
COMMIT;