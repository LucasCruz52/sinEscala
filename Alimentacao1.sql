INSERT INTO Intervalo(cod_intervalo, duracao) VALUES (1, 15);
INSERT INTO Intervalo(cod_intervalo, duracao) VALUES (2, 60);

INSERT INTO Restricao(cod_restricao, descricao, horas_folga) VALUES (1, 'Descanso para jornadas de 6h ou 18h.', 11);
INSERT INTO Restricao(cod_restricao, descricao, horas_folga) VALUES (2, 'Descanso para jornadas de 12h.', 36);

INSERT INTO CargaHorariaDia(cod_ch_dia, duracao, intervalo, restricao) VALUES (1, 6, 1, 1);
INSERT INTO CargaHorariaDia(cod_ch_dia, duracao, intervalo, restricao) VALUES (2, 18, 2, 1);
INSERT INTO CargaHorariaDia(cod_ch_dia, duracao, intervalo, restricao) VALUES (3, 12, 2, 2);

INSERT INTO CargaHorariaMes(cod_ch_mes, ch_mensal) VALUES (1, 144);
INSERT INTO CargaHorariaMes(cod_ch_mes, ch_mensal) VALUES (2, 120);

INSERT INTO TipoProfissional(cod_tipo, nome_tipo, descricao_tipo) VALUES (1, 'TE', 'TECNICO DE ENFERMAGEM');
INSERT INTO TipoProfissional(cod_tipo, nome_tipo, descricao_tipo) VALUES (2, 'AE', 'AUXILIAR DE ENFERMAGEM');
INSERT INTO TipoProfissional(cod_tipo, nome_tipo, descricao_tipo) VALUES (3, 'ENF', 'ENFERMEIRO');
INSERT INTO TipoProfissional(cod_tipo, nome_tipo, descricao_tipo) VALUES (4, 'CHEF', 'CHEFE DIVISÃO DE ENFERMERMAGEM');
INSERT INTO TipoProfissional(cod_tipo, nome_tipo, descricao_tipo) VALUES (5, 'SUBCHEF', 'SUBCHEFE DE UNIDADE');

INSERT INTO Vinculo(cod_vinculo, nome_vinculo, descricao_vinculo) VALUES (1, 'EBSERH', 'Empresa Brasileira de Serviços Hospitalares');
INSERT INTO Vinculo(cod_vinculo, nome_vinculo, descricao_vinculo) VALUES (2, 'UFS', 'Universidade Federal de Sergipe');

INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (2158958, 509529, 1, 1, 1, 1, 'Cristiane Dias Vacarri', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (2347536, 100593, 1, 1, 1, 1, 'Dominique Souza Farias', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (2213461, 364501, 3, 1, 1, 1, 'Jailma Ferreira de Oliveira', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (2166265, 540713, 3, 1, 1, 1, 'José Augusto Dias', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (1421656, 457019, 2, 2, 2, 2, 'Edson Costa Matos', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (1359435, 81088, 2, 2, 1, 2, 'Simone de França Solano', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (2348025, 132757, 1, 1, 3, 1, 'Simone de França Solano', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (2327677, 126203, 2, 2, 5, 2, 'Andrea Gois Ribeiro', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (2347740, 129366, 1, 1, 1, 1, 'Adriana Costa Moura', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (2237664, 514545, 1, 1, 1, 1, 'Barbara de Jesus Oliveira Sampaio', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (2347792, 72049, 3, 1, 1, 1, 'Edvânia Maria Santos', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (2232709, 50875, 3, 1, 1, 1, 'Eloiza Pereira Santos', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (1421550, 54731, 2, 2, 1, 2, 'Élida Maria de Souza', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (1421651, 446531, 2, 2, 2, 2, 'Silvia Cristina da Silva', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (2250154, 109914, 1, 1, 3, 1, 'Mara Maely Oliveira Roque', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (1573276, 129049, 1, 1, 5, 1, 'Leila Cristrina Oliveira Santos', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (2232671, 390379, 1, 1, 1, 1, 'Alicleyde Souza da Fé', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (2289394, 645419, 1, 1, 1, 1, 'Jeymes Neves Rodrigues Paulo', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (2149044, 189338, 3, 1, 1, 1, 'Claudileide Mendonça da Silva', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (2297671, 957011, 3, 1, 1, 1, 'Érica Siqueira', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (2265994, 525110, 2, 2, 1, 2, 'Zilmara Mazzê Rocha', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (2149106, 202742, 2, 2, 2, 2, 'Lúcia Helena Ferreira Santos', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (1213833, 254371, 1, 1, 3, 1, 'Viviane Couvo Teixeira Fontes', TRUE);
INSERT INTO Profissional(siape, registro_conselho, ch_dia, ch_mes, cargo, vinculo, nome, status) VALUES (2149068, 280072, 1, 1, 5, 1, 'Grayce Kelly Nunes Fernandes', TRUE);
