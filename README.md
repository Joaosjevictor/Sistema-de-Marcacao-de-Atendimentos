💇‍♂️ Invictus - Sistema de Gestão de Barbearia
O Invictus é uma aplicação desktop desenvolvida para automatizar e organizar o fluxo de agendamentos em barbearias. O projeto foi construído durante o 3º semestre do curso de Análise e Desenvolvimento de Sistemas, com foco total em Arquitetura de Software, Padrões de Projeto (MVC) e Persistência de Dados (ORM).

🚀 Funcionalidades
* Gestão de Agendamentos: CRUD completo (Criar, Ler, Atualizar e Deletar) de horários de atendimento.
* Seleção de Serviços: Integração com base de dados de serviços e preços em tempo real.
* Regras de Negócio Robustas: Validação automática que impede agendamentos em datas ou horários que já passaram.
* Interface Intuitiva: Desenvolvida em Java Swing com foco na experiência do usuário final.
* Histórico de Atendimento: Listagem dinâmica filtrada por cliente através de HQL (Hibernate Query Language).

🛠️ Stack Tecnológica
* Linguagem: Java 17 (ou a versão que você usa).
* Interface Gráfica: Java Swing.
* ORM (Mapeamento Objeto-Relacional): Hibernate 6.
* Banco de Dados: PostgreSQL.
* Gerenciador de Dependências: Maven (opcional, se estiver usando).

🏗️ Arquitetura e Padrões de Projeto
O projeto foi estruturado seguindo o padrão MVC (Model-View-Controller) para garantir a separação de responsabilidades e facilitar a manutenção:
* Model: Representa as entidades do banco de dados (Cliente, Serviço, Agendamento).
* View: Camada de interface com o usuário.
* Controller: Camada intermediária que processa as requisições da View e aplica as regras de negócio.
* DAO (Data Access Object): Camada de persistência que isola a lógica do Hibernate, garantindo que o restante do sistema não precise lidar com SQL direto.

⚙️ Como Executar o Projeto
* Pré-requisitos
* JDK 17+ instalado.
* PostgreSQL instalado e rodando.

Criação do banco de dados (ex: bd_agendamentos).

Configuração
1- Clone o repositório:
```bash
  git clone https://github.com/Joaosjevictor/Sistema-de-Marcacao-de-Atendimentos.git
```
2- Ajuste as credenciais do banco de dados no arquivo src/main/resources/hibernate.cfg.xml:
```xml
<property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/seu_banco</property>
<property name="hibernate.connection.username">seu_usuario</property>
<property name="hibernate.connection.password">sua_senha</property>
```

3- Execute a classe principal (no pacote app).


👤 Autor
João Victor Q. de Barros
* Estudante de Análise e Desenvolvimento de Sistemas.
* Interesses: Java, Hibernate, Clean Code e Engenharia de Dados.
* LinkedIn: www.linkedin.com/in/joaovictorqueiroz-ads | GitHub: https://github.com/Joaosjevictor
