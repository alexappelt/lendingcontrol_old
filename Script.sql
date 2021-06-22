CREATE SEQUENCE seq_pk_usuario;
CREATE TABLE usuarios (
	id int PRIMARY KEY DEFAULT nextval('seq_pk_usuario'),
	nome varchar(50),
	email varchar(50),
	img varchar(100),
	login varchar(40),
	senha varchar(40),
	root boolean
);
INSERT INTO usuarios (nome, email, login, senha, root) VALUES ('admin admin',	'admin@admin.com', 'admin', '21232f297a57a5a743894a0e4a801fc3', true);

CREATE SEQUENCE seq_pk_estados START 1;
create table estados(
	id int primary key  DEFAULT nextval('seq_pk_estados'),
	descricao varchar(40)
);
insert into estados values(1, 'Perfeito'), (2, 'Bom'), (3, 'Razoável');


CREATE SEQUENCE seq_pk_status START 1;
create table statuses(
	id int primary key  DEFAULT nextval('seq_pk_status'),
	descricao varchar(40)
);
insert into statuses values(1, 'Emprestado'), (2, 'Finalizado'), (3, 'Reservado');

CREATE SEQUENCE seq_pk_produtos START 1;
create table produtos (
	id int primary key  DEFAULT nextval('seq_pk_produtos'),
	descricao varchar(40),
	marca varchar(40),
	id_estado integer,
	id_usuario integer,
	foreign key (id_estado) references estados(id),
	foreign key (id_usuario) references usuarios(id),
	imagem varchar(80)
);

CREATE SEQUENCE seq_pk_emprestimos START 1;
create table emprestimos (
	id int primary key default nextval('seq_pk_emprestimos'),
	id_mutuante integer,
	id_beneficiario integer,
	id_produto integer,
	id_status integer,
	classificacao integer,
	data date,
	foreign key (id_status) references statuses(id),
	foreign key (id_mutuante) references usuarios(id),
	foreign key (id_beneficiario) references usuarios(id),
	foreign key (id_produto) references produtos(id)
);











