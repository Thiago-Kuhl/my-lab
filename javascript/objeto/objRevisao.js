//colecao dinâmica de pares chave / valore
const produto = new Object;
produto.nome = 'cadeira'
produto.marca = 'top'
produto.preco = 220.00

console.log(produto)
delete produto.preco
console.log(produto)


const carro = {
    modelo: 'A4',
    valor: 89000.00,
    proprietario: {
        nome: 'Thiago',
        idade: 20,
        endereco: {
            logradouro: 'rua abv',
            numero: 213
        }
    },
    condutores: [{
        nome: 'Ana',
        idade: 20
    },
    {
        nome: 'Junior',
        idade: 34
    }],
    calcularValorSeguro: () => {
        //...
    }
}

console.log(carro)