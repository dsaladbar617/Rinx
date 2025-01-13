drop table if exists teams_goalies cascade;
drop table if exists teams_skaters cascade;
drop table if exists skaters cascade;
drop table if exists goalies cascade;
drop table if exists teams cascade;
drop table if exists members cascade;
drop table if exists rinks cascade;
drop table if exists leagues cascade;

CREATE TABLE rinks (
                    rink_id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                    rink_name varchar(255) DEFAULT NULL,
                    rink_number int DEFAULT NULL
);

CREATE TABLE leagues (
                    league_id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                    league_name varchar(255) NOT NULL
);

CREATE TABLE teams (
                    team_id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                    team_name varchar(255) NOT NULL,
                    league_id bigint DEFAULT NULL,
                    CONSTRAINT teams_ibfk_1 FOREIGN KEY (league_id) REFERENCES leagues (league_id) ON DELETE CASCADE
);

CREATE TABLE members (
                    member_id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                    first_name varchar(255) NOT NULL,
                    last_name varchar(255) NOT NULL,
                    email varchar(255) NOT NULL UNIQUE,
                    member_password varchar(255) DEFAULT NULL,
                    date_joined date NOT NULL
);

CREATE TABLE skaters (
                    skater_id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                    member_id bigint DEFAULT NULL,
                    goals int DEFAULT '0',
                    assists int DEFAULT '0',
                    pim int DEFAULT '0',
                    CONSTRAINT skaters_ibfk_1 FOREIGN KEY (member_id) REFERENCES members (member_id) ON DELETE CASCADE
);

CREATE TABLE goalies (
                    goalie_id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
                    member_id bigint DEFAULT NULL,
                    shots_against int DEFAULT '0',
                    saves int DEFAULT '0',
                    pim int DEFAULT '0',
                    CONSTRAINT goalies_ibfk_1 FOREIGN KEY (member_id) REFERENCES members (member_id) ON DELETE CASCADE
);

CREATE TABLE teams_skaters (
                   team_id BIGINT NOT NULL,
                   skater_id BIGINT NOT NULL,
                   CONSTRAINT fk_teams_skaters_team FOREIGN KEY (team_id) REFERENCES teams (team_id) ON DELETE CASCADE,
                   CONSTRAINT fk_teams_skaters_skater FOREIGN KEY (skater_id) REFERENCES skaters (skater_id) ON DELETE CASCADE,
                   PRIMARY KEY (team_id, skater_id)
);

CREATE TABLE teams_goalies (
                   team_id BIGINT NOT NULL,
                   goalie_id BIGINT NOT NULL,
                   CONSTRAINT fk_teams_goalies_team FOREIGN KEY (team_id) REFERENCES teams (team_id) ON DELETE CASCADE,
                   CONSTRAINT fk_teams_goalies_goalie FOREIGN KEY (goalie_id) REFERENCES goalies (goalie_id) ON DELETE CASCADE,
                   PRIMARY KEY (team_id, goalie_id)
);


