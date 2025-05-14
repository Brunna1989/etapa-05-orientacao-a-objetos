# 🌳 Projeto: Árvore Genealógica em Java

Este projeto tem como objetivo representar a **árvore genealógica de uma família** utilizando **Java puro (sem frameworks como Spring)**, com foco em boas práticas de orientação a objetos, organização em camadas e cobertura completa de testes unitários com JUnit.

---

## 📌 Requisitos

- **JDK:** 17
- **JUnit:** 4.13.2
- **Hamcrest:** 1.3
- **IDE recomendada:** IntelliJ IDEA, Eclipse ou VS Code com suporte a Java

---

## 📂 Estrutura de Pacotes

```
src/
├── exception/              # Contém a exceção personalizada
│   └── PessoaException.java
├── model/                  # Classe entidade Pessoa
│   └── Pessoa.java
├── service/                # Lógica de negócio
│   └── PessoaService.java
├── test/                   # Testes unitários com JUnit 4
│   └── PessoaServiceTest.java
└── main/                   # Classe com método main
    └── Main.java
```

---

## 🧠 Funcionalidades

- Criar pessoas com nome, idade, pai e mãe (todos do tipo `Pessoa`)
- Verificar se duas pessoas são irmãos
- Verificar se duas pessoas são pais de um filho
- Exibir a árvore genealógica de uma pessoa
- Tratar erros com exceção personalizada (`PessoaException`)

---

## ✅ Testes Unitários

A suíte de testes cobre:

- Criação válida de pessoas
- Lançamento de exceções para dados inválidos
- Detecção de irmãos (positiva e negativa)
- Geração correta da árvore genealógica
- Testes de exceção para entrada nula

### Rodar os testes (via terminal):

```bash
javac -cp "lib/*" -d bin src/**/*.java
java -cp "bin:lib/*" org.junit.runner.JUnitCore test.PessoaServiceTest
```

> 💡 **Obs**: No Windows, troque `:` por `;` no classpath:
> `java -cp "bin;lib/*" org.junit.runner.JUnitCore test.PessoaServiceTest`

---

## 🚀 Executar o Programa Principal

```bash
javac -cp "lib/*" -d bin src/**/*.java
java -cp "bin" main.Main
```

---

## 📦 Bibliotecas utilizadas

As bibliotecas necessárias estão localizadas na pasta `lib/`:

- `junit-4.13.2.jar` – para testes unitários
- `hamcrest-core-1.3.jar` – para matchers no JUnit

---

## 💡 Exemplos de Uso

Saída esperada ao rodar o `main`:

```
Nome: Lucas | Idade: 20
  Pai -> Carlos (50 anos)
  Mãe -> Ana (48 anos)

Nome: Carlos | Idade: 50
  Pai -> João (78 anos)
  Mãe -> Maria (74 anos)

Lucas e Laura são irmãos? Sim
```

---

## 📘 Autor

Projeto acadêmico desenvolvido com foco em POO e testes unitários.

---

