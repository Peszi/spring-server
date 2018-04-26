

create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), password varchar(255), token varchar(255), primary key (id)) engine=InnoDB;
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB;
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id);
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id);
