use rinx;

create table if not exists leagues (
    id int PRIMARY KEY AUTO_INCREMENT,
    league_name varchar(255) NOT NULL
);

create table if not exists teams (
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    league_id int,
    foreign key (league_id) references leagues(id)
);

create table if not exists members (
    id int PRIMARY KEY AUTO_INCREMENT,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    member_password varchar(45) NOT NULL,
    date_joined date not null
);

create table if not exists goalies (
    id int PRIMARY KEY AUTO_INCREMENT,
    member_id int,
    foreign key (member_id) references members(id),
    shots_against int DEFAULT 0,
    saves int DEFAULT 0,
    pim int DEFAULT 0
);


create table if not exists skaters (
    id int PRIMARY KEY AUTO_INCREMENT,
    member_id int,
    foreign key (member_id) references members(id),
    goals int DEFAULT 0,
    assists int DEFAULT 0,
    pim int DEFAULT 0
);

create table if not exists team_rosters (
	id int PRIMARY KEY AUTO_INCREMENT,
    skater_id int,
    goalie_id int,
    team_id int,
    foreign key (skater_id) references skaters(id),
    foreign key (goalie_id) references goalies(id),
    foreign key (team_id) references teams(id)
);

create table if not exists games (
    id int PRIMARY KEY AUTO_INCREMENT,
    game_date date not null,
    game_time time not null,
    rink int,
    league_id int,
    away_team int,
    home_team int,
    foreign key (league_id) references leagues(id),
    foreign key (away_team) references teams(id),
    foreign key (home_team) references teams(id),
    away_team_score int not null,
    home_team_score int not null,
    away_team_pim int default 0,
    home_team_pim int default 0,
    away_team_shots int,
    home_team_shots int
);