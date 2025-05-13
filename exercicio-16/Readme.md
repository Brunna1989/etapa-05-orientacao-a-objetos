# 📚 Sistema de Empréstimo de Livros

Um sistema simples de gerenciamento de empréstimo e devolução de livros, desenvolvido em **Java puro** com **JDK 17**. O projeto possui testes unitários com **JUnit** e **Hamcrest**, organizados em pacotes separados seguindo boas práticas de programação orientada a objetos.

## 🚀 Funcionalidades

- 📖 Cadastro e empréstimo de livros a pessoas.
- 🔁 Devolução de livros com mensagens descritivas.
- 🚫 Prevenção de empréstimos duplicados com tratamento de exceção.
- ✅ Testes unitários cobrindo todos os cenários (positivos e negativos).
- 🧪 Captura e verificação de saídas do console nos testes.

## 🛠️ Tecnologias Utilizadas

- Java 17
- JUnit 4
- Hamcrest
- Arquitetura em camadas (model, service, exception, test)

## 📂 Estrutura de Pacotes

```

📦 /src
├── 📁 model # Classes principais do domínio (Livro, Pessoa, Emprestimo)
├── 📁 service # Lógica de negócio (EmprestimoService)
├── 📁 exception # Exceções personalizadas (LivroJaEmprestadoException)
├── 📁 test # Testes unitários com JUnit (EmprestimoServiceTest)
└── 📄 Main.java # Classe principal com interface via console

```


## ⚙️ Requisitos

- JDK 17
- IDE compatível com Java (Eclipse, IntelliJ IDEA, VS Code, etc.)
- JUnit 4 e Hamcrest (os `.jar` estão na pasta `lib` do projeto)

## ▶️ Como Executar

1. Clone o repositório (ou copie os arquivos para seu projeto local).

2. Compile o projeto:

```bash
javac -cp ".;lib/*" src/**/*.java
````

No Linux/macOS, substitua ; por ::

```bash
javac -cp ".:lib/*" src/**/*.java
````

3. Execute o sistema:

```bash
java -cp ".;lib/*;src" Main
```

## ▶️ Como Executar os Testes
Certifique-se de que os arquivos .jar do JUnit 4 e Hamcrest estão dentro da pasta lib.

Execute os testes com:

````bash
javac -cp ".;lib/*" src/test/**/*.java
java -cp ".;lib/*;src/test" org.junit.runner.JUnitCore test.EmprestimoServiceTest
No Linux/macOS, substitua ; por ::
````

````bash
javac -cp ".:lib/*" src/test/**/*.java
java -cp ".:lib/*;src/test" org.junit.runner.JUnitCore test.EmprestimoServiceTest
````


## 📄 Descrição das Classes

1. **Main.java**  
   Esta é a classe principal do sistema, onde o usuário pode interagir com o programa por meio de um menu simples. As funcionalidades incluem:
   - Realizar empréstimo de livros.
   - Devolver livros.
   - Verificar se o livro já está emprestado.

2. **Livro.java**  
   Classe que representa um livro no sistema. Possui os seguintes atributos e métodos:
   - Atributos:
     - `titulo`: Título do livro.
     - `emprestado`: Estado de empréstimo (boolean).
   - Métodos:
     - `getTitulo()`: Retorna o título do livro.
     - `isEmprestado()`: Retorna se o livro está emprestado.
     - `setEmprestado()`: Define o status de empréstimo do livro.

3. **Pessoa.java**  
   Classe que representa uma pessoa no sistema. A pessoa pode realizar um empréstimo de livro.
   - Atributos:
     - `nome`: Nome da pessoa.
   - Métodos:
     - `getNome()`: Retorna o nome da pessoa.

4. **Emprestimo.java**  
   Classe que representa um empréstimo de livro para uma pessoa. Contém informações sobre quem fez o empréstimo, qual livro foi emprestado e a data do empréstimo.
   - Atributos:
     - `pessoa`: A pessoa que fez o empréstimo.
     - `livro`: O livro emprestado.
     - `dataEmprestimo`: Data em que o empréstimo foi feito.

5. **EmprestimoService.java**  
   Classe que contém a lógica de negócio para realizar e devolver empréstimos de livros. Implementa as regras de validação para garantir que os livros não sejam emprestados quando já estão em uso.
   - Métodos:
     - `realizarEmprestimo()`: Realiza o empréstimo de um livro a uma pessoa, verificando se o livro já está emprestado.
     - `devolverLivro()`: Marca o livro como devolvido.

6. **LivroJaEmprestadoException.java**  
   Exceção personalizada que é lançada quando um livro já está emprestado e uma tentativa de empréstimo é feita.

## 🧪 Testes
Os testes unitários para a classe `EmprestimoService` estão localizados na pasta `test`. Eles cobrem os seguintes cenários:
- Empréstimo bem-sucedido: Verifica se o empréstimo de um livro disponível funciona corretamente.
- Empréstimo de livro já emprestado: Testa se a exceção é lançada corretamente quando tentamos emprestar um livro que já está em uso.
- Devolução bem-sucedida: Verifica se a devolução do livro funciona e se o status de empréstimo é atualizado corretamente.
- Devolução de livro disponível: Testa o comportamento quando tentamos devolver um livro que já foi devolvido.
- Empréstimo e devolução combinados: Verifica a combinação de empréstimo e devolução, garantindo que os status de empréstimo sejam alterados corretamente.

## 📄 Exemplo de Execução
Ao rodar o sistema, o usuário pode escolher entre:
- Realizar um empréstimo.
- Devolver um livro.
- Sair do sistema.

## 📄 Exemplo de saída:

=== Sistema de Empréstimo de Livros ===

[1] Realizar empréstimo
[2] Devolver livro
[0] Sair
Escolha uma opção: 1
Digite o nome da pessoa: João
Digite o título do livro: Java Básico
✅ Empréstimo realizado com sucesso!
Pessoa: João
Livro: Java Básico
Data: 2025-05-13

Deseja devolver o livro? (s/n): s
Livro "Java Básico" devolvido com sucesso.


## 📚 Licença
Projeto educacional.
