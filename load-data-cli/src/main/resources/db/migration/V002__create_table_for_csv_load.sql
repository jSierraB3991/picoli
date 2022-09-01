CREATE TABLE IF NOT EXISTS lazy_data (
    id bigint NOT NULL,
    name character varying(200) NOT NULL,
    creation_date timestamp without time zone
);
ALTER TABLE lazy_data OWNER TO ${flyway:user};

CREATE SEQUENCE IF NOT EXISTS lazy_data_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    CACHE 1;
ALTER TABLE lazy_data_id_seq OWNER TO ${flyway:user};

ALTER SEQUENCE lazy_data_id_seq OWNED BY lazy_data.id;
ALTER TABLE ONLY lazy_data ALTER COLUMN id SET DEFAULT nextval('lazy_data_id_seq'::regclass)