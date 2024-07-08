# spring-batch-application
📚 ☕️ Simples aplicação em Spring Batch


O Spring Batch é um framework poderoso desenvolvido pela SpringSource, projetado para facilitar o desenvolvimento e a execução de processos batch robustos e escaláveis em Java. Aqui estão alguns pontos-chave sobre o Spring Batch:

1. **Modelo de Programação**: O Spring Batch utiliza um modelo de programação baseado em chunking, onde grandes volumes de dados são processados em blocos menores (chunks). Isso ajuda na escalabilidade e no gerenciamento de grandes volumes de dados.

2. **Componentes Principais**:
   - **Job**: Define um trabalho completo a ser executado. Um job consiste em uma ou mais tarefas sequenciais ou paralelas.
   - **Step**: Cada job é composto por um ou mais steps. Um step define uma única etapa do processo batch, como leitura de dados, processamento e escrita.
   - **ItemReader**: Responsável pela leitura de dados de uma fonte, como um banco de dados, arquivo CSV, XML, etc.
   - **ItemProcessor**: Opcionalmente, processa os itens lidos antes de serem gravados.
   - **ItemWriter**: Grava os itens processados em um local de destino, como um banco de dados ou arquivo.

3. **Gerenciamento de Transações**: Spring Batch integra-se perfeitamente com o Spring Framework, aproveitando suas capacidades de gerenciamento de transações para garantir a integridade dos dados durante o processamento em lotes.

4. **Escalabilidade e Tolerância a Falhas**: Oferece suporte a estratégias de escalabilidade horizontal e vertical, permitindo o processamento de grandes volumes de dados de forma eficiente. Além disso, possui mecanismos para lidar com falhas durante o processamento, como retries e skip policies.

5. **Monitoramento e Gerenciamento**: Spring Batch fornece ferramentas e APIs para monitorar e gerenciar a execução de jobs, permitindo visualizar o progresso, status e métricas de desempenho.

6. **Integração com Outros Frameworks**: É altamente integrável com outros frameworks do ecossistema Spring, como Spring Boot, Spring Data, e Spring Integration, facilitando o desenvolvimento de pipelines de processamento de dados completos.

Em resumo, o Spring Batch é uma escolha excelente para desenvolvedores que precisam implementar e gerenciar processos batch confiáveis e escaláveis em aplicações Java, proporcionando um modelo robusto e flexível para lidar com grandes volumes de dados de forma eficiente.

### Requisitos
- Neste exemplo, foi criado um job que lê dados de um arquivo CSV, processa esses dados e os grava em um banco de dados.
- Ao iniciar a aplicação Spring Boot, o job runJob será executado automaticamente. Ele lerá os dados do arquivo CSV, processará cada pessoa convertendo seus nomes para maiúsculas, e em seguida salvará esses dados no banco de dados H2 em memória.

Este é um exemplo básico para demonstrar como o Spring Batch pode ser usado para processar dados em lotes de forma eficiente e escalável. Você pode expandir este exemplo adicionando mais funcionalidades, como validações, tratamento de exceções, entre outros.


### Configuração
* Java 21
* Spring Boot 3.3.1
* Gradle
* H2 Data Base - JDBC URL: jdbc:h2:mem:testdb - http://localhost:8080/h2-console


