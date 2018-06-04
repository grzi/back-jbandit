CREATE TABLE users (
	id integer NOT NULL,
	username varchar(50) NOT NULL,
	email varchar(100) NULL,
	password varchar(150) NOT NULL,
	enabled bool NULL,
	locked bool NULL,
	lastcredentialchange date NULL,
	CONSTRAINT users_pk PRIMARY KEY (id)
)

CREATE TABLE ref_roles (
	id integer NULL,
	"name" varchar(50) NULL,
	CONSTRAINT ref_roles_pk PRIMARY KEY (id)
)

CREATE TABLE public.user_roles (
	id_users integer NOT NULL,
	id_role integer NOT NULL,
	CONSTRAINT user_roles_user_fk FOREIGN KEY (id_users) REFERENCES public."user"(id),
	CONSTRAINT user_roles_ref_roles_fk FOREIGN KEY (id_role) REFERENCES public.ref_roles(id)
)


