# 📞 Agenda Telefônica Java (JDK 17)

Este projeto é uma **Agenda Telefônica** simples, desenvolvida em **Java puro (JDK 17)**, sem uso de frameworks como Spring Boot. Ele possui:

- Interface gráfica com `Swing`
- Cadastro e remoção de contatos com validações
- Lista ordenada alfabeticamente
- Testes unitários com JUnit 4 e Hamcrest

---

## 🧱 Estrutura de Pacotes

```
📦 src/
├── model/                 # Contém a classe Contato
├── service/               # Contém a lógica de negócio da agenda
├── exception/             # Contém exceção personalizada
├── test/                  # Testes unitários com JUnit 4
└── Main.java              # Interface gráfica (Swing)
```

---

## ✅ Funcionalidades

- Adicionar contato com nome e telefone
- Impedir contatos duplicados (nome ou telefone iguais)
- Remover contato por nome
- Exibir contatos ordenados alfabeticamente
- Interface gráfica com mensagens de erro e sucesso
- Testes unitários cobrindo os principais cenários

---

## 🧪 Testes Unitários

- Utiliza **JUnit 4.13.2** e **Hamcrest 1.3**
- Arquivos `.jar` estão disponíveis na pasta `lib/`

---

## ▶️ Como Executar

### 1. Requisitos
- JDK 17 instalado
- Editor ou IDE (Ex: IntelliJ, Eclipse ou VS Code)

### 2. Compilação

```bash
javac -cp "lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" -d bin src/**/*.java
```

> No Linux/Mac use `:` no lugar de `;` no classpath:
> `-cp "lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar"`

### 3. Execução do Programa (GUI)

```bash
java -cp bin Main
```

### 4. Execução dos Testes

```bash
java -cp "bin;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore test.AgendaServiceTest
```

---

## 📚 Dependências

Coloque os arquivos `.jar` na pasta `lib/`:

- [junit-4.13.2.jar](https://search.maven.org/remotecontent?filepath=junit/junit/4.13.2/junit-4.13.2.jar)
- [hamcrest-core-1.3.jar](https://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar)

---

## 👨‍💻 Autor

Desenvolvido com foco em boas práticas de **POO (Programação Orientada a Objetos)** e testes automatizados para garantir confiabilidade e manutenibilidade do código.

---