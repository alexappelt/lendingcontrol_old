CREATE SEQUENCE seq_pk_estados START 1;
create table estados(
	id int primary key  DEFAULT nextval('seq_pk_estados'),
	descricao varchar(40)
);
insert into estados values(1, 'Perfeito'), (2, 'Bom'), (3, 'Razoável');


CREATE SEQUENCE seq_pk_status START 1;
create table status(
	id int primary key  DEFAULT nextval('seq_pk_status'),
	descricao varchar(40)
);
insert into status values(1, 'Disponível'), (2, 'Emprestado'), (3, 'Reservado');


CREATE SEQUENCE seq_pk_clientes START 1;

create table clientes (
 id int primary key  DEFAULT nextval('seq_pk_clientes'),
 nome varchar(40),
 sobrenome varchar(40),
 idade integer,
 usuario varchar(40),
 senha varchar(40)
 );


CREATE SEQUENCE seq_pk_produtos START 1;
create table produtos (
	id int primary key  DEFAULT nextval('seq_pk_produtos'),
	descricao varchar(40),
	marca varchar(40),
	id_status integer,
	id_estado integer,
	foreign key (id_status) references status(id),
	foreign key (id_estado) references estados(id),
	imagem varchar(80)
);



