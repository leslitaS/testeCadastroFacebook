# language: pt
  # encoding: utf-8

Funcionalidade: Se cadastrar no facebook

    Cenário: Cadastro com sexo feminino
        Dado que o usuario está na tela de cadastro
        Quando preenche os campos de forma correta
        E escolhe o genero feminino
        E clica no botão cadastrar
        Então deve ser criada uma conta com o genero escolhido