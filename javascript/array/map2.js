const carrinho = [
    '{"nome": "Borracha", "preco": 3.45}',
    '{"nome": "Caderno", "preco": 13.90}',
    '{"nome": "Kit Lápis", "preco": 41.22}',
    '{"nome": "Caneta", "preco": 7.50}',
]

//Forma pessoal
let precos = carrinho.map(item =>JSON.parse(item).preco)
console.log(precos)

//Forma vídeo
const paraObjeto = json => JSON.parse(json)
const apenasPreco = item => item.preco

const resultado = carrinho.map(paraObjeto).map(apenasPreco)

console.log(resultado)