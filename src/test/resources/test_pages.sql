INSERT INTO public.pages
(id, title, description)
VALUES(1, 'JBandit - Blog', 'Bienvenue sur le site JBandit, un condensé d''informations sur les nouvelles technologies.');

INSERT INTO public.properties
(id, "name", value)
VALUES(1, 'mentionslegales', 'Test mentions légales');

INSERT INTO public.page_properties
(id_page, id_property)
VALUES(1, 1);
