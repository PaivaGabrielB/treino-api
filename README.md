# API - SISTEMA INTEGRADO DE FISCALIZAÇÃO ![API](https://img.shields.io/badge/API-yellow)


Esta API foi desenvolvida para atender o aplicativo mobile

A API foi desenvolvida em Java 1.8 e Spring Boot 2.7.0.

O SGBD utilizado é Oracle.

### Para rodar o projeto

- Baixe o repositório utilizando:

```bash
git clone https://github.com/codiub-repository/sif-api.git
```

- Atualize o `application-local.properties`, garanta que `spring.datasource.username` e `spring.datasource.password` correspondam ao username e senha do seu banco de dados.

- Rode a API utilizando Spring Boot:

```bash
mvn spring-boot:run
```

## :warning: Importante 

### Desenvolvedor

### Antes de executar QUALQUER modificação na API, certifique-se de estar  com o código atualizado com a branch de desenvolvimento `dev`.

### A branch `dev` deverá ser atualizada SOMENTE a partir de pull requests de outras branchs, para não causar erros de unrelated-histories.

- Antes da implementação de qualquer feature, deverá ser criada uma branch com o nome de `feature/{{nome-da-feature}}`:

```bash
git fetch origin 
git checkout dev
git checkout -b feature/{{nome-da-feature}}
git pull origin dev
```

- Após a implementação de qualquer feature (por menor que seja), deve ser criado um pull request para merge com a branch `dev`; 
- Após o merge com a branch `dev` e realização de testes necessários, a branch `feature/{{nome-da-feature}}` mergeada deverá ser excluída;
- Para implementação de quaisquer outra modificação, deverá ser criada outra branch `feature`.

