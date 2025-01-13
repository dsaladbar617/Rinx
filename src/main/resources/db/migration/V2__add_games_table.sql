drop table if exists games cascade;

CREATE TABLE games (
                game_id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                home_team_id bigint,
                away_team_id bigint,
                rink_id bigint,
                game_date datetime NOT NULL,
                home_score int,
                away_score int,
                CONSTRAINT fk_games_home_team FOREIGN KEY (home_team_id) REFERENCES teams (team_id) ON DELETE SET NULL,
                CONSTRAINT fk_games_away_team FOREIGN KEY (away_team_id) REFERENCES teams (team_id) ON DELETE SET NULL,
                CONSTRAINT fk_games_rink FOREIGN KEY (rink_id) REFERENCES rinks (rink_id) ON DELETE SET NULL

);