# StringUtils00

javac -encoding UTF-8 -d ./bin/ ./src/br/com/producao/validador.java
    javac é o compilador Java. Ele é usado para compilar arquivos fonte .java em bytecode Java, que é armazenado em arquivos .class.
    -encoding UTF-8 especifica a codificação de caracteres a ser usada ao ler os arquivos fonte. No caso, UTF-8 é um tipo de codificação que pode representar qualquer caractere em praticamente qualquer língua do mundo principalmente linguas que utilizam acentuação como no caso do português.
    -d especifica o diretório de destino onde os arquivos .class (código compilado) serão colocados após a compilação.
    .\bin\ indica que os arquivos compilados devem ser armazenados na pasta bin (geralmente, a pasta bin é onde o bytecode compilado é armazenado em um projeto no VSCode).
    .\src\br\com\validador\validador.java: Este é o caminho do arquivo fonte Java que você deseja compilar.

jar cf validador.jar -C ./bin/ .
    jar O comando jar é uma ferramenta fornecida utilizada para empacotar "arquivo compactado" arquivos .class, bibliotecas e outros recursos em um arquivo JAR.
    c é uma opção que indica que o objetivo do comando é criar um novo arquivo JAR.
    f é uma opção que indica que o nome do arquivo JAR será fornecido diretamente a seguir. Ou seja, f informa ao jar que o próximo argumento será o nome do arquivo JAR a ser criado.
    validador.jar é o nome do arquivo JAR que será criado. Esse arquivo irá conter as classes compiladas e outros arquivos que você especificar.
    -C a opção -C permite mudar temporariamente o diretório de trabalho ao empacotar os arquivos.
    .\bin\ especifica o diretório a partir do qual os arquivos serão empacotados. No caso, o diretório bin, que é onde você compilou as classes (de acordo com o comando javac -d .\bin\ que discutimos anteriormente).
    O ponto (.) ao final do comando significa incluir todos os arquivos e subdiretórios do diretório atual (que, após o -C, é .\bin\) no arquivo JAR.

O que acontece após executar o comando jar?
    O comando jar irá criar um arquivo JAR chamado validador.jar.
    Pronto, você tem agora uma biblioteca que pode ser compartilhada com outras pessoas da forma que você quiser. Você pode adicionar a sua biblioteca em seu github ou site.

Utilizando a sua própria biblioteca:
    1 - Primeiramente, você precisa criar um novo projeto Java. 
    2 - Copie o arquivo validador.jar para a pasta lib do seu projeto.
    3 - Crie o código abaixo: 
    import br.com.Validador.*;