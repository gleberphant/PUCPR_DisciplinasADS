# Estágio 1: Build (Compilação)
# Usamos uma imagem oficial do OpenJDK que contém o Kit de Desenvolvimento Java (JDK)
FROM mcr.microsoft.com/devcontainers/java:21 AS build

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia a pasta 'src' do seu projeto para o diretório de trabalho no contêiner
COPY src ./src

# Cria um arquivo com a lista de todos os arquivos .java para compilação
RUN find src -name "*.java" > sources.txt

# Cria o diretório de saída para os arquivos compilados (.class)
RUN mkdir out

# Compila todo o código-fonte Java
RUN javac --release 21 -d out @sources.txt

# Estágio 2: Run (Execução)
# Usamos uma imagem mais leve, que contém apenas o Ambiente de Execução Java (JRE)
FROM mcr.microsoft.com/devcontainers/java:21
WORKDIR /app

# Copia apenas os arquivos compilados (.class) do estágio de build para a imagem final
COPY --from=build /app/out .

# Define o comando que será executado quando o contêiner iniciar
CMD ["java", "-cp", ".", "Main.ConsoleApp"]

