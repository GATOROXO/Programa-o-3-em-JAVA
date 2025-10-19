# Programação 3 em JAVA

Repositório criado com intuito de enviar todas as atividades propostas na matéria de Programação 3 em JAVA.

## 📋 Guia de Instalação do Ambiente de Desenvolvimento Java no Windows

Este guia completo irá orientá-lo na instalação e configuração do Java Development Kit (JDK) e do Visual Studio Code no Windows, incluindo a configuração das variáveis de ambiente do sistema.

---

## 📥 Passo 1: Download do Java (JDK)

### 1.1 Acessar o site oficial da Oracle

1. Acesse o site oficial do Oracle Java: [https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)
2. Na página, localize a seção **Java SE Development Kit**
3. Escolha a versão mais recente do JDK (recomendado: JDK 17 ou superior)

### 1.2 Download do instalador

1. Clique na aba **Windows**
2. Baixe o arquivo instalador adequado para sua arquitetura:
   - **x64 Installer** (para sistemas 64 bits - mais comum)
   - **x64 MSI Installer** (alternativa em formato MSI)
3. Aguarde o download do arquivo `.exe` ou `.msi`

---

## 🔧 Passo 2: Instalação do JDK

### 2.1 Executar o instalador

1. Localize o arquivo baixado (geralmente na pasta **Downloads**)
2. Execute o arquivo como **Administrador** (clique com botão direito → "Executar como administrador")
3. Na janela de instalação, clique em **Next**

### 2.2 Escolher o diretório de instalação

1. **IMPORTANTE**: Anote o caminho de instalação exibido (exemplo: `C:\Program Files\Java\jdk-17`)
2. Recomenda-se manter o caminho padrão sugerido
3. Clique em **Next** para continuar
4. Aguarde a instalação ser concluída
5. Clique em **Close** ao finalizar

---

## 🌐 Passo 3: Configurar Variáveis de Ambiente do Windows

As variáveis de ambiente permitem que o sistema operacional localize o Java em qualquer local do sistema.

### 3.1 Acessar as Configurações de Variáveis de Ambiente

**Método 1 (Recomendado):**
1. Pressione `Windows + R` para abrir o "Executar"
2. Digite `sysdm.cpl` e pressione **Enter**
3. Na janela "Propriedades do Sistema", vá para a aba **Avançado**
4. Clique no botão **Variáveis de Ambiente**

**Método 2 (Alternativo):**
1. Clique com o botão direito em **Este Computador** ou **Meu Computador**
2. Selecione **Propriedades**
3. Clique em **Configurações avançadas do sistema** (no menu lateral)
4. Na aba **Avançado**, clique em **Variáveis de Ambiente**

### 3.2 Criar a variável JAVA_HOME

1. Na seção **Variáveis do sistema** (parte inferior da janela), clique em **Novo**
2. Configure a nova variável:
   - **Nome da variável**: `JAVA_HOME`
   - **Valor da variável**: Cole o caminho onde o JDK foi instalado
     - Exemplo: `C:\Program Files\Java\jdk-17`
     - **ATENÇÃO**: Use o caminho EXATO da sua instalação (anotado no Passo 2.2)
3. Clique em **OK**

### 3.3 Adicionar o Java ao PATH

1. Ainda na seção **Variáveis do sistema**, localize a variável chamada **Path**
2. Selecione a variável **Path** e clique em **Editar**
3. Na nova janela, clique em **Novo**
4. Adicione a seguinte entrada: `%JAVA_HOME%\bin`
5. Clique em **OK** em todas as janelas abertas para salvar as alterações

---

## ✅ Passo 4: Verificar a Instalação do Java

### 4.1 Abrir o Prompt de Comando

1. Pressione `Windows + R`
2. Digite `cmd` e pressione **Enter**
3. Uma janela preta (Prompt de Comando) será aberta

### 4.2 Verificar a versão do Java

Execute os seguintes comandos:

```bash
java -version
```

**Saída esperada** (exemplo):
```
java version "17.0.x" 2023-xx-xx LTS
Java(TM) SE Runtime Environment (build 17.0.x+xx-LTS-xxx)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.x+xx-LTS-xxx, mixed mode, sharing)
```

Agora verifique o compilador Java:

```bash
javac -version
```

**Saída esperada** (exemplo):
```
javac 17.0.x
```

✅ Se ambos os comandos exibirem as versões, **a instalação foi bem-sucedida!**

❌ Se aparecer "comando não reconhecido", revise as configurações das variáveis de ambiente.

---

## 💻 Passo 5: Instalação do Visual Studio Code

### 5.1 Download do VS Code

1. Acesse o site oficial: [https://code.visualstudio.com/](https://code.visualstudio.com/)
2. Clique no botão **Download for Windows**
3. Aguarde o download do instalador

### 5.2 Instalação do VS Code

1. Execute o arquivo baixado (VSCodeUserSetup-x64-x.xx.x.exe)
2. Aceite os termos de licença
3. **IMPORTANTE**: Marque as seguintes opções:
   - ✅ Adicionar "Abrir com Code" ao menu de contexto
   - ✅ Adicionar ao PATH (recomendado)
   - ✅ Criar um ícone na Área de Trabalho (opcional)
4. Clique em **Instalar**
5. Aguarde a conclusão e clique em **Concluir**

---

## 🔌 Passo 6: Configurar Extensões Java no VS Code

### 6.1 Abrir o VS Code

1. Inicie o Visual Studio Code
2. Na primeira execução, pode aparecer uma tela de boas-vindas

### 6.2 Instalar o Extension Pack for Java

1. Clique no ícone de **Extensões** na barra lateral esquerda (ou pressione `Ctrl + Shift + X`)
2. Na barra de pesquisa, digite: `Extension Pack for Java`
3. Localize o pacote publicado pela **Microsoft**
4. Clique em **Install** (Instalar)

**Este pacote inclui:**
- Language Support for Java by Red Hat
- Debugger for Java
- Test Runner for Java
- Maven for Java
- Project Manager for Java
- Visual Studio IntelliCode

### 6.3 Aguardar a configuração automática

1. O VS Code detectará automaticamente o JDK instalado
2. Aguarde alguns segundos para que as extensões sejam configuradas
3. Pode aparecer uma notificação pedindo para recarregar a janela - clique em **Reload**

---

## 🧪 Passo 7: Testar o Ambiente

### 7.1 Criar um projeto de teste

1. No VS Code, pressione `Ctrl + Shift + P` para abrir a paleta de comandos
2. Digite: `Java: Create Java Project`
3. Selecione **No build tools**
4. Escolha uma pasta para salvar o projeto
5. Digite um nome para o projeto (exemplo: `MeuPrimeiroJava`)

### 7.2 Criar um arquivo Java simples

1. Na pasta `src`, crie um arquivo chamado `Main.java`
2. Digite o seguinte código:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Olá, Mundo! Java está funcionando!");
    }
}
```

### 7.3 Executar o programa

1. Clique com o botão direito no arquivo `Main.java`
2. Selecione **Run Java** ou clique no botão ▶️ **Run** no canto superior direito
3. O terminal exibirá: `Olá, Mundo! Java está funcionando!`

✅ **Parabéns! Seu ambiente Java está completamente configurado!**

---

## 🔧 Solução de Problemas Comuns

### Problema 1: "java não é reconhecido como um comando interno ou externo"

**Solução:**
- Verifique se a variável `JAVA_HOME` está configurada corretamente
- Verifique se `%JAVA_HOME%\bin` foi adicionado ao `Path`
- **IMPORTANTE**: Feche e reabra o Prompt de Comando após alterar variáveis de ambiente
- Se o problema persistir, reinicie o computador

### Problema 2: VS Code não encontra o JDK

**Solução:**
1. Abra as configurações do VS Code (`Ctrl + ,`)
2. Pesquise por `java.home`
3. Clique em **Edit in settings.json**
4. Adicione manualmente o caminho do JDK:
```json
{
    "java.home": "C:\\Program Files\\Java\\jdk-17"
}
```
5. Salve e reinicie o VS Code

### Problema 3: Extensões Java não funcionam

**Solução:**
- Verifique se o JDK (não apenas o JRE) está instalado
- Reinstale o Extension Pack for Java
- Pressione `Ctrl + Shift + P` e digite: `Java: Clean Java Language Server Workspace`
- Reinicie o VS Code

---

## 📚 Recursos Adicionais

- [Documentação oficial do Java](https://docs.oracle.com/en/java/)
- [Documentação do VS Code para Java](https://code.visualstudio.com/docs/languages/java)
- [Tutoriais Java para iniciantes](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)

---

## 📝 Dicas Importantes

1. **Sempre use o JDK** (Java Development Kit), não apenas o JRE (Java Runtime Environment)
2. **Mantenha o Java atualizado** verificando periodicamente por novas versões
3. **Use um gerenciador de projetos** como Maven ou Gradle para projetos maiores
4. **Aprenda atalhos do VS Code** para aumentar sua produtividade:
   - `Ctrl + Space`: Autocompletar código
   - `F5`: Iniciar debug
   - `Ctrl + /`: Comentar/descomentar linhas
   - `Alt + Shift + F`: Formatar código

---
