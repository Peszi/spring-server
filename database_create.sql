create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, created_at datetime not null, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, created_at datetime not null, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table rooms (id bigint not null auto_increment, game_type integer, is_started bit, host_id bigint, primary key (id)) engine=InnoDB
create table teams (id bigint not null auto_increment, alias varchar(32), room_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, active bit not null, deleted bit not null, email varchar(255), name varchar(255), password varchar(255), token varchar(255), team_id bigint, primary key (id)) engine=InnoDB
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB
alter table teams add constraint UKrpl8s8ub2ic6cnqacpro20m22 unique (room_id, alias)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_3g1j96g94xpk3lpxl2qbl985x unique (name)
alter table rooms add constraint FKoxd2xovikhdpk4si9ffhyb83i foreign key (host_id) references users (id)
alter table teams add constraint FKkgky4yaphs7d5oj7fbk0cepsd foreign key (room_id) references rooms (id)
alter table users add constraint FKfjws1rdruab2bqg7qipoqf65r foreign key (team_id) references teams (id)
alter table users_roles add constraint FKj6m8fwv7oqv74fcehir1a9ffy foreign key (role_id) references roles (id)
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users (id)
