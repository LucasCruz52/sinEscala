INSERT INTO Intervalo(cod_intervalo, duracao) VALUES (1, 15);
INSERT INTO Intervalo(cod_intervalo, duracao) VALUES (2, 60);

INSERT INTO Restricao(cod_restricao, descricao, horas_folga) VALUES (1, 'Descanso para jornadas de 6h ou 18h.', 11);
INSERT INTO Restricao(cod_restricao, descricao, horas_folga) VALUES (2, 'Descanso para jornadas de 12h.', 36);

INSERT INTO CargaHorariaDia(cod_ch_dia, duracao, intervalo, restricao) VALUES (1, 6, 1, 1);
INSERT INTO CargaHorariaDia(cod_ch_dia, duracao, intervalo, restricao) VALUES (2, 18, 2, 1);
INSERT INTO CargaHorariaDia(cod_ch_dia, duracao, intervalo, restricao) VALUES (3, 12, 2, 2);

INSERT INTO CargaHorariaMes(cod_ch_mes, ch_mensal) VALUES (1, 144);
INSERT INTO CargaHorariaMes(cod_ch_mes, ch_mensal) VALUES (2, 120);

INSERT INTO Turno(cod_tipo, nome_tipo, descricao_tipo) VALUES (1, 'MAT', 'MATUTINO/MANHÃ');
INSERT INTO Turno(cod_tipo, nome_tipo, descricao_tipo) VALUES (2, 'VES', 'VESPERTINO/TARDE');
INSERT INTO Turno(cod_tipo, nome_tipo, descricao_tipo) VALUES (3, 'NOT', 'NOTURNO/NOITE');

INSERT INTO TipoProfissional(cod_tipo, nome_tipo, descricao_tipo) VALUES (1, 'TE', 'TECNICO DE ENFERMAGEM');
INSERT INTO TipoProfissional(cod_tipo, nome_tipo, descricao_tipo) VALUES (2, 'AE', 'AUXILIAR DE ENFERMAGEM');
INSERT INTO TipoProfissional(cod_tipo, nome_tipo, descricao_tipo) VALUES (3, 'ENF', 'ENFERMEIRO');
INSERT INTO TipoProfissional(cod_tipo, nome_tipo, descricao_tipo) VALUES (4, 'CHEF', 'CHEFE DIVISÃO DE ENFERMERMAGEM');
INSERT INTO TipoProfissional(cod_tipo, nome_tipo, descricao_tipo) VALUES (5, 'SUBCHEF', 'SUBCHEFE DE UNIDADE');

INSERT INTO TipoSituacaoSolicitacao(cod_tipo, nome_tipo, descricao_tipo) VALUES (1, 'APROV', 'APROVADA');
INSERT INTO TipoSituacaoSolicitacao(cod_tipo, nome_tipo, descricao_tipo) VALUES (2, 'NEGAD', 'NEGADA');
INSERT INTO TipoSituacaoSolicitacao(cod_tipo, nome_tipo, descricao_tipo) VALUES (3, 'ANALI', 'EM ANÁLISE');
INSERT INTO TipoSituacaoSolicitacao(cod_tipo, nome_tipo, descricao_tipo) VALUES (4, 'ENVIAD', 'ENVIADA');
INSERT INTO TipoSituacaoSolicitacao(cod_tipo, nome_tipo, descricao_tipo) VALUES (5, 'RECEBID', 'RECEBIDA');

INSERT INTO TipoSituacaoEscala(cod_tipo, nome_tipo, descricao_tipo) VALUES (1, 'APROV', 'APROVADA');
INSERT INTO TipoSituacaoEscala(cod_tipo, nome_tipo, descricao_tipo) VALUES (2, 'NEGAD', 'NEGADA');
INSERT INTO TipoSituacaoEscala(cod_tipo, nome_tipo, descricao_tipo) VALUES (3, 'HOMOL', 'HOMOLOGADA');
INSERT INTO TipoSituacaoEscala(cod_tipo, nome_tipo, descricao_tipo) VALUES (4, 'CORREC', 'CORREÇÃO SOLICITADA');
INSERT INTO TipoSituacaoEscala(cod_tipo, nome_tipo, descricao_tipo) VALUES (5, 'ENVIAD', 'ENVIADA');
INSERT INTO TipoSituacaoEscala(cod_tipo, nome_tipo, descricao_tipo) VALUES (6, 'RECEBID', 'RECEBIDA');

INSERT INTO TipoAfastamento(cod_tipo, nome_tipo, descricao_tipo, prazo_deferimento, status, quantidade_dias) VALUES (1, 'LM', 'LICENÇA MATERNIDADE', 1, TRUE, 180);
INSERT INTO TipoAfastamento(cod_tipo, nome_tipo, descricao_tipo, prazo_deferimento, status, quantidade_dias) VALUES (2, 'LP', 'LICENÇA MATERNIDADE', 1, TRUE, 5);
INSERT INTO TipoAfastamento(cod_tipo, nome_tipo, descricao_tipo, prazo_deferimento, status, quantidade_dias) VALUES (3, 'L', 'LICENÇA MÉDICA/ODONTOLÓGICA', 1, TRUE, 1);
INSERT INTO TipoAfastamento(cod_tipo, nome_tipo, descricao_tipo, prazo_deferimento, status, quantidade_dias) VALUES (4, 'LC', 'LICENÇA CAPACITAÇÃO', 1, TRUE, 1);
INSERT INTO TipoAfastamento(cod_tipo, nome_tipo, descricao_tipo, prazo_deferimento, status, quantidade_dias) VALUES (5, 'FE', 'FÉRIAS', 60, TRUE, 30);
INSERT INTO TipoAfastamento(cod_tipo, nome_tipo, descricao_tipo, prazo_deferimento, status, quantidade_dias) VALUES (6, 'FO', 'FOLGA', 2, TRUE, 1);
INSERT INTO TipoAfastamento(cod_tipo, nome_tipo, descricao_tipo, prazo_deferimento, status, quantidade_dias) VALUES (7, 'CE', 'CONPENSAÇÃO HORA EXTRA', 1, TRUE, 1);
INSERT INTO TipoAfastamento(cod_tipo, nome_tipo, descricao_tipo, prazo_deferimento, status, quantidade_dias) VALUES (8, 'AF', 'AFASTAMENTO', 1, TRUE, 1);

INSERT INTO TipoPreferencia(cod_tipo, nome_tipo, descricao_tipo, status) VALUES (1, 'FD', 'FERIADO', TRUE);
INSERT INTO TipoPreferencia(cod_tipo, nome_tipo, descricao_tipo, status) VALUES (2, 'RC', 'RECESSO', TRUE);
INSERT INTO TipoPreferencia(cod_tipo, nome_tipo, descricao_tipo, status) VALUES (3, 'PF', 'PONTO FACULTATIVO', TRUE);
INSERT INTO TipoPreferencia(cod_tipo, nome_tipo, descricao_tipo, status) VALUES (4, 'PF', 'PONTO FACULTATIVO', TRUE);
INSERT INTO TipoPreferencia(cod_tipo, nome_tipo, descricao_tipo, status) VALUES (5, 'D', 'PLANTÃO DIA (12h)', TRUE);
INSERT INTO TipoPreferencia(cod_tipo, nome_tipo, descricao_tipo, status) VALUES (6, 'N', 'PLANTÃO NOITE (12h)', TRUE);
INSERT INTO TipoPreferencia(cod_tipo, nome_tipo, descricao_tipo, status) VALUES (7, 'D/N', 'PLANTÃO DIA/NOITE (24h)', TRUE);

INSERT INTO Vinculo(cod_vinculo, nome_vinculo, descricao_vinculo, ch_dia, ch_mes) VALUES (1, 'EBSERH 6/11', 'Empresa Brasileira de Serviços Hospitalares', 1, 1);
INSERT INTO Vinculo(cod_vinculo, nome_vinculo, descricao_vinculo, ch_dia, ch_mes) VALUES (2, 'EBSERH 12/36', 'Empresa Brasileira de Serviços Hospitalares', 3, 1);
INSERT INTO Vinculo(cod_vinculo, nome_vinculo, descricao_vinculo, ch_dia, ch_mes) VALUES (3, 'UFS', 'Universidade Federal de Sergipe', 2, 2);

INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (2158958, 509529, 1, 1, 'Cristiane Dias Vacarri', TRUE, 1);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (2347536, 100593, 1, 2, 'Dominique Souza Farias', TRUE, 2);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (2213461, 364501, 1, 1, 'Jailma Ferreira de Oliveira', TRUE, 2);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (2166265, 540713, 1, 2, 'José Augusto Dias', TRUE, 3);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (1421656, 457019, 2, 3, 'Edson Costa Matos', TRUE, 1);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (1359435, 81088, 1, 3, 'Simone de França Solano', TRUE, 2);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (2348025, 132757, 3, 1, 'Simone de França Solano', TRUE, 2);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (2327677, 126203, 5, 3, 'Andrea Gois Ribeiro', TRUE, 3);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (2347740, 129366, 1, 1, 'Adriana Costa Moura', TRUE, 1);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (2237664, 514545, 1, 2, 'Barbara de Jesus Oliveira Sampaio', TRUE, 2);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (2347792, 72049, 1, 1, 'Edvânia Maria Santos', TRUE, 2);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (2232709, 50875, 1, 2, 'Eloiza Pereira Santos', TRUE, 3);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (1421550, 54731, 1, 3, 'Élida Maria de Souza', TRUE, 1);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (1421651, 446531, 2, 3, 'Silvia Cristina da Silva', TRUE, 2);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (2250154, 109914, 3, 1, 'Mara Maely Oliveira Roque', TRUE, 2);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (1573276, 129049, 5, 2, 'Leila Cristrina Oliveira Santos', TRUE, 3);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (2232671, 390379, 1, 1, 'Alicleyde Souza da Fé', TRUE, 1);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (2289394, 645419, 1, 2, 'Jeymes Neves Rodrigues Paulo', TRUE, 2);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (2149044, 189338, 1, 1, 'Claudileide Mendonça da Silva', TRUE, 2);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (2297671, 957011, 1, 2, 'Érica Siqueira', TRUE, 3);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (2265994, 525110, 1, 3, 'Zilmara Mazzê Rocha', TRUE, 1);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (2149106, 202742, 2, 3, 'Lúcia Helena Ferreira Santos', TRUE, 2);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (1213833, 254371, 3, 1, 'Viviane Couvo Teixeira Fontes', TRUE, 2);
INSERT INTO Profissional(siape, registro_conselho, cargo, horario, nome, status, turno) VALUES (2149068, 280072, 5, 2, 'Grayce Kelly Nunes Fernandes', TRUE, 3);