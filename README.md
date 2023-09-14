# effective-jpa

Este reposítório é focado no aprendizado de JPA. Partindo dos conceitos elementares até os mais avançados.

## Princípios JPA

1 - Todo relacionamenteo tem que ter um lado dominante. Ex: Cliente tem um endereço, então o lado dominante é o cliente.
Pois é no cliente que estará a chave estrangeira. Ou seja, a tabela cliente conhece o endereço.

2 - É referente aos relacionamentos, podendo ser uniderecionais ou bidirecionais. 
Ex: Cliente tem um endereço, mas o endereço não tem um cliente. Então é unidirecional.
Ex: Cliente tem um endereço e o endereço tem um cliente. Então é bidirecional.




## Relacionamentos
`@OneToOne` significa que um cliente tem um endereço e um endereço tem um cliente.

`@OneToMany` significa que um cliente tem muitos telefones e um telefone tem um cliente.

`@ManyToOne` significa que um cliente tem muitos pedidos e um pedido tem um cliente.

`@ManyToMany` significa que um cliente tem muitos produtos e um produto tem muitos clientes.


## Estados de um objeto

São 4 estados de um objeto: Transient, Managed, Detached e Removed.

`Managed` é o estado em que o objeto está sendo gerenciado pelo EntityManager. Ou seja, o objeto está sincronizada
à transação. Por exemplo: o método find() do EntityManager retorna um objeto no estado Managed.
Todas alterações realizadas a uma entidade que está no estado managed, são modificadas no banco de dados quando o
`commit()` for realizado.

Outro detalhe interessante é que a entidade após ser _managed_ a mesma é colocada dentro de uma estrutura chamada de 
Persistence Context. Onde o EntityManager gerencia todas as entidades que estão dentro do Persistence Context.

Ao realizar qualquer comando para o banco de dados, essa entidade estará no Persistence Context e estará no estado _managed_.

`Detached` é o estado em que o objeto não está mais sendo gerenciado pelo EntityManage ou nunca foi gerenciado.
