INSERT INTO public.pages
(id, title, description)
VALUES(1, 'JBandit - Blog', 'Bienvenue sur le site JBandit, un condensé d''informations sur les nouvelles technologies.');

INSERT INTO public.properties
(id, "name", value)
VALUES(1, 'mentionslegales', 'Test mentions légales');

INSERT INTO public.page_properties
(id_page, id_property)
VALUES(1, 1);

INSERT INTO public.articles
(link)
VALUES('spring-boot-2-and-kotlin');
INSERT INTO public.articles
(link)
VALUES('intellij-idea-to-eclipse');
INSERT INTO public.articles
(link)
VALUES('kotlin-elastic-hello-world');
INSERT INTO public.articles
(link)
VALUES('spring-bean-list');
INSERT INTO public.articles
(link)
VALUES('dbeaver');
INSERT INTO public.articles
(link)
VALUES('java-memory-management');
INSERT INTO public.articles
(link)
VALUES('unity-ubuntu-how-to-install-environment');

INSERT INTO public.articleshead
(link, title, description, create_date, "type", theme, image)
VALUES('test', 'test article', 'description article test', '2018-06-09', 'billet', 'test', '');
INSERT INTO public.articleshead
(link, title, description, create_date, "type", theme, image)
VALUES('spring-boot-2-and-kotlin', 'spring-boot-2-and-kotlin', 'description article tggggggggest', '2018-06-08', 'billet', 'kotlin', NULL);
INSERT INTO public.articleshead
(link, title, description, create_date, "type", theme, image)
VALUES('intellij-idea-to-eclipse', 'intellij-idea-to-eclipse', 'deeeededcv ffd gd gdf g', '2018-06-07', 'billet', 'intelliJ', NULL);
INSERT INTO public.articleshead
(link, title, description, create_date, "type", theme, image)
VALUES('kotlin-elastic-hello-world', 'kotlin-elastic-hello-world', 'description articgggggle test', '2018-05-25', 'billet', 'kotlin', NULL);
INSERT INTO public.articleshead
(link, title, description, create_date, "type", theme, image)
VALUES('spring-bean-list', 'spring-bean-list', 'description article tddddest', '2018-06-05', 'billet', 'java', NULL);
INSERT INTO public.articleshead
(link, title, description, create_date, "type", theme, image)
VALUES('dbeaver', 'dbeaver', 'sdfsd', '2018-06-03', 'billet', 'Base de données', NULL);
INSERT INTO public.articleshead
(link, title, description, create_date, "type", theme, image)
VALUES('java-memory-management', 'java-memory-management', 'fdsfdsfsdf', '2018-06-02', 'tutoriel', 'java', NULL);
INSERT INTO public.articleshead
(link, title, description, create_date, "type", theme, image)
VALUES('unity-ubuntu-how-to-install-environment', 'unity-ubuntu-how-to-install-environment', 'description article testfsdfsd', '2018-06-01', 'tutoriel', 'unity', NULL);
