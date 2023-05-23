INSERT INTO perfil ( nome) VALUES('GERENTE');
INSERT INTO perfil (nome) VALUES('OPERADOR');

INSERT INTO usuario ( email, nome, senha) VALUES('gerente@gmail.com', 'gerente', '$2a$10$./f1RQvh4Uo3rSsiOetDMeCKHsorsHzez7Z7najauKoBUABAPLRVy');
INSERT INTO usuario ( email, nome, senha) VALUES('operador@gmail.com', 'operador', '$2a$10$./f1RQvh4Uo3rSsiOetDMeCKHsorsHzez7Z7najauKoBUABAPLRVy');
INSERT INTO usuario_perfil (usuario_id, perfil_id) VALUES(1, 1);
INSERT INTO usuario_perfil (usuario_id, perfil_id) VALUES(2, 2);
