# APP NEXT ESG

O objetivo do aplicativo é incentivar a práticas sustentáveis e 
desenvolvimento de uma cultura empresarial inclusiva, sustentável 
e saudável.

Quando uma empresa for cadastrada com seus funcionários e suas equipes, se iniciará um ciclo (definido pela empresa), onde os funcionários poderão realizar login,
visualizar o progresso de sua equipe, cadastrar atividades (pode ser texto, vídeo, foto),
 e acompanhar em seu perfil sua pontuação.

A pontuação será definida pela somatória das entradas do usuário,
onde a pontuação de cada entrada é definida pela sua categoria.

Para incentivar o uso da plataforma, haverá um sistema de "Conquistas"
que concederá ao funcionário selos, que serão exibidos em seu perfil
publico

Ao final do ciclo, o top 1 em pontuação de cada equipe terá direito a uma bonificação
(será definida pela empresa)
___

## TABELAS:

**tbl_empresas**
- id_empresa INT (PK)
- nome VARCHAR(50) NOT NULL

**tbl_usuarios**
- id_usuario INT (PK)
- id_equipe INT NOT NULL (FK)
- id_empresa INT NOT NULL (FK)
- nome VARCHAR(50) NOT NULL
- administrador BIT NOT NULL 

**tbl_ciclos**
- id_ciclo INT (PK)
- id_empresa INT NOT NULL (FK)
- dt_inicio DATE NOT NULL
- dt_fim DATE NOT NULL
  
**tbl_equipes**
- id_equipe INT (PK)
- id_empresa INT NOT NULL (FK)
- nome VARCHAR(50) NOT NULL
- sigla VARCHAR(3) NOT NULL
  
**tbl_categorias**
- id_categoria INT (PK)
- nome VARCHAR(100) NOT NULL 
- pontuacao DECIMAL NOT NULL

**tbl_empresa_categorias**
- id_empresa INT (FK)
- id_categoria INT (FK)

**tbl_atividades**
- id_atividade INT (PK)
- id_usuario INT NOT NULL (FK)
- id_ciclo INT NOT NULL (FK)
- descricao VARCHAR(250)
- linkFoto VARCHAR(250)
- linkVideo VARCHAR(250)
  
**tbl_conquistas**
- id_conquista INT (PK)
- titulo VARCHAR(30) NOT NULL
- descricao VARCHAR(200) NOT NULL
- ativa BIT NOT NULL

**tbl_usuario_conquistas**
- id_conquista INT NOT NULL (FK)
- id_usuario INT NOT NULL (FK)
- dataConquista DATE NOT NULL

---

## ROADMAP

- Registrar usuario admin
- Login
- Criar empresa
- Criar Ciclos
- Criar Categorias
- Criar Equipes
- Cadastrar colaboradores em uma empresa e equipe
- Cadastrar atividades
- Criar timeline de atividades para as equipes
- Fluxo de fechamento de ciclo e definição de premiações
- Sistema de conquistas
