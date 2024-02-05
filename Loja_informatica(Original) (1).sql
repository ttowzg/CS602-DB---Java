CREATE DATABASE Loja_Informatica;
use Loja_Informatica;

create table Cliente(
ID_Cliente int not null auto_increment primary key,
Nome varchar (65) not null, 
Rua varchar(65),
Telefone varchar(20),
Email varchar(35)
);

alter table Cliente
drop column Endereco;

alter table Cliente
add column Rua varchar(30);

alter table Cliente
add column Numero varchar(6);

alter table Cliente 
add column Histórico_Serviços int;
alter table Cliente 
add constraint Histórico_Serviços foreign key(Histórico_Serviços) references Servico(ID_Serviço);

alter table Cliente 
add column ID_Computador int;
alter table Cliente 
add constraint ID_Computador foreign key(ID_Computador) references Computador(ID_Computador);

create table Computador(
Marca varchar(20),
ID_Computador int not null auto_increment primary key,
Especificações varchar(50),
Defeito varchar(60),
ID_Cliente int,
foreign key (ID_Cliente) references  Cliente(ID_Cliente)
);

alter table Computador
drop column Serie;

alter table Computador
drop column modelo;






create table Tecnico(
ID_Técnico int not null auto_increment primary key,
Nome_Técnico varchar(50),
Telefone varchar(15), 
Endereço varchar(65), 
Sálario double 
);
alter table Tecnico 
add column Sexo varchar(25);


describe tecnico;


create table Servico(
ID_Serviço int not null auto_increment primary key,
ID_Cliente int,
foreign key (ID_Cliente) references  Cliente(ID_Cliente),
ID_Computador int,
foreign key (ID_Computador) references Computador(ID_Computador),
ID_Fornecedor int,
foreign key (ID_Fornecedor) references  Fornecedor(ID_Fornecedor),
ID_Produto int,
foreign key (ID_Produto) references  Produto(ID_Produto),
ID_Técnico int,
foreign key (ID_Técnico) references  Tecnico(ID_Técnico),
Data_Devolução date, 
Data_Solicitação date, 
Valor_Total double
);

ALTER TABLE servico
drop column Data_Pagamento;
ALTER TABLE cliente DROP FOREIGN KEY Histórico_Serviços ;


