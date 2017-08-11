# README #

Segue abaixo as instruções para implementação do teste para que possamos avaliar melhor seus conhecimentos.

### Sistema Simplificado de Biblioteca ###

**Atores**: Usuário Administrador e usuário comum.

    * Usuário Administrador: Cuida do cadastro de livros e do cadastro de usuários.
    * Usuário Comum: É quem pega livro emprestado e devolve.

1. Interface inicial do sistema: Tela de Login, com link “Cadastrar-se” para novos usuários. Para login serão utilizados o e-mail e senha do cadastro de usuário.
2. Importante: Somente o “Usuário Administrador” terá acesso às telas CRUD de Livros, CRUD de Usuários e a tela Histórico de Reservas. As demais telas podem ser acessadas por ambos os perfis.
3. Cada usuário pode reservar ou retirar no máximo 3 livros ao mesmo tempo. Caso algum usuário tente reservar ou retirar mais de 3 livros emitir alerta: “Atenção: São permitidos no máximo três livros por usuário”.
4. CRUD de Livros (Cadastrar, Consultar, Editar e Excluir)
    * Campos para Cadastro: Título do Livro, Editora, Ano de Publicação, Autor, Edição.
    * Botão “Sair” no canto da tela.
5. CRUD de Usuários
    * a.Campos: Nome, Telefone, Perfil (Adm ou Normal), Data Nascimento, e-mail e senha. Somente Telefone e Data de Nascimento não são obrigatórios.
6. Tela de Pesquisa de Livro
    * O usuário pode escolher pesquisar por: Título do Livro ou Nome do Autor.
    * Apresentar resultado da pesquisa em um grid, sendo que cada linha deve conter um link para a tela “Detalhes do Livro”, onde será possível fazer uma reserva ou retirada.
7. Tela de Detalhes do Livro
    * Apresentar os dados do livro: Título do Livro, Editora, Ano de Publicação, Autor, Edição. Somente Título do Livro e Autor são obrigatórios.
    * Apresentar o Status do Livro, podendo ser: “Disponível”, “Indisponível” e “Reservado para: ” + [Nome do Usuário que Reservou].
    * Apresentar botões “Reservar” e “Retirar Livro” quando o status do livro for “Disponível”.
    * Apresentar tabela com o histórico de reservas e retiradas, indicando a data e o usuário que efetuou a reserva ou a retirada.
8. Tela Meus Livros
    * Apresentar ao usuário logado em um grid, seu histórico de livros retirados e reservados, informando: Título do Livro, Data de Reserva e Data de Retirada, Status do Livro.
    * Para cada linha, adicionar botão equivalente ao status do livro, por exemplo:
        * Título do Livro: ABCD Brasil – Status: Retirado: Apresentar botão “Devolver”.
        * Título do Livro: FGHIJ China – Status: Reservado: Apresentar botão “Retirar” e botão “Cancelar Reserva”.
9. Tela de Histórico de Reservas
    * a.Apresentar em um grid com paginação (20 linhas por página) o histórico de reservas geral, com os seguintes campos:
        * Título do Livro, Autor, Nome do Usuário, Data da Reserva, Data de Cancelamento da Reserva, Data da Retirada, Data da Devolução.
        


**Vale lembrar que não será desconsiderado o teste incompleto, o foco do mesmo é apenas medir sua capacidade de resolução do problema.**

## Pré-requisitos ##
    * Linguagem Java 7+
    * Java Server Faces 2+
    * Maven 3+
    
## Desejável ##
    * Linguagem Java 8
    * Primefaces
    * Banco de dados SQL (JDBC)
    
## Diferencial ##
    * Spring Framework

## Montar Ambiente ##

* Instalar Java JDK 7+
    * [Download Java](http://www.oracle.com/technetwork/java/javase/downloads/java-archive-downloads-javase7-521261.html)
* Instalar Git
* Aceitar convite de acesso ao bitbucket e criar conta.
* Uma vez com acesso ao repositório do teste será possível cloná-lo.
    * "git clone https://bitbucket.org/developers-upe/library-test.git"
* Importar projeto Maven no Eclipse ou IDE de sua preferência.
* Rodar projeto de preferência no servidor de aplicação Tomcat 7+
    * [Download Java](https://tomcat.apache.org/download-70.cgi)

    