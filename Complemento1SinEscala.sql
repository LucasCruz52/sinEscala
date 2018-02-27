ALTER TABLE Profissional ADD status boolean NOT NULL;

ALTER TABLE Profissional DROP COLUMN siape;
ALTER TABLE Profissional ADD siape int NOT NULL;

ALTER TABLE Profissional DROP COLUMN registro_conselho;
ALTER TABLE Profissional ADD registro_conselho int NOT NULL;

ALTER TABLE Intervalo DROP COLUMN turno;

ALTER TABLE Restricao DROP COLUMN horas_trabalho;

ALTER TABLE CargaHorariaMes DROP COLUMN acressimo_horas;
ALTER TABLE CargaHorariaMes DROP COLUMN ano;
ALTER TABLE CargaHorariaMes DROP COLUMN mes;

CREATE TABLE AcressimoHoras (
    cod_acressimo int NOT NULL,
    profissional int NOT NULL,
    horas_acressimo int NOT NULL,
    mes int NOT NULL,
    ano int NOT NULL,
    CONSTRAINT PK_Acressimohoras PRIMARY KEY (cod_acressimo),
    CONSTRAINT FK_Acressimo_Profissional FOREIGN KEY (profissional) REFERENCES Profissional(siape)
);

ALTER TABLE UnidadeInternacao ADD status boolean NOT NULL;

CREATE TABLE TipoSituacaoSolicitacao (
    cod_tipo int NOT NULL,
    nome_tipo varchar(45) NOT NULL,
    descricao_tipo varchar(100) NOT NULL,
    CONSTRAINT PK_TipoSituacaoS PRIMARY KEY (cod_tipo)
);
ALTER TABLE SituacaoSolicitacao DROP COLUMN motivo_situacao;
ALTER TABLE SituacaoSolicitacao ADD COLUMN tipo_situacao int NOT NULL;
ALTER TABLE SituacaoSolicitacao ADD
CONSTRAINT FK_SituacaoS_TipoS FOREIGN KEY (tipo_situacao) REFERENCES TipoSituacaoSolicitacao(cod_tipo);

CREATE TABLE TipoSituacaoEscala (
    cod_tipo int NOT NULL,
    nome_tipo varchar(45) NOT NULL,
    descricao_tipo varchar(100) NOT NULL,
    CONSTRAINT PK_TipoSituacaoEscala PRIMARY KEY (cod_tipo)
);
ALTER TABLE SituacaoEscala DROP COLUMN tipo_situacao;
ALTER TABLE SituacaoEscala ADD COLUMN tipo_situacao int NOT NULL;
ALTER TABLE SituacaoEscala ADD
CONSTRAINT FK_SituacaoE_TipoS FOREIGN KEY (tipo_situacao) REFERENCES TipoSituacaoEscala(cod_tipo);

