# Configurando o consul

## Instalação

* Instale o [consul](https://www.consul.io/downloads) 
* Inicie ele com o comando: 

```
consul agent -data-dir=my-new-data-dir -dev
```

## Execução

Em localhost:8500, acesse Key/Value e por padrao, adicione variaveis dentro da pasta config/application-name.

Para alterar as configuracões padrão:

* application.properties

```
spring.application.name=NOME-QUE-EU-QUERO
spring.config.import=optional:consul:
spring.cloud.consul.config.enabled=true
spring.cloud.consul.config.prefix=PASTA-NO-LUGAR-DE-CONFIG
spring.cloud.consul.config.defaultContext=${spring.application.name}
```

E dentro de Key/Value adicione as suas variaveis dentro de PASTA-NO-LUGAR-DE-CONFIG/NOME-QUE-EU-QUERO!