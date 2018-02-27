CREATE DATABASE SinEscala;

CREATE TABLE CargaHorariaMes (
    cod_ch_mes int NOT NULL,
    ch_mensal int NOT NULL,
    acressimo_horas int NULL,
    ano int NOT NULL,
    mes int NOT NULL,
    CONSTRAINT PK_CargaHorariaMes PRIMARY KEY (cod_ch_mes)
);

CREATE TABLE Intervalo (
    cod_intervalo int NOT NULL,
    turno varchar(10),
    duracao int NOT NULL,
    CONSTRAINT PK_Intervalo PRIMARY KEY (cod_intervalo)
);

CREATE TABLE Log (
    cod_log int NOT NULL,
    data_registro date NOT NULL,
    hora_registro time NOT NULL,
    usuario_registro varchar(40) NOT NULL,
    modulo_registro varchar(20) NOT NULL,
    pagina_registro varchar(20) NOT NULL,
    acao_registro varchar(45) NOT NULL,
    CONSTRAINT PK_Log PRIMARY KEY (cod_log)
);

CREATE TABLE Restricao (
    cod_restricao int NOT NULL,
    descricao varchar (100) NOT NULL,
    horas_trabalho int NOT NULL,
    horas_folga int NOT NULL,
    CONSTRAINT PK_Restricao PRIMARY KEY (cod_restricao)
);

CREATE TABLE SituacaoSolicitacao(
    cod_situacao_solicitacao int NOT NULL,
    data_situacao date NOT NULL,
    hora_situacao time NOT NULL,
    motivo_situacao varchar(40) NOT NULL,
    CONSTRAINT PK_TipoSituacaoSolicitacao PRIMARY KEY (cod_situacao_solicitacao)
);

CREATE TABLE TipoAfastamento (
    cod_tipo int NOT NULL,
    descricao_tipo varchar(45) NOT NULL,
    prazo_deferimento int NOT NULL,
    status boolean NOT NULL,
    quantidade_dias int NOT NULL,
    nome_tipo varchar(25) NOT NULL,
    CONSTRAINT PK_TipoAfastamento PRIMARY KEY (cod_tipo)
);

CREATE TABLE TipoPreferencia (
    cod_tipo int NOT NULL,
    descricao_tipo varchar(45) NOT NULL,
    status boolean NOT NULL,
    nome_tipo varchar(25) NOT NULL,
    CONSTRAINT PK_TipoPreferencia PRIMARY KEY (cod_tipo)
);

CREATE TABLE TipoProfissional (
    cod_tipo int NOT NULL,
    nome_tipo varchar(45) NOT NULL,
    descricao_tipo varchar(100) NOT NULL,
    CONSTRAINT PK_TipoProfissional PRIMARY KEY (cod_tipo)
);

CREATE TABLE TipoRegistro (
    cod_tipo int NOT NULL,
    descricao_tipo varchar(100) NOT NULL,
    nome_tipo varchar(45) NOT NULL,
    CONSTRAINT PK_TipoRegistro PRIMARY KEY (cod_tipo)
);

CREATE TABLE UnidadeInternacao (
    cod_unidade int NOT NULL,
    nome_unidade varchar(45) NOT NULL,
    sigla_unidade varchar(10) NOT NULL,
    descricao_unidade varchar(100) NOT NULL,
    CONSTRAINT PK_UnidadeInternacao PRIMARY KEY (cod_unidade)
);

CREATE TABLE Vinculo (
    cod_vinculo int NOT NULL,
    nome_vinculo varchar(45) NOT NULL,
    descricao_vinculo varchar(100) NOT NULL,
    CONSTRAINT PK_Vinculo PRIMARY KEY (cod_vinculo)
);

CREATE TABLE CargaHorariaDia (
    cod_ch_dia int NOT NULL,
    duracao int NOT NULL,
    intervalo int NOT NULL,
    restricao int NOT NULL,
    CONSTRAINT PK_CargaHorariaDia PRIMARY KEY (cod_ch_dia),
    CONSTRAINT FK_Ch_Int FOREIGN KEY (intervalo) REFERENCES Intervalo(cod_intervalo),
    CONSTRAINT FK_Ch_Rest FOREIGN KEY (restricao) REFERENCES Restricao(cod_restricao)
);

CREATE TABLE EscalaMensal (
    cod_escala_mes int NOT NULL,
    unidade_internacao int NOT NULL,
    profissional_geracao varchar(45),
    prazo_dias int NOT NULL,
    homologada boolean NOT NULL,
    data_geracao date NOT NULL,
    hora_geracao time NOT NULL,
    mes int NOT NULL,
    ano int NOT NULL,
    CONSTRAINT PK_EscalaMensal PRIMARY KEY (cod_escala_mes),
    CONSTRAINT FK_EscalaM_Uni FOREIGN KEY (unidade_internacao) REFERENCES UnidadeInternacao(cod_unidade)
);

CREATE TABLE EscalaDiaria (
    cod_escala_dia int NOT NULL,
    escala_mes int NOT NULL,
    dia_semana int NOT NULL,
    dia int NOT NULL,
    CONSTRAINT PK_EscalaDiaria PRIMARY KEY (cod_escala_dia),
    CONSTRAINT FK_EscalaD_EscalaM FOREIGN KEY (escala_mes) REFERENCES EscalaMensal(cod_escala_mes)
);

CREATE TABLE PreferenciaMensal (
    cod_preferencia_mes int NOT NULL,
    unidade_internacao int NOT NULL,
    profissional_gerador varchar(45) NOT NULL,
    prazo_dias int NOT NULL,
    homologada boolean NOT NULL,
    data_geracao date NOT NULL,
    hora_geracao time NOT NULL,
    mes int NOT NULL,
    ano int NOT NULL,
    CONSTRAINT PK_PreferenciaMensal PRIMARY KEY (cod_preferencia_mes),
    CONSTRAINT FK_PreferenciaM_Uni FOREIGN KEY (unidade_internacao) REFERENCES UnidadeInternacao(cod_unidade)
);

CREATE TABLE PreferenciaDiaria (
    cod_preferencia_dia int NOT NULL,
    preferencia_mes int NOT NULL,
    dia int NOT NULL,
    dia_semana int NOT NULL,
    CONSTRAINT PK_PreferenciaDiaria PRIMARY KEY (cod_preferencia_dia),
    CONSTRAINT FK_PreferenciaD_PreferenciaM FOREIGN KEY (preferencia_mes) REFERENCES PreferenciaMensal(cod_preferencia_mes)
);

CREATE TABLE Profissional (
    siape int NOT NULL,
    registro_conselho int NOT NULL,
    ch_dia int NOT NULL,
    ch_mes int NOT NULL,
    cargo int NOT NULL,
    vinculo int NOT NULL,
    nome varchar(45) NOT NULL,
    CONSTRAINT PK_Profissional PRIMARY KEY (siape),
    CONSTRAINT FK_Profissional_ChDia FOREIGN KEY (ch_dia) REFERENCES CargaHorariaDia(cod_ch_dia),
    CONSTRAINT FK_Profissional_ChMes FOREIGN KEY (ch_mes) REFERENCES CargaHorariaMes(cod_ch_mes),
    CONSTRAINT FK_Profissional_TipoP FOREIGN KEY (cargo) REFERENCES TipoProfissional(cod_tipo),
    CONSTRAINT FK_Profissional_Vinculo FOREIGN KEY (vinculo) REFERENCES Vinculo(cod_vinculo)
);

CREATE TABLE Telefone(
	siape int,
	telefone varchar(15),
	CONSTRAINT PK_telefone PRIMARY KEY (siape, telefone),
	CONSTRAINT FK_telefone_profissional FOREIGN KEY (cpf) REFERENCES Profissional(cpf)
);

CREATE TABLE SituacaoEscala (
    cod_situacao int NOT NULL,
    preferencia_dia int NOT NULL,
    preferencia_mes int NOT NULL,
    escala_dia int NOT NULL,
    escala_mes int NOT NULL,
    observacoes varchar(100) NULL,
    data_situacao date NOT NULL,
    hora_situacao time NOT NULL,
    profissional_situacao varchar(45) NOT NULL,
    tipo_situacao varchar(20) NOT NULL,
    CONSTRAINT PK_SituacaoEscala PRIMARY KEY (cod_situacao),
    CONSTRAINT FK_Situacao_PreferenciaDia FOREIGN KEY (preferencia_dia) REFERENCES PreferenciaDiaria(cod_preferencia_dia),
    CONSTRAINT FK_Situacao_PreferenciaMes FOREIGN KEY (preferencia_mes) REFERENCES PreferenciaMensal(cod_preferencia_mes),
    CONSTRAINT FK_Situacao_EscalaDia FOREIGN KEY (escala_dia) REFERENCES EscalaDiaria(cod_escala_dia),
    CONSTRAINT FK_Situacao_Mes FOREIGN KEY (escala_mes) REFERENCES EscalaMensal(cod_escala_mes)
);

CREATE TABLE Usuario (
    cod_usuario int NOT NULL,
    profissional int NOT NULL,
    nome VARCHAR (30) NULL,
    dataCadastro date NOT NULL,
    dataExpiracao date NOT NULL,
    email varchar(25) NOT NULL,
    ativo boolean NOT NULL,
    login varchar(15) NOT NULL,
    senha varchar(6) NOT NULL,
    CONSTRAINT PK_Usuario PRIMARY KEY (cod_usuario),
    CONSTRAINT FK_Usuario_Profissional FOREIGN KEY (profissional) REFERENCES Profissional(siape)
);    
    
CREATE TABLE BlocoHorarioEscala (
    cod_bloco_escala int NOT NULL,
    escala_dia int NOT NULL,
    horario_inicio time NOT NULL,
    horario_termino time NOT NULL,
    turno varchar(10) NOT NULL,
    tecnicos_necessario int NOT NULL,
    enfermeiros_necessarios int NOT NULL,
    CONSTRAINT PK_BlocoHorarioEscala PRIMARY KEY (cod_bloco_escala),
    CONSTRAINT FK_BlocoE_EscalaDia FOREIGN KEY (escala_dia) REFERENCES EscalaDiaria(cod_escala_dia)
);

CREATE TABLE BlocoHorarioPreferencia (
    cod_bloco_preferencia int NOT NULL,
    preferencia_dia int NOT NULL,
    horario_inicio time NOT NULL,
    horario_termino time NOT NULL,
    turno varchar(10) NOT NULL,
    tecnicos_necessario int NOT NULL,
    enfermeiros_necessarios int NOT NULL,
    CONSTRAINT PK_BlocoHorarioPreferencias PRIMARY KEY (cod_bloco_preferencia),
    CONSTRAINT FK_BlocoP_PreferenciaD FOREIGN KEY (preferencia_dia) REFERENCES PreferenciaDiaria(cod_preferencia_dia)
);
    
CREATE TABLE ProfissionalAlocado (
    cod_alocacao int NOT NULL,
    profissional int NOT NULL,
    bloco_escala int NOT NULL,
    bloco_preferencia int NOT NULL,
    presente boolean NOT NULL,
    CONSTRAINT PK_ProfissionalAlocado PRIMARY KEY (cod_alocacao),
    CONSTRAINT FK_ProfissionalA_Profissional FOREIGN KEY (profissional) REFERENCES Profissional(siape),
    CONSTRAINT FK_ProfissionalA_BlocoE FOREIGN KEY (bloco_escala) REFERENCES BlocoHorarioEscala(cod_bloco_escala),
    CONSTRAINT FK_ProfissionalA_BlocoP FOREIGN KEY (bloco_preferencia) REFERENCES BlocoHorarioPreferencia(cod_bloco_preferencia)
);    
    
CREATE TABLE Solicitacao (
    cod_solicitacao int NOT NULL,
    profissional int NOT NULL,
    situacao_solicitacao int NOT NULL,
    data_solicitacao date NOT NULL,
    hora_solicitacao time NOT NULL,
    status varchar(10),
    CONSTRAINT PK_Solicitacao PRIMARY KEY (cod_solicitacao),
    CONSTRAINT FK_Solicitacao_Profissional FOREIGN KEY (profissional) REFERENCES Profissional(siape),
    CONSTRAINT FK_Solicitacao_SituacaoS FOREIGN KEY (situacao_solicitacao) REFERENCES SituacaoSolicitacao(cod_situacao_solicitacao)
);    
    
CREATE TABLE Registro (
    cod_registro int NOT NULL,
    alocacao int NOT NULL,
    solicitacao int NOT NULL,
    tipo_registro int NOT NULL,
    observacoes varchar(100) NULL,
    data_registro date NOT NULL,
    hora_registro time NOT NULL,
    CONSTRAINT PK_Registro PRIMARY KEY (cod_registro),
    CONSTRAINT FK_Registro_ProfissionalA FOREIGN KEY (alocacao) REFERENCES ProfissionalAlocado(cod_alocacao),
    CONSTRAINT FK_Registro_Solicitacao FOREIGN KEY (solicitacao) REFERENCES Solicitacao(cod_solicitacao),
    CONSTRAINT FK_Registro_TipoR FOREIGN KEY (tipo_registro) REFERENCES TipoRegistro(cod_tipo)
);    

CREATE TABLE Afastamento (
    cod_afastamento int NOT NULL,
    solicitacao int NOT NULL,
    tipo_afastamento int NOT NULL,
    profissional_afastado varchar(45) NOT NULL,
    CONSTRAINT PK_Afastamento PRIMARY KEY (cod_afastamento),
    CONSTRAINT FK_Afastamento_TipoA FOREIGN KEY (tipo_afastamento) REFERENCES TipoAfastamento(cod_tipo),
    CONSTRAINT FK_Afastamento_Solicitacao FOREIGN KEY (solicitacao) REFERENCES Solicitacao(cod_solicitacao)
);    
    
CREATE TABLE Comparecimento (
    cod_comparecimento int NOT NULL,
    solicitacao int NOT NULL,
    profissional_respondente varchar(45) NOT NULL,
    profissional_solicitante varchar(45) NOT NULL,
    CONSTRAINT PK_Comparecimento PRIMARY KEY (cod_comparecimento),
    CONSTRAINT FK_Comparecimento_Solicitacao FOREIGN KEY (solicitacao) REFERENCES Solicitacao(cod_solicitacao)
);        

CREATE TABLE Preferencia (
    cod_preferencia int NOT NULL,
    solicitacao int NOT NULL,
    bloco_preferencia int NOT NULL,
    tipo_preferencia int NOT NULL,
    CONSTRAINT PK_Preferencia PRIMARY KEY (cod_preferencia),
    CONSTRAINT FK_Preferencia_Solicitacao FOREIGN KEY (solicitacao) REFERENCES Solicitacao(cod_solicitacao),
    CONSTRAINT FK_Preferencia_BlocoP FOREIGN KEY (bloco_preferencia) REFERENCES BlocoHorarioPreferencia(cod_bloco_preferencia),
    CONSTRAINT FK_Preferencia_TipoPreferencia FOREIGN KEY (tipo_preferencia) REFERENCES TipoPreferencia(cod_tipo)
);

CREATE TABLE Transferencia (
    cod_transferencia int NOT NULL,
    solicitacao int NOT NULL,
    bloco_escala int NOT NULL,
    profissional_solicitado varchar(45) NOT NULL,
    profissional_respondente varchar(45) NOT NULL,
    horario_solicitado time NOT NULL,
    horario_insuficiente time NOT NULL,
    CONSTRAINT PK_Transferencia PRIMARY KEY (cod_transferencia),
    CONSTRAINT FK_Transferencia_Solicitacao FOREIGN KEY (solicitacao) REFERENCES Solicitacao(cod_solicitacao),
    CONSTRAINT FK_Transferencia_BlocoE FOREIGN KEY (bloco_escala) REFERENCES BlocoHorarioEscala(cod_bloco_escala)
);

CREATE TABLE TrocaHorario (
    cod_troca int NOT NULL,
    solicitacao int NOT NULL,
    bloco_escala int NOT NULL,
    profissional_respondente varchar(45) NOT NULL,
    horario_solicitante time NOT NULL,
    horario_respondente time NOT NULL,
    CONSTRAINT PK_Troca PRIMARY KEY (cod_troca),
    CONSTRAINT FK_Troca_Solicitacao FOREIGN KEY (solicitacao) REFERENCES Solicitacao(cod_solicitacao),
    CONSTRAINT FK_Troca_BlocoE FOREIGN KEY (bloco_escala) REFERENCES BlocoHorarioEscala(cod_bloco_escala)
);
    
    
    
    
