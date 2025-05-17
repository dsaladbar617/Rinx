drop table if exists locations cascade;

CREATE TABLE locations (
    location_id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    street varchar(255) NOT NULL,
    city varchar(255) NOT NULL,
    state varchar(255) NOT NULL,
    zip_code varchar(5) NOT NULL,
    location_name varchar(255) NOT NULL
);

ALTER TABLE rinks ADD COLUMN location_id bigint;
ALTER TABLE rinks ADD CONSTRAINT fk_rinks_location FOREIGN KEY (location_id) REFERENCES locations (location_id) ON DELETE SET NULL;