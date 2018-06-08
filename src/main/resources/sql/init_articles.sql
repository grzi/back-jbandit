CREATE TABLE articleshead (
	id int NOT NULL,
	title varchar NOT NULL,
	description varchar(300) NULL,
	create_date date NULL,
	link varchar(150) NOT NULL,
	"type" varchar(50) NOT NULL,
	theme varchar(50) NULL,
	image varchar(100) NULL,
	CONSTRAINT articleshead_pk PRIMARY KEY (id)
);

CREATE TABLE public.pages (
	id int4 NOT NULL,
	title varchar(100) NOT NULL,
	description varchar(300) NULL,
	CONSTRAINT pages_pk PRIMARY KEY (id)
);

CREATE TABLE public.properties (
	id int4 NOT NULL,
	"name" varchar(100) NOT NULL,
	value varchar(500) NULL,
	CONSTRAINT properties_pk PRIMARY KEY (id)
);

CREATE TABLE public.page_properties (
	id_page int NOT NULL,
	id_property int NOT NULL,
	CONSTRAINT page_properties_pk PRIMARY KEY (id_page,id_property),
	CONSTRAINT page_properties_pages_fk FOREIGN KEY (id_page) REFERENCES public.pages(id),
	CONSTRAINT page_properties_properties_fk FOREIGN KEY (id_property) REFERENCES public.properties(id)
);

