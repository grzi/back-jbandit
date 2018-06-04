INSERT INTO user
(id, username, email, password, enabled, locked, lastcredentialchange)
VALUES(1, 'grzi', 'jeremy.thulliez@gmail.com', '{bcrypt}$2a$10$qpOnBnf/T5mPgfbL74IrLuvNNf6DUZ9rjCiphe3moeS7MczdDseKy', true, false, '2018-06-02');


INSERT INTO public.ref_roles (id, "name") VALUES(0, 'ROLE_ADMIN');
INSERT INTO public.ref_roles(id, "name") VALUES(1, 'ROLE_USER');

INSERT INTO public.user_roles (id_user, id_role) VALUES(1, 0);
INSERT INTO public.user_roles (id_user, id_role) VALUES(1, 1);