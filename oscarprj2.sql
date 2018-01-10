
CREATE TABLE public.pessoa (
                pescodigo INTEGER NOT NULL,
                nome VARCHAR(50) NOT NULL,
                sexo CHAR(1) NOT NULL,
                anoscarreira INTEGER,
                nomeacoes INTEGER,
                conquistas INTEGER,
                CONSTRAINT pessoa_pkey PRIMARY KEY (pescodigo)
);


CREATE TABLE public.filme (
                filcodigo INTEGER NOT NULL,
                titulo VARCHAR(100) NOT NULL,
                genero SMALLINT NOT NULL,
                paisorigem VARCHAR(40) NOT NULL,
                estreia DATE NOT NULL,
                duracao SMALLINT NOT NULL,
                sinopse TEXT NOT NULL,
                CONSTRAINT filme_pkey PRIMARY KEY (filcodigo)
);


CREATE TABLE public.elenco (
                pescodigo INTEGER NOT NULL,
                filcodigo INTEGER NOT NULL,
                CONSTRAINT elenco_pkey PRIMARY KEY (pescodigo, filcodigo)
);


CREATE TABLE public.categoria (
                catcodigo INTEGER NOT NULL,
                descricao VARCHAR(40) NOT NULL,
                CONSTRAINT categoria_pkey PRIMARY KEY (catcodigo)
);


CREATE TABLE public.indicacao (
                ano SMALLINT NOT NULL,
                catcodigo INTEGER NOT NULL,
                filcodigo INTEGER NOT NULL,
				vencedor smallint NOT NULL DEFAULT 0,
                CONSTRAINT indicacao_pkey PRIMARY KEY (ano, catcodigo, filcodigo)
);


CREATE TABLE public.indicacaoelenco (
                ano SMALLINT NOT NULL,
                filcodigo INTEGER NOT NULL,
                catcodigo INTEGER NOT NULL,
                pescodigo INTEGER NOT NULL,
                CONSTRAINT indicacaoelenco_pk PRIMARY KEY (ano, filcodigo, catcodigo, pescodigo)
);


ALTER TABLE public.elenco ADD CONSTRAINT elenco_pescodigo_fkey
FOREIGN KEY (pescodigo)
REFERENCES public.pessoa (pescodigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.elenco ADD CONSTRAINT elenco_filcodigo_fkey
FOREIGN KEY (filcodigo)
REFERENCES public.filme (filcodigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.indicacao ADD CONSTRAINT filme_indicacao_fk
FOREIGN KEY (filcodigo)
REFERENCES public.filme (filcodigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.indicacaoelenco ADD CONSTRAINT elenco_indicacaoelenco_fk
FOREIGN KEY (pescodigo, filcodigo)
REFERENCES public.elenco (pescodigo, filcodigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.indicacao ADD CONSTRAINT categoria_indicacao_fk
FOREIGN KEY (catcodigo)
REFERENCES public.categoria (catcodigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.indicacaoelenco ADD CONSTRAINT indicacao_indicacaoelenco_fk
FOREIGN KEY (ano, catcodigo, filcodigo)
REFERENCES public.indicacao (ano, catcodigo, filcodigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;


INSERT INTO categoria VALUES (1, 'Melhor Filme');
INSERT INTO categoria VALUES (3, 'Melhor Atriz');
INSERT INTO categoria VALUES (2, 'Melhor Ator');
INSERT INTO categoria VALUES (5, 'Melhor Atriz Coadjuvante');
INSERT INTO categoria VALUES (4, 'Melhor Ator Coadjuvante');

INSERT INTO filme VALUES (1, 'A Chegada', 6, 'EUA', '2016-11-24', 100, 'Louise, uma linguista especializada, é chamada para desvendar sinais alienígenas deixados por extraterrestres na Terra, e descobrir se trata-se ou não de uma ameaça. As respostas, no entanto, podem colocar em risco a vida de Louise e a existência da humanidade.
');
INSERT INTO filme VALUES (4, 'Manchester À Beira-Mar', 2, 'EUA', '2017-01-19', 135, 'Depois da morte de seu irmão mais velho, Lee Chandler é forçado a voltar para casa para cuidar do seu sobrinho de 16 anos. Lá ele é obrigado a lidar com um passado trágico que o separou de sua família e do lugar onde nasceu e foi criado.');
INSERT INTO filme VALUES (5, 'Moonlight: Sob a Luz do Luar', 2, 'EUA', '2017-02-23', 111, 'Black trilha uma jornada de autoconhecimento enquanto tenta escapar do caminho fácil da criminalidade e do mundo das drogas de Miami. Encontrando amor em locais surpreendentes, ele sonha com um futuro maravilhoso.');
INSERT INTO filme VALUES (6, 'Florence - Quem é Essa Mulher?', 3, 'EUA', '2016-07-07', 100, 'Florence Foster Jenkins, uma rica herdeira e cantora de ópera, acredita plenamente em suas habilidades vocais. O ator St. Clair Bayfield, seu companheiro, no entanto, tenta de todas as formas poupá-la da verdade que muitos acreditam: sua voz é aburdamente horrível. E um concerto público pode desvendar a farsa.
');
INSERT INTO filme VALUES (3, 'La La Land - Cantando Estações', 8, 'EUA', '2017-01-19', 128, 'O pianista Sebastian conhece a atriz iniciante Mia e os dois se apaixonam perdidamente. Em busca de oportunidades para suas carreiras na competitiva cidade, os jovens tentam fazer o relacionamento amoroso dar certo enquanto perseguem fama e sucesso.');
INSERT INTO filme VALUES (7, 'Elle', 7, 'EUA', '2016-11-17', 100, 'Após ser violentada, uma mulher passa a receber ameaças provocadoras de quem lhe atacou, o que a leva a suspeitar de quem lhe cerca.');
INSERT INTO filme VALUES (2, 'Até o Último Homem', 2, 'EUA, Austrália', '2017-01-26', 149, 'Acompanhe a história de Desmond T. Doss, um médico do exército americano que, durante a Segunda Guerra Mundial, se recusa a pegar em armas. Durante a Batalha de Okinawa ele trabalha na ala médica e salva cerca de 75 homens.');
INSERT INTO filme VALUES (8, 'Um Limite Entre Nós', 2, 'EUA', '2017-03-02', 140, 'Baseado na aclamada e premiada peça teatral homônima, um jogador de beisebol aposentado, que sonhava em se tornar uma grande estrela do esporte durante sua infância, agora trabalha como coletor de lixo para sobreviver. Ele terá de navegar pelas complicadas águas de seu relacionamento com a esposa, o filho e os amigos.');
INSERT INTO filme VALUES (9, 'A Qualquer Custo', 2, 'EUA', '2017-02-02', 103, 'Dois irmãos, um ex-presidiário e um pai divorciado, perderam a fazenda da família em West Texas e decidem assaltar um banco como uma chance de se restabelecerem financeiramente. Porém, cruzam com um delegado que tudo fará para capturá-los.');

INSERT INTO pessoa VALUES (1, 'Casey Affleck', 'M', 29, 2, 1);
INSERT INTO pessoa VALUES (3, 'Ryan Gosling', 'M', 24, 2, 0);
INSERT INTO pessoa VALUES (7, 'Viola Davis', 'F', 21, 3, 1);
INSERT INTO pessoa VALUES (8, 'Naomie Harris', 'F', 30, 1, 0);
INSERT INTO pessoa VALUES (9, 'Michelle Williams', 'F', 24, 4, 0);
INSERT INTO pessoa VALUES (10, 'Mahershala Ali', 'M', 16, 1, 1);
INSERT INTO pessoa VALUES (11, 'Jeff Bridges', 'M', 48, 7, 1);
INSERT INTO pessoa VALUES (12, 'Lucas Hedges', 'M', 10, 1, 0);
INSERT INTO pessoa VALUES (5, 'Meryl Streep', 'F', 42, 20, 3);
INSERT INTO pessoa VALUES (2, 'Andrew Garfield', 'M', 13, 1, 0);
INSERT INTO pessoa VALUES (4, 'Emma Stone', 'F', 10, 2, 1);
INSERT INTO pessoa VALUES (6, 'Isabelle Huppert', 'F', 46, 1, 0);

INSERT INTO elenco VALUES (1, 4);
INSERT INTO elenco VALUES (2, 2);
INSERT INTO elenco VALUES (3, 3);
INSERT INTO elenco VALUES (4, 3);
INSERT INTO elenco VALUES (5, 6);
INSERT INTO elenco VALUES (6, 7);
INSERT INTO elenco VALUES (7, 8);
INSERT INTO elenco VALUES (8, 5);
INSERT INTO elenco VALUES (9, 4);
INSERT INTO elenco VALUES (10, 5);
INSERT INTO elenco VALUES (11, 9);
INSERT INTO elenco VALUES (12, 4);

INSERT INTO indicacao VALUES (2017, 1, 1, 0);
INSERT INTO indicacao VALUES (2017, 1, 2, 0);
INSERT INTO indicacao VALUES (2017, 1, 3, 0);
INSERT INTO indicacao VALUES (2017, 2, 2, 0);
INSERT INTO indicacao VALUES (2017, 2, 3, 0);
INSERT INTO indicacao VALUES (2017, 3, 6, 0);
INSERT INTO indicacao VALUES (2017, 3, 7, 0);
INSERT INTO indicacao VALUES (2017, 5, 5, 0);
INSERT INTO indicacao VALUES (2017, 5, 4, 0);
INSERT INTO indicacao VALUES (2017, 4, 9, 0);
INSERT INTO indicacao VALUES (2017, 4, 4, 0);
INSERT INTO indicacao VALUES (2017, 2, 4, 1);
INSERT INTO indicacao VALUES (2017, 1, 5, 1);
INSERT INTO indicacao VALUES (2017, 3, 3, 1);
INSERT INTO indicacao VALUES (2017, 5, 8, 1);
INSERT INTO indicacao VALUES (2017, 4, 5, 1);

INSERT INTO indicacaoelenco VALUES (2017, 4, 2, 1);
INSERT INTO indicacaoelenco VALUES (2017, 2, 2, 2);
INSERT INTO indicacaoelenco VALUES (2017, 3, 2, 3);
INSERT INTO indicacaoelenco VALUES (2017, 3, 3, 4);
INSERT INTO indicacaoelenco VALUES (2017, 6, 3, 5);
INSERT INTO indicacaoelenco VALUES (2017, 7, 3, 6);
INSERT INTO indicacaoelenco VALUES (2017, 8, 5, 7);
INSERT INTO indicacaoelenco VALUES (2017, 5, 5, 8);
INSERT INTO indicacaoelenco VALUES (2017, 4, 5, 9);
INSERT INTO indicacaoelenco VALUES (2017, 5, 4, 10);
INSERT INTO indicacaoelenco VALUES (2017, 9, 4, 11);
INSERT INTO indicacaoelenco VALUES (2017, 4, 4, 12);
