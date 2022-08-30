CREATE TABLE IF NOT EXISTS clients(
    id bigint NOT NULL,
    name character varying(200) NOT NULL,
    email character varying(255) NOT NULL,
    address character varying(255) NOT NULL,
    region character varying(100) NOT NULL,
    country character varying(100) NOT NULL,
    aleatory_text character varying(100) NOT NULL,
    aleatory_number int NOT NULL
);
ALTER TABLE clients OWNER TO ${flyway:user};

CREATE SEQUENCE IF NOT EXISTS client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    CACHE 1;
ALTER TABLE client_id_seq OWNER TO ${flyway:user};

ALTER SEQUENCE client_id_seq OWNED BY clients.id;
ALTER TABLE ONLY clients ALTER COLUMN id SET DEFAULT nextval('client_id_seq'::regclass)