# 🚗 Projeto: Sistema de Automóveis com POO (Java)

Este projeto é uma implementação em Java que demonstra os **quatro pilares da Programação Orientada a Objetos (POO)** — Abstração, Encapsulamento, Herança e Polimorfismo — por meio de um sistema com veículos como `Automóvel`, `Carro`, `Moto`, `Guincho`, e suas especializações. O sistema também inclui **tratamento de exceções** personalizado e **testes unitários com JUnit 4**.

---

## ✅ Enunciado da Atividade

### Questão 18

> Faça uma classe `Automóvel`, identificando seus atributos e métodos. Herdando tais características, crie três classes: `Carro`, `Moto` e `Guincho`.  
> Herdando `Carro`, faça uma classe `CarroAutomático`, na qual, para poder ligar, o freio precisa estar sendo pressionado.  
> Herdando `Moto`, faça uma classe `MotoPartidaPedal`, onde, para ligar, o acelerador precisa estar puxado.  
> O `Guincho` pode carregar tanto `Carro` quanto `Moto`.  
> Utilize os **4 pilares da POO**.

---

## 📁 Estrutura de Pacotes

```
src/
├── model/
│   ├── Automovel.java
│   ├── Carro.java
│   ├── CarroAutomatico.java
│   ├── Moto.java
│   ├── MotoPartidaPedal.java
│   └── Guincho.java
├── service/
│   └── AutomovelService.java
├── exception/
│   ├── LigacaoException.java
│   └── AutomovelExceptionHandler.java
├── test/
│   └── AutomovelTest.java
└── Main.java
```

---

## 🔍 Pilares de POO Utilizados

| Pilar            | Onde foi aplicado                                 |
|------------------|---------------------------------------------------|
| **Abstração**    | Classe `Automovel` como classe abstrata base      |
| **Encapsulamento**| Uso de modificadores de acesso (`private`, `protected`) |
| **Herança**      | `Carro`, `Moto`, `Guincho` herdam de `Automovel`  |
| **Polimorfismo** | Método `ligar()` sobrescrito em subclasses        |

---

## 📦 Dependências (JUnit 4)

Coloque os seguintes arquivos `.jar` na pasta `lib/` do seu projeto:

- `junit-4.13.2.jar`
- `hamcrest-core-1.3.jar`

**Importante:** Para compilar e executar os testes com JUnit 4, adicione os `.jar` ao classpath.

---

## 🚀 Como executar o projeto

### Pré-requisitos:
- JDK 8 ou superior instalado
- JARs do JUnit 4 (`junit-4.13.2.jar` e `hamcrest-core-1.3.jar`) já incluídos no diretório `lib/`

### Compilar o projeto

Navegue até o diretório `src/` e execute:

```bash
javac -cp ".;../lib/junit-4.13.2.jar;../lib/hamcrest-core-1.3.jar" main/Main.java model/*.java exception/*.java service/*.java
```

(Em Linux/macOS, troque `;` por `:` no classpath: `-cp ".:../lib/..."`)

### Executar o projeto

```bash
java -cp ".;../lib/junit-4.13.2.jar;../lib/hamcrest-core-1.3.jar" main.Main
```

A saída esperada será algo como:

```
===== Testando Automóveis =====
Carro ligado? true
Moto ligada? true
Carro Automático ligado? true
Moto Partida a Pedal ligada? true
Guincho: Carro
Guincho: Moto
Guincho ligado? true
```


## 🧪 Executando os Testes

### Compilar (Linux/Mac)

```bash
javac -cp .:lib/* src/**/*.java
```

### Compilar (Windows)

```cmd
javac -cp .;lib/* src/**/*.java
```

### Executar testes (Linux/Mac)

```bash
java -cp .:lib/*:src org.junit.runner.JUnitCore test.AutomovelTest
```

### Executar testes (Windows)

```cmd
java -cp .;lib/*;src org.junit.runner.JUnitCore test.AutomovelTest
```

---

## 👨‍💻 Funcionalidades Implementadas

- `Carro` e `Moto` podem ser ligados normalmente.
- `CarroAutomatico` só liga se o freio estiver pressionado.
- `MotoPartidaPedal` só liga se o acelerador estiver puxado.
- `Guincho` pode carregar qualquer `Automovel` (carro ou moto).
- Exceções personalizadas são lançadas em condições inválidas.
- Testes unitários cobrindo todos os cenários positivos e negativos.

---

## 🧠 Autor e Objetivo

Este projeto tem fins **didáticos** e foi desenvolvido para demonstrar o uso correto da **POO em Java puro**, com atenção a boas práticas, estrutura em camadas e testes automatizados com JUnit 4.

---

