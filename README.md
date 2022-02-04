# projetoCvc

Patterns utilizado no projeto. -Abstract Factory: escolhido para poder utilizar cada vez que necessário a regra de negocio, com o objtivo caso o cliente pedir novas alterações 
teremos novas camadas que vai ser necessário reutilizar os mesmos cálculos, o modelo de interface também se aplicaria na solução, então teríamos um cenário de polimorfismo,
onde cada classe implementaria sua regra de negocio, imaginei uma forma diferente olhando que a descrição do negocio não confirmou que poderia dessa maneira.

Justifique frameworks. -Juni - Criação dos testes unitarios (validação apenas das regras de negocio), nao vi a necessidade de teste intregado devido usar o banco em memória
o h2 e não ter nenhuma iteração externa.

-Maven - Utilizado para gestão de dependencia e principalmente para build do projeto, atravez do comando (mvn) linha de comando e possivel executar o projeto de fomra simples 
e organizada.

-MapStruct - Utilizado para fazer o "DE PARA", e deixar de forma limpa, dinamica e organizada o codigo, nao precisando utilizar os metodos SET do java, mapeamentos feitos na 
inter
