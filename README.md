**Passo a passo de como rodar o código**

Primeiro devemos instalar o Java jdk 21.0.2 disponível em: https://download.java.net/java/GA/jdk21.0.2/f2283984656d49d69e91c558476027ac/13/GPL/openjdk-21.0.2_windows-x64_bin.zip

Após feito o download devemos navegar até a pasta C:\Program Files do computador, e se não existir, criar uma pasta de Nome **Java**.

Dentro da pasta Java, iremos extrair o arquivo baixado, ficando da seguinte forma:

![image](https://github.com/user-attachments/assets/23b10e4e-a0c3-43a8-8d5d-c0347f71633c)

**Configurando Variável de Ambiente**

Após instalado, o Windows é incapaz de saber aonde está nosso Java, então precisamos ensiná-lo a encontra-lo. Isso se dá através de variáveis de ambiente:

Em "Meu computador" clique com o botão direito, e depois clique em "Propriedades", dentro de "Propriedades" clique em "Configurações Avançadas do Sistema"

![image](https://github.com/user-attachments/assets/92d2e33b-7601-4e70-82cb-f9d1f830e6fd)

Aberta as configurações, iremos no botão "Variáveis de Ambiente" no canto direito inferior.

Aberta essas configurações clique em "Novo", na parte de baixo da tela

![image](https://github.com/user-attachments/assets/ddbc6530-0f42-4541-b3fa-93fc2ac52c6a)

No nome da Variável colocaremos "JAVA_HOME" e em valor colocaremos o caminho que o Java foi instalado, no nosso caso "C:\Program Files\Java\jdk-21.0.2"

Feito isso, voltaremos para a tela de variáveis de ambiente, e procuraremos a variável "path":

![image](https://github.com/user-attachments/assets/be7f8654-a800-4a80-bbc8-d24ca8087506)

Agora daremos um clique em path, e depois em "editar"

Irá abrir uma nova tela, nessa tela clicaremos em novo, e digitaremos "%JAVA_HOME%\bin":

![image](https://github.com/user-attachments/assets/8492bc4c-4e20-4a97-beec-6b7427dd8f73)

Após isso daremos "OK", na tela de variáveis também daremos "OK", assim voltando para a tela de propriedades, que clicaremos em "APLICAR"

Para testar se funcionou, iremos abrir o terminal e digitar "javac --version", essa mensagem deve aparecer:

![image](https://github.com/user-attachments/assets/a171c508-df22-4aba-81aa-b65809f24923)

