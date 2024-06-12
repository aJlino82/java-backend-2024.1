Projeto de Gerenciamento de Atletas e Clubes
Descrição

Este projeto é uma API de gerenciamento de atletas e clubes construída com Spring Boot, todas as entidades com validação personalizada de dados. Além disso, possui integração com uma segunda API para consulta de esportes. O projeto inclui as classes Atleta e Clube com todas as camadas necessárias (repositories, services e controllers). A segunda API possui uma classe Esporte e serve apenas para consulta de esportes pelo código.
Funcionalidades

    CRUD de Atletas
    CRUD de Clubes
    Consulta de Esporte por Código

Estrutura do Projeto

    Atleta
        Classe representando um atleta
        Repositório, serviço e controlador para operações CRUD

    Clube
        Classe representando um clube
        Repositório, serviço e controlador para operações CRUD
        Método no controlador para consulta de esporte por código

    Esporte
        Classe representando um esporte
        API separada para consulta de esportes

Pré-requisitos

    Java 11+
    Maven
    Spring Boot!

Exemplo de endpoints:

    https://github.com/aJlino82/java-backend-2024.1/assets/53987087/affbf0ee-1a72-4b7f-b163-b416170cf6ab


